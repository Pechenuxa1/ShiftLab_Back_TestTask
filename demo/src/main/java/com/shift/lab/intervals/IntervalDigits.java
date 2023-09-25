package com.shift.lab.intervals;


public class IntervalDigits implements Interval {
  Integer start;
  Integer end;
  public IntervalDigits(Integer start, Integer end) {
    this.start = start;
    this.end = end;
  }

  public Integer getStart() {
    return start;
  }

  public Integer getEnd() {
    return end;
  }

  @Override
  public int compareTo(Interval other) {
    return this.getStart() - (Integer) other.getStart();
  }

  @Override
  public String toString() {
    return "[" + start + "," + end + "]";
  }
}
