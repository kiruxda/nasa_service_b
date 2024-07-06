package tn.nasa_service_b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.nasa_service_b.model.Apod;

@Repository
public interface ApodRepository extends JpaRepository<Apod, Long> {
}
