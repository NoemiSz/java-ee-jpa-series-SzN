package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Genre;
import com.codecool.jpaseries.entity.Season;
import com.codecool.jpaseries.entity.Series;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SeasonRepository seasonRepository;


    @Test
    public void saveSeries(){

        Series friends = Series.builder()
                .title("Friends")
                .genre(Genre.COMEDY)
                .build();
        seriesRepository.save(friends);


        List<Series> seriesList = seriesRepository.findAll();
        System.out.println(seriesList.toString());
        assertThat(seriesList).hasSize(1);

    }
    @Test
    public void saveSeasonsWithSeries(){

        Set<Season> seasons = new HashSet<>();
        Season season1 = Season.builder()
                        .title("one")
                        .releaseDate(LocalDate.of(2000,10,10))
                        .build();
        seasons.add(season1);
        Season season2 = Season.builder()
                        .title("two")
                        .releaseDate(LocalDate.of(2001,11,10))
                        .build();
        seasons.add(season2);
        Season season3 = Season.builder()
                        .title("three")
                        .releaseDate(LocalDate.of(2002,12,10))
                        .build();
        seasons.add(season3);

        Series friends = Series.builder()
                .title("Friends")
                .genre(Genre.COMEDY)
                .seasons(seasons)
                .build();
        seriesRepository.save(friends);

        assertThat(seasonRepository.findAll()).hasSize(3);

    }


}