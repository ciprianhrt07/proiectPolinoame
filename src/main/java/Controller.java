import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {

    private Model model ;
    private View view;

    public Controller(Model model ,View view)
    {
        this.model=model;
        this.view=view;
        view.getFrmPolynomialCalculator().setVisible(true);
        initializareButoane();

    }
    void initializareButoane()
    {
        view.getButonInmulteste().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // setLocationtoWrite = 1;
                //  textPrimulPolinom.setText("ASta ii forta");
                //JOptionPane.showMessageDialog(frmPolynomialCalculator,"asta ii");
                //  codOperatie = 1;
                //    JOptionPane.showMessageDialog(frmPolynomialCalculator,Integer.toString(codOperatie));
                try {
                    ArrayList<Monom> sirMonom1 = Model.matchingPattern(view.getTextPrimulPolinom().getText());
                    ArrayList<Monom> sirMonom2 = Model.matchingPattern(view.getTextAlDoileaPolinom().getText());

                    if (sirMonom1.size() == 0 || sirMonom1.size() == 0)
                        JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Eroare la introducerea datelor");
                    else {

                        Polinom polinom1 = new Polinom(sirMonom1);
                        Polinom polinom2 = new Polinom(sirMonom2);

                        Model.eliminareRedundante(polinom1);
                        Model.eliminareRedundante(polinom2);
                        System.out.println(polinom1.toString() + "\n" + polinom2.toString());
                        Model model = new Model();
                        model.inmulteste(polinom1, polinom2);
                        // System.out.println(model.getRezultat().toString());

                        view.getTextRezultat().setText(model.getRezultat().toString());

                    }


                } catch (StringIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Date invalide");
                }
            }
        });

        view.getButonImparte().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            // codOperatie = -1;
            //   JOptionPane.showMessageDialog(frmPolynomialCalculator,Integer.toString(codOperatie));
          try {
              ArrayList<Monom> sirMonom1 = Model.matchingPattern(view.getTextPrimulPolinom().getText());
              ArrayList<Monom> sirMonom2 = Model.matchingPattern(view.getTextAlDoileaPolinom().getText());

              if (sirMonom1.size() == 0 || sirMonom1.size() == 0)
                  JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Eroare la introducerea datelor");
              else {

                  Polinom polinom1 = new Polinom(sirMonom1);
                  Polinom polinom2 = new Polinom(sirMonom2);

                  // Model.eliminareRedundante(polinom1);
                  //  Model.eliminareRedundante(polinom2);
                  //  System.out.println(polinom1.toString() + "\n" + polinom2.toString());
                  Model model = new Model();
                  //model.imparte(polinom1,polinom2);
                  // System.out.println(model.getRezultat().toString());
                  String rezultatImpartire = model.imparte(polinom1, polinom2);
                  if (rezultatImpartire == null)
                      JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Impartirea nu se poate efectua");
                  else

                      view.getTextRezultat().setText(rezultatImpartire);

              }

          }catch(StringIndexOutOfBoundsException ex)
          {
              JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(),"Date invalide");
          }
        }
    });
        view.getButonAduna().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //   codOperatie = 2;
                // JOptionPane.showMessageDialog(frmPolynomialCalculator,Integer.toString(codOperatie));

                // textPrimulPolinom.getText();
                //String polinom2 = textAlDoileaPolinom.getText();
             try{
                ArrayList<Monom> sirMonom1= Model.matchingPattern(view.getTextPrimulPolinom().getText());
                ArrayList<Monom> sirMonom2 = Model.matchingPattern(view.getTextAlDoileaPolinom().getText());

                if(sirMonom1.size() ==0 || sirMonom1.size() ==0)
                    JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(),"Eroare la introducerea datelor");
                else {

                    Polinom polinom1 =new Polinom(sirMonom1);
                    Polinom polinom2 =new Polinom(sirMonom2);

                    Model.eliminareRedundante(polinom1);
                    Model.eliminareRedundante(polinom2);
                    System.out.println(polinom1.toString() + "\n" + polinom2.toString());
                    Model model = new Model();
                    model.adunaSiScade(polinom1,polinom2,1);
                     System.out.println(model.getRezultat().toString());

                     view.getTextRezultat().setText(model.getRezultat().toString());

                }
             }catch(StringIndexOutOfBoundsException ex)
             {
                 JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(),"Date invalide");
             }
            }
        });

        view.getButonScade().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // codOperatie = -2;
                //    JOptionPane.showMessageDialog(frmPolynomialCalculator,Integer.toString(codOperatie));
             try {
                 ArrayList<Monom> sirMonom1 = Model.matchingPattern(view.getTextPrimulPolinom().getText());
                 ArrayList<Monom> sirMonom2 = Model.matchingPattern(view.getTextAlDoileaPolinom().getText());

                 if (sirMonom1.size() == 0 || sirMonom2.size() == 0)
                     JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Eroare la introducerea datelor");
                 else {

                     Polinom polinom1 = new Polinom(sirMonom1);
                     Polinom polinom2 = new Polinom(sirMonom2);

                     Model.eliminareRedundante(polinom1);
                     Model.eliminareRedundante(polinom2);
                     System.out.println(polinom1.toString() + "\n" + polinom2.toString());
                     Model model = new Model();
                     model.adunaSiScade(polinom1, polinom2, -1);
                     // System.out.println(model.getRezultat().toString());

                     view.getTextRezultat().setText(model.getRezultat().toString());


                 }
              }catch(StringIndexOutOfBoundsException ex)
             {
                 JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(),"Date invalide");
             }
            }
        });
       view.getButonDeriveaza().addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {

               // codOperatie = 3;
               //  JOptionPane.showMessageDialog(frmPolynomialCalculator,Integer.toString(codOperatie));
          try {
                 String getInfotextPolinomDoi="";

              getInfotextPolinomDoi=view.getTextAlDoileaPolinom().getText();

              if(getInfotextPolinomDoi.length()!=0)
                  JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Eroare la introducerea datelor, doar in campul Primul Polinom se va insera polinomul supus derivarii");
                   else{

              ArrayList<Monom> sirMonom1 = Model.matchingPattern(view.getTextPrimulPolinom().getText());
              if (sirMonom1.size() == 0)
                  JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Eroare la introducerea datelor");
              else {

                  Polinom polinom1 = new Polinom(sirMonom1);

                  Model.eliminareRedundante(polinom1);

                  System.out.println(polinom1.toString());

                  Model.deriveaza(polinom1);

                  view.getTextRezultat().setText(polinom1.toString());
                 }
              }
          }catch(StringIndexOutOfBoundsException ex)
          {
              JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(),"Date invalide");
          }
           }
       });

        view.getButonIntegreaza().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //    codOperatie = -3;
                //    JOptionPane.showMessageDialog(frmPolynomialCalculator,Integer.toString(codOperatie));
                //  JOptionPane.showMessageDialog(frmPolynomialCalculator,Integer.toString(codOperatie));



                try {
                    String getInfotextPolinomDoi = "";

                    getInfotextPolinomDoi = view.getTextAlDoileaPolinom().getText();

                    if (getInfotextPolinomDoi.length() != 0)
                        JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Eroare la introducerea datelor, doar in campul Primul Polinom se va insera polinomul supus integrarii");
                    else {
                        ArrayList<Monom> sirMonom1 = Model.matchingPattern(view.getTextPrimulPolinom().getText());
                        if (sirMonom1.size() == 0)
                            JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(), "Eroare la introducerea datelor");
                        else {

                            Polinom polinom1 = new Polinom(sirMonom1);

                            Model.eliminareRedundante(polinom1);

                            System.out.println(polinom1.toString());

                            // Model.integreaza(polinom1);

                            // textRezultat.setText(polinom1.toString());
                            view.getTextRezultat().setText(Model.integreaza(polinom1));

                        }
                    }
                }catch(StringIndexOutOfBoundsException ex)
                {
                    JOptionPane.showMessageDialog(view.getFrmPolynomialCalculator(),"Date invalide");
                }
            }
        });

        view.getButonUnu().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("1");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("1");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }
            }
        });

        view.getButonDoi().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("2");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                if(view.getSetLocationtoWrite() == 1)
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("2");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }

            }
        });

        view.getButonTrei().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior =  view.getTextPrimulPolinom().getText().concat("3");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("3");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }

            }
        });

        view.getButonPatru().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("4");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("4");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }

            }
        });

        view.getButonCinci().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("5");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                { textAnterior = view.getTextAlDoileaPolinom().getText().concat("5");
                    view.getTextAlDoileaPolinom().setText(textAnterior);

                }

            }
        });
        view.getButonSase().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            String textAnterior ="";
            if(view.getSetLocationtoWrite() == 0) {
                textAnterior = view.getTextPrimulPolinom().getText().concat("6");
                view.getTextPrimulPolinom().setText(textAnterior);
            }else
            {
                textAnterior = view.getTextAlDoileaPolinom().getText().concat("6");
                view.getTextAlDoileaPolinom().setText(textAnterior);
            }


        }
    });
        view.getButonSapte().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("7");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("7");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }

            }
        });

        view.getButonOpt().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("8");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("8");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }

            }
        });
        view.getButonNoua().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("9");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("9");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }

            }
        });

        view.getButonZero().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            String textAnterior ="";
            if(view.getSetLocationtoWrite() == 0) {
                textAnterior = view.getTextPrimulPolinom().getText().concat("0");
                view.getTextPrimulPolinom().setText(textAnterior);
            }else
            {
                textAnterior = view.getTextAlDoileaPolinom().getText().concat("0");
                view.getTextAlDoileaPolinom().setText(textAnterior);
            }
        }
    });
        view.getButonPlus().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            String textAnterior ="";
            if(view.getSetLocationtoWrite() == 0) {
                textAnterior = view.getTextPrimulPolinom().getText().concat("+");
                view.getTextPrimulPolinom().setText(textAnterior);
            }else
            {
                textAnterior = view.getTextAlDoileaPolinom().getText().concat("+");
                view.getTextAlDoileaPolinom().setText(textAnterior);
            }
        }
    });
        view.getButonMinus().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("-");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("-");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }
            }
        });

        view.getButonStea().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("*");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("*");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }
            }
        });

        view.getButonExponent().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior = view.getTextPrimulPolinom().getText().concat("^");
                    view.getTextPrimulPolinom().setText(textAnterior);
                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText().concat("^");
                    view.getTextAlDoileaPolinom().setText(textAnterior);
                }
            }
        });


        view.getButonVariabila().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            String textAnterior ="";
            if(view.getSetLocationtoWrite() == 0) {
                textAnterior = view.getTextPrimulPolinom().getText().concat("X");
                view.getTextPrimulPolinom().setText(textAnterior);
            }else
            {
                textAnterior = view.getTextAlDoileaPolinom().getText().concat("X");
                view.getTextAlDoileaPolinom().setText(textAnterior);
            }

        }
    });


        view.getButonStergere().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String textAnterior ="";
                if(view.getSetLocationtoWrite() == 0) {
                    textAnterior =view.getTextPrimulPolinom().getText();
                    if(textAnterior.length()>0)
                    {
                        view.getTextPrimulPolinom().setText(textAnterior.substring(0,textAnterior.length()-1));}


                }else
                {
                    textAnterior = view.getTextAlDoileaPolinom().getText();
                    if(textAnterior.length()>0)
                    {
                        view.getTextAlDoileaPolinom().setText(textAnterior.substring(0,textAnterior.length()-1));}

                }

                // textAnterior=textPrimulPolinom.getText();

            }
        });



        view.getButonAnterior().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            String s = view.getTextRezultat().getText();
            view.getTextRezultat().setText("");
            view.getTextPrimulPolinom().setText(s);
            view.getTextAlDoileaPolinom().setText("");

        }
    });

        view.getBtnClear().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            String textAnterior ="";
            if(view.getSetLocationtoWrite() == 0) {
                // textAnterior = textPrimulPolinom.getText().concat(".");
                view.getTextPrimulPolinom().setText(textAnterior);
            }else
            {
                //  textAnterior = textAlDoileaPolinom.getText().concat(".");
                view.getTextAlDoileaPolinom().setText(textAnterior);
            }

        }
    });

        view.getBtnPol1().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            view.setSetLocationtoWrite(0) ;
        }
    });

        view.getBtnPol2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                view.setSetLocationtoWrite(1) ;
            }
        });

    }


}
