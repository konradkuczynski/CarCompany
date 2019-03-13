package carrentalcompany.demo;

import carrentalcompany.demo.thread.VariableRunnable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        threadPool.schedule(new VariableRunnable(), 1, TimeUnit.SECONDS );

    }

}
