package com.tobeto.rentacar.core.utilities.results;

public class ErrorResult extends Result{
    ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }
}
