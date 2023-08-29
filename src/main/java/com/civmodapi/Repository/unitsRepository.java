package com.civmodapi.Repository;


import com.civmodapi.Model.Units_civilian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface unitsRepository extends JpaRepository<Units_civilian, Long> {
    Units_civilian findByName(String str);
}
