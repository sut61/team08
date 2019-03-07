package com.sut.se.cpe.server;

import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;
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
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkScheduleTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StaffRepository staffRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
   @Test
    public void testDataSuccess(){
        Staff staff = new Staff();
        staff.setStaffName("mingming");
        staff.setLabStaffId("S12345");
        staff.setTel("0912345678");
        try {
            entityManager.persist(staff);
            entityManager.flush();

            System.out.println("\n\n======================>DataSuccessCase<========================");
            System.out.println("\n");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testMustNotBeNull(){
        Staff staff = new Staff();
        staff.setStaffName("mingming");
        staff.setLabStaffId(null);
        staff.setTel("0912345678");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>MustNotBeNullCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    @Test
    public void testSizeNameOver(){
        Staff staff = new Staff();
        staff.setStaffName("mingmingmingmingmingmingmingmingmingmingg");
        staff.setLabStaffId("S12345");
        staff.setTel("0912345678");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>SizeNameOver<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    @Test
    public void testPatternId(){
        Staff staff = new Staff();
        staff.setStaffName("mingming");
        staff.setLabStaffId("S12345ww");
        staff.setTel("0912345678");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>PatternIdCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPatternTel(){
        Staff staff = new Staff();
        staff.setStaffName("mingming");
        staff.setLabStaffId("S12345");
        staff.setTel("09123456789");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>PatternTelCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}