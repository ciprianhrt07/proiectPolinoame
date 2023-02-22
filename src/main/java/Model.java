import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Model {

    private Polinom rezultat;

    public Model(){

    }

    public static void eliminaZerouriNesemnificative(Polinom polinom)
    {
        if(polinom.getPol().size()>1) {
            for (int i = 0; i < polinom.getPol().size(); i++) {
                if (polinom.getPol().get(i).getCoeficient() == 0) {
                    polinom.getPol().remove(i);
                    i--;
                }
            }
        }

    }


    public static void eliminareRedundante(Polinom polinom)
    {

        Collections.sort(polinom.getPol());

        if(polinom.getPol().size()>1)
        {
            int i=0;
            while(i<polinom.getPol().size()-1)
            {
                int j=i+1;

                int exponentCurent = polinom.getPol().get(i).getExponent();
                int coeficientCurent = polinom.getPol().get(i).getCoeficient();
                int exponentUrmator ;
                double coeficientUrmator;

                while(j<polinom.getPol().size()) {

                    exponentUrmator = polinom.getPol().get(j).getExponent();
                    coeficientUrmator = polinom.getPol().get(j).getCoeficient();

                    if(exponentCurent == exponentUrmator)
                    {
                        coeficientCurent+=coeficientUrmator;
                        polinom.getPol().remove(j);

                    }else
                        break;

                }
                if(coeficientCurent !=0)
                    polinom.getPol().get(i).setCoeficient(coeficientCurent);
                else
                {
                    polinom.getPol().remove(i);
                    i--;
                }

                i=j;

            }

            if(polinom.getPol().get(polinom.getPol().size()-1).getCoeficient()==0)
                polinom.getPol().remove(polinom.getPol().size()-1);

        }


    }



    public void adunaSiScade(Polinom p1,Polinom p2,int semn)
    {
        ArrayList<Monom> rezultatCurent = new ArrayList<>();

        Model.eliminareRedundante(p1);
        Model.eliminareRedundante(p2);

        for(int i=0;i<p1.getPol().size();i++)
        {
            boolean ok = false;

            for(int j=0;j<p2.getPol().size() && ok==false;j++)
            {
                if(p1.getPol().get(i).getExponent()==p2.getPol().get(j).getExponent())
                {
                    ok=true;
                    int coeficientRezultat = p1.getPol().get(i).getCoeficient()+semn*p2.getPol().get(j).getCoeficient();
                    int exponentRezultat = p1.getPol().get(i).getExponent();

                    Monom monomRezultat = new Monom(coeficientRezultat,exponentRezultat);

                    rezultatCurent.add(monomRezultat);
                }

            }

            if(ok==false)
            {
                rezultatCurent.add(p1.getPol().get(i));
            }

        }

        for(int j=0;j<p2.getPol().size();j++)
        {
            boolean ok = false;

            for(int i=0;i<p1.getPol().size();i++)
            {
                if(p2.getPol().get(j).getExponent() == p1.getPol().get(i).getExponent())
                {
                    ok=true;
                    break;
                }
            }

            if(ok==false)
            {

                int  coeficient = (int) (semn*p2.getPol().get(j).getCoeficient());
                int exponent = p2.getPol().get(j).getExponent();

                Monom auxiliar = new Monom(coeficient,exponent);
                rezultatCurent.add(auxiliar);
            }

        }



        Collections.sort(rezultatCurent);
        this.rezultat=new Polinom(rezultatCurent);
        Model.eliminareRedundante(this.rezultat);

    }

    public void inmulteste(Polinom p1,Polinom p2)
    {
        ArrayList<Monom> rezultatCurent = new ArrayList<>();

        for(int i=0;i<p1.getPol().size();i++)
        {
            Monom m1 = p1.getPol().get(i);

            for(int j=0;j<p2.getPol().size();j++)
            {
                Monom m2 = p2.getPol().get(j);
                int coeficientRezultat = m1.getCoeficient()*m2.getCoeficient();
                int exponentRezultat = m1.getExponent()+m2.getExponent();
                Monom rezultatAuxiliar = new Monom(coeficientRezultat,exponentRezultat);
                rezultatCurent.add(rezultatAuxiliar);
            }

        }



        Polinom paux = new Polinom(rezultatCurent);
        eliminareRedundante(paux);
        this.rezultat=paux;

    }

    public static void deriveaza(Polinom polinom)
    {
        for(int i=0;i<polinom.getPol().size();i++)
        {
            int exponent = polinom.getPol().get(i).getExponent();
            int coeficient = polinom.getPol().get(i).getCoeficient();

            if(exponent == 0)
            {
                polinom.getPol().remove(i);
                i--;
            }else
            {
                coeficient *=exponent;
                exponent--;
                polinom.getPol().get(i).setExponent(exponent);
                polinom.getPol().get(i).setCoeficient(coeficient);
            }
        }
           Model.eliminareRedundante(polinom);
      //  System.out.println(polinom.getPol().toString());

            if(polinom.getPol().size()==0)
              polinom.getPol().add(polinom.getPol().size(),new Monom(0,0));


    }

    public static String integreaza(Polinom polinom)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        String rezultat="";

        for(int i=0;i<polinom.getPol().size();i++)
        {
            int exponent = polinom.getPol().get(i).getExponent();
            int coeficient = polinom.getPol().get(i).getCoeficient();

            exponent = exponent+1;

            double coeficientRezultat = (double) coeficient;
            coeficientRezultat = coeficientRezultat/(exponent);

            if(coeficient>=0)
            {
                rezultat=rezultat+"+"+df.format(coeficientRezultat)+"X^"+exponent;
            }else
                rezultat=rezultat+""+df.format(coeficientRezultat)+"X^"+exponent;

            //polinom.getPol().get(i).setExponent(exponent);
            //  polinom.getPol().get(i).setCoeficient(coeficient);
        }
        if(rezultat.length()==0)
            return "0*X^0";
             else
        return rezultat;

    }

    public String imparte(Polinom polinomPrincipal,Polinom polinomSecundar)
    {
        String catRezultat="";
        String restRezultat="";

        Model.eliminareRedundante(polinomPrincipal);
        Model.eliminareRedundante(polinomSecundar);
      //caz polinom/0 sau 0/0
     if(polinomSecundar.getPol().size()==1 && polinomSecundar.getPol().get(0).getCoeficient()==0)
     {
         if(polinomPrincipal.getPol().size()==1 && polinomPrincipal.getPol().get(0).getCoeficient()==0)
         {
             return null;
         }else
             return null;

     }else {

         Polinom copiePrincipal = new Polinom(polinomPrincipal.getPol());
         int exponentPolinomPrincipal = copiePrincipal.getPol().get(0).getExponent();
         int exponentPolinomSecundar = polinomSecundar.getPol().get(0).getExponent();

         int pas = 0;

         if (exponentPolinomPrincipal < exponentPolinomSecundar) {
             restRezultat = copiePrincipal.toString();
             catRezultat = "0*X^0";
         }

         while (exponentPolinomPrincipal >= exponentPolinomSecundar) {
             int exponentCurent = exponentPolinomPrincipal - exponentPolinomSecundar;
             int coeficientCurent = (int) ((copiePrincipal.getPol().get(0).getCoeficient()) / (polinomSecundar.getPol().get(0).getCoeficient()));

             if(((copiePrincipal.getPol().get(0).getCoeficient()) % (polinomSecundar.getPol().get(0).getCoeficient()))!=0)
             {
                 catRezultat = "0*X^0";
                 break;

             }
             ArrayList<Monom> monomCurent = new ArrayList<>();
             monomCurent.add(new Monom(coeficientCurent, exponentCurent));

             Polinom catCurent = new Polinom(monomCurent);

             catRezultat = catRezultat + catCurent.toString();

             inmulteste(catCurent, polinomSecundar);

             catCurent = this.rezultat;


             System.out.println("La pasul :" + pas + "  " + catCurent.toString());
             ++pas;


             adunaSiScade(copiePrincipal, catCurent, -1);


             catCurent = this.rezultat;

             System.out.println(catCurent.toString());

             if (catCurent.getPol().get(0).getCoeficient() == 0)
                 catCurent.getPol().remove(0);

             if (catCurent.getPol().size() != 0) {
                 System.out.println("Dupa scadere a rezultat polinomul:" + catCurent.toString());

                 exponentPolinomPrincipal = catCurent.getPol().get(0).getExponent();

                 // System.out.println(exponentPolinomPrincipal);

                 if (exponentPolinomPrincipal < exponentPolinomSecundar)
                     restRezultat = catCurent.toString();

                 copiePrincipal = new Polinom(catCurent.getPol());
             } else
                 break;

         }

         if (restRezultat.length() == 0)
             restRezultat = "0*X^0";

         return "catul: " + catRezultat + " si restul: " + restRezultat.toString();


     }


    }

    public static ArrayList<Monom> matchingPattern(String str)
    {


        StringTokenizer st = new StringTokenizer(str,"+-");
        ArrayList<Monom> rezultat = new ArrayList<>();
        String  monomPattern1=  "[0-9]{1,6}[*\\w](X[^\\w])([0-9]{1,3})";
        String  monomPattern2= "[0-9]{1,6}";
        String  monomPattern3="[0-9]{0,6}[*\\w]X";
        String monomPattern4 ="X";
        String monomPattern5 ="X[^\\w][0-9]{1,3}";

        //reluat pattern uri

        boolean ok = true;

        while (st.hasMoreTokens() && ok == true) {

            String monom = st.nextToken();
            Pattern pattern = Pattern.compile(monomPattern1);
            Matcher matcher = pattern.matcher(monom);
            Monom rezultatCurent;

            if(matcher.matches())
            {

               // System.out.println("Patteren 1");

                StringTokenizer tokenMonom = new StringTokenizer(monom,"*X^");
                int cnt =0;
                int coeficient =0;
                int exponent = 0;
                while(tokenMonom.hasMoreTokens())
                {
                    if(cnt ==0) {

                        try {
                            coeficient = Integer.parseInt(tokenMonom.nextToken());
                        }catch (NumberFormatException ex)
                        {
                            ok=false;
                        }
                    }
                    else {

                        try {
                            exponent = Integer.parseInt(tokenMonom.nextToken());
                        }catch (NumberFormatException ex)
                        {
                            ok=false;
                        }

                    }
                    ++cnt;
                }

                rezultatCurent = new Monom(coeficient,exponent);
                rezultat.add(rezultatCurent);


            }else
            {
                pattern = Pattern.compile(monomPattern2);
                matcher = pattern.matcher(monom);

                if(matcher.matches())
                {
                    //System.out.println("Pattern2");

                    try {
                        int coeficient = Integer.parseInt(monom);

                        rezultatCurent = new Monom(coeficient,0);
                        rezultat.add(rezultatCurent);

                    }catch(NumberFormatException ex)
                    {
                        // JOptionPane.showMessageDialog("Polinomul nu este potrivit");
                        ok= false;
                    }


                }else {


                    pattern = Pattern.compile(monomPattern3);
                    matcher = pattern.matcher(monom);

                    if(matcher.matches()) {


                        int i=0;
                        int coeficient;
                        //  int exponent=1;

                        while(i<monom.length()&&monom.charAt(i)!='X'&&i<monom.length()&&monom.charAt(i)!='*')
                        {
                            i++;
                        }

                        if(i==0) {
                            coeficient = 1;
                            rezultatCurent = new Monom(coeficient,1);
                            rezultat.add(rezultatCurent);

                        }
                        else
                        {
                            try{


                                String substring =monom.substring(0,i);
                                coeficient = Integer.parseInt(substring);

                                rezultatCurent = new Monom(coeficient,1);
                                rezultat.add(rezultatCurent);

                            }catch(NumberFormatException ex)
                            {
                                ok=false;
                            }
                        }


                    }else {

                        //System.out.println("Nicun Pattern ");
                        pattern = Pattern.compile(monomPattern4);
                        matcher = pattern.matcher(monom);

                        if(matcher.matches()) {


                            rezultatCurent = new Monom(1,1);
                            rezultat.add(rezultatCurent);


                        }else
                        {
                            pattern = Pattern.compile(monomPattern5);
                            matcher = pattern.matcher(monom);

                            if(matcher.matches())
                            {
                                //System.out.println("A verificat");
                                try{

                                    String substring =monom.substring(2,monom.length());
                                   int  exponent = Integer.parseInt(substring);

                                    rezultatCurent = new Monom(1,exponent);
                                    rezultat.add(rezultatCurent);

                                }catch(NumberFormatException ex)
                                {
                                    ok=false;
                                }


                            }else
                              ok = false;
                        }
                    }
                }
            }

        }

        //verificare semnul coeficientilor;
        int  poz =0;

        if(ok==true)
        {
            int i=0;
            while(i<str.length()-1&&ok==true)
            {
                if(str.charAt(i)=='+'&& (str.charAt(i+1)=='-'||str.charAt(i+1)=='+'))
                    ok=false;
                else
                if(str.charAt(i)=='-'&& (str.charAt(i+1)=='-'||str.charAt(i+1)=='+'))
                    ok=false;
                else
                if(str.charAt(i)=='-')
                {
                    rezultat.get(poz).setCoeficient(rezultat.get(poz).getCoeficient()*(-1));
                }
                if(str.charAt(i)=='X')
                    poz++;

                i++;
            }


            if(ok==true)
            {
                if(str.charAt(str.length()-1)=='+' || str.charAt(str.length()-1)=='-' )
                    ok=false;
            }

        }

        // System.out.println(ok);

        if( ok == true)
            return rezultat;
        else
        {
            rezultat.removeAll(rezultat);
            return rezultat;
        }
    }

    public Polinom getRezultat() {
        return rezultat;
    }

    public void setRezultat(Polinom rezultat) {
        this.rezultat = rezultat;
    }

    @Override
    public String toString() {
        return  rezultat.getPol().toString();
    }
}
