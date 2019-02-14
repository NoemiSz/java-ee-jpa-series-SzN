package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Genre;
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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void saveSeries(){

        Series snl = Series.builder()
                .title("Saturday Night Live")
                .genre(Genre.COMEDY)
                .build();
        seriesRepository.save(snl);


        List<Series> seriesList = seriesRepository.findAll();
        System.out.println(seriesList.toString());
        assertThat(seriesList).hasSize(1);

    }

}