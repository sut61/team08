package com.sut.se.cpe.server;

import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import java.util.Date;

@SpringBootApplication
public class ServerApplication {

	@Autowired
	TreatHistoryRepository treatHistoryRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	MedicineRepository medicineRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	ApplicationRunner init(RegisterRepository registerrepository, ProvinceRepository provincerepository, PatienttypeRepository patienttyperepository, SexRepository sexrepository,
	TreatHistoryRepository treatHistoryRepository, DoctorRepository doctorRepository,
	MedicineRepository medicineRepository	) {
		return args -> {
			//set Patient type
			Patienttype pat1 = new Patienttype();
			pat1.setType("Inner Patient");
			pat1.setDetail("Patient That must be observe in hospital.");
			patienttyperepository.save(pat1);

			Patienttype pat2 = new Patienttype();
			pat2.setType("Outer Patient");
			pat2.setDetail("Patient That walk-in or can return back home.");
			patienttyperepository.save(pat2);

			//set Sex
			Sex m1 = new Sex();
			m1.setSex("Male");
			m1.setNametitle("นาย");
			sexrepository.save(m1);

			Sex m2 = new Sex();
			m2.setSex("Male");
			m2.setNametitle("เด็กชาย");
			sexrepository.save(m2);

			Sex f1 = new Sex();
			f1.setSex("Female");
			f1.setNametitle("นาง");
			sexrepository.save(f1);

			Sex f2 = new Sex();
			f2.setSex("Female");
			f2.setNametitle("นางสาว");
			sexrepository.save(f2);

			Sex f3 = new Sex();
			f3.setSex("Female");
			f3.setNametitle("เด็กหญิง");
			sexrepository.save(f3);

			//set Province
			Province p1 = new Province();
			p1.setProvince("Nakonratchasima");
			provincerepository.save(p1);

			//set medicine
			Medicine med1 = new Medicine();
			Medicine med2 = new Medicine();
			Medicine med3 = new Medicine();
			med1.setMedicine("ยาแก้ไข้");
			med2.setMedicine("ยาแก้ปวด");
			med3.setMedicine("ยาแก้อักเสบ");
			medicineRepository.save(med1);
			medicineRepository.save(med2);
			medicineRepository.save(med3);

			//set doctor
			Doctor doc1 = new Doctor();
			doc1.setDoctor("Tonkaw");
			doc1.setPassword("Tonkaw");
			doctorRepository.save(doc1);
		};
	}
}
