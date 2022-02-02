package be.strouwi.intake.services;

import be.strouwi.intake.domain.Oppervlakte;
import be.strouwi.intake.forms.ObjectForm;


import java.util.Optional;

public interface OppervlakteService {
    Optional<Oppervlakte> findById(long id);
    void create(ObjectForm objectForm);
}
