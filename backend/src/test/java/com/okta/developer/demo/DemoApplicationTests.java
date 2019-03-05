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

	//Patient
	@Test
	public void PatientInsertTest(){
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		entityManager.persist(p);
		entityManager.flush();
	}

	@Test
	public void PatientNullFirstnameTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname(null);
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Null Firstname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientNullLastnameTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname(null);
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Null Lastname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientNullDistrictTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict(null);
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Null District");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientNullSubdistrictTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict(null);
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Null Subdistrict");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientNullHousenumberTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber(null);
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Null Housenumber");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientNullPostcodeTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode(null);
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Null Postcode");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientNullPatientdetailTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail(null);
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Null Patientdetail");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientShortenFirstnameTest(){
		//Patient null test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("N");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shorten Firstname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientShortenLastnameTest(){
		//Patient Shorten test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("T");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shorten Lastname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientShortenDistrictTest(){
		//Patient Shorten test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เ");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shorten District");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientShortenSubdistrictTest(){
		//Patient Shorten test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ใ");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shorten Subdistrict");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientShortenHousenumberTest(){
		//Patient Shorten test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("3");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shorten Housenumber");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientShortenPostcodeTest(){
		//Patient Shorten test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("3");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shorten Postcode");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientShortenPatientdetailTest(){
		//Patient Shorten test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("c");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Shorten Patientdetail");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientLongerFirstnameTest(){
		//Patient Longer test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUTTTTTTTTTTTTTTTTTT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longer Firstname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientLongerLastnameTest(){
		//Patient Longer test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERTTTTTTTTTTTTTTTT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longer Lastname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientLongerDistrictTest(){
		//Patient Longer test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมืองงงงงงงงงงงงงงงงงงงงง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longer District");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientLongerSubdistrictTest(){
		//Patient Longer test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมืองงงงงงงงงงงงงงงงงงง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longer Subdistrict");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientLongerHousenumberTest(){
		//Patient Longer test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386 หมู่ 1 ถนน สุรรารายณ์");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longer Housenumber");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientLongerPostcodeTest(){
		//Patient Longer test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000000000000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longer Postcode");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientLongerPatientdetailTest(){
		//Patient Longer test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a coldddddddddddddddddddddddddddddddddddddddd");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect Longer Patientdetail");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientPatternFirstnameTest(){
		//Patient Pattern test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT1");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong Pattern Firstname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientPatternLastnameTest(){
		//Patient Pattern test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT1");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong Pattern Lastname");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientPatternDistrictTest(){
		//Patient Pattern test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง1");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong Pattern District");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientPatternSubdistrictTest(){
		//Patient Pattern test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง1");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong Pattern Subdistrict");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientPatternPostcodeTest(){
		//Patient Pattern test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("3GGWP");
		p.setPatientdetail("caght a cold");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong Pattern Postcode");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void PatientPatternPatientdetailTest(){
		//Patient Pattern test
		Patient p = new Patient();
		Patienttype b = this.patienttypeRepository.findByid(1L);
        Province o = this.provinceRepository.findByid(1L);
        Sex n = this.sexRepository.findByid(1L);
        p.setPatienttype(b);
        p.setProvince(o);
        p.setSex(n);
		p.setFirstname("NUTTAWUT");
		p.setLastname("TUNPRASERT");
		p.setDistrict("เมือง");
		p.setSubdistrict("ในเมือง");
		p.setHousenumber("386");
		p.setPostcode("30000");
		p.setPatientdetail("caght a cold1");
		try {
			entityManager.persist(p);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("can detect wrong Pattern Patientdetail");
			System.out.println(e);
			System.out.println();
		}
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

	@Test
	public void OndutyinsertTest(){
		//insert Onduty
		Onduty on = new Onduty();
		Lab a = this.labRepository.findByid(1L);
        Doctor b = this.doctorRepository.findByid(1L);
        on.setLab(a);
        on.setDoctor(b);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport("everything's fine");
		on.setBrokenreport("none");
		entityManager.persist(on);
		entityManager.flush();
	}

	@Test
	public void OndutyNullSignTest(){
		//null Sign test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign(null);
		on.setDailyreport("everything's fine");
		on.setBrokenreport("none");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect null Sign");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyNullDailyreportTest(){
		//null Dailyreport test 
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport(null);
		on.setBrokenreport("none");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect null Dailyreport");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyNullBrokenreportTest(){
		//null Brokenreport test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport("everything's fine");
		on.setBrokenreport(null);
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect null Brokenreport");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyNullOndutydateTest(){
		//null Ondutydate test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(null);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport("everything's fine");
		on.setBrokenreport("none");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect null Ondutydate");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyShortenSignTest(){
		//Shorten Sign test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณ");
		on.setDailyreport("everything's fine");
		on.setBrokenreport("none");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect Shorten Brokenreport");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyShortenDailyreportTest(){
		//Shorten Sign test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport("e");
		on.setBrokenreport("none");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect Shorten Dailyreport");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyShortenBrokenreportTest(){
		//Shorten Sign test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport("everything's fine");
		on.setBrokenreport("n");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect Shorten Brokenreport");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyLongestSignTest(){
		//Longest Sign test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิณณณณณณณณณณณณณณ");
		on.setDailyreport("everything's fine");
		on.setBrokenreport("none");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect Longest Sign");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyLongestDailyreportTest(){
		//Longest Dailyreport test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport("everything's fineeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		on.setBrokenreport("none");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect Longest Dailyreport");
			System.out.println(e);
			System.out.println();
		}
	}

	@Test
	public void OndutyLongestBrokenreportTest(){
		//Longest Brokenreport test
		Onduty on = new Onduty();
		Lab b = this.labRepository.findByid(1L);
        Doctor o = this.doctorRepository.findByid(1L);
        on.setLab(b);
        on.setDoctor(o);
        Date date = new Date();
        on.setOndutydate(date);
		on.setSign("ณัฐวุฒิ");
		on.setDailyreport("everything's fine");
		on.setBrokenreport("nonenonenonenonenonenonenonenonenonenonenonenonenone");
		try {
			entityManager.persist(on);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch (javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println();
			System.out.println("can detect Longest Brokenreport");
			System.out.println(e);
			System.out.println();
		}
	}
}