package com.inti.nosily_coach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing // JPA를 이용하면서 AuditingEntityListener를 활성화시키기 위해 설정 추가
public class NosilyCoachApplication {

	public static void main(String[] args) {
		SpringApplication.run(NosilyCoachApplication.class, args);
	}

}
