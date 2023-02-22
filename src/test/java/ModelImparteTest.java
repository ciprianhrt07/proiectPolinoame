import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModelImparteTest {

    @Test
    void impartePolinoame() {
        Model model = new Model();

        ArrayList<Monom> sirMonoameUnu = new ArrayList<>();

        sirMonoameUnu.add(new Monom(7,5));
        sirMonoameUnu.add(new Monom(12,10));
        sirMonoameUnu.add(new Monom(5,3));

        Polinom polinomUnu = new Polinom(sirMonoameUnu);

        ArrayList<Monom> sirMonoameDoi= new ArrayList<>();

        sirMonoameDoi.add(new Monom(1,4));
        sirMonoameDoi.add(new Monom(2,0));

        Polinom polinomDoi = new Polinom(sirMonoameDoi);

        assertTrue(model.imparte(polinomUnu,polinomDoi).equals("catul: +12*X^6-24*X^2+7*X^1 si restul: +5*X^3+48*X^2-14*X^1"));


    }
}