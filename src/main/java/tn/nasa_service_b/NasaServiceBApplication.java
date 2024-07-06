package tn.nasa_service_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NasaServiceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaServiceBApplication.class, args);
	}

}
