package com.wangindustries.badmintondbbackend.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "racket", schema = "public")
public class Racket {
    @Id
    @Column(name = "racket_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID racketId;

    //todo create a new UUID that maps from OwnedRacket to RacketModel for functional data?
    @Column
    private String make;

    @Column
    private String model;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(referencedColumnName = "user_id")
    private User owner;
}
