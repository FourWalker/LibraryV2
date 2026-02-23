package uno.zeron.one.LibraryV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "uno.zeron.one")
public class LibraryV2Application {

	public static void main(String[] args) {
		SpringApplication.run(LibraryV2Application.class, args);
	}

}
