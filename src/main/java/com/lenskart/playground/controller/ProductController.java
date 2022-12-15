package com.lenskart.playground.controller;

import com.lenskart.playground.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class ProductController {

    @Autowired
    private KafkaProducer kp;
    @GetMapping("api/product/{product}")
    public void createProduct(@PathVariable String product) {
        log.info("Product api hit with %s", product);

        kp.sendMessage(product);
    }
}

