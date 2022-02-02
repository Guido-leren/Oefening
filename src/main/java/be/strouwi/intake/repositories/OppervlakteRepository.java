package be.strouwi.intake.repositories;

import be.strouwi.intake.domain.Oppervlakte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OppervlakteRepository extends JpaRepository<Oppervlakte, Long> {
}
