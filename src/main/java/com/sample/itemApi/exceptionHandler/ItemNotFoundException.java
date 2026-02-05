package com.sample.itemApi.exceptionHandler;

public class ItemNotFoundException extends RuntimeException{
    
    public ItemNotFoundException(Long id){
        super("Item Not Found With Id: "+ id);
    }
}
