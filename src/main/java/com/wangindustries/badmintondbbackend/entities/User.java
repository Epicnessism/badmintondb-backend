package com.wangindustries.badmintondbbackend.entities;

import com.wangindustries.badmintondbbackend.models.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="user", schema = "public")
public class User {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID userId;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "stringer_id")
    private List<Stringing> stringings;
}
