package com.wangindustries.badmintondbbackend.Entities;

import com.wangindustries.badmintondbbackend.models.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users", schema = "public")
public class User {

  @Id
  @Column(name = "user_id", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID userId;

  @Column
  private String givenName;

  @Column
  private String familyName;

  @Column
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column
  private String email;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private Date dateOfBirth;

  @OneToMany
  @JoinColumn
  private List<Racket> rackets;
}
