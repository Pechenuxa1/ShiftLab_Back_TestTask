package com.shift.lab;

import com.shift.lab.entities.IntervalsOfDigitsEntity;
import com.shift.lab.entities.IntervalsOfLettersEntity;
import com.shift.lab.intervals.IntervalDigits;
import com.shift.lab.intervals.IntervalLetters;
import com.shift.lab.services.IntervalDigitsService;
import com.shift.lab.services.IntervalLettersService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;

public class DatabaseQuery {
  private IntervalDigitsService digitService;
  private IntervalLettersService letterService;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public DatabaseQuery(IntervalDigitsService digitService, IntervalLettersService letterService, JdbcTemplate jdbcTemplate) {
    this.digitService = digitService;
    this.letterService = letterService;
    this.jdbcTemplate = jdbcTemplate;
  }
  @Autowired
  public DatabaseQuery(IntervalDigitsService digitService) {
    this.digitService = digitService;
  }
  @Autowired
  public DatabaseQuery(IntervalLettersService letterService) {
    this.letterService = letterService;
  }
  @Autowired
  public DatabaseQuery(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  public void saveDigitsIntervalsInDB(ArrayList<IntervalDigits> intervals) {
    for (IntervalDigits interval : intervals) {
      IntervalsOfDigitsEntity entity = new IntervalsOfDigitsEntity();
      entity.setStart(interval.getStart());
      entity.setEnd(interval.getEnd());
      digitService.save(entity);
    }
  }

  public void saveLettersIntervalsInDB(ArrayList<IntervalLetters> intervals) {
    for (IntervalLetters interval : intervals) {
      IntervalsOfLettersEntity entity = new IntervalsOfLettersEntity();
      entity.setStart(interval.getStart());
      entity.setEnd(interval.getEnd());
      letterService.save(entity);
    }
  }

  public JSONArray sqlQueryToDigitsDB(String sql) {
    JSONArray array = new JSONArray();
    return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
      int start = rs.getInt("START_DIGIT");
      int end = rs.getInt("END_DIGIT");
      array.add(start);
      array.add(end);
      return array;
    });
  }

  public JSONArray sqlQueryToLettersDB(String sql) {
    JSONArray array = new JSONArray();
    return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
      String start = rs.getString("START_LETTER");
      String end = rs.getString("END_LETTER");
      array.add(start);
      array.add(end);
      return array;
    });
  }
}
