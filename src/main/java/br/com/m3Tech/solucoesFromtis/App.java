package br.com.m3Tech.solucoesFromtis;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App  {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext contexto = new SpringApplicationBuilder(App.class)
                .web(WebApplicationType.NONE)
                .headless(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
	}
	
}
