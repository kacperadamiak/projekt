package logowanie;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Lokata {
    double kasa;
    double lokata;
    int termin;
    Scanner x = new Scanner(System.in);

    Lokata(double kasa){
        this.kasa=kasa;
    }

   public void testowanie(){

        System.out.println("Podaj ile chcesz wplacic na lokate: ");
        lokata= x.nextInt();
        while (lokata>kasa){
            System.out.println("Brak podana wartosc przekracza ilosc twoich pieniedzy, podaj poprawna wartosc: ");
            lokata= x.nextInt();

        }
        System.out.println("Na jaki termin(do 12 miesiecy): ");
        termin=x.nextInt();
        while(termin>12) {
            System.out.println("Podaj poprawna wartosc:");
            termin = x.nextInt();
        }

        if(termin<=4){
            System.out.println("Podana kwota: "+lokata+" zł ");
           // System.out.println("Na twoim koncie pozostanie:"+(kasa-lokata));
            System.out.println("Oprocentowanie w skali roku wynosi 1%");

            double procent=1;
            double sto=100;
            double ulamek=procent/sto;
            double kwota=lokata*pow(1+ulamek,(double)termin/12);
            double podatek= (kwota-lokata)*0.19;
            double kwotapopodatku= kwota-podatek;
            System.out.print("Po podanym okresie i odliczeniu podatku Belki kwota bedzie rowna: ");
            System.out.format("%.2f%n\n", kwotapopodatku);
        }
       else if(termin>=4 && termin>=8){
           System.out.println("Podana kwota: "+lokata+" zł ");
           // System.out.println("Na twoim koncie pozostanie:"+(kasa-lokata));
           System.out.println("Oprocentowanie w skali roku wynosi 1%");

           double procent=2;
           double sto=100;
           double ulamek=procent/sto;
           double kwota=lokata*pow(1+ulamek,(double)termin/12);
           double podatek= (kwota-lokata)*0.19;
           double kwotapopodatku= kwota-podatek;
           System.out.print("Po podanym okresie i odliczeniu podatku Belki kwota bedzie rowna: ");
           System.out.format("%.2f%n\n", kwotapopodatku);
       }
       else{
            System.out.println("Podana kwota: "+lokata+" zł ");
            // System.out.println("Na twoim koncie pozostanie:"+(kasa-lokata));
            System.out.println("Oprocentowanie w skali roku wynosi 1%");
            double procent=3;
            double sto=100;
            double ulamek=procent/sto;
            double kwota=lokata*pow(1+ulamek,(double)termin/12);
            double podatek= (kwota-lokata)*0.19;
            double kwotapopodatku= kwota-podatek;
            System.out.print("Po podanym okresie i odliczeniu podatku Belki kwota bedzie rowna: ");
            System.out.format("%.2f%n\n", kwotapopodatku);
        }
    }
}
