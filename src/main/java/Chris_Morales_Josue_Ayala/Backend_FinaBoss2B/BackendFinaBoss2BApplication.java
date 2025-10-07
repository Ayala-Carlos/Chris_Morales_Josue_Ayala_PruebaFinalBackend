package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendFinaBoss2BApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(),entry.getValue()));
		SpringApplication.run(BackendFinaBoss2BApplication.class, args);

	}

}
