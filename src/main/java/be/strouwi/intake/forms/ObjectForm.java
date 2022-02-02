package be.strouwi.intake.forms;

import be.strouwi.intake.exceptions.ObjectNietGevondenException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ObjectForm {
    private final String object;
    private final BigDecimal zijde;
    private final BigDecimal hoogte;

    public ObjectForm(String object, BigDecimal zijde, BigDecimal hoogte) {
        this.object = object;
        this.zijde = zijde;
        this.hoogte = hoogte;
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

    public BigDecimal getOppervlakte(){
        var oppervlakte = BigDecimal.ZERO;
        switch (getObject().toLowerCase()) {
            case "triangle":
                oppervlakte = getZijde().multiply(getHoogte()).divide(BigDecimal.valueOf(2),2, RoundingMode.HALF_UP);
                break;
            case "square":
                oppervlakte = getZijde().multiply(getZijde());
                break;
            case "hexagon":
                MathContext mc = new MathContext(10);
                oppervlakte = BigDecimal.valueOf(3).multiply(BigDecimal.valueOf(3).sqrt(mc)).multiply(getZijde())
                        .multiply(getZijde()).divide(BigDecimal.valueOf(2),2, RoundingMode.HALF_UP);
                break;
            default:
                throw new ObjectNietGevondenException();
        }
        return oppervlakte;
    }
}
