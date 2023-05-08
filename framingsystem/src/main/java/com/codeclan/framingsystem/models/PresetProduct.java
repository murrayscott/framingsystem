package com.codeclan.framingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "preset_products")
public class PresetProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "print_height")
    private double printHeight;
    @Column(name = "print_width")
    private double printWidth;
    @Column(name = "mount_overlap")
    private double mountOverlap;
    @Column(name = "mount_size_top")
    private double mountSizeTop;
    @Column(name = "mount_size_left")
    private double mountSizeLeft;
    @Column(name = "mount_size_right")
    private double mountSizeRight;
    @Column(name = "mount_Size_bottom")
    private double mountSizeBottom;
    @Column(name = "qty")
    private int qty;
    @Column(name = "deleted")
    private boolean deleted;

//    Link downwards to PresetPart
    @JsonIgnoreProperties({"preset_products"})
    @OneToMany(mappedBy = "presetProduct", fetch = FetchType.LAZY)
    private List<PresetPart> presetParts;

    public PresetProduct(String description, double printHeight, double printWidth, double mountOverlap, double mountSizeTop, double mountSizeLeft, double mountSizeRight, double mountSizeBottom, int qty, boolean deleted) {
        this.description = description;
        this.printHeight = printHeight;
        this.printWidth = printWidth;
        this.mountOverlap = mountOverlap;
        this.mountSizeTop = mountSizeTop;
        this.mountSizeLeft = mountSizeLeft;
        this.mountSizeRight = mountSizeRight;
        this.mountSizeBottom = mountSizeBottom;
        this.qty = qty;
        this.deleted = deleted;
        this.presetParts = new ArrayList<PresetPart>();
    }

    public PresetProduct() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrintHeight() {
        return printHeight;
    }

    public void setPrintHeight(double printHeight) {
        this.printHeight = printHeight;
    }

    public double getPrintWidth() {
        return printWidth;
    }

    public void setPrintWidth(double printWidth) {
        this.printWidth = printWidth;
    }

    public double getMountOverlap() {
        return mountOverlap;
    }

    public void setMountOverlap(double mountOverlap) {
        this.mountOverlap = mountOverlap;
    }

    public double getMountSizeTop() {
        return mountSizeTop;
    }

    public void setMountSizeTop(double mountSizeTop) {
        this.mountSizeTop = mountSizeTop;
    }

    public double getMountSizeLeft() {
        return mountSizeLeft;
    }

    public void setMountSizeLeft(double mountSizeLeft) {
        this.mountSizeLeft = mountSizeLeft;
    }

    public double getMountSizeRight() {
        return mountSizeRight;
    }

    public void setMountSizeRight(double mountSizeRight) {
        this.mountSizeRight = mountSizeRight;
    }

    public double getMountSizeBottom() {
        return mountSizeBottom;
    }

    public void setMountSizeBottom(double mountSizeBottom) {
        this.mountSizeBottom = mountSizeBottom;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<PresetPart> getPresetParts() { return presetParts; }

    public void setPresetParts(List<PresetPart> presetParts) {this.presetParts = presetParts; }
}
