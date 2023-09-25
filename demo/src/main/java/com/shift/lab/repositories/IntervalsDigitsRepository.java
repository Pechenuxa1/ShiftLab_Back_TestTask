package com.shift.lab.repositories;

import com.shift.lab.entities.IntervalsOfDigitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervalsDigitsRepository extends JpaRepository<IntervalsOfDigitsEntity, Integer> {

}
