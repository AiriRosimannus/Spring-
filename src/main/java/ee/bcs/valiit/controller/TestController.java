package ee.bcs.valiit.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private static final List<Employee> employees = new ArrayList();


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

   public TestController() {
    }


    @GetMapping("dto")
    public Employee dtoTest() {
        Employee employee = new Employee();
        employee.setAge(50);
        employee.setName("Jüri");
        employee.setAge(51);
        employee.setName("Mari");
        employee.setAge(52);
        employee.setName("Ülo");
        employee.setAge(53);
        employee.setName("Ants");
        employee.setAge(54);
        employee.setName("Sirje");
        return employee;
    }

    @PostMapping("dto")
    public void postTest(@RequestBody Employee employee) {
        System.out.println(employee.getName());
        System.out.println(employee.getAge());
    }

    @GetMapping("employees")
    public List<Employee> employees() {
        return employees;
    }

    @PostMapping("employees")
    public void addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
    }

    @PutMapping("employees/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employees.set(id, employee);
    }

    @DeleteMapping("employees/{id}")
    public void delateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employees.remove(id);
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employees.get(id);
    }
}
