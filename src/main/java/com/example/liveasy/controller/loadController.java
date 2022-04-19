package com.example.liveasy.controller;

import com.example.liveasy.dto.LoadDto;
import com.example.liveasy.entity.Load;
import com.example.liveasy.repository.LoadRepository;
import com.example.liveasy.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class loadController {

    @Autowired
    public LoadRepository loadRepository;

    @Autowired
    public LoadService loadService;

    //Add load details
    @PostMapping("/load")
    public ResponseEntity<String> saveLoad (@RequestBody final LoadDto loadDto) {
        return new ResponseEntity<>(this.loadService.saveLoad(loadDto), HttpStatus.CREATED);
    }

    //Get all load details of a shipper
    @GetMapping("/load")
    public ResponseEntity<List<Load>> getListOfLoad (@RequestParam final String shipperId) {
        return new ResponseEntity<>(this.loadService.getListOfLoad(shipperId), HttpStatus.OK);
    }

    //Get load details with a load id
    @GetMapping("/load/{loadId}")
    public ResponseEntity<Load> getLoad (@PathVariable String loadId) {
        return new ResponseEntity<>(this.loadService.getLoad(Long.parseLong(loadId)), HttpStatus.OK);
    }

}
