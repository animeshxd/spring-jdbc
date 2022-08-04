package example;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) throws Exception {
        var ctx = new ClassPathXmlApplicationContext("spring.xml");
        var jdbc = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

        ctx.close();
    }
}
