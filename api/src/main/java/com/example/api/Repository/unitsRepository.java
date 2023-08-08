package com.example.api.Repository;

import com.example.api.Model.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface unitsRepository extends JpaRepository<Units, Long> {

}
