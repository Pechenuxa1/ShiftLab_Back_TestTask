package com.shift.lab;

import com.shift.lab.intervals.IntervalDigits;
import com.shift.lab.intervals.IntervalLetters;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class JsonArrayParsing {

  public static ArrayList<IntervalDigits> jsonArrayToDigitsIntervals(String jsonData) throws ParseException {
    JSONArray arrayOfIntervals = (JSONArray) new JSONParser().parse(jsonData);
    ArrayList<IntervalDigits> intervals = new ArrayList<>();
    for (Object interval : arrayOfIntervals) {
      JSONArray jsonInterval = (JSONArray) interval;
      Integer start = ((Long)jsonInterval.get(0)).intValue();
      Integer end = ((Long)jsonInterval.get(1)).intValue();
      intervals.add(new IntervalDigits(start, end));
    }
    return intervals;
  }

  public static ArrayList<IntervalLetters> jsonArrayToLettersIntervals(String jsonData) throws ParseException {
    JSONArray arrayOfIntervals = (JSONArray) new JSONParser().parse(jsonData);
    ArrayList<IntervalLetters> intervals = new ArrayList<>();
    for (Object interval : arrayOfIntervals) {
      JSONArray jsonInterval = (JSONArray) interval;
      String start = (String) jsonInterval.get(0);
      String end = (String) jsonInterval.get(1);
      intervals.add(new IntervalLetters(start, end));
    }
    return intervals;
  }
}
