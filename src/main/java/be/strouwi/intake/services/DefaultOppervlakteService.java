package be.strouwi.intake.services;

import be.strouwi.intake.domain.Oppervlakte;
import be.strouwi.intake.exceptions.ObjectNietGevondenException;
import be.strouwi.intake.forms.ObjectForm;
import be.strouwi.intake.repositories.OppervlakteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@Transactional
public class DefaultOppervlakteService implements OppervlakteService {
    private final OppervlakteRepository oppervlakteRepository;
    private final EntityManager manager;

    public DefaultOppervlakteService(OppervlakteRepository oppervlakteRepository, EntityManager manager) {
        this.oppervlakteRepository = oppervlakteRepository;
        this.manager = manager;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Oppervlakte> findById(long id) {
        return oppervlakteRepository.findById(id);
    }

    @Override
    public Oppervlakte create(ObjectForm objectForm) {
        var oppervlakte = new Oppervlakte(objectForm.getObject(), objectForm.getZijde(), objectForm.getHoogte(), getOppervlakte(objectForm));
        oppervlakteRepository.save(oppervlakte);
        return oppervlakte;
    }

    private BigDecimal getOppervlakte(ObjectForm objectForm){
        var oppervlakte = BigDecimal.ZERO;
        switch (objectForm.getObject().toLowerCase()) {
            case "triangle":
                oppervlakte = objectForm.getZijde().multiply(objectForm.getHoogte()).divide(BigDecimal.valueOf(2),2, RoundingMode.HALF_UP);
                break;
            case "square":
                oppervlakte = objectForm.getZijde().multiply(objectForm.getZijde());
                break;
            case "hexagon":
                MathContext mc = new MathContext(10);
                oppervlakte = BigDecimal.valueOf(3).multiply(BigDecimal.valueOf(3).sqrt(mc)).multiply(objectForm.getZijde())
                        .multiply(objectForm.getZijde()).divide(BigDecimal.valueOf(2),2, RoundingMode.HALF_UP);
                break;
            default:
                throw new ObjectNietGevondenException();
        }
        return oppervlakte;
    }
}
