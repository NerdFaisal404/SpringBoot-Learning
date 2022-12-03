package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public List<String> bismillah(){
		return List.of("Bismillah","Allahu");
	}

	@GetMapping("/thanks")
	public List<String> thanksShimulBhai(){
		return List.of("Jajak Allah","Shimul Bhai");
	}

	@GetMapping("/greet")
	public GreetResponse greeting(){
		return new GreetResponse("Hello");
	}


	class GreetResponse{
		private final String greet;

		public GreetResponse(String greet) {
			this.greet = greet;
		}

		public String getGreet() {
			return greet;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			GreetResponse that = (GreetResponse) o;
			return greet.equals(that.greet);
		}

		@Override
		public int hashCode() {
			return Objects.hash(greet);
		}
	}

}
