package com.example.illustris.schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.illustris.order.Order;
import com.example.illustris.order.OrderRepository;
import com.example.illustris.patient.Patient;
import com.example.illustris.patient.PatientRepository;
import com.example.illustris.patient.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    OrderRepository orderRepository;

    public List<Schedule> getSchedule() {
        return scheduleRepository.findAll();
    }

    public void createNewAppt(Schedule schedule) {
        Optional<Schedule> scheduleOptional = scheduleRepository.
        findApptByApptTime(schedule.getApptTime());
        
        Patient patient= patientRepository.find(1l);
        Order order= orderRepository.find(1l);
       
		if (scheduleOptional.isPresent()) {
			throw new IllegalStateException("this appointment day and time is taken");//TODO: use an error message
		}
        
        schedule.setPatient(patient);
        schedule.setOrder(order);
		scheduleRepository.save(schedule);
        
    }

    public void deleteSchedule(Long scheduleId) {
        boolean exists=scheduleRepository.existsById(scheduleId);
		if (!exists) {
			throw new IllegalStateException("appointment with id "+ scheduleId + " does not exist");//TODO: use an error message
		}
		scheduleRepository.deleteById(scheduleId);
    }

    public void uadateSchedule(Long scheduleId, LocalDateTime apptTime, Patient patient,
            Order order) {
                Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() ->new IllegalStateException(
                    "appointment with id "+ scheduleId + " does not exist"));//TODO: use an error message
        
                if (patient != null && !Objects.equals(schedule.getPatient(), patient)) {
                    schedule.setPatient(patient);
                }

                if (order != null && !Objects.equals(schedule.getOrder(), order)) {
                    schedule.setOrder(order);
                }

                if (apptTime != null && apptTime.compareTo(LocalDateTime.now()) >0 
                && !Objects.equals(schedule.getApptTime(), apptTime)) {
                    Optional<Schedule> scheduleOptional = scheduleRepository
                    .findApptByApptTime(apptTime);
                    if (scheduleOptional.isPresent()) {
                        throw new IllegalStateException("appointment time taken");//TODO: use an error message
                    }
                    schedule.setApptTime(apptTime);
                }
    }
}
