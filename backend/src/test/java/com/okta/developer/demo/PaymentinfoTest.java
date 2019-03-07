package com.sut.se.cpe.server;
import lombok.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Date;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;
import javax.persistence.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentinfoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PaymentinfoRepository paymentinfoRepository;



    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDataSuccess(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("55555");
        paymentinfo.setNote("okay");
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();

            System.out.println("\n\n======================>DataSuccessCase<========================");
            System.out.println("\n");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testTooShortPay(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("1");
        paymentinfo.setNote("okay");
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();

            System.out.println("\n\n======================>DataSuccessCase<========================");
            System.out.println("\n");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testsetsetPayPriceNotBeNull(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice(null);
        paymentinfo.setNote("okay");
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetsetPayPriceNotBeNull<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testsetsetPayPriceNotBeSize(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("4444444444444444444444444444444444444444444");
        paymentinfo.setNote("okay");
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetsetPayPriceNotBeSize<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testsetPayPriceNotPattern(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("hhhhh");
        paymentinfo.setNote("okay");
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetsetPayPriceNotPattern<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }

    @Test
    public void testsetNoteNotNull(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("500");
        paymentinfo.setNote(null);
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetsetPayPriceNotPattern<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }

    @Test
    public void testsetMediNotNull(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("500");
        paymentinfo.setNote("none");
        paymentinfo.setMediList(null);
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetsetPayPriceNotPattern<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }

    @Test
    public void testsetTreatNotNull(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("500");
        paymentinfo.setNote("non");
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList(null);
        paymentinfo.setSpecialNote("non");

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetsetPayPriceNotPattern<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }

    @Test
    public void testsetSpecialNotNull(){
        Paymentinfo paymentinfo = new Paymentinfo();
        paymentinfo.setPayPrice("500");
        paymentinfo.setNote("non");
        paymentinfo.setMediList("พาราเซตามอล");
        paymentinfo.setTreatList("รักษาอาการปวด");
        paymentinfo.setSpecialNote(null);

        try {
            entityManager.persist(paymentinfo);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetsetPayPriceNotPattern<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }





}
