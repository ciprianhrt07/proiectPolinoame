import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelIntegreazaTest {

    @Test
    void integreazaPolinom() {

        ArrayList<Monom> sirMonoameUnu = new ArrayList<>();

        sirMonoameUnu.add(new Monom(-15,10));
        sirMonoameUnu.add(new Monom(-12,15));

        Polinom polinomUnu = new Polinom(sirMonoameUnu);

        assertTrue(Model.integreaza(polinomUnu).equals("-1.36X^11-0.75X^16"));

    }
}