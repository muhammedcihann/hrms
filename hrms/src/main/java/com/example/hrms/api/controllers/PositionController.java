package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.PositionService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")

public class PositionController {
    @Autowired
    private PositionService positionService;
    @GetMapping("/getAll")
    public DataResult<List<Position>> getPositions(){
        return positionService.getAll();
    }
    
    @PostMapping("/add")
    public Result add(@RequestBody Position position){
        return positionService.add(position);
    }
    
}
