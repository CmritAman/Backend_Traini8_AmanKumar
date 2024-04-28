package com.example.training_centers.repository;

import com.example.training_centers.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCenterRepository  extends JpaRepository<TrainingCenter,Long> {
}
