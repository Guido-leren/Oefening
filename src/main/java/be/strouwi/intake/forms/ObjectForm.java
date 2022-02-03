package be.strouwi.intake.forms;


import java.math.BigDecimal;


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

}
