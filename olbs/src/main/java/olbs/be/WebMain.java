package olbs.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan("olbs.be")
public class WebMain extends SpringBootServletInitializer{
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebMain.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(WebMain.class, args);
	}

}
