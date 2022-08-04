package example;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.database.Manager;
import example.models.Customer;

public class App {
    public static void main(String[] args) throws Exception {
        var ctx = new ClassPathXmlApplicationContext("spring.xml");
        var customerManager = ctx.getBean("customerManager", Manager.class);

        var reader = new BufferedReader(new FileReader("test.txt"));
        reader.lines().forEach((data) -> {

            try {
                int update = customerManager.insert(new Customer(data.split(" , ")));
                System.out.println("number of row affected: " + update);
            } catch (Exception e) {
                System.out.println(data);
            }
        });

        reader.close();
        ctx.close();
    }
}
