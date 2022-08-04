package example;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) throws Exception {
        var ctx = new ClassPathXmlApplicationContext("spring.xml");
        var jdbc = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        String statement = """
                CREATE TABLE IF NOT EXISTS Customers (
                    CustomerID INTEGER PRIMARY KEY AUTOINCREMENT,
                    CustomerName TEXT,
                    ContactName TEXT,
                    Address TEXT,
                    City TEXT,
                    PostalCode TEXT,
                    Country TEXT
                    )
                """.strip();
        jdbc.update(statement); // create table

        var reader = new BufferedReader(new FileReader("test.txt"));
        statement = "INSERT INTO Customers(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country) VALUES (?,?,?,?,?,?,?)";
        final String _statement = statement;

        reader.lines().forEach((data) -> {

            try {
                int update = jdbc.update(_statement, (Object[]) data.split(" , "));
                System.out.println("number of row affected: " + update);
            } catch (Exception e) {
                System.out.println(data);
            }
        });

        reader.close();
        ctx.close();
    }
}
