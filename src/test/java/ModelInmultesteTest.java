import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelInmultesteTest {

    @Test
    void inmultestePolinoame() {
        Model model = new Model();

        ArrayList<Monom> sirMonoameUnu = new ArrayList<>();

        sirMonoameUnu.add(new Monom(33,2));
        sirMonoameUnu.add(new Monom(20,5));

        Polinom polinomUnu = new Polinom(sirMonoameUnu);

        ArrayList<Monom> sirMonoameDoi= new ArrayList<>();

        sirMonoameDoi.add(new Monom(10,15));
        sirMonoameDoi.add(new Monom(2,4));


        Polinom polinomDoi = new Polinom(sirMonoameDoi);

        Model.eliminareRedundante(polinomUnu);
        Model.eliminareRedundante(polinomDoi);

        model.inmulteste(polinomUnu,polinomDoi);

        assertTrue(model.getRezultat().toString().equals("+200*X^20+330*X^17+40*X^9+66*X^6"));
    }
}