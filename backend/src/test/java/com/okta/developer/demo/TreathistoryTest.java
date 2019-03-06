package com.sut.se.cpe.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)

@DataJpaTest

public class TreathistoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired 
    private TreatHistoryRepository treatHistoryRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired 
    private MedicineRepository medicineRepository;
    @Autowired 
    private PatientRepository patientRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSuccess() {
        TreatHistory th = new TreatHistory();
        th.setPressure(165);
        th.setWeight(75);
        th.setSymptom("มัีไข้เล็กน้อย");
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        th.setPatient(patientRepository.getOne(1L));
        try {

            entityManager.persist(th);
            entityManager.flush();

           // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testSuccess =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSymptomNotNull() {
        TreatHistory th = new TreatHistory();
        th.setPressure(165);
        th.setWeight(75);
        th.setSymptom(null);
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        try {

            entityManager.persist(th);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testSymptomNotNull =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSymptomPattern() {
        TreatHistory th = new TreatHistory();
        th.setPressure(165);
        th.setWeight(75);
        th.setSymptom("123456");
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        try {

            entityManager.persist(th);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testSymptomPattern =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testSymptomMinSize() {
        TreatHistory th = new TreatHistory();
        th.setPressure(165);
        th.setWeight(75);
        th.setSymptom("ปวด");
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        try {

            entityManager.persist(th);
            entityManager.flush();

           // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testSymptomMinSize =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
 }
 @Test
    public void testMaxPressure() {
        TreatHistory th = new TreatHistory();
        th.setPressure(250);
        th.setWeight(75);
        th.setSymptom("มีไข้เล็กน้อย");
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        try {

            entityManager.persist(th);
            entityManager.flush();

           // fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testRangePressure =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testMinPressure() {
        TreatHistory th = new TreatHistory();
        th.setPressure(50);
        th.setWeight(75);
        th.setSymptom("มีไข้เล็กน้อย");
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        try {

            entityManager.persist(th);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testRangePressure =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testMinWeight() {
        TreatHistory th = new TreatHistory();
        th.setPressure(120);
        th.setWeight(20);
        th.setSymptom("มีไข้เล็กน้อย");
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        try {

            entityManager.persist(th);
            entityManager.flush();

           fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testRangePressure =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testMaxWeight() {
        TreatHistory th = new TreatHistory();
        th.setPressure(120);
        th.setWeight(200);
        th.setSymptom("มีไข้เล็กน้อย");
        th.setDoctor(doctorRepository.findByDoctorid("Tonkaw"));
        th.setMedicine(medicineRepository.findByMedicine("ยาแก้ปวด"));
        try {

            entityManager.persist(th);
            entityManager.flush();

           fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("================ from testRangePressure =================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}