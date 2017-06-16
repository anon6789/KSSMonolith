package de.mstock.monolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonolithApplication {

  public static void main(String[] args) {
	System.getProperties().put( "server.port", 8081 );  //8181 port is set here
    SpringApplication.run(MonolithApplication.class, args);
  }
}
