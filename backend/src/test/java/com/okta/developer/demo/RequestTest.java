package com.okta.developer.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RequestTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RequestFormRepository requestformRepository;

    @Autowired
    private ApproverRepository approverRepository;
    
    @Autowired 
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired 
    private SurrogateRepository surrogateRepository;

    @Autowired 
    private ToolRepository toolRepository;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void contextLoads() {
        System.out.println("Test Successful");
    }
    @Test
    public void testSuccess() {
        RequestForm rq = new RequestForm();
        rq.setAmount(5);
        rq.setObjective("ล่าช้า");
        rq.setSgname("นายสนาน");

        try {

            entityManager.persist(rq);
            entityManager.flush();

            fail("Should not pass to this line");
        }
        catch(javax.validation.ConstraintViolationException e) {
            System.out.println("==================== from testSuccess =====================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test 
    public void testSgnameNull() {
        RequestForm rq = new RequestForm();
        rq.setAmount(5);
        rq.setObjective("สบาย");
        rq.setSgname(null);

        try {

            entityManager.persist(rq);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println("==================== from testSgnameNull =====================");
            System.out.println(e);
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
        public void testSgnameMinsize() {
            RequestForm rq = new RequestForm();
            rq.setAmount(5);
            rq.setObjective("สบาย");
            rq.setSgname("ddddd");

            try {
                entityManager.persist(rq);
                entityManager.flush();

                fail("Should not pass to this line");

            } catch (javax.validation.ConstraintViolationException e){
                System.out.println("==================== from testSgnameMinsize =====================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);

            }

        }
        @Test
        public void testSgnameMaxsize() {
            RequestForm rq = new RequestForm();
            rq.setAmount(5);
            rq.setObjective("สบาย");
            rq.setSgname("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");

            try {
                entityManager.persist(rq);
                entityManager.flush();

                fail("Should not pass to this line");

            } catch (javax.validation.ConstraintViolationException e){
                System.out.println("==================== from testSgnameMaxsize =====================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 2);

            }

        }
        @Test
        public void testSgnamePatternNotNumber() {
            RequestForm rq = new RequestForm();
            rq.setAmount(5);
            rq.setObjective("สบาย");
            rq.setSgname("56789");

            try {
                entityManager.persist(rq);
                entityManager.flush();

                fail("Should not pass to this line");

            } catch (javax.validation.ConstraintViolationException e){
                System.out.println("==================== from testSgnamePatternNotNumber =====================");
                System.out.println(e);
                Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                assertEquals(violations.isEmpty(), false);
                assertEquals(violations.size(), 1);

            }

        }
    }
