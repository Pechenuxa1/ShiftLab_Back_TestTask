package com.shift.lab.services;

import com.shift.lab.entities.IntervalsOfDigitsEntity;
import com.shift.lab.repositories.IntervalsDigitsRepository;
import org.springframework.stereotype.Service;

@Service
public class IntervalDigitsService {
  private final IntervalsDigitsRepository intervalsDigitsRepository;

  public IntervalDigitsService(IntervalsDigitsRepository intervalsDigitsRepository) {
    this.intervalsDigitsRepository = intervalsDigitsRepository;
  }
  public void save(IntervalsOfDigitsEntity intervalsOfDigitsEntity) {
    intervalsDigitsRepository.save(intervalsOfDigitsEntity);
  }
}
