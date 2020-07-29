package com.lusa.apicarros;

import com.lusa.apicarros.entity.Carros;
import com.lusa.apicarros.repository.CarrosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabaseCarros(CarrosRepository carrosRepository) {
        return args -> {
            carrosRepository.save(new Carros(1L, "Ford", "Focus"));
            carrosRepository.save(new Carros(2L, "Ford", "Fiesta"));
            carrosRepository.save(new Carros(3L, "Ford", "Mondeo"));
            carrosRepository.save(new Carros(4L, "Ford", "Mustang"));
            carrosRepository.save(new Carros(5L, "Ford", "Maverick"));
            carrosRepository.save(new Carros(6L, "Ford", "Edge"));
            carrosRepository.save(new Carros(7L, "Ford", "Ka"));
        };
    }
}