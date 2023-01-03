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

	@Bean
	public CommandLineRunner emailSender(EmailSenderService senderService, ItemServices itemServices){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
//				senderService.sendEmail("alimbayev.talgat@gmail.com","hello","1st email sent by Spring Boot");
//				System.out.println(itemServices.getItemsById(Arrays.asList(1L,2L)));
			}
		};
	}
}
