package ee.bcs.valiit.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/fibonacci/{fibonacci}") //http://localhost:8080/fibonacci/8
    public int fibonacci(@PathVariable("fibonacci") int id) {
        int i = Lesson2.fibonacci(id);
        return i;
    }

    @GetMapping("/exercise1/{exercise1}") //http://localhost:8080/exercise1/4,5,6,7,8,9,10,11,12,13
    public int[] exercise1(@PathVariable("exercise1") int[] id) {
        int[] i = Lesson2.exercise1(id);
        return i;
    }

}





   /* @GetMapping(value= "/")
    public String getHelloWorld(){
        return "Hello World";
    }
} */
