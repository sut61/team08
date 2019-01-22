package com.sut.se.cpe.server;

import com.sut.se.cpe.server.entity.*;
import com.sut.se.cpe.server.repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import java.util.Date;

@SpringBootApplication
public class ServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	ApplicationRunner init(RegisterRepository registerrepository, ProvinceRepository provincerepository, PatienttypeRepository patienttyperepository, SexRepository sexrepository) {
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
		};
	}
}