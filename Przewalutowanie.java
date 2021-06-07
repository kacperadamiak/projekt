package projekt;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Przewalutowanie implements ActionListener {
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("SMB - Waluty");
    JLabel zloty1 = new JLabel();
    JLabel euro1 = new JLabel();
    JLabel dolar1 = new JLabel();

    JTextField kwotazloty = new JTextField();
    JTextField kwotazloty2 = new JTextField();

    JTextField kwotaeuro = new JTextField();
    JTextField kwotaeuro2 = new JTextField();

    JTextField kwotadolar = new JTextField();
    JTextField kwotadolar2 = new JTextField();

    JLabel kurse1 = new JLabel();
    JLabel kursd1 = new JLabel();

    JLabel kurse2 = new JLabel();
    JLabel kursp2 = new JLabel();

    JLabel kursd3 = new JLabel();
    JLabel kursp3 = new JLabel();

    JButton wnae = new JButton("Wymień na EUR");
    JButton wnad = new JButton("Wymień na USD");

    JButton wnae2 = new JButton("Wymień na EUR");
    JButton wnap = new JButton("Wymień na PLN");

    JButton wnap2 = new JButton("Wymień na PLN");
    JButton wnad2 = new JButton("Wymień na USD");

    JButton wyjscie = new JButton("Wróć");

    Uzytkownik x;
    double zloty;
    double euro;
    double dolar;
    Przewalutowanie(Uzytkownik x){
        this.x=x;
        double EUR1=4.53;
        double USD1=3.73;

        double PLN2=0.27;
        double EUR2=1.22;

        double PLN3=0.22;
        double USD3=0.82;
        zloty = x.GetZloty();
        euro = x.GetEuro();
        dolar = x.GetDolar();

        wyjscie.setBounds(180, 700, 120, 25);
        wyjscie.setFocusable(false);
        wyjscie.addActionListener(this);

        ///////////////////////////////
        zloty1.setText("Stan konta: "+zloty+"ZŁ");
        zloty1.setBounds(180, 10, 130, 23);

        kursd1.setText("Kurs na $: "+USD1);
        kursd1.setBounds(50, 50, 100, 23);
        kwotazloty.setBounds(30, 85, 140, 25);
        kwotazloty.setText("Wpisz tutaj kwote");

        kurse1.setText("Kurs na €: "+EUR1);
        kurse1.setBounds(340, 50, 100, 23);
        kwotazloty2.setBounds(320, 85, 140, 25);
        kwotazloty2.setText("Wpisz tutaj kwote");

        wnad.setBounds(30, 130, 140, 50);
        wnad.setFocusable(false);
        wnad.addActionListener(this);


        wnae.setBounds(320, 130, 140, 50);
        wnae.setFocusable(false);
        wnae.addActionListener(this);

        ///////////////////////////////
        dolar1.setText("Stan konta: "+dolar+"$");
        dolar1.setBounds(180, 210, 130, 23);

        kurse2.setText("Kurs na €: "+EUR2);
        kurse2.setBounds(50, 250, 100, 23);
        kwotadolar.setBounds(30, 285, 140, 25);
        kwotadolar.setText("Wpisz tutaj kwote");

        kursp2.setText("Kurs na ZŁ: "+PLN2);
        kursp2.setBounds(340, 250, 100, 23);
        kwotadolar2.setBounds(320, 285, 140, 25);
        kwotadolar2.setText("Wpisz tutaj kwote");

        wnae2.setBounds(30, 330, 140, 50);
        wnae2.setFocusable(false);
        wnae2.addActionListener(this);

        wnap.setBounds(320, 330, 140, 50);
        wnap.setFocusable(false);
        wnap.addActionListener(this);

        ////////////////////////////////
        euro1.setText("Stan konta: "+euro+"€");
        euro1.setBounds(180, 410, 130, 23);

        kursd3.setText("Kurs na $: "+USD3);
        kursd3.setBounds(30, 420, 100, 23);
        kwotaeuro.setBounds(30, 485, 140, 25);
        kwotaeuro.setText("Wpisz tutaj kwote");

        kursp3.setText("Kurs na €: "+PLN3);
        kursp3.setBounds(370, 420, 100, 23);
        kwotaeuro2.setBounds(320, 485, 140, 25);
        kwotaeuro2.setText("Wpisz tutaj kwote");

        wnad2.setBounds(30, 530, 140, 50);
        wnad2.setFocusable(false);
        wnad2.addActionListener(this);

        wnap2.setBounds(320, 530, 140, 50);
        wnap2.setFocusable(false);
        wnap2.addActionListener(this);

        //////////////////////////////////
        frame.setLayout(null);

        frame.add(zloty1);
        frame.add(euro1);
        frame.add(dolar1);

        frame.add(kwotadolar);
        frame.add(kwotaeuro);
        frame.add(kwotazloty);
        frame.add(kwotadolar2);
        frame.add(kwotaeuro2);
        frame.add(kwotazloty2);

        frame.add(kurse1);
        frame.add(kursd1);
        frame.add(kurse2);
        frame.add(kursp2);
        frame.add(kursd3);
        frame.add(kursp3);

        frame.add(wnae);
        frame.add(wnad);
        frame.add(wnae2);
        frame.add(wnap);
        frame.add(wnap2);
        frame.add(wnad2);
        frame.add(wyjscie);

        frame.setSize(500,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        frame.setVisible(true);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        double rounded = tmp/factor;
        return rounded;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==wnad) {
            String test=kwotazloty.getText();
            double zloty= Double.parseDouble(test);
            x.zloty=x.zloty-zloty;
            double buff = 0;
            double USD1=3.73;
            buff = zloty/USD1;
            double rounded = round(buff,2);
            x.dolar = x.dolar + rounded;
            x.zapiszzloty(x.zloty);
            x.zapiszdolar(x.dolar);
            JOptionPane.showMessageDialog(null,"Wymieniono!","Sukces",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() ==wnae) {
            String test=kwotazloty2.getText();
            double zloty= Double.parseDouble(test);
            x.zloty=x.zloty-zloty;
            double buff = 0;
            double EUR1=4.53;
            buff = zloty/EUR1;
            double rounded = round(buff,2);
            x.euro = x.euro + rounded;
            x.zapiszzloty(x.zloty);
            x.zapiszeuro(x.euro);
            JOptionPane.showMessageDialog(null,"Wymieniono!","Sukces",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() ==wnae2) {
            String test=kwotadolar.getText();
            double dolar= Double.parseDouble(test);
            x.dolar=x.dolar-dolar;
            double buff = 0;
            double EUR2=1.22;
            buff = dolar/EUR2;
            double rounded = round(buff,2);
            x.euro = x.euro + rounded;
            x.zapiszdolar(x.dolar);
            x.zapiszeuro(x.euro);
            JOptionPane.showMessageDialog(null,"Wymieniono!","Sukces",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() ==wnap) {
            String test=kwotadolar2.getText();
            double dolar= Double.parseDouble(test);
            x.dolar=x.dolar-dolar;
            double buff = 0;
            double PLN2=0.27;
            buff = dolar/PLN2;
            double rounded = round(buff,2);
            x.zloty = x.zloty + rounded;
            x.zapiszdolar(x.dolar);
            x.zapiszzloty(x.zloty);
            JOptionPane.showMessageDialog(null,"Wymieniono!","Sukces",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() ==wnad2) {
            String test=kwotaeuro.getText();
            double euro= Double.parseDouble(test);
            x.euro=x.euro-euro;
            double buff = 0;
            double USD3=0.82;
            buff = euro/USD3;
            double rounded = round(buff,2);
            x.dolar = x.dolar + rounded;
            x.zapiszeuro(x.euro);
            x.zapiszdolar(x.dolar);
            JOptionPane.showMessageDialog(null,"Wymieniono!","Sukces",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() ==wnap2) {
            String test=kwotaeuro2.getText();
            double euro= Double.parseDouble(test);
            x.euro=x.euro-euro;
            double buff = 0;
            double PLN3=0.22;
            buff = euro/PLN3;
            double rounded = round(buff,2);
            x.zloty = x.zloty + rounded;
            x.zapiszeuro(x.euro);
            x.zapiszzloty(x.zloty);
            JOptionPane.showMessageDialog(null,"Wymieniono!","Sukces",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() ==wyjscie) {
            frame.dispose();
            Menu menu = new Menu(x);
        }
    }
}


