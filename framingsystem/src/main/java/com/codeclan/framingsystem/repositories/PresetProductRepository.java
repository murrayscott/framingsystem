package com.codeclan.framingsystem.repositories;

import com.codeclan.framingsystem.models.PresetProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresetProductRepository extends JpaRepository <PresetProduct, Long>{
    List<PresetProduct> findProductById(Long id);
}
