package com.doctorapp.model;

public class Doctor {
    private Integer doctorId;
    private String doctorName;
    private String speciality;
    private double fees;
    private int rating;
    private int experience;

    public Doctor(Integer doctorId, String doctorName, String speciality, double fees,
                  int rating, int experience) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.fees = fees;
        this.rating = rating;
        this.experience = experience;
    }

    public Doctor(String doctorName, String speciality, double fees, int rating, int experience) {
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.fees = fees;
        this.rating = rating;
        this.experience = experience;
    }

    public Doctor() {

    }

    public Integer getDoctorId(Integer doctorId) {
        return this.doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", fees=" + fees +
                ", rating=" + rating +
                ", experience=" + experience +
                '}';
    }
}
