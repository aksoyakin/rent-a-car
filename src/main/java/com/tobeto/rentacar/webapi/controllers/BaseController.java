package com.tobeto.rentacar.webapi.controllers;

import com.tobeto.rentacar.core.utilities.results.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public ResponseEntity<?> handleDataResult(DataResult<?> dataResult){
        if(dataResult.isSuccess()){
            return ResponseEntity.ok(dataResult);
        }
        return ResponseEntity.badRequest().body(dataResult);

    }
}
