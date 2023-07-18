package com.example.cardiotomsk.objectModels;

import java.util.ArrayList;
import java.util.Date;

public class User {
   private int id;
   private String first_name;
   private String second_name;
   private String patronymic;
   private int phone;
   private String email;
   private int gender;
   private Date date_of_birth;

   private ArrayList<Appointment> appointments;
   private ArrayList<Pill> pills;

   public User() {
   }
   public User(int id, String first_name, String second_name, String patronymic, int phone, String email, int gender, Date date_of_birth) {
      this.id = id;
      this.first_name = first_name;
      this.second_name = second_name;
      this.patronymic = patronymic;
      this.phone = phone;
      this.email = email;
      this.gender = gender;
      this.date_of_birth = date_of_birth;
   }

   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }

   public String getFirst_name() {
      return first_name;
   }
   public void setFirst_name(String first_name) {
      this.first_name = first_name;
   }

   public String getSecond_name() {
      return second_name;
   }
   public void setSecond_name(String second_name) {
      this.second_name = second_name;
   }

   public String getPatronymic() {
      return patronymic;
   }
   public void setPatronymic(String patronymic) {
      this.patronymic = patronymic;
   }

   public int getPhone() {
      return phone;
   }
   public void setPhone(int phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }

   public int getGender() {
      return gender;
   }
   public void setGender(int gender) {
      this.gender = gender;
   }

   public Date getDate_of_birth() {
      return date_of_birth;
   }
   public void setDate_of_birth(Date date_of_birth) {
      this.date_of_birth = date_of_birth;
   }

   public ArrayList<Appointment> getAppointments() {
      return appointments;
   }
   public void setAppointments(ArrayList<Appointment> appointments) {
      this.appointments = appointments;
   }

   public ArrayList<Pill> getPills() {
      return pills;
   }
   public void setPills(ArrayList<Pill> pills) {
      this.pills = pills;
   }


   public String getGenderString() {
      if (gender == 0) return "Муж";
      if (gender == 1) return "Жен";
      else return "Не указан";
   }

   public void addAppointment(Appointment appointment) {
      appointments.add(appointment);
   }
}
