package com.shift.lab.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "INTERVALS_OF_DIGITS")
public class IntervalsOfDigitsEntity {
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "START_DIGIT")
  private Integer start;
  @Column(name = "END_DIGIT")
  private Integer end;
  public IntervalsOfDigitsEntity() {

  }
  public IntervalsOfDigitsEntity setStart(Integer start) {
    this.start = start;
    return this;
  }
  public IntervalsOfDigitsEntity setEnd(Integer end) {
    this.end = end;
    return this;
  }
  @Override
  public String toString() {
    return "IntervalOfDigitsEntity [" + "id=" + id + ", start=" + start + ", end=" + end + "]";
  }
}
