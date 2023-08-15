package com.example.api.Repository;

import com.example.api.Model.Units_civilian;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface unitsRepository extends JpaRepository<Units_civilian, Long> {
    Units_civilian findByName(String str);
}
