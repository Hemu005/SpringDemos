package com.doctorapp.util;

public class Queries {
    public static final String InsertQuery="INSERT INTO DOCTOR(doctor_name,speciality,fees,ratings,experience) VALUES (?,?,?,?,?)";
    
    public static final String UpdateQuery="UPDATE DOCTOR SET fees=? WHERE doctor_id=?";
    
    public static final String DeleteQuery="DELETE FROM DOCTOR WHERE doctor_id=? ";

    public static final String findAllQuery="SELECT * FROM DOCTOR";

    public static final String findBySpeciality="SELECT * FROM DOCTOR WHERE speciality=?";

    public static final String findBySpecialityAndExp=
             "SELECT * FROM DOCTOR WHERE speciality=? AND experience=?";

    public static final String findBySpecialityAndLessFees=
            "SELECT * FROM DOCTOR WHERE speciality=? AND fees<=?";

    public static final String findBySpecialityAndRatings=
            "SELECT * FROM DOCTOR WHERE speciality=? AND ratings=?";

    public static final String findBySpecialityAndName=
            "SELECT * FROM DOCTOR WHERE speciality=? AND doctor_name";
    
    public static final String findByIdQuery="SELECT * FROM doctor WHERE doctor_id=?";

}
