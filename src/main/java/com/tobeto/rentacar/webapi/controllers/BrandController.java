package com.tobeto.rentacar.webapi.controllers;

import com.tobeto.rentacar.business.abstracts.BrandService;
import com.tobeto.rentacar.business.requests.create.brand.CreateBrandRequest;
import com.tobeto.rentacar.business.responses.create.brand.CreateBrandResponse;
import com.tobeto.rentacar.business.responses.get.brand.GetAllBrandResponse;
import com.tobeto.rentacar.business.responses.get.brand.GetBrandResponse;
import com.tobeto.rentacar.core.utilities.paging.PageDto;
import com.tobeto.rentacar.core.utilities.results.DataResult;
import com.tobeto.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController extends BaseController{
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateBrandRequest request){
     //   DataResult<CreateBrandResponse> result = brandService.add(request);

        return handleDataResult(brandService.add(request));
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll(){
        return handleDataResult(brandService.getAll());
    }

    @GetMapping(value = "getbyid/{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    //pagination
    @GetMapping("sort")
    public ResponseEntity<?> getAllPage(@RequestBody PageDto pageDto){
        return handleDataResult(brandService.getAllPage(pageDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return handleResult(brandService.delete(id));
    }
}
