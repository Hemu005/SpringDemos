package com.doctorapp.model;

public enum Specialization {
   ORTHO("ORTHOPEDIATRICIAN"),
    PEDIA("PEDIATRICIAN"),
    PHYSICIAN("GENERAL PHYSICIAN"),
    GYNAEC("GYNAECOLOGIST"),
    NEURO("NEUROLOGIST"),
    DERMA("DERMATOLOGIST");

    public String getSpeciality() {
        return speciality;
    }

    private final String speciality;

    Specialization(String speciality) {
        this.speciality = speciality;
    }

}
