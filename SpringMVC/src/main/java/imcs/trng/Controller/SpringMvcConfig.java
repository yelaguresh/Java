package imcs.trng.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"imcs.trng.Controller"})
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
	@Bean
public InternalResourceViewResolver viewResolver() {
	InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/");
	resolver.setSuffix(".jsp");
	return resolver;
}
}
