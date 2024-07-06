package tn.nasa_service_b.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.nasa_service_b.model.Apod;

import java.sql.Date;

@FeignClient(name="nasaApi", url = "${nasa-api.base-url}")
public interface NasaApiClient {
    @GetMapping("/planetary/apod?api_key=${nasa-api.key}")
    ResponseEntity<Apod> getApod();
    @GetMapping("/planetary/apod?date={date}&api_key=${nasa-api.key}")
    ResponseEntity<Apod> getApodByDate(@PathVariable("date") Date date);
}
