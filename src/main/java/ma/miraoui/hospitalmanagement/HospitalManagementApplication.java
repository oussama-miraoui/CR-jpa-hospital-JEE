package ma.miraoui.hospitalmanagement;

import ma.miraoui.hospitalmanagement.entities.*;
import ma.miraoui.hospitalmanagement.repositories.ConsultationRepository;
import ma.miraoui.hospitalmanagement.repositories.MedecinRepository;
import ma.miraoui.hospitalmanagement.repositories.PatientRepository;
import ma.miraoui.hospitalmanagement.repositories.RendezVousRepository;
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
	CommandLineRunner start(PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository,
							ConsultationRepository consultationRepository){
		return args -> {
			Stream.of("Ahmed", "Mohammed", "Imad").forEach(name->{
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random() > 0.5 ? "Dentiste" : "Chirurgie");
				medecinRepository.save(medecin);
			});


			Stream.of("Oussama", "Hamid", "Hassan").forEach(name->{
					Patient patient = new Patient();
					patient.setNom(name);
					patient.setDateNaissance(new Date());
					patient.setMalade(false);
					patientRepository.save(patient);
			});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Medecin medecin = medecinRepository.findByNom("Ahmed");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDateRDV(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			rendezVousRepository.save(rendezVous);


			RendezVous rdv = rendezVousRepository.findById(1L).orElse(null);

			Consultation consultation = new Consultation();
			if(rdv!=null) {
				consultation.setDateConsultation(rdv.getDateRDV());
				consultation.setRendezVous(rdv);
				consultationRepository.save(consultation);
			}
		};
	}
}
