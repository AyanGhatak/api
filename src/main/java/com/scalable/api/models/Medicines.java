package com.scalable.api.models;

import java.util.List;

public class Medicines {
    private int id;
    private List<Object> medicines;

    public Medicines() {
    }

    public Medicines(int medicineId) {
        this.id = medicineId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return medicines;
    }

    public void setMedicines(List<Object> medicines) {
        this.medicines = medicines;
    }
}
