package com.wangindustries.badmintondbbackend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "racket_model", schema = "public")
public class RacketModel {
    @Id
    @Column(name = "racket_model_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID racketId;

    @Column
    private String make;

    @Column
    private String model;
}
