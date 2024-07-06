package tn.nasa_service_b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.nasa_service_b.model.Apod;
import tn.nasa_service_b.service.ApodService;

import java.sql.Date;

@RestController
@RequestMapping("/api/apod")
public class ApodController {
    @Autowired
    private ApodService apodService;

    @GetMapping
    public ResponseEntity<Apod> getApod() {
        return ResponseEntity.ok(apodService.getApodData());
    }
    @GetMapping("/{date}")
    public ResponseEntity<Apod> getApodByDate(@PathVariable Date date) {
        return ResponseEntity.ok(apodService.getApodDataByDay(date));
    }
}