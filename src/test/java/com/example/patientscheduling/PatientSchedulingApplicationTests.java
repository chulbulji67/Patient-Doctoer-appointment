package com.example.patientscheduling;

import com.example.patientscheduling.entity.Appointment;
import com.example.patientscheduling.entity.Doctor;
import com.example.patientscheduling.entity.Patient;
import com.example.patientscheduling.repo.AppointmentRepo;
import com.example.patientscheduling.repo.DoctoerRepo;
import com.example.patientscheduling.repo.PatientRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
class PatientSchedulingApplicationTests {

	@Autowired
	DoctoerRepo doctoerRepo;

	@Autowired
	PatientRepo patientRepo;

	@Autowired
	AppointmentRepo appointmentRepo;

//	Logger logger = (Logger) LoggerFactory.getLogger(PatientSchedulingApplicationTests.class);


	@Test
	void addDoctor() {
		Doctor doctor = new Doctor();
		doctor.setDockerId(1);
		doctor.setDoctorName("Harsh");
		doctoerRepo.save(doctor);
	}

	@Test
	void addPatient(){
		Patient patient = new Patient();
		patient.setPatientId(1);
		patient.setPatientName("Marij");
		Doctor doctor = doctoerRepo.findById(1L).get();
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(doctor);
		patient.setDoctors(doctors);
		patientRepo.save(patient);
	}

	@Test
	void  addAppointment(){
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setAppointmentDate(new Date());
		appointment.setPatient(patientRepo.findById(1L).get());
		appointment.setDoctor(doctoerRepo.findById(1L).get());
		appointmentRepo.save(appointment);
	}

	//Getting all appointmentDetails by patientId
//	@Transactional
	@Test
	void getAppointmentDetails(){
		Patient patient = patientRepo.findById(1L).get();
		List<Appointment> appointments = patient.getAppointments();
		appointments.forEach(appointment -> System.out.println(appointment.getAppointmentDate()));

	}

	//GetAll doctor based on patientId
	@Test
	public void getDoctorsByPatientId(){
		long patientId = 1L;
		Patient patient = patientRepo.findById(patientId).get();
		List<Doctor> doctors = patient.getDoctors();
		doctors.forEach(doctor -> System.out.println(doctor.getDoctorName()));
	}

	//GetAll Patient based on DoctoerId
	@Test
	public void getDoctorsByDoctortId(){
		long doctorId = 1L;
		Doctor doctor = doctoerRepo.findById(doctorId).get();
		List<Patient> patients = doctor.getPatients();
		patients.forEach(patient -> System.out.println(patient.getPatientName()));
	}

	//Fetch All doctor Based on appointment id
	@Test
	void getAllDoctorBasedOnAppointmentId(){
		Appointment appointment = appointmentRepo.findById(1L).get();
		Doctor doctor = appointment.getDoctor();
		Patient patient = appointment.getPatient();
		System.out.println(doctor.getDoctorName());
		System.out.println(patient.getPatientName());
	}

	//FetchAllAppointmentDetailsBasedOnDoctoerId

	@Test
	void fetchAppointmentsByDoctorId(){
		Doctor doctor = doctoerRepo.findById(1L).get();
		List<Appointment> appointments = doctor.getAppointments();
		appointments.forEach(appointment -> System.out.println(appointment.getAppointmentDate()));
	}

	//FetchAllAppointmentDetailsBasedOnPatientId

	@Test
	void fetchAppointmentsByPatinetID(){
		Patient patient = patientRepo.findById(1L).get();
		List<Appointment> appointments = patient.getAppointments();
		appointments.forEach(appointment -> System.out.println(appointment.getAppointmentDate()));
	}

}
