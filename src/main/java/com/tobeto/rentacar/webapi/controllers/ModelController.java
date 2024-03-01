package com.tobeto.rentacar.webapi.controllers;

import com.tobeto.rentacar.business.abstracts.ModelService;
import com.tobeto.rentacar.business.requests.create.model.CreateModelRequest;
import com.tobeto.rentacar.business.responses.create.model.CreateModelResponse;
import com.tobeto.rentacar.business.responses.get.model.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelController {
    private ModelService modelService;

    @PostMapping
    public CreateModelResponse add(@RequestBody CreateModelRequest request){
        CreateModelResponse result = modelService.add(request);
        return result;

    }

    @GetMapping
    public List<GetAllModelResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/getbyname/{name}")
    public GetAllModelResponse getByName(@PathVariable String name){
        return modelService.getByName(name);
    }

}
