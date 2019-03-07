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
public class SuggestTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private RequestSuggestionRepository requestSuggestionRepository;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
   @Test
    public void testDataSuccess(){
        Personnel personnel = new Personnel();
        personnel.setPersonnelName("ming mingmi");
        personnel.setLabPersonnelId("P1234567");
        personnel.setGuidanced("งดเครื่องดื่ม");
        try {
            entityManager.persist(personnel);
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
        Personnel personnel = new Personnel();
        personnel.setPersonnelName(null);
        personnel.setLabPersonnelId("P1234567");
        personnel.setGuidanced("งดเครื่องดื่ม");
        try {
            entityManager.persist(personnel);
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
    public void testSizeIdOver(){
        Personnel personnel = new Personnel();
        personnel.setPersonnelName("mingming");
        personnel.setLabPersonnelId("P12345666");
        personnel.setGuidanced("งดเครื่องดื่มาา");
        try {
            entityManager.persist(personnel);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>SizeIdOver<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    
    @Test
    public void testPattern(){
        Personnel personnel = new Personnel();
        personnel.setPersonnelName("mingming");
        personnel.setLabPersonnelId("I1234566");
        personnel.setGuidanced("งดเครื่องดื่มาา");
        try {
            entityManager.persist(personnel);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>PatternCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeNameLess(){
        Personnel personnel = new Personnel();
        personnel.setPersonnelName("ming");
        personnel.setLabPersonnelId("P1234567");
        personnel.setGuidanced("งดเครื่องดื่มาา");
        try {
            entityManager.persist(personnel);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>SizeNameLess<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeGuidancedLess(){
        Personnel personnel = new Personnel();
        personnel.setPersonnelName("mingming");
        personnel.setLabPersonnelId("P1234567");
        personnel.setGuidanced("qwq");
        try {
            entityManager.persist(personnel);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>SizeGuidancedLess<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test(expected=javax.persistence.PersistenceException.class)
    public void testPersonnelIdMustBeUnique() {
        Personnel personnel1 = new Personnel();
        personnel1.setPersonnelName("sunthi");
        personnel1.setLabPersonnelId("P1234567");
        personnel1.setGuidanced("งดเครื่องดื่ม");

        try{
            entityManager.persist(personnel1);
            entityManager.flush();

        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>PersonnelIdUniqeCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }

        Personnel personnel2 = new Personnel();
        personnel2.setPersonnelName("sunthipp");
        personnel2.setLabPersonnelId("P1234567");
        personnel2.setGuidanced("มีครับ");

        try{
            entityManager.persist(personnel2);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>PersonnelIdUniqeCase<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeUserRequestNameOver(){
        RequestSuggestion suggest = new RequestSuggestion();
        suggest.setUserRequestName("mingmingmingmingmingmingmingmingmingmingming");
        suggest.setQuestion("มีตรวจมั้ยครับ");
        suggest.setEmail("non@hotmail.com");
        try {
            entityManager.persist(suggest);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>SizeUserRequestNameOver<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testSizeQuestionOver(){
        RequestSuggestion suggest = new RequestSuggestion();
        suggest.setUserRequestName("mingming");
        suggest.setQuestion("มีตรวจมั้ยครับaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        suggest.setEmail("non@hotmail.com");
        try {
            entityManager.persist(suggest);
            entityManager.flush();
            fail("Should not pass to this line");
        }  catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("\n\n======================>SizeQuestionOver<========================");
            System.out.println(violations);
            System.out.println("\n");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}