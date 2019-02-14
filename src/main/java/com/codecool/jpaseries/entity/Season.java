package com.codecool.jpaseries.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    public void calculateAge(){
        if (releaseDate != null){
            age = ChronoUnit.YEARS.between(releaseDate,LocalDate.now());
        }
    }




}