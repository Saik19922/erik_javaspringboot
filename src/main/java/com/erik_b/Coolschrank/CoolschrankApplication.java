package com.erik_b.Coolschrank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CoolschrankApplication {

	private static final Logger log = LoggerFactory.getLogger(CoolschrankApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CoolschrankApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthentication("rolabewerbung", "Bewerbungen-rola").build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Coolschrank coolschrank = CoolschrankService.createCoolschrank(restTemplate);
			log.info(coolschrank.getId());
		};
	}

}
