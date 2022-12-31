package talgatdemostoreemail;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import talgatdemostoreemail.services.EmailSenderService;

@SpringBootApplication
public class TalgatDemoStoreEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalgatDemoStoreEmailApplication.class, args);
	}

	@Bean
	public CommandLineRunner emailSender(EmailSenderService senderService){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				senderService.sendEmail("alimbayev.talgat@gmail.com","hello","1st email sent by Spring Boot");
			}
		};
	}
}
