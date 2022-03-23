package ma.miraoui.hospitalmanagement;

import ma.miraoui.hospitalmanagement.entities.Patient;
import ma.miraoui.hospitalmanagement.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository){
		return args -> {
			Stream.of("Oussama", "Hamid", "Hassan").forEach(name->{
					Patient patient = new Patient();
					patient.setNom(name);
					patient.setDateNaissance(new Date());
					patient.setMalade(false);
					patientRepository.save(patient);
			});
		};
	}
}
