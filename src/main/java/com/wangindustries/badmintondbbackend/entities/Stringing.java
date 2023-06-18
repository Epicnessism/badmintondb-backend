package com.wangindustries.badmintondbbackend.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "stringing", schema = "public")
public class Stringing {

    @Id
    @Column(name = "stringing_id", nullable = false, unique = true)
    private UUID stringing_id;

    @ManyToOne
    @JoinColumn(name = "stringer_id", nullable = false)
    private User stringerId;
}
