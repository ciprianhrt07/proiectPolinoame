import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelAdunaTest {

  /*  @ParameterizedTest
    @MethodSource("adunaDouaPolinoame")

    void adunaDouaPolinoame(Polinom rezultat,Polinom polinomPrincipal,Polinom polinomSecundar)
    {
        Model model =new Model();
        model.adunaSiScade(polinomPrincipal,polinomSecundar,1);
        assertEquals(rezultat,model.getRezultat());

    }

    private static Stream<Arguments> aduna()
    {
        return Stream.of(

                Arguments.of()


        )
    }

    */

    @Test
    void adunaPolinoame() {

        Model model = new Model();

        ArrayList<Monom> sirMonoameUnu = new ArrayList<>();

        sirMonoameUnu.add(new Monom(1,2));
        sirMonoameUnu.add(new Monom(22,32));
        sirMonoameUnu.add(new Monom(4,5));

        Polinom polinomUnu = new Polinom(sirMonoameUnu);

        ArrayList<Monom> sirMonoameDoi= new ArrayList<>();

        sirMonoameDoi.add(new Monom(12,2));
        sirMonoameDoi.add(new Monom(4,11));
        sirMonoameDoi.add(new Monom(10,5));

        Polinom polinomDoi = new Polinom(sirMonoameDoi);

        Model.eliminareRedundante(polinomUnu);
        Model.eliminareRedundante(polinomDoi);

        model.adunaSiScade(polinomUnu,polinomDoi,1);

        assertTrue(model.getRezultat().toString().equals("+22*X^32+4*X^11+14*X^5+13*X^2"));

    }



}