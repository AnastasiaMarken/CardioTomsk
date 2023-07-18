package com.example.cardiotomsk.objectModels;

import java.util.Date;

public class Appointment {

	private int id;
	//потом удалить
	private User user;
	private Doctor doctor;
	private Date appointment_date_time;

	public Appointment() {
	}
	public Appointment(int id, User user, Doctor doctor, Date appointment_date_time) {
		this.id = id;
		this.user = user;
		this.doctor = doctor;
		this.appointment_date_time = appointment_date_time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getAppointment_date_time() {
		return appointment_date_time;
	}
	public void setAppointment_date_time(Date appointment_date_time) {
		this.appointment_date_time = appointment_date_time;
	}

}
