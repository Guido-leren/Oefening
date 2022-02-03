package be.strouwi.intake.restcontrollers;

import be.strouwi.intake.domain.Oppervlakte;
import be.strouwi.intake.exceptions.ObjectNietGevondenException;
import be.strouwi.intake.forms.ObjectForm;
import be.strouwi.intake.services.OppervlakteService;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/oppervlakte")
public class OppervlakteController {
    private final OppervlakteService oppervlakteService;
    private final TypedEntityLinks.ExtendedTypedEntityLinks<Oppervlakte> links;

    public OppervlakteController(OppervlakteService oppervlakteService, EntityLinks links) {
        this.oppervlakteService = oppervlakteService;
        this.links = links.forType(Oppervlakte.class,Oppervlakte::getId);
    }

    @GetMapping("{id}")
    Oppervlakte get(@PathVariable long id){
        return oppervlakteService.findById(id)
                .orElseThrow(ObjectNietGevondenException::new);
    }
    @ExceptionHandler(ObjectNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void objectNietGevonden(){}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HttpHeaders create(@RequestBody ObjectForm objectForm){
       var oppervlakte = oppervlakteService.create(objectForm);
       var headers = new HttpHeaders();
       headers.setLocation(links.linkToItemResource(oppervlakte).toUri());
       return headers;
    }
}
