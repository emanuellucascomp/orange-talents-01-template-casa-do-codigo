package br.com.wb.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CasadocodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadocodigoApplication.class, args);
	}

}
