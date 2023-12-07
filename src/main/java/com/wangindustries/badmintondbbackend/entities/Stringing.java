package com.wangindustries.badmintondbbackend.entities;

import com.wangindustries.badmintondbbackend.models.StringingMethod;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "public")
public class Stringing {

  @Id
  @Column(nullable = false, unique = true)
  private UUID stringingId;

  @ManyToOne
  @JoinColumn(nullable = false)
  private User stringerUser;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Racket racket;

  @Column(nullable = false)
  private Timestamp requestedTimestamp;

  @Column
  private Timestamp completedTimestamp;

  @Column
  private Timestamp lastUpdatedTimestamp;

  @Column
  private String stringName;

  @Column(nullable = false)
  private int mainTension;

  @Column
  private Integer mainLength;

  @Column(nullable = false)
  private int crossTension;

  @Column
  private Integer crossLength;

  @Column
  @Enumerated(value = EnumType.STRING)
  private StringingMethod method;
  //TODO look into converters.........https://www.baeldung.com/jpa-persisting-enums-in-jpa

  @Column
  private boolean isCompleted;

  @Column
  private String notes;


  @JoinColumn(referencedColumnName = "user_id")
  @ManyToOne(targetEntity = User.class)
  private User requester; //todo: should this be requester?
}
