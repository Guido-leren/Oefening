package be.strouwi.intake.services;

import be.strouwi.intake.domain.Oppervlakte;
import be.strouwi.intake.forms.ObjectForm;
import be.strouwi.intake.repositories.OppervlakteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DefaultOppervlakteService implements OppervlakteService {
    private final OppervlakteRepository oppervlakteRepository;

    public DefaultOppervlakteService(OppervlakteRepository oppervlakteRepository) {
        this.oppervlakteRepository = oppervlakteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Oppervlakte> findById(long id) {
        return oppervlakteRepository.findById(id);
    }

    @Override
    public void create(ObjectForm objectForm) {
        oppervlakteRepository.save(new Oppervlakte(objectForm.getObject(), objectForm.getZijde(), objectForm.getHoogte(), objectForm.getOppervlakte()));
    }
}
