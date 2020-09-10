package ee.bcs.valiit.controller;

import java.math.BigDecimal;
import java.util.Scanner;


public class Lesson2 {

    public static int[] exercise1(int[] m) {
        // TODO loo 10 elemendile täisarvude massiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras
        int [] result = new int [10];
        for (int m2 = 9; m2 >= 0; m2--) {
            result[9-m2] = m[m2];
        }
        return result;
    }

    public static void exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta mitu paaris arvu soovid:");
        x = scanner.nextInt();


        for (int x1 = 1; x1 <= x; x1++) {
            System.out.println(x1 * 2 + " ");
        }
    }

    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
        Scanner scanner = new Scanner(System.in);
        System.out.println("Korrutus tabeli laius ühikutes:");
        x = scanner.nextInt();
        System.out.println("Korrutus tabeli kõrgus ühikutes:");
        y = scanner.nextInt();


        for (int x1 = 1; x1 <= x; x1++) {

            for (int y1 = 1; y1 <= y; y1++) {

                System.out.print(x1 * y1 + "\t");
            }
            System.out.println();
        }
    }


    public static int fibonacci(int n) {
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element

        {
            if (n <= 1) {
                return n;
            } else {
                return (fibonacci(n - 1) + fibonacci(n - 2));
            }

        }

    }


    public static void exercise5(int i) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        int k = 0;


        while (i != 1) {

            i = Lesson3.alg(i);

            k = +1;
        }


        return;
    }


    public static void exercise6() {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */
    }

    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal(1.89);
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");

    }

    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

}