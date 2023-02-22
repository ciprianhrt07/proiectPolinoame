
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class View {

    private JFrame frmPolynomialCalculator;
    private JTextField textPrimulPolinom;
    private JTextField textAlDoileaPolinom;
    private JTextField textRezultat;
    private JLabel lblNewLabel;
    private JLabel lblSecondPolynomial;
    private  JLabel lblResultPolynomial;
    private  JButton butonInmulteste;
    private  JButton butonImparte;
    private JButton butonAduna;
    private JButton butonScade;
    private JButton butonDeriveaza;
    private JButton butonIntegreaza;
    private JButton butonZero;
    private JButton butonUnu;
    private  JButton butonDoi;
    private JButton butonTrei;
    private JButton butonPatru;
    private JButton butonCinci;
    private JButton butonSase;
    private JButton butonSapte;
    private JButton butonOpt;
    private JButton butonNoua;
    private JButton butonPlus;
    private JButton butonMinus;
    private JButton butonStea;
    private JButton butonExponent;
    private JButton butonVariabila;
    private JButton butonStergere;
    private JButton butonAnterior;
    private int codOperatie;
    private int setLocationtoWrite;
    private JButton btnPol1;
    private JButton btnPol2;
    private JButton btnClear;

    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    public View() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmPolynomialCalculator = new JFrame();
        frmPolynomialCalculator.getContentPane().setForeground(Color.GREEN);
        frmPolynomialCalculator.setForeground(Color.CYAN);
        frmPolynomialCalculator.setTitle("Polynomial Calculator");
        frmPolynomialCalculator.setBounds(100, 100, 713, 634);
        frmPolynomialCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPolynomialCalculator.getContentPane().setLayout(null);

        textPrimulPolinom = new JTextField();
        textPrimulPolinom.setEditable(false);
        textPrimulPolinom.setBounds(348, 69, 333, 40);
        textPrimulPolinom.setHorizontalAlignment(SwingConstants.RIGHT);
        frmPolynomialCalculator.getContentPane().add(textPrimulPolinom);
        textPrimulPolinom.setColumns(10);

        textAlDoileaPolinom = new JTextField();
        textAlDoileaPolinom.setEditable(false);
        textAlDoileaPolinom.setHorizontalAlignment(SwingConstants.RIGHT);
        textAlDoileaPolinom.setBounds(348, 119, 333, 40);
        frmPolynomialCalculator.getContentPane().add(textAlDoileaPolinom);
        textAlDoileaPolinom.setColumns(10);

        textRezultat = new JTextField();
        textRezultat.setEditable(false);
        textRezultat.setHorizontalAlignment(SwingConstants.RIGHT);
        textRezultat.setColumns(10);
        textRezultat.setBounds(348, 169, 333, 40);
        frmPolynomialCalculator.getContentPane().add(textRezultat);

        lblNewLabel = new JLabel("Primul Polinom =");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lblNewLabel.setBounds(23, 69, 297, 40);
        frmPolynomialCalculator.getContentPane().add(lblNewLabel);

        lblSecondPolynomial = new JLabel("Al doilea Polinom =");
        lblSecondPolynomial.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lblSecondPolynomial.setBounds(23, 119, 344, 40);
        frmPolynomialCalculator.getContentPane().add(lblSecondPolynomial);

        lblResultPolynomial = new JLabel("Polinom Rezultat =");
        lblResultPolynomial.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lblResultPolynomial.setBounds(23, 169, 329, 40);
        frmPolynomialCalculator.getContentPane().add(lblResultPolynomial);

        butonInmulteste = new JButton("Inmulteste");

        butonInmulteste.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonInmulteste.setBounds(70, 264, 211, 32);
        frmPolynomialCalculator.getContentPane().add(butonInmulteste);

        butonImparte = new JButton("Imparte");

        butonImparte.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonImparte.setBounds(70, 306, 211, 32);
        frmPolynomialCalculator.getContentPane().add(butonImparte);

        butonAduna = new JButton("Aduna");

        butonAduna.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonAduna.setBounds(70, 348, 211, 32);
        frmPolynomialCalculator.getContentPane().add(butonAduna);

        butonScade = new JButton("Scade");

        butonScade.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonScade.setBounds(378, 264, 206, 32);
        frmPolynomialCalculator.getContentPane().add(butonScade);

        butonDeriveaza = new JButton("Deriveaza");

        butonDeriveaza.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonDeriveaza.setBounds(378, 306, 206, 32);
        frmPolynomialCalculator.getContentPane().add(butonDeriveaza);

        butonIntegreaza = new JButton("Integreaza");

        butonIntegreaza.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonIntegreaza.setBounds(378, 348, 206, 32);
        frmPolynomialCalculator.getContentPane().add(butonIntegreaza);

        butonDoi = new JButton("2");

        butonDoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonDoi.setBounds(147, 427, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonDoi);

        butonTrei = new JButton("3");

        butonTrei.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonTrei.setBounds(219, 427, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonTrei);

        butonUnu = new JButton("1");

        butonUnu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonUnu.setBounds(75, 427, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonUnu);

        butonPatru = new JButton("4");

        butonPatru.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonPatru.setBounds(75, 477, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonPatru);

        butonCinci = new JButton("5");

        butonCinci.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonCinci.setBounds(147, 477, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonCinci);

        butonSase = new JButton("6");

        butonSase.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonSase.setBounds(219, 477, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonSase);

        butonSapte = new JButton("7");

        butonSapte.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonSapte.setBounds(75, 527, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonSapte);

        butonOpt = new JButton("8");

        butonOpt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonOpt.setBounds(147, 527, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonOpt);

        butonNoua = new JButton("9");

        butonNoua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonNoua.setBounds(219, 527, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonNoua);

        butonZero = new JButton("0");

        butonZero.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonZero.setBounds(378, 427, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonZero);

        butonPlus = new JButton("+");

        butonPlus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonPlus.setBounds(450, 427, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonPlus);

        butonMinus = new JButton("-");

        butonMinus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonMinus.setBounds(522, 427, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonMinus);


        butonStea = new JButton("*");

        butonStea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonStea.setBounds(450, 477, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonStea);

        butonExponent = new JButton("^");

        butonExponent.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonExponent.setBounds(522, 477, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonExponent);

        butonVariabila = new JButton("X");

        butonVariabila.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonVariabila.setBounds(378, 527, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonVariabila);

        butonStergere = new JButton("DEL");

        butonStergere.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonStergere.setBounds(450, 527, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonStergere);



        butonAnterior = new JButton("Ant");

        butonAnterior.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        butonAnterior.setBounds(378, 477, 62, 40);
        frmPolynomialCalculator.getContentPane().add(butonAnterior);

        btnPol1 = new JButton("Pol1");

        btnPol1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnPol1.setBounds(594, 477, 87, 40);
        frmPolynomialCalculator.getContentPane().add(btnPol1);

        btnPol2 = new JButton("Pol2");

        btnPol2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnPol2.setBounds(596, 527, 85, 40);
        frmPolynomialCalculator.getContentPane().add(btnPol2);

        btnClear = new JButton("CLR");

        btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnClear.setBounds(522, 527, 68, 40);
        frmPolynomialCalculator.getContentPane().add(btnClear);

        JLabel lblNewLabel_1 = new JLabel("                           Calculator de Polinoame");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(95, 10, 400, 37);
        frmPolynomialCalculator.getContentPane().add(lblNewLabel_1);
    }

    public JFrame getFrmPolynomialCalculator() {
        return frmPolynomialCalculator;
    }

    public void setFrmPolynomialCalculator(JFrame frmPolynomialCalculator) {
        this.frmPolynomialCalculator = frmPolynomialCalculator;
    }

    public JTextField getTextPrimulPolinom() {
        return textPrimulPolinom;
    }

    public void setTextPrimulPolinom(JTextField textPrimulPolinom) {
        this.textPrimulPolinom = textPrimulPolinom;
    }

    public JTextField getTextAlDoileaPolinom() {
        return textAlDoileaPolinom;
    }

    public void setTextAlDoileaPolinom(JTextField textAlDoileaPolinom) {
        this.textAlDoileaPolinom = textAlDoileaPolinom;
    }

    public JTextField getTextRezultat() {
        return textRezultat;
    }

    public void setTextRezultat(JTextField textRezultat) {
        this.textRezultat = textRezultat;
    }

    public JLabel getLblNewLabel() {
        return lblNewLabel;
    }

    public void setLblNewLabel(JLabel lblNewLabel) {
        this.lblNewLabel = lblNewLabel;
    }

    public JLabel getLblSecondPolynomial() {
        return lblSecondPolynomial;
    }

    public void setLblSecondPolynomial(JLabel lblSecondPolynomial) {
        this.lblSecondPolynomial = lblSecondPolynomial;
    }

    public JLabel getLblResultPolynomial() {
        return lblResultPolynomial;
    }

    public void setLblResultPolynomial(JLabel lblResultPolynomial) {
        this.lblResultPolynomial = lblResultPolynomial;
    }

    public JButton getButonInmulteste() {
        return butonInmulteste;
    }

    public void setButonInmulteste(JButton butonInmulteste) {
        this.butonInmulteste = butonInmulteste;
    }

    public JButton getButonImparte() {
        return butonImparte;
    }

    public void setButonImparte(JButton butonImparte) {
        this.butonImparte = butonImparte;
    }

    public JButton getButonAduna() {
        return butonAduna;
    }

    public void setButonAduna(JButton butonAduna) {
        this.butonAduna = butonAduna;
    }

    public JButton getButonScade() {
        return butonScade;
    }

    public void setButonScade(JButton butonScade) {
        this.butonScade = butonScade;
    }

    public JButton getButonDeriveaza() {
        return butonDeriveaza;
    }

    public void setButonDeriveaza(JButton butonDeriveaza) {
        this.butonDeriveaza = butonDeriveaza;
    }

    public JButton getButonIntegreaza() {
        return butonIntegreaza;
    }

    public void setButonIntegreaza(JButton butonIntegreaza) {
        this.butonIntegreaza = butonIntegreaza;
    }

    public JButton getButonZero() {
        return butonZero;
    }

    public void setButonZero(JButton butonZero) {
        this.butonZero = butonZero;
    }

    public JButton getButonUnu() {
        return butonUnu;
    }

    public void setButonUnu(JButton butonUnu) {
        this.butonUnu = butonUnu;
    }

    public JButton getButonDoi() {
        return butonDoi;
    }

    public void setButonDoi(JButton butonDoi) {
        this.butonDoi = butonDoi;
    }

    public JButton getButonTrei() {
        return butonTrei;
    }

    public void setButonTrei(JButton butonTrei) {
        this.butonTrei = butonTrei;
    }

    public JButton getButonPatru() {
        return butonPatru;
    }

    public void setButonPatru(JButton butonPatru) {
        this.butonPatru = butonPatru;
    }

    public JButton getButonCinci() {
        return butonCinci;
    }

    public void setButonCinci(JButton butonCinci) {
        this.butonCinci = butonCinci;
    }

    public JButton getButonSase() {
        return butonSase;
    }

    public void setButonSase(JButton butonSase) {
        this.butonSase = butonSase;
    }

    public JButton getButonSapte() {
        return butonSapte;
    }

    public void setButonSapte(JButton butonSapte) {
        this.butonSapte = butonSapte;
    }

    public JButton getButonOpt() {
        return butonOpt;
    }

    public void setButonOpt(JButton butonOpt) {
        this.butonOpt = butonOpt;
    }

    public JButton getButonNoua() {
        return butonNoua;
    }

    public void setButonNoua(JButton butonNoua) {
        this.butonNoua = butonNoua;
    }

    public JButton getButonPlus() {
        return butonPlus;
    }

    public void setButonPlus(JButton butonPlus) {
        this.butonPlus = butonPlus;
    }

    public JButton getButonMinus() {
        return butonMinus;
    }

    public void setButonMinus(JButton butonMinus) {
        this.butonMinus = butonMinus;
    }

    public JButton getButonStea() {
        return butonStea;
    }

    public void setButonStea(JButton butonStea) {
        this.butonStea = butonStea;
    }

    public JButton getButonExponent() {
        return butonExponent;
    }

    public void setButonExponent(JButton butonExponent) {
        this.butonExponent = butonExponent;
    }

    public JButton getButonVariabila() {
        return butonVariabila;
    }

    public void setButonVariabila(JButton butonVariabila) {
        this.butonVariabila = butonVariabila;
    }

    public JButton getButonStergere() {
        return butonStergere;
    }

    public void setButonStergere(JButton butonStergere) {
        this.butonStergere = butonStergere;
    }

    public JButton getButonAnterior() {
        return butonAnterior;
    }

    public void setButonAnterior(JButton butonAnterior) {
        this.butonAnterior = butonAnterior;
    }

    public int getCodOperatie() {
        return codOperatie;
    }

    public void setCodOperatie(int codOperatie) {
        this.codOperatie = codOperatie;
    }

    public int getSetLocationtoWrite() {
        return setLocationtoWrite;
    }

    public void setSetLocationtoWrite(int setLocationtoWrite) {
        this.setLocationtoWrite = setLocationtoWrite;
    }

    public JButton getBtnPol1() {
        return btnPol1;
    }

    public void setBtnPol1(JButton btnPol1) {
        this.btnPol1 = btnPol1;
    }

    public JButton getBtnPol2() {
        return btnPol2;
    }

    public void setBtnPol2(JButton btnPol2) {
        this.btnPol2 = btnPol2;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(JButton btnClear) {
        this.btnClear = btnClear;
    }

    public void setTextRezultat(String rezultat)
    {
        textRezultat.setText(rezultat);
    }


}
