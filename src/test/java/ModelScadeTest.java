import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelScadeTest {

    @Test
    void scadePolinoame() {

        Model model = new Model();

        ArrayList<Monom> sirMonoameUnu = new ArrayList<>();

        sirMonoameUnu.add(new Monom(22,2));
        sirMonoameUnu.add(new Monom(3,5));
        sirMonoameUnu.add(new Monom(4,16));

        Polinom polinomUnu = new Polinom(sirMonoameUnu);

        ArrayList<Monom> sirMonoameDoi= new ArrayList<>();

        sirMonoameDoi.add(new Monom(11,2));
        sirMonoameDoi.add(new Monom(2,2));
        sirMonoameDoi.add(new Monom(9,3));

        Polinom polinomDoi = new Polinom(sirMonoameDoi);

        Model.eliminareRedundante(polinomUnu);
        Model.eliminareRedundante(polinomDoi);

        model.adunaSiScade(polinomUnu,polinomDoi,-1);

        assertTrue(model.getRezultat().toString().equals("+4*X^16+3*X^5-9*X^3+9*X^2"));


    }
}