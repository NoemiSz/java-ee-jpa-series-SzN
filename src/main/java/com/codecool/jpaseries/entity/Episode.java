package com.codecool.jpaseries.entity;


import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int lengthInMinutes;

    @ElementCollection
    @Singular
    private List<String> actors;


}
