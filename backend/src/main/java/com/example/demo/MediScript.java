	package com.sut.sa.cpe.entity;

	import javax.persistence.*;
import lombok.*;

	import java.util.Date;


	@Data

	@Entity

	@Table(name="MediScript")

	@Getter 
	@Setter


	@ToString

	@EqualsAndHashCode
public 

		class MediScript {
	@Id
	@SequenceGenerator(name="Tmt_seq",sequenceName="Tmt_seq")
    
			@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Tmt_seq")
    
			@Column(name = "IdMediScript"")
	
				private @NonNull Long id;
	
				private Integer Price;

	
			public Long getId() {
        return id;
    }

    
			public void setId(Long id) {
        this.id = id;
    }

    
			public void setDate(Date date) {
        this.date = date;
    }

	
			@Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
	
			Date date; 

		
		public MediScript() {

	}	    
	
			@OneToOne(fetch = FetchType.LAZY)
    
			@JoinColumn(name= "IdMedi")
    
			private Medi medi;	    

	
			@ManyToOne(fetch = FetchType.LAZY,targetEntity = Employee.class)
    
			@JoinColumn(name= "IdEmployee",insertable = true)
	
			private Employee employee;
	
	
			@ManyToOne(fetch = FetchType.LAZY,targetEntity = PetInfo.class)
    
			@JoinColumn(name= "IdPetInfo",insertable = true)
	
			private PetInfo petInfo;
	

	
	
		public void setMediScriptId(Long MediScriptId){this.id=MediScriptId;}
	
		public Long getMediScriptId(){return id;} 

	
	
		public void setPrice(Integer Price){this.Price=Price;}
    
		public Integer getPrice(){return Price;}


		
		public void setEmployee(Employee employee){this.employee=employee;}
	
		public Employee getEmployee() { return employee; }
	
		public void setMedi(Medi medi){this.medi=medi;}
	public Medi getMedi(){return medi;}	
	
		public void setPetInfo(PetInfo petInfo){ this.petInfo=petInfo; }
    public PetInfo getPetInfo(){return petInfo;}
	


	

	
		public MediScript(Integer price, Employee employee,PetInfo petInfo,Date date,Medi medi) 
			{
		
				this.medi=medi;
		
				this.date=date;
        
				this.petInfo=petInfo;
		
				this.employee=employee;
		
				this.Price=price;
		
	
			}

	

	
		
}
