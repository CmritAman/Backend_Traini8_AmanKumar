package com.example.training_centers.services;

import com.example.training_centers.model.TrainingCenter;
import com.example.training_centers.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingCenterService {
    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter)
    {
        return trainingCenterRepository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenter()
    {
        return trainingCenterRepository.findAll();
    }

    public Optional<TrainingCenter> getTrainingCenterById(@PathVariable long id)
    {
        return trainingCenterRepository.findById(id);
    }
}
