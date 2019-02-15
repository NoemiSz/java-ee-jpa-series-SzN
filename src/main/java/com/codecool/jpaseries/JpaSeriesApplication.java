package com.codecool.jpaseries;

import com.codecool.jpaseries.entity.Episode;
import com.codecool.jpaseries.entity.Genre;
import com.codecool.jpaseries.entity.Season;
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

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
            Set<Episode > episodes = new HashSet<>();
            Episode episode1 = Episode.builder()
                    .title("one")
                    .lengthInMinutes(110)
                    .build();
            episodes.add(episode1);
            Episode episode2 = Episode.builder()
                    .title("two")
                    .lengthInMinutes(130)
                    .build();
            episodes.add(episode2);
            Episode episode3 = Episode.builder()
                    .title("three")
                    .lengthInMinutes(120)
                    .actor("Tina Fey")
                    .actor("Pete Davidson")
                    .actor("Amy Poehler")
                    .build();
            episodes.add(episode3);

            Set<Season> seasons = new HashSet<>();
            Season season1 = Season.builder()
                    .title("one")
                    .episode(episodes)
                    .series(snl)
                    .releaseDate(LocalDate.of(2000,10,10))
                    .build();
            seasons.add(season1);
            seasonRepository.save(season1);
            Season season2 = Season.builder()
                    .title("two")
                    .series(snl)
                    .releaseDate(LocalDate.of(2001,11,10))
                    .build();
            seasons.add(season2);
            seasonRepository.save(season2);
            Season season3 = Season.builder()
                    .title("three")
                    .series(snl)
                    .releaseDate(LocalDate.of(2002,12,10))
                    .build();
            seasons.add(season3);
            seasonRepository.save(season3);

        };
    }
}

