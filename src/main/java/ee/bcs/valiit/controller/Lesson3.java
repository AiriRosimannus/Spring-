package ee.bcs.valiit.controller;

import java.util.Arrays;


public class Lesson3 {

    public static void main(String[] args) {
        alg(7);
        System.out.println(alg(7));

        int a = 5;
        int b = 3;
        System.out.println(sum(a, b));

        int[] m = {2, 6, 8, 10};
        System.out.println(sum(m));

        int c = 5;
        System.out.println(factorial(c));

        int[] d = {2, 6, 8, 1};
        int temp;
        System.out.println(Arrays.toString(sort(d)));

        String s = "Test";
        System.out.println(reverseString(s));

        int e = 17;
        System.out.println(isPrime(e));

    }

    public static int alg(int i) {
        // todo kui i on paaris arv tagasta i /2
        // kui i on paaritu tagasta i*3+1

        if (i % 2 == 0) {
            return i / 2;

        } else {
            return i * 3 + 1;
        }


    }


    public static int sum(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus

        int sum = x + y;
        return sum;
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x

        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        return sum;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120

        if (x == 0)
            return 1;
        return x * factorial(x - 1);
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}


        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length - 1; j++) {
                if (a[i] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        // Näiteks:
        // a = "Test";
        // return tseT";
        char[] in = a.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        for (int i = 2; i < x; i++) {
            if (x % i == 0 && i != x) {
                return false;
            }
        }
        return true;
    }
}