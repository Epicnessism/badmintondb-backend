package com.wangindustries.badmintondbbackend.Entities;

import com.wangindustries.badmintondbbackend.models.enums.StringColor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public")
public class StringEntity {

    @Id
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column
    private String model;

    @Column
    private String make;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StringColor color;
}
