import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelDerivareTest {

    @Test
    void deriveazaPolinom() {

        ArrayList<Monom> sirMonoameUnu = new ArrayList<>();

        sirMonoameUnu.add(new Monom(-33,22));
        sirMonoameUnu.add(new Monom(20,53));

        Polinom polinomUnu = new Polinom(sirMonoameUnu);

        Model.deriveaza(polinomUnu);

        assertTrue(polinomUnu.toString().equals("+1060*X^52-726*X^21"));

    }
}