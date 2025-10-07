package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendFinaBoss2BApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendFinaBoss2BApplication.class, args);
		/*
		* Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(),entry.getValue()));
		SpringApplication.run(JosueAyala20240001Application.class, args);
		* */
	}

}
