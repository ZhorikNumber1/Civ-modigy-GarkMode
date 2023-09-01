package com.civmodapi.Repository;


import com.civmodapi.Model.ModsUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModUnitsRepository extends JpaRepository<ModsUnits, Long> {
}
