package com.example.cardiotomsk.objectModels;

import java.util.ArrayList;

public class Doctor {
	private int id;
	private String first_name;
	private String second_name;
	private String patronymic;
	private String office;
	private String specialization;

	private ArrayList<Appointment> appointments;


	public Doctor() {
	}
	public Doctor(int id, String first_name, String second_name, String patronymic, String office, String specialization, ArrayList<Appointment> appointments) {
		this.id = id;
		this.first_name = first_name;
		this.second_name = second_name;
		this.patronymic = patronymic;
		this.office = office;
		this.specialization = specialization;
		this.appointments = appointments;
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

	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}

	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}
}
