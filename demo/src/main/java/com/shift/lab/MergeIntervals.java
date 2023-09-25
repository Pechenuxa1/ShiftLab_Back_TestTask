package com.shift.lab;

import com.shift.lab.intervals.Interval;
import com.shift.lab.intervals.IntervalDigits;
import com.shift.lab.intervals.IntervalLetters;

import java.util.*;

public class MergeIntervals {
  private static ArrayList<? extends Interval> intervals;
  private static String kind;

  MergeIntervals(ArrayList<? extends Interval> intervals, String kind) {
    MergeIntervals.intervals = intervals;
    MergeIntervals.kind = kind;
  }

  private static void sorting() {
    intervals.sort(Interval::compareTo);
  }

  public static ArrayList<? extends Interval> merge() {
    sorting();

    if (kind.equals("digits")) {
      ArrayList<IntervalDigits> result = new ArrayList<>();
      Integer start = (Integer) intervals.get(0).getStart();
      Integer end = (Integer) intervals.get(0).getEnd();
      for (int i = 1; i < intervals.size(); i++) {
        Integer nextStart = (Integer) intervals.get(i).getStart();
        Integer nextEnd = (Integer) intervals.get(i).getEnd();
        if (nextStart <= end) {
          end = Math.max(end, nextEnd);
        } else {
          result.add(new IntervalDigits(start, end));
          start = nextStart;
          end = nextEnd;
        }
      }
      result.add(new IntervalDigits(start, end));
      return result;
    } else {
      ArrayList<IntervalLetters> result = new ArrayList<>();
      String start = (String) intervals.get(0).getStart();
      String end = (String) intervals.get(0).getEnd();
      for (int i = 1; i < intervals.size(); i++) {
        String nextStart = (String) intervals.get(i).getStart();
        String nextEnd = (String) intervals.get(i).getEnd();
        if (nextStart.compareTo(end) <= 0) {
          end = maxLetter(end, nextEnd);
        } else {
          result.add(new IntervalLetters(start, end));
          start = nextStart;
          end = nextEnd;
        }
      }
      result.add(new IntervalLetters(start, end));
      return result;
    }
  }

  private static String maxLetter(String letter1, String letter2) {
    int compare = letter1.compareTo(letter2);
    if (compare >= 0) {
      return letter1;
    } else {
      return letter2;
    }
  }

}
