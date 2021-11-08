package Configuration;

import org.springframework.context.annotation.Bean;

public class PasswordSecure {
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
}
