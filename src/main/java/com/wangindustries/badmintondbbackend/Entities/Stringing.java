package com.wangindustries.badmintondbbackend.Entities;

import com.wangindustries.badmintondbbackend.models.enums.StringingMethod;
import com.wangindustries.badmintondbbackend.models.enums.StringingStatus;
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

  @Column(nullable = false)
  private Timestamp requestedTimestamp;

  @Column
  private Timestamp completedTimestamp;

  @Column
  private Timestamp lastUpdatedTimestamp;

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
  @Enumerated(value = EnumType.STRING)
  private StringingStatus status;

  @Column
  private boolean isCompleted;

  @Column
  private double price;

  @Column
  private String notes;


  @ManyToOne
  @JoinColumn(nullable = false)
  private StringEntity stringMains;

  @ManyToOne
  @JoinColumn(nullable = false)
  private StringEntity stringCrosses;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Racket racket;

  @ManyToOne
  @JoinColumn(referencedColumnName = "user_id", nullable = false)
  private User stringer;

  @JoinColumn(referencedColumnName = "user_id")
  @ManyToOne(targetEntity = User.class)
  private User requester; //todo: should this be requester?
}
