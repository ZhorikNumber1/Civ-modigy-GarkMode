package com.example.api.Repository;

import com.example.api.Model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface unitRepository extends JpaRepository<Unit, Long> {

}
