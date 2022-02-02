package be.strouwi.intake.forms;

import be.strouwi.intake.exceptions.ObjectNietGevondenException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ObjectFormTest {
    @Test
    void eenNietBestaandObject(){
        assertThatExceptionOfType(ObjectNietGevondenException.class).isThrownBy(
                ()-> new ObjectForm("Driekant", BigDecimal.ONE,BigDecimal.ONE).getOppervlakte());
    }
    @Test
    void oppervlakteVanEenDriehoek(){
        assertThat(new ObjectForm("Triangle",BigDecimal.valueOf(2), BigDecimal.valueOf(3)).getOppervlakte()).isEqualByComparingTo(BigDecimal.valueOf(3));
    }
    @Test
    void oppervlakteVanEenVierkant(){
        assertThat(new ObjectForm("Square",BigDecimal.valueOf(6), BigDecimal.ZERO).getOppervlakte()).isEqualByComparingTo(BigDecimal.valueOf(36));
    }
    @Test
    void oppervlakteVanEenHexagon(){
        assertThat(new ObjectForm("Hexagon",BigDecimal.valueOf(9), BigDecimal.ZERO).getOppervlakte()).isEqualByComparingTo(BigDecimal.valueOf(210.44));
    }


}