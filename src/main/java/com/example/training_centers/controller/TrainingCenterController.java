package com.example.training_centers.controller;

import com.example.training_centers.model.TrainingCenter;
import com.example.training_centers.services.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainingCenter")
public class TrainingCenterController {
    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenter> createNewTrainingCenter(@RequestBody TrainingCenter trainingCenter)
    {
        TrainingCenter savedTrainingCenter=trainingCenterService.saveTrainingCenter(trainingCenter);
        return new ResponseEntity<>(savedTrainingCenter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenter()
    {
        List<TrainingCenter> trainingCenters=trainingCenterService.getAllTrainingCenter();
        return new ResponseEntity<>(trainingCenters,HttpStatus.OK);
    }

    @GetMapping("/training-center/{id}")
    public ResponseEntity<TrainingCenter> getTrainingCenterById(long id)
    {
        Optional<TrainingCenter> trainingCenterById=trainingCenterService.getTrainingCenterById(id);
        if(trainingCenterById.isPresent())
        {
            return new ResponseEntity<>(trainingCenterById.get(),HttpStatus.FOUND);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
