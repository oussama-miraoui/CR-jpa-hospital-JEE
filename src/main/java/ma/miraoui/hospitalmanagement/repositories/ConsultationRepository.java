package ma.miraoui.hospitalmanagement.repositories;

import ma.miraoui.hospitalmanagement.entities.Consultation;
import ma.miraoui.hospitalmanagement.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
