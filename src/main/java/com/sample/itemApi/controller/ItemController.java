package com.sample.itemApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.itemApi.model.Item;
import com.sample.itemApi.service.ItemService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/item/")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item){
        return ResponseEntity.ok(itemService.addItem(item));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id){

        return ResponseEntity.ok(itemService.getItemById(id));
    }


    
}
