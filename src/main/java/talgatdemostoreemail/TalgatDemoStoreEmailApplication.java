package talgatdemostoreemail;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import talgatdemostoreemail.services.EmailSenderService;
import talgatdemostoreemail.services.ItemServices;

import java.util.Arrays;

@SpringBootApplication
public class TalgatDemoStoreEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalgatDemoStoreEmailApplication.class, args);
	}

}
