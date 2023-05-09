package com.codeclan.framingsystem.repositories;

import com.codeclan.framingsystem.models.RawPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RawPartRepository extends JpaRepository <RawPart, Long>{
    List<RawPart> findRawPartById(Long id);
}
