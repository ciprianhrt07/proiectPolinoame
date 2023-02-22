import java.util.Objects;

public class Monom implements  Comparable<Monom> {
    private int coeficient;
    private int exponent;


    public Monom(int coeficient, int exponent) {
        this.exponent = exponent;
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public String toString() {

        String s="";

        if(coeficient>=0)
            s="+"+coeficient+"*";
        else
            s=""+coeficient+"*";


        s=s+"X^"+exponent;


        return s;
    }


    @Override
    public int compareTo(Monom o) {

        if(this.exponent == o.getExponent())
            return 0;
        else
        if(this.exponent < o.getExponent())
            return 1;
        else
            return -1;

    }




}
