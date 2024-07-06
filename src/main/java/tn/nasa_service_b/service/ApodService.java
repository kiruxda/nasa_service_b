package tn.nasa_service_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.nasa_service_b.client.NasaApiClient;
import tn.nasa_service_b.model.Apod;
import tn.nasa_service_b.repository.ApodRepository;

import java.sql.Date;

@Service
public class ApodService {
    @Autowired
    private ApodRepository apodRepository;

    @Autowired
    private NasaApiClient nasaApiClient;

    public Apod getApodData(){
        Apod apod = new Apod();
        apod.setDate(nasaApiClient.getApod().getBody().getDate());
        apod.setTitle(nasaApiClient.getApod().getBody().getTitle());
        apod.setHdurl(nasaApiClient.getApod().getBody().getHdurl());
        apod.setExplanation(nasaApiClient.getApod().getBody().getExplanation());
        apodRepository.save(apod);
        return apod;
    }

    public Apod getApodDataByDay(Date date){
        Apod apod = new Apod();
        apod.setDate(nasaApiClient.getApodByDate(date).getBody().getDate());
        apod.setTitle(nasaApiClient.getApodByDate(date).getBody().getTitle());
        apod.setHdurl(nasaApiClient.getApodByDate(date).getBody().getHdurl());
        apod.setExplanation(nasaApiClient.getApodByDate(date).getBody().getExplanation());
        apodRepository.save(apod);
        return apod;
    }
}
