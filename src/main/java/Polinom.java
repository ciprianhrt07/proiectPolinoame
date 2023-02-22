import java.util.ArrayList;
import java.util.List;

public class Polinom {

    private ArrayList <Monom> pol = new ArrayList<Monom>();

    public Polinom(ArrayList<Monom> pol) {
        this.pol = pol;
    }

    @Override
    public String toString() {

        String s="";

        for (Monom m:pol)
        {
            s=s+m.toString();
        }
        return s;

    }

    public ArrayList<Monom> getPol() {
        return pol;
    }

    public void setPol(ArrayList<Monom> pol) {
        this.pol = pol;
    }
}
