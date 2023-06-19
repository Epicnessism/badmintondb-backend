package com.wangindustries.badmintondbbackend.entities;

import com.wangindustries.badmintondbbackend.models.StringingMethod;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(schema = "public")
public class Stringing {

  @Id
  @Column(nullable = false, unique = true)
  private UUID stringing_id;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Users stringerId;

  @Column(nullable = false)
  private Timestamp requestedTimestamp;

  @Column
  private Timestamp completedTimestamp;

  @Column
  private Timestamp lastUpdatedTimestamp;

  @Column
  private String brand;

  @Column
  private String model;

  @Column(nullable = false)
  private int mainTension;

  @Column
  private Integer mainLength;

  @Column(nullable = false)
  private int crossTension;

  @Column
  private Integer crossLength;

  @Column
  private StringingMethod method;

  @Column
  private boolean status;

  @Column
  private String notes;

}
