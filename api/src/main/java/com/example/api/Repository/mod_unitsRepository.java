package com.example.api.Repository;

import com.example.api.Model.Mods_units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mod_unitsRepository extends JpaRepository<Mods_units, Long> {
}
