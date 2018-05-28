package es.pablogdt.thermomix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ThermomixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThermomixApplication.class, args);
	}
}
