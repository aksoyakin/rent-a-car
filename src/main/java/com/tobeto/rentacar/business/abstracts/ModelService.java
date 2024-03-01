package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.requests.create.model.CreateModelRequest;
import com.tobeto.rentacar.business.responses.create.model.CreateModelResponse;
import com.tobeto.rentacar.business.responses.get.model.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    CreateModelResponse add(CreateModelRequest request);
    List<GetAllModelResponse> getAll();
    GetAllModelResponse getByName(String name);

}
