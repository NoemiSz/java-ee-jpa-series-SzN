package com.codecool.jpaseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Singular
    @OneToMany(mappedBy = "Series", cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;


}