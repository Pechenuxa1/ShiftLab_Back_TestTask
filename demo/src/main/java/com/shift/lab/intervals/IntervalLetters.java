package com.shift.lab.intervals;

public class IntervalLetters extends Object implements Interval {
  String start;
  String end;
  public IntervalLetters(String start, String end) {
    this.start = start;
    this.end = end;
  }
  public String getStart() {
    return start;
  }

  public String getEnd() {
    return end;
  }

  @Override
  public int compareTo(Interval other) {
    return this.getStart().compareTo((String) other.getStart());
  }

  @Override
  public String toString() {
    return "[" + start + "," + end + "]";
  }
}
