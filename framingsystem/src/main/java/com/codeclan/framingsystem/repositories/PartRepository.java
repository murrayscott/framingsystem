package com.codeclan.framingsystem.repositories;

import com.codeclan.framingsystem.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository <Part, Long>{
    List<Part> findPartById(Long id);
}
