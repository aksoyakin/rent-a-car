package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.ModelService;
import com.tobeto.rentacar.business.requests.create.model.CreateModelRequest;
import com.tobeto.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.tobeto.rentacar.business.responses.create.model.CreateModelResponse;
import com.tobeto.rentacar.business.responses.get.model.GetAllModelResponse;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.dataaccess.abstracts.ModelRepository;
import com.tobeto.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        Model model = modelMapperService.forRequest().map(request,Model.class);

        modelRepository.save(model);


        CreateModelResponse response = modelMapperService.forResponse().map(model,CreateModelResponse.class);

        return response;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> responses = models.stream()
                .map(model -> modelMapperService.forResponse()
                        .map(model, GetAllModelResponse.class))
                .collect(Collectors.toList());

        return responses;

    }

    @Override
    public GetAllModelResponse getByName(String name) {
        Model model = modelRepository.findByName(name);
        GetAllModelResponse response = modelMapperService
                .forResponse().map(model, GetAllModelResponse.class);

        return response;
    }
}
