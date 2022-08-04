package example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import example.database.Manager;
import example.models.Customer;

public class App {
    public static void main(String[] args) throws Exception {
        var ctx = new ClassPathXmlApplicationContext("spring.xml");
        var manager = ctx.getBean("customerManager", Manager.class);

        var customer = new Customer(32, "Robot", "XA12-V002", "S2F1", "XA", "0012", "RobotLand-1");
        System.out.println(customer);

        var r = manager.delete(32);
        System.out.println("rows affected: " + r);

        r = manager.insert(customer);
        System.out.println("rows affected: " + r);

        customer.setPostalCode("0013");
        r = manager.update(customer);
        System.out.println("rows affected: " + r);

        var customer_ = manager.findOne(32);
        System.out.println(customer_);

        var customers = manager.findAll();
        for(Customer c: customers){
            System.out.println(c);
        }
        ctx.close();
    }
}
