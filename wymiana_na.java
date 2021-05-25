package Wymiana_walut;
import java.util.Scanner;

class wymianaPLN_na {
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double kwota2= 0;
        String w2= "PLN";
        double EUR=4.5298;
        double USD=3.7288;
        double AUD=2.8939;
        double THB=0.1186;
        double CAD=3.0787;
        double NZD=2.6911;
        double HKD=0.4801;
        double SGD=2.7913;
        double GBP=5.2602;
        double CHF=4.1347;
        System.out.println("Podaj kwote jaka chcesz wymienic: ");
        int kwota1 = in.nextInt();
        System.out.println("Wybierz na jaka walute chcesz wymienic:(wpisz numerek znajdujacy sie przy walucie)");
        System.out.println("1.Euro.");
        System.out.println("2.Dolar amerykanski.");
        System.out.println("3.Dolar australijski.");
        System.out.println("4.Bat tajlandzki.");
        System.out.println("5.Dolar kanadyjski.");
        System.out.println("6.Dolar nowozelandzki.");
        System.out.println("7.Dolar hongkongu.");
        System.out.println("8.Dolar singapurski");
        System.out.println("9.Funt szterling.");
        System.out.println("10.Frank szwajcarski.");
        System.out.println("Twoj wybor:");
        int w = in.nextInt();
        switch (w){
            case 1: {kwota2 = kwota1/EUR;
                w2 = "EUR";
            }break;
            case 2: {kwota2 = kwota1/USD;
                w2= "USD";
            }break;
            case 3: {kwota2 = kwota1/AUD;
                w2= "AUD";
            }break;
            case 4: {kwota2 = kwota1/THB;
                w2= "THB";
            }break;
            case 5: {kwota2 = kwota1/CAD;
                w2= "CAD";
            }break;
            case 6: {kwota2 = kwota1/NZD;
                w2= "NZD";
            }break;
            case 7: {kwota2 = kwota1/HKD;
                w2= "HKD";
            }break;
            case 8: {kwota2 = kwota1/SGD;
                w2= "SGD";
            }break;
            case 9: {kwota2 = kwota1/GBP;
                w2= "GBP";
            }break;
            case 10: {kwota2 = kwota1/CHF;
                w2= "CHF";
            }break;
            }
            System.out.println("Kwota otrzymana po wymianie:"+round(kwota2,2)+" "+w2);
    }
    }

