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
public class DemoApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PatienttypeRepository patienttypeRepository;

	@Autowired
	private LabRepository labRepository;

	@Autowired
	private OndutyRepository ondutyRepository;

	@Autowired
	private ProvinceRepository provinceRepository;

	@Autowired
	private SexRepository sexRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	//Sprint 1 test
	//Test sexclass
	@Test
	public void SexInsertTest(){
		Sex sex = new Sex();
		sex.setSex("Tom");
		sex.setNametitle("นางสาว");
		entityManager.persist(sex);
		entityManager.flush();
	}

	@Test
	public void SexNullTest(){
		//sex Null test
		Sex sex = new Sex();
		sex.setSex(null);
		sex.setNametitle("นางสาว");
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect null sex");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void NameTitleNullTest(){
		//NameTitle Null test
		Sex sex = new Sex();
		sex.setSex("Tom");
		sex.setNametitle(null);
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect null nametitle");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void SexShortStringTest(){
		//sex Short String test
		Sex sex = new Sex();
		sex.setSex("T");
		sex.setNametitle("นางสาว");
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect sex shortstring");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void SexLongStringTest(){
		//sex long string test
		Sex sex = new Sex();
		sex.setSex("Thompson submachine gun");
		sex.setNametitle("นางสาว");
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect sex longstring");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void NametitleshortStringTest(){
		//nametitle short string test
		Sex sex = new Sex();
		sex.setSex("Tom");
		sex.setNametitle("น");
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Nametitle shortstring");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void NametitleLongStringTest(){
		//nametitle long string test
		Sex sex = new Sex();
		sex.setSex("Tom");
		sex.setNametitle("นางสาวงามที่สุดในจักรวาร");
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Nametitle longstring");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void SexworsepatternTest(){
		//nametitle worse pattern test
		Sex sex = new Sex();
		sex.setSex("Tom007");
		sex.setNametitle("นางสาว");
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong pattern");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void NametitleworsepatternTest(){
		//nametitle worse pattern test
		Sex sex = new Sex();
		sex.setSex("Tom");
		sex.setNametitle("นางสาว007");
		try {
			entityManager.persist(sex);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong pattern");
			System.out.println(e);
			System.out.println();
		}
	}

	//Test province class
	@Test
	public void ProvinceInsertTest(){
		Province prov = new Province();
		prov.setProvince("Rumprang");
		entityManager.persist(prov);
		entityManager.flush();
	}

	@Test
	public void ProvinceNullTest(){
		//Province = Null
		Province prov = new Province();
		prov.setProvince(null);
		try {
			entityManager.persist(prov);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect null province");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void ProvinceTooShortsizeTest(){
		//Province = Shortsize
		Province prov = new Province();
		prov.setProvince("A");
		try {
			entityManager.persist(prov);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect shorten size");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void ProvinceTooLongStringTest(){
		//Province = Longestsize
		Province prov = new Province();
		prov.setProvince("GUNGTHABMAHANAKONAMONRATTANAGOSINMAHINTARAAYUTAYAMAHADILOG");
		try {
			entityManager.persist(prov);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longest size");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void ProvinceWorsePatternTest(){
		//Province = worse pattern
		Province prov = new Province();
		prov.setProvince("Bangkok1");
		try {
			entityManager.persist(prov);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longest size");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void ProvinceUniqueTest(){
		//Province = Duplicate
		Province prov = new Province();
		prov.setProvince("Naan");
		entityManager.persist(prov);
		entityManager.flush();

		Province prov1 = new Province();
		prov1.setProvince("Naan");
		try {
			entityManager.persist(prov1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.persistence.PersistenceException e) {
			System.out.println("can detect Duplicate unique");
			System.out.println(e);
			System.out.println();
		}
	}

	//patient type
	@Test
	public void PatienttypeInsertTest(){
		Patienttype p = new Patienttype();
		p.setType("ICU guest");
		p.setDetail("EMERGENCY patient");
		entityManager.persist(p);
		entityManager.flush();
	}

	//Sprint 2 test
	//test labclass
	@Test
	public void NormalLabidtest() {
		Lab l = new Lab();
		l.setLabid("113");
		l.setLabaddress("main building 3 floor");
		entityManager.persist(l);
		entityManager.flush();

		Lab l2 = new Lab();
		l2.setLabid("114");
		l2.setLabaddress("main building 4 floor");
		entityManager.persist(l2);
		entityManager.flush();
		System.out.println("It's a normal input test");

	}

	@Test
	public void NullLabidtest() {
		//Labid = Null
		Lab l = new Lab();
		l.setLabid(null);
		l.setLabaddress("main building 5 floor");
		try {
			entityManager.persist(l);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect null Labid");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void ShortsizeLabidtest() {
		//Labid = Shortsize
		Lab l = new Lab();
		l.setLabid("1");
		l.setLabaddress("main building 6 floor");
		try {
			entityManager.persist(l);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shortsize Labid");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatternLabidtest() {
		//Labid = string and int input
		Lab l = new Lab();
		l.setLabid("1A2B");
		l.setLabaddress("main building 7 floor");
		try {
			entityManager.persist(l);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect string and int input Labid");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OversizeLabidtest() {
		//Labid = oversize
		Lab l = new Lab();
		l.setLabid("11122223333123123123");
		l.setLabaddress("main building 8 floor");
		try {
			entityManager.persist(l);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect Oversize Labid");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void UniqueLabidtest() {
		//Labid = Duplicate Unique
		Lab l = new Lab();
		l.setLabid("111");
		l.setLabaddress("main building 1 floor");
		entityManager.persist(l);
		entityManager.flush();

		Lab l1 = new Lab();
		l1.setLabid("111");
		l1.setLabaddress("main building 2 floor");
		try {
			entityManager.persist(l1);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.persistence.PersistenceException e) {
			System.out.println("can detect Unique Duplicate.");
			System.out.println(e);
		}
	}

	//Doctor test
	@Test
	public void DoctorInsertTest(){
		Doctor doc = new Doctor();
		doc.setDoctorname("Dr.Octopus");
		doc.setDoctorid("Octopus");
		doc.setPassword("55555");
		entityManager.persist(doc);
		entityManager.flush();
	}

	@Test
	public void DoctorNullTest(){
		//Doctorname null
		Doctor doc = new Doctor();
		doc.setDoctorname(null);
		doc.setDoctorid("Octopus");
		doc.setPassword("55555");
		try {
			entityManager.persist(doc);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect null Doctorname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void DoctoridNullTest(){
		//Doctorid null
		Doctor doc = new Doctor();
		doc.setDoctorname("Dr.Octopus");
		doc.setDoctorid(null);
		doc.setPassword("55555");
		try {
			entityManager.persist(doc);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect null Doctorid");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PasswordNullTest(){
		//Password null
		Doctor doc = new Doctor();
		doc.setDoctorname("Dr.Octopus");
		doc.setDoctorid("Octopus");
		doc.setPassword(null);
		try {
			entityManager.persist(doc);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect null Password");
			System.out.println(e);
			System.out.println();
		}
	}
}