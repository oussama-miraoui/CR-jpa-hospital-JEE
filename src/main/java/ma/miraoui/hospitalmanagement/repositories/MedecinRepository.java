package ma.miraoui.hospitalmanagement.repositories;

import ma.miraoui.hospitalmanagement.entities.Medecin;
import ma.miraoui.hospitalmanagement.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
