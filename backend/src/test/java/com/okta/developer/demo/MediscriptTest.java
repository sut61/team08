package com.sut.se.cpe.server.test;
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
public class MediscriptTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MediscriptRepository mediscriptRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDataSuccess(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("55555");
        mediscript.setNote("okay");
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
            entityManager.flush();

            System.out.println("\n\n======================>DataSuccessCase<========================");
            System.out.println("\n");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }

    @Test
    public void testTooShort(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("1");
        mediscript.setNote("okay");
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
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
    public void testsetMediscriptNotBeNull(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi(null);
        mediscript.setNote("okay");
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>mediscriptNotBeNullCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testsetMediscriptNotBeSize(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("4444444444444444444444444444444444444444444");
        mediscript.setNote("okay");
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetMediscriptNotBeSize<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testsetMediscriptNotPattern(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("hhhhh");
        mediscript.setNote("okay");
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>testsetMediscriptNotPattern<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }


    public void testsetNoteNotBeNull(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("55555");
        mediscript.setNote(null);
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>mediscriptNotBeNullCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }

    public void testsetOrderNotBeNull(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("55555");
        mediscript.setNote("okay");
        mediscript.setOrderPlace(null);
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>mediscriptNotBeNullCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }

    public void testsetPostNotBeNull(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("55555");
        mediscript.setNote("okay");
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace(null);
        mediscript.setPriceOrder("500000");

        try {
            entityManager.persist(mediscript);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>mediscriptNotBeNullCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }

    public void testsetPriceNotBeNull(){
        Mediscript mediscript = new Mediscript();
        mediscript.setAmountMedi("55555");
        mediscript.setNote("okay");
        mediscript.setOrderPlace("Lab");
        mediscript.setPostPlace("30000");
        mediscript.setPriceOrder(null);

        try {
            entityManager.persist(mediscript);
            entityManager.flush();
            //fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>mediscriptNotBeNullCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }





}
