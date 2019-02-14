package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Episode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class EpisodeRepositoryTest {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    public void saveActors(){
        Episode episode = Episode.builder()
                .title("one")
                .lengthInMinutes(120)
                .actor("Tina Fey")
                .actor("Pete Davidson")
                .actor("Amy Poehler")
                .build();

        episodeRepository.save(episode);
        List<String> actors = episode.getActors();
        System.out.println(actors.toString());

        assertEquals(3,actors.size());


    }

}