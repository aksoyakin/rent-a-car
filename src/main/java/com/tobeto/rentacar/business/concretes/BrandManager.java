package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.BrandService;
import com.tobeto.rentacar.business.constants.BrandMessage;
import com.tobeto.rentacar.business.requests.create.brand.CreateBrandRequest;
import com.tobeto.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.tobeto.rentacar.business.responses.get.brand.GetAllBrandResponse;
import com.tobeto.rentacar.business.responses.get.brand.GetBrandResponse;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.core.utilities.paging.PageDto;
import com.tobeto.rentacar.core.utilities.results.DataResult;
import com.tobeto.rentacar.core.utilities.results.Result;
import com.tobeto.rentacar.core.utilities.results.SuccessDataResult;
import com.tobeto.rentacar.core.utilities.results.SuccessResult;
import com.tobeto.rentacar.dataaccess.abstracts.BrandRepository;
import com.tobeto.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateBrandResponse> add(CreateBrandRequest request) {
        Brand brand = modelMapperService.forRequest().map(request,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        brandRepository.save(brand);

        CreateBrandResponse response = modelMapperService.forResponse().map(brand,CreateBrandResponse.class);

        return new
                SuccessDataResult<CreateBrandResponse>(response, BrandMessage.brandAdded);
    }

    @Override
    public DataResult<List<GetAllBrandResponse>> getAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponse> brandResponses =
                brands.stream().map(brand -> modelMapperService
                                .forResponse()
                                .map(brand, GetAllBrandResponse.class))
                                .collect(Collectors.toList());

        return new
                SuccessDataResult
                        <List<GetAllBrandResponse>>(brandResponses,BrandMessage.brandListed);
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.getById(id);
        GetBrandResponse response = modelMapperService.forResponse().map(brand,GetBrandResponse.class);
        return response;
    }

    //pagination
    @Override
    public DataResult<List<GetAllBrandResponse>> getAllPage(PageDto pageDto) {
        Sort sort = Sort.by
                (Sort.Direction.fromString(pageDto.getSortDirection()),
                pageDto.getSortBy());

        Pageable pageable = PageRequest.of(pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<Brand> brands = brandRepository.findAll(pageable);

        List<GetAllBrandResponse> responses = brands
                .stream()
                .map(brand -> modelMapperService.forResponse().map(brand,GetAllBrandResponse.class)).toList();

        return new SuccessDataResult<List<GetAllBrandResponse>>(responses);
    }

    @Override
    public Result delete(int id) {
        Brand brand = brandRepository.getById(id);
        brandRepository.delete(brand);
        return new SuccessResult("Deleted success");
    }


}
