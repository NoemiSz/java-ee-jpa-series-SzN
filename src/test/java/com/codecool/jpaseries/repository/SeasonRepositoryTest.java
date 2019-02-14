package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Season;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SeasonRepositoryTest {
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TestEntityManager testEntiyManager;


    @Test
    public void transientIsNotSaved(){
        Season season = Season.builder()
                .title("one")
                .releaseDate(LocalDate.of(1999, 12, 12))
                .build();


        season.calculateAge();
        assertThat(season.getAge()).isGreaterThanOrEqualTo(18);

        seasonRepository.save(season);
        testEntiyManager.clear();

        List<Season> seasons = seasonRepository.findAll();
        System.out.println(seasons.toString());
        assertThat(seasons).allMatch(seasons1-> seasons1.getAge() == 0L);
    }

}