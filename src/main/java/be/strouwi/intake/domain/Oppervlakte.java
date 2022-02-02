package be.strouwi.intake.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "oppervlakte")
public class Oppervlakte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String object;
    private  BigDecimal zijde;
    private  BigDecimal hoogte;
    private  BigDecimal oppervlakte;
    @Version
    private Timestamp versie;

    protected Oppervlakte(){}

    public Oppervlakte(String object, BigDecimal zijde, BigDecimal hoogte, BigDecimal oppervlakte) {
        this.object = object;
        this.zijde = zijde;
        this.hoogte = hoogte;
        this.oppervlakte = oppervlakte;
    }

    public long getId() {
        return id;
    }


    public String getObject() {
        return object;
    }

    public BigDecimal getZijde() {
        return zijde;
    }

    public BigDecimal getHoogte() {
        return hoogte;
    }

    public BigDecimal getOppervlakte() {
        return oppervlakte;
    }
}
