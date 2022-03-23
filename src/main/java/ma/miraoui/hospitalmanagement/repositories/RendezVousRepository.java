package ma.miraoui.hospitalmanagement.repositories;

import ma.miraoui.hospitalmanagement.entities.Patient;
import ma.miraoui.hospitalmanagement.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
