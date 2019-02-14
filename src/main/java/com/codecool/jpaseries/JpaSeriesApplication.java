package com.codecool.jpaseries;

import com.codecool.jpaseries.entity.Genre;
import com.codecool.jpaseries.entity.Series;
import com.codecool.jpaseries.repository.SeasonRepository;
import com.codecool.jpaseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class JpaSeriesApplication {


    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;


    public static void main(String[] args) {
        SpringApplication.run(JpaSeriesApplication.class, args);
    }


    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {
            Series snl = Series.builder()
                    .title("Saturday Night Live")
                    .genre(Genre.COMEDY)
                    .build();
            seriesRepository.save(snl);
        };
    }
}

