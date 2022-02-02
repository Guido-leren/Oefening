package be.strouwi.intake.restcontrollers;

import be.strouwi.intake.domain.Oppervlakte;
import be.strouwi.intake.forms.ObjectForm;
import be.strouwi.intake.services.OppervlakteService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/oppervlakte")
public class OppervlakteController {
    private final OppervlakteService oppervlakteService;

    public OppervlakteController(OppervlakteService oppervlakteService) {
        this.oppervlakteService = oppervlakteService;
    }
    @GetMapping("{id}")
    Oppervlakte get(@PathVariable long id){
        return oppervlakteService.findById(id).get();
    }
    @PostMapping
    void post(@RequestBody ObjectForm objectForm){
        oppervlakteService.create(objectForm);
    }

}
