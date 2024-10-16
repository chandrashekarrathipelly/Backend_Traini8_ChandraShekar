package traini8.API.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;

import traini8.API.DTOs.TrainingCenterDTO;
import traini8.API.model.TrainingCenter;
import traini8.API.repository.TrainingCenterRepository;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenter addTrainingCenterDetails(TrainingCenterDTO trainingCenterDTO) {
        TrainingCenter trainingCenterEntity = new TrainingCenter();
        trainingCenterEntity.setCenterName(trainingCenterDTO.getCenterName());
        trainingCenterEntity.setCenterCode(trainingCenterDTO.getCenterCode());

        trainingCenterEntity.setAddress(trainingCenterDTO.getAddress());
        
        trainingCenterEntity.setStudentCapacity(trainingCenterDTO.getStudentCapacity());
        trainingCenterEntity.setCoursesOffered(trainingCenterDTO.getCoursesOffered());
        trainingCenterEntity.setCreatedOn(Instant.now().toEpochMilli());
        trainingCenterEntity.setContactEmail(trainingCenterDTO.getContactEmail());
        trainingCenterEntity.setContactPhone(trainingCenterDTO.getContactPhone());


        
        return trainingCenterRepository.save(trainingCenterEntity);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }
}