package ma.miraoui.hospitalmanagement.repositories;

import ma.miraoui.hospitalmanagement.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
