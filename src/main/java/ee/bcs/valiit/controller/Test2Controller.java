package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test2")
public class Test2Controller {

    // 1 2 3 4 5 6 7 8 9 10
    // 2 3 4 5 6 7 8 9 10 11
    // 3 4 5 6 7 8 9 10 11 12
    // 10 rida

    private static final Map<String, BigDecimal> map = new HashMap<>();
    int x = 10;
    int y = 10;
    int a;

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
    public static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 1;
        } else {
            return (fibonacci(n - 1) + fibonacci(n - 3));

        }
   /* public static void fibonacci(int n) {
        int n1 = 0;
        int n2 = 1;
        int n3 = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(n - 1) + fibonacci(n - 3));
        }
    }/*



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


        // Loed läbi requestparami 2 väärtust x, y
        // teed tabeli mis on x ühikut lai ja y ühikut kõrge
        // Näide:
        // 1 2 3 4 5 6 7
        // 2 3 4 5 6 7 8
        // 3 4 5 6 7 8 9
  /* @GetMapping("y3")
    public void test2(@RequestParam("width") int x,)
                      @RequestParam("height") int y) {
        for (int x1 = 1; x1 <= x; x1++) {
            for (int y1 = 1; y1 <= y; y1++) {
                System.out.print(x1 + (y1 - 1) + "\t");
            }
            System.out.println();
        }
    }*/
    }

    @GetMapping("y5")
    public void test(@RequestParam() int a) {
        this.a = a; // Annab vääärtuse http://localhost:8080/test2/y5?a=5
    }

    @GetMapping("y6")
    public int test2() {
        return (this.a); //tagastab väärtuse http://localhost:8080/test2/y6?

    }

    @GetMapping("y7")
    public void y7(@RequestParam String accountNr, @RequestParam() BigDecimal balance) {
        map.put(accountNr, balance);
        //Loob konto ja annab väärtuse http://localhost:8080/test2/y7?accountNr=abc&balance=44

    }

    @GetMapping("y8")
    public BigDecimal y8(@RequestParam String accountNr) {
        return map.get(accountNr);// accountNr väärtuse e. balance.
        //http://localhost:8080/test2/y8?accountNr=abc  kuvab 44

    }

}
