package com.wangindustries.badmintondbbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "stringing", schema = "public")
public class Stringing {

    @Id
    @Column(name = "stringing_id", nullable = false, unique = true)
    private UUID stringing_id;

    @ManyToOne
    @Column(name = "stringer_id", nullable = false, unique = false)
    private User stringerId;
}
