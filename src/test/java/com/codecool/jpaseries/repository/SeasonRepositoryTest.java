package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Episode;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private EpisodeRepository episodeRepository;


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
    @Test
    public void saveSeasonWithEpisode(){
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
                .lengthInMinutes(90)
                .build();
        episodes.add(episode3);

        Season season1 = Season.builder()
                        .title("One")
                        .episode(episodes)
                        .releaseDate(LocalDate.of(2001,12,10))
                        .build();

        seasonRepository.save(season1);
        System.out.println(season1);
        assertThat(episodeRepository.findAll()).hasSize(3);

    }
}