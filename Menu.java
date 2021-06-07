package projekt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {

    private JPanel panel = new JPanel();

    JLabel kwotazloty = new JLabel();
    JLabel kwotadolar = new JLabel();
    JLabel kwotaeuro = new JLabel();

    JButton Waluty = new JButton("Wymiana walut");
    JButton Lokata = new JButton("Lokata");
    JButton Ubezpieczenie = new JButton("Ubezpieczenie");
    JButton Przelew = new JButton("Przelew");
    JButton Wyloguj = new JButton("Wyloguj");
    Uzytkownik x;


    private JFrame frame= new JFrame("SMB");

    Menu(Uzytkownik x){

        this.x=x;

        kwotazloty.setText("Zloty: "+x.GetZloty()+"zł");
        kwotazloty.setBounds(50, 70, 100, 100);

        kwotadolar.setText("Dolar: "+x.GetDolar()+"$");
        kwotadolar.setBounds(50, 110, 100, 100);

        kwotaeuro.setText("Euro:   "+x.GetEuro()+"€");
        kwotaeuro.setBounds(50, 150, 100, 100);




        ImageIcon logo = new ImageIcon("smb.png");

        frame.setIconImage(logo.getImage());
        frame.setResizable(false);

        Przelew.setBounds(25, 260, 200, 100);
        Przelew.setFocusable(false);
        Przelew.addActionListener(this);

        Ubezpieczenie.setBounds(258, 260, 200, 100);
        Ubezpieczenie.setFocusable(false);
        Ubezpieczenie.addActionListener(this);

        Waluty.setBounds(25, 380, 200, 100);
        Waluty.setFocusable(false);
        Waluty.addActionListener(this);

        Lokata.setBounds(258, 380, 200, 100);
        Lokata.setFocusable(false);
        Lokata.addActionListener(this);

        Wyloguj.setBounds(180, 700, 120, 25);
        Wyloguj.setFocusable(false);
        Wyloguj.addActionListener(this);

        frame.setSize(500,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);
        panel.add(Waluty);
        panel.add(Lokata);
        panel.add(Ubezpieczenie);
        panel.add(Przelew);
        panel.add(Wyloguj);
        panel.add(kwotadolar);
        panel.add(kwotaeuro);
        panel.add(kwotazloty);

        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Przelew) {
            Przelew przelew = new Przelew(x);
            frame.dispose();        }
        if (e.getSource() == Ubezpieczenie) {
            JOptionPane.showMessageDialog(null,"Wkrótce!","W trakcie realizacji...",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() == Waluty) {
            Przewalutowanie waluty = new Przewalutowanie(x);
            frame.dispose();
        }
        if (e.getSource() ==Lokata) {
            JOptionPane.showMessageDialog(null,"Wkrótce!","W trakcie realizacji...",JOptionPane.PLAIN_MESSAGE);
        }
        if (e.getSource() ==Wyloguj) {
            frame.dispose();
            Konta konta = new Konta();
            Logowanie login = new Logowanie(konta.getLoginInfo());
        }

    }
}
