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

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private Date dateOfBirth;

  @OneToMany(mappedBy = "stringerId")
  private List<Stringing> stringings;
}
