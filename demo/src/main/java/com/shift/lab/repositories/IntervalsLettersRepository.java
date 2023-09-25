package com.shift.lab.repositories;

import com.shift.lab.entities.IntervalsOfLettersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsLettersRepository extends JpaRepository<IntervalsOfLettersEntity, Integer> {

}
