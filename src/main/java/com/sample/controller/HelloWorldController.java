package com.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class HelloWorldController {

    public static List<String> countryNames = new ArrayList<String>();
    @GetMapping("/getCountryNames")
    public ResponseEntity getName(){
        return ResponseEntity.ok(countryNames);
    }

    @GetMapping("/addCountry/{name}")
    public ResponseEntity addCountry(@PathVariable("name") String name){
        countryNames.add(name);
        return ResponseEntity.status(201).body(name);
    }

    @GetMapping("/{index}")
    public ResponseEntity getByIndex(@PathVariable("index") int index){
        System.out.print(" index ==>"+index+" ---- ");
        int val = index;
        if(countryNames.size()<val){
            return ResponseEntity.status(404).body(" requested index is no available ");
        }
        return ResponseEntity.ok(countryNames.get(val));
    }

    @PatchMapping("/{index}/{value}")
    public  ResponseEntity updateIndex(@PathVariable("index") int index,@PathVariable("value") String value){

        int val = index;

        if (countryNames.size()<val)
            return ResponseEntity.status(404).body(" requested index is no available "+" "+ HttpStatus.BAD_GATEWAY);

        countryNames.set(val,value);
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteIndex(@PathVariable("index") int index){

        int val = index;

        if (countryNames.size()<val)
            return ResponseEntity.status(404).body(" requested index is no available "+" "+ HttpStatus.BAD_GATEWAY);

        countryNames.remove(val);
        return  ResponseEntity.status(200).body("deleted");
    }

}
