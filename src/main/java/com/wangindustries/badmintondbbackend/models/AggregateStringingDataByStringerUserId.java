package com.wangindustries.badmintondbbackend.models;

import lombok.Data;

import java.util.UUID;

@Data
public class AggregateStringingDataByStringerUserId {
  private UUID stringerUserId;
  private long totalStringingCount;
  private double totalPrice;
  private double totalAveragePrice;

  private long totalCompletedStringsNotIncludingUser;

  private double totalMinimumPrice;
  private double totalMaximumPrice;

  private long numberOfCompleted;
  private long numberNotCompleted;

  public AggregateStringingDataByStringerUserId(
      UUID stringerUserId,
      long totalStringingCount,
      double totalPrice,
      double totalAveragePrice,
      long totalCompletedStringsNotIncludingUser,
      double totalMinimumPrice,
      double totalMaximumPrice,
      long numberOfCompleted,
      long numberNotCompleted) {
    this.stringerUserId = stringerUserId;
    this.totalStringingCount = totalStringingCount;
    this.totalPrice = (double) Math.round(totalPrice * 100) / 100; // todo do something about this shit please, maybe use the psql Money datatype
    this.totalAveragePrice = (double) Math.round(totalAveragePrice * 100) / 100;
    this.totalCompletedStringsNotIncludingUser = totalCompletedStringsNotIncludingUser;
    this.totalMinimumPrice = totalMinimumPrice;
    this.totalMaximumPrice = totalMaximumPrice;
    this.numberOfCompleted = numberOfCompleted;
    this.numberNotCompleted = numberNotCompleted;
  }
}
