package sweStart.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sweStart.project")

public class SweStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweStartApplication.class, args);
	}

}
