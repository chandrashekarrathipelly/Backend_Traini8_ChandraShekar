package traini8.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import traini8.API.DTOs.TrainingCenterDTO;
import traini8.API.model.TrainingCenter;
import traini8.API.service.TrainingCenterService;

@RestController
@RequestMapping("/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenterDTO trainingCenterDTO) {
        TrainingCenter savedTrainingCenterDetails = trainingCenterService.addTrainingCenterDetails(trainingCenterDTO);
        return ResponseEntity.ok(savedTrainingCenterDetails);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> listOfAllTrainingCenters = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(listOfAllTrainingCenters);
    }
}
