package com.civmodapi.Repository;


import com.civmodapi.Model.UnitsCivilian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitsRepository extends JpaRepository<UnitsCivilian, Long> {
    UnitsCivilian findByName(String str);
}
