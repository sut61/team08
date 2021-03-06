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
	@Autowired
	ApproverRepository approverRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	RequestFormRepository requestformRepository;
	@Autowired
	SurrogateRepository surrogateRepository;
	@Autowired
	ToolRepository toolRepository;
	@Autowired
	MedicaltechniqueRepository medicaltechniqueRepository;
	@Autowired
	OrderlabRepository orderlabRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	 PayerRepository payerRepository;
	 @Autowired
	 PaymentStatusRepository paymentStatusRepository;
	 @Autowired
	PayTypeRepository paytypeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	ApplicationRunner init(PatientRepository patientRepository,
						ProvinceRepository provincerepository, 
						PatienttypeRepository patienttyperepository, 
						SexRepository sexrepository,
						TreatHistoryRepository treatHistoryRepository, 
						DoctorRepository doctorRepository, 
						MedicineRepository medicineRepository,
						LabRepository labRepository,
						ApproverRepository approverRepository, 
						DepartmentRepository departmentRepository,
						RequestFormRepository requestformRepository,
						   NurseRepository nurseRepository,
						   MediRepository mediRepository,
						SurrogateRepository surrogateRepository, 
						ToolRepository toolRepository,
						HealthLabRepository healthLabRepository,
						StaffPositionRepository staffPositionRepository,
						StaffRepository staffRepository,
						WorkScheduleRepository workScheduleRepository,
						HealthProgramRepository healthProgramRepository,
						RequestSuggestionRepository requestSuggestionRepository,
						PersonnelRepository personnelRepository,

                           CompanyRepository companyRepository,
                           PayerRepository payerRepository,
                           PaymentStatusRepository paymentStatusRepository,
                           PayTypeRepository paytypeRepository,

                           SuggestionRepository suggestionRepository,
						UserRepository userRepository,
						WorkdayRepository workdayRepository,
						WorktimeRepository worktimeRepository,
						OrderlabRepository orderlabRepository,
						MedicaltechniqueRepository medicaltechniqueRepository) {
		
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

			Province p2 = new Province();
			p2.setProvince("Bangkok");
			provincerepository.save(p2);

			Nurse nurse = new Nurse();
			Nurse nurse1 = new Nurse();
			nurse.setNameNurse("พยาบาลคนสวย");
			nurse1.setNameNurse("พยาบาลใจดี");
			nurseRepository.save(nurse);
			nurseRepository.save(nurse1);

			Medi medi = new Medi();
			Medi medi1 = new Medi();
			medi.setMediName("M1");
			medi1.setMediName("M2");
			mediRepository.save(medi);
			mediRepository.save(medi1);


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
			doc1.setDoctorname("Dr.Tonkaw");
			doc1.setDoctorid("Tonkaw");
			doc1.setPassword("Tonkaw");
			doctorRepository.save(doc1);

			//set lab
			Lab lab1 = new Lab();
			lab1.setLabid("112");
			lab1.setLabaddress("main building 2 floor");
			labRepository.save(lab1);

			//set surrogent
			Surrogate sg1 = new Surrogate();
			Surrogate sg2 = new Surrogate();
			sg1.setSurrogate("พยาบาล");
			sg2.setSurrogate("ผู้ช่วยพยาบาล");
			surrogateRepository.save(sg1);
			surrogateRepository.save(sg2);

			//set approver
			Approver app1 = new Approver();
			app1.setApprover("นายญาติ");
			approverRepository.save(app1);

			//set department
			Department dep1 = new Department();
			Department dep2 = new Department();
			Department dep3 = new Department();
			dep1.setDepartment("แผนกอยุรกรรม");
			dep2.setDepartment("แผนกสูตินารีแพทย์");
			dep3.setDepartment("แผนกอยุรแแพทย์ทั่วไป");
			departmentRepository.save(dep1);
			departmentRepository.save(dep2);
			departmentRepository.save(dep3);

			//set tool
			Tool t1 = new Tool();
			Tool t2 = new Tool();
			Tool t3 = new Tool();
			t1.setTool("กระดาษ(รีม)");
			t2.setTool("หมึกเครื่องปริ้น(ขวด)");
			t3.setTool("ปากกา(โหล)");
			toolRepository.save(t1);
			toolRepository.save(t2);
			toolRepository.save(t3);

            Company company = new Company();
            Company company1 = new Company();
            company.setCompanyName("บริษัทสยามยา");
            company1.setCompanyName("บริษัทไทยฟาร์มาซี");
            companyRepository.save(company);
            companyRepository.save(company1);

            Payer payer = new Payer();
            Payer payer1 = new Payer();
            payer.setPayerName("นายใจดี");
            payer1.setPayerName("นางสาวสดใส");
            payerRepository.save(payer);
            payerRepository.save(payer1);


            PaymentStatus paymentStatus = new PaymentStatus();
            PaymentStatus paymentStatus1 = new PaymentStatus();
            paymentStatus.setPaymentStatusName("Not pay yet");
            paymentStatus1.setPaymentStatusName("Paid");
            paymentStatusRepository.save(paymentStatus);
            paymentStatusRepository.save(paymentStatus1);


            PayType paytype = new PayType();
            PayType paytype1 = new PayType();
            paytype.setPayTypeName("Cash");
            paytype1.setPayTypeName("Installment");
            paytypeRepository.save(paytype);
            paytypeRepository.save(paytype1);


			Patient p = new Patient();
			p.setFirstname("Sompong");
			p.setLastname("Seayim");
			p.setAge(15);
			p.setDistrict("sdsd");
			p.setSubdistrict("dfdfd");
			p.setHousenumber("dfdfdf");
			p.setPostcode("15616");
			p.setPatientdetail("dfsvssdv");
			patientRepository.save(p);

			Patient pt2 = new Patient();
			pt2.setFirstname("Somchai");
			pt2.setLastname("wlllfa");
			pt2.setAge(15);
			pt2.setDistrict("sdsd");
			pt2.setSubdistrict("dfdfd");
			pt2.setHousenumber("dfdfdf");
			pt2.setPostcode("15616");
			pt2.setPatientdetail("dfsvssdv");
			patientRepository.save(pt2);
		
		// set ชื่อเทคนิคการแพทย์
			Medicaltechnique mt = new Medicaltechnique();
			mt.setMtname("Johny");
			mt.setPhonenumber("0912321312");
			medicaltechniqueRepository.save(mt);

			Medicaltechnique mt2 = new Medicaltechnique();
			mt2.setMtname("Alex");
			mt2.setPhonenumber("0902442324");
			medicaltechniqueRepository.save(mt2);

		


				// For Registration
				Stream.of("ตรวจร่างกาย/สุขภาพทั่วไป", "ตรวจเลือด", "ตรวจโรคติดต่อ", "จักษุ/ทันตกรรม", "X-ray/Untrasound").forEach(lab -> {

					HealthLab healthLab = new HealthLab();
					healthLab.setSName(lab);
					healthLabRepository.save(healthLab);
				});

				// For Staff set Staff
				Stream.of("บันทึกผลการตรวจ", "ประจำอุปกรณ์เครื่องตรวจ", "เก็บตัวอย่าง(เลือด,ปัสสะวะ,ฯลฯ)", "ผู้ช่วยแพทย์", "ติดต่อประสานงาน").forEach(name -> {
					StaffPosition staffPosition = new StaffPosition();
					staffPosition.setStaffPositName(name);
					staffPositionRepository.save(staffPosition);
				});

				// For HealthProgram
				Stream.of("ตรวจหาความสมบรูณ์ของเม็ดเลือด(C.B.C.)").forEach(program -> {
					HealthProgram healthProgram = new HealthProgram();
					healthProgram.setProgramName(program);
					healthProgram.setPrice("250-");
					healthProgramRepository.save(healthProgram);
				});

				Stream.of("เอ็กซเรย์ปอด(Chest X-ray)", "ตรวจโรคติดต่อ").forEach(program -> {
					HealthProgram healthProgram1 = new HealthProgram();
					healthProgram1.setProgramName(program);
					healthProgram1.setPrice("500-");
					healthProgramRepository.save(healthProgram1);
				});

				// For Question
				Stream.of("ขอราคาการตรวจโรคติดต่อหน่อยค่ะ").forEach(request -> {
					RequestSuggestion requestSuggestion1 = new RequestSuggestion();
					requestSuggestion1.setQuestion(request);
					requestSuggestion1.setUserRequestName("Manee Jairai");
					requestSuggestion1.setEmail("manee@gmail.com");
					requestSuggestionRepository.save(requestSuggestion1);
				});

				Stream.of("มีตรวจเอ็กซเรย์ปอดไหมครับ").forEach(request -> {
					RequestSuggestion requestSuggestion2 = new RequestSuggestion();
					requestSuggestion2.setQuestion(request);
					requestSuggestion2.setUserRequestName("Nut Tong");
					requestSuggestion2.setEmail("tongnut@gmail.com");
					requestSuggestionRepository.save(requestSuggestion2);
				});

				// For Work Day
				Stream.of("จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์", "เสาร์", "อาทิตย์").forEach(d -> {
					Workday workday = new Workday();
					workday.setDaywork(d);
					workdayRepository.save(workday);
				});

				// For Work Time
				Stream.of("09.00-18.00", "10.00-19.00", "11.00-20.00", "12.00-21.00").forEach(t -> {
					Worktime worktime = new Worktime();
					worktime.setTimework(t);
					worktimeRepository.save(worktime);
				});			
				
				// For User Login
				Stream.of("staff", "cpe").forEach(username ->{

					if(username == "staff"){
						User user = new User();
						user.setUsername(username);
						user.setPasswordd("123456");
						userRepository.save(user);
					}else{
						User user = new User();
						user.setUsername(username);
						user.setPasswordd("111111");
						userRepository.save(user);
					}
				});
		};
	}
}
