package Zadanie3;

import java.util.Scanner;
public class Silnia {
    private class Watek extends Thread {
        private int liczba;
        private Silnia silnia;

        @Override
        public void run() {
            System.out.println(Thread.
                    currentThread().getName()
                    + "[" + liczba
                    + "] ! = " + silnia.licz(liczba));
        }
    }

    // obliczenie silni odbywa się za pomocą rekurencji
    public int licz(int wartosc) {
        try {
            if (wartosc <= 1)
                return 1;
            else
                return wartosc * licz(wartosc - 1);
        } finally {
            System.out.println(Thread.currentThread().getName()
                    + " ==[liczbe]==> " + wartosc);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
// pobieramy od użytkownika liczbę
        int liczba = sc.nextInt();
        sc.close();
        if (liczba < 16) {
            Silnia silnia = new Silnia();
            for (int i = 0; i < liczba; i++) {
                Watek watek = silnia.new Watek();
                watek.silnia = silnia;
                watek.liczba = liczba;
                watek.start();
            }
        }else{
            System.out.println("Licze max do !15");
        }
    }
}
/*
silnia jest liczona prawidlowo, po usunieciu synchronizacji silnia nadal jest poprawna.
 */


