package traini8.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traini8.API.model.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}