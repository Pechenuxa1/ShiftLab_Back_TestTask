package com.shift.lab;

import com.shift.lab.intervals.IntervalDigits;
import com.shift.lab.intervals.IntervalLetters;
import com.shift.lab.services.IntervalDigitsService;
import com.shift.lab.services.IntervalLettersService;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/intervals")
public class RequestController {

  private final IntervalDigitsService digitService;
  private final IntervalLettersService letterService;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public RequestController(IntervalDigitsService digitService, IntervalLettersService letterService, JdbcTemplate jdbcTemplate) {
    this.digitService = digitService;
    this.letterService = letterService;
    this.jdbcTemplate = jdbcTemplate;
  }

  @PostMapping("/merge")
  public void postIntervals(@RequestParam("kind") String kind, @RequestBody String jsonData) throws ParseException {
    if (kind.equals("digits")) {
      ArrayList<IntervalDigits> intervals = JsonArrayParsing.jsonArrayToDigitsIntervals(jsonData);
      ArrayList<IntervalDigits> mergedIntervals = (ArrayList<IntervalDigits>) new MergeIntervals(intervals, kind).merge();
      DatabaseQuery query = new DatabaseQuery(digitService);
      query.saveDigitsIntervalsInDB(mergedIntervals);
    } else if (kind.equals("letters")) {
      ArrayList<IntervalLetters> intervals = JsonArrayParsing.jsonArrayToLettersIntervals(jsonData);
      ArrayList<IntervalLetters> mergedIntervals = (ArrayList<IntervalLetters>) new MergeIntervals(intervals, kind).merge();
      DatabaseQuery query = new DatabaseQuery(letterService);
      query.saveLettersIntervalsInDB(mergedIntervals);
    }
  }

  @GetMapping("/min")
  public JSONArray getMin(@RequestParam("kind") String kind) {
    DatabaseQuery query = new DatabaseQuery(jdbcTemplate);
    if (kind.equals("digits")) {
      String sql = "SELECT START_DIGIT, END_DIGIT\n" +
          "FROM INTERVALS_OF_DIGITS\n" +
          "ORDER BY START_DIGIT ASC, END_DIGIT ASC\n" +
          "LIMIT 1";
      return query.sqlQueryToDigitsDB(sql);
    } else if (kind.equals("letters")) {
      String sql = "SELECT START_LETTER, END_LETTER\n" +
          "FROM INTERVALS_OF_LETTERS\n" +
          "ORDER BY START_LETTER ASC, END_LETTER ASC\n" +
          "LIMIT 1";
      return query.sqlQueryToLettersDB(sql);
    }
    return null;
  }
}
