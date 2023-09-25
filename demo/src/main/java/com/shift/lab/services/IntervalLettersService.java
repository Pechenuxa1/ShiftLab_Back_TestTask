package com.shift.lab.services;

import com.shift.lab.entities.IntervalsOfLettersEntity;
import com.shift.lab.repositories.IntervalsLettersRepository;
import org.springframework.stereotype.Service;

@Service
public class IntervalLettersService {
  private final IntervalsLettersRepository intervalsLettersRepository;

  public IntervalLettersService(IntervalsLettersRepository intervalsLettersRepository) {
    this.intervalsLettersRepository = intervalsLettersRepository;
  }
  public void save(IntervalsOfLettersEntity intervalsOfLettersEntity) {
    intervalsLettersRepository.save(intervalsOfLettersEntity);
  }
}
