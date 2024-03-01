package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.requests.create.brand.CreateBrandRequest;
import com.tobeto.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.tobeto.rentacar.business.responses.get.brand.GetAllBrandResponse;
import com.tobeto.rentacar.business.responses.get.brand.GetBrandResponse;
import com.tobeto.rentacar.core.utilities.results.DataResult;


import java.util.List;

public interface BrandService {
    DataResult<CreateBrandResponse> add(CreateBrandRequest request);
    DataResult<List<GetAllBrandResponse>> getAll();

    GetBrandResponse getById(int id);
}