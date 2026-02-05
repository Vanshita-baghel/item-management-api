package com.sample.itemApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.sample.itemApi.exceptionHandler.ItemNotFoundException;
import com.sample.itemApi.model.Item;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ItemService {
    
    private List<Item> items= new ArrayList<>();
    private final AtomicLong itemCounter= new AtomicLong(1);

    public Item addItem(Item item){
        
        item.setId(itemCounter.getAndIncrement());
        items.add(item);
        log.info("added the item with itemID: "+ item.getId());
        return item;
    }

    public Item getItemById(Long id){
        return items.stream()
                    .filter(i-> i.getId().equals(id))
                    .findFirst()
                    .orElseThrow(()-> new ItemNotFoundException(id));
    }
}
