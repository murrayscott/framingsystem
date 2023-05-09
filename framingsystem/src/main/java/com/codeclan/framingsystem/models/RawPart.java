package com.codeclan.framingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "raw_parts")
public class RawPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double width;
    private double height;
    private double length;
    private Enum type;
    private double unitMultiple;
    private boolean partStatus;
    private int progress;
    private boolean deleted;

    public RawPart(String description, double width, double height, double length, Enum type, double unitMultiple, boolean partStatus, int progress, boolean deleted) {
        this.description = description;
        this.width = width;
        this.height = height;
        this.length = length;
        this.type = type;
        this.unitMultiple = unitMultiple;
        this.partStatus = partStatus;
        this.progress = progress;
        this.deleted = deleted;
    }

    public RawPart() {
    }

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public double getUnitMultiple() {
        return unitMultiple;
    }

    public void setUnitMultiple(double unitMultiple) {
        this.unitMultiple = unitMultiple;
    }

    public boolean isPartStatus() {
        return partStatus;
    }

    public void setPartStatus(boolean partStatus) {
        this.partStatus = partStatus;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}

