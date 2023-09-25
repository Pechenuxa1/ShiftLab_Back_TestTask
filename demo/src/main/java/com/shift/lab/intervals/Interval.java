package com.shift.lab.intervals;

public interface Interval {
  Object getStart();
  Object getEnd();

  int compareTo(Interval other);

}
