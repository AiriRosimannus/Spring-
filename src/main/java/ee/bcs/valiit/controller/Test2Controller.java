package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test2")
public class Test2Controller {

    // 1 2 3 4 5 6 7 8 9 10
    // 2 3 4 5 6 7 8 9 10 11
    // 3 4 5 6 7 8 9 10 11 12
    // 10 rida

    int x = 10;
    int y = 10;

    // sisend on int n; väljund n-is arv jadas
    // fun(n) = fun(n-1) + fun(n-3)
    // 0
    // 1
    // 1
    // 1
    // 2
    // 3
    // 4
    // 6
    @GetMapping("y4")

    // üks võimalus
   /* public static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 1;
        } else {
            return (fibonacci(n - 1) + fibonacci(n - 3));

        }*/
    public static int fib (int n){


    }

    @GetMapping("y1")
    public void test1() {

        for (int x1 = 1; x1 <= x; x1++) {
            for (int y1 = 1; y1 <= y; y1++) {

                System.out.print(x1 + (y1 - 1) + "\t");
            }
            System.out.println();
        }
    }

    // loe need 3 muutujat sisse kasutades request parameetrit
    // tee nii, et tagastatav väärtus on alati miinus märgiga
    @GetMapping("y2")
    public void test2(@RequestParam("firstnumber") int a,
                      @RequestParam("secondnumber") int b,
                      @RequestParam("thirdnumber") int c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        if (a * b * c > 0) {
            System.out.println(-1 * (a * b * c));
        } else if (a * b * c == 0) {
            System.out.println("-0");
        } else {
            System.out.println(a * b * c);
        }
        // näiteks: http://localhost:8080/test2/y2?firstnumber=-2&secondnumber=3&thirdnumber=4
        // TODO loo 3 int tüüpi muutujat
        // Anna neile väärtused 5, 9 ,7
        // trüki välja nende numbrite korrutis miinus märgiga
        /*int a = 5;
        int b = 9;
        int c = 7;
        System.out.println(-(a*b*c));*/
    }

    // Loed läbi requestparami 2 väärtust x, y
    // teed tabeli mis on x ühikut lai ja y ühikut kõrge
    // Näide:
    // 1 2 3 4 5 6 7
    // 2 3 4 5 6 7 8
    // 3 4 5 6 7 8 9
    @GetMapping("y3")
    public void test2(@RequestParam("width") int x,
                      @RequestParam("height") int y) {
        for (int x1 = 1; x1 <= x; x1++) {
            for (int y1 = 1; y1 <= y; y1++) {
                System.out.print(x1 + (y1 - 1) + "\t");
            }
            System.out.println();
        }
    }
}





