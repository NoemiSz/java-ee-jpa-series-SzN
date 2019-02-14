package com.codecool.jpaseries.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private LocalDate releaseDate;

    @Transient
    private Long age;

    @ManyToOne
    private Series series;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Episode> episode;


    public void calculateAge(){
        if (releaseDate != null){
            age = ChronoUnit.YEARS.between(releaseDate,LocalDate.now());
        }
    }




}