package com.codeclan.framingsystem.repositories;

import com.codeclan.framingsystem.models.PresetPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresetPartRepository extends JpaRepository <PresetPart, Long>{
    List<PresetPart> findPresetPartById(Long id);
}
