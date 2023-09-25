package com.shift.lab.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "INTERVALS_OF_LETTERS")
public class IntervalsOfLettersEntity {
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "START_LETTER")
  private String start;
  @Column(name = "END_LETTER")
  private String end;

  public IntervalsOfLettersEntity() {

  }

  public IntervalsOfLettersEntity setStart(String start) {
    this.start = start;
    return this;
  }

  public IntervalsOfLettersEntity setEnd(String end) {
    this.end = end;
    return this;
  }

  @Override
  public String toString() {
    return "IntervalOfLettersEntity [" + "id=" + id + ", start=" + start + ", end=" + end + "]";
  }
}
