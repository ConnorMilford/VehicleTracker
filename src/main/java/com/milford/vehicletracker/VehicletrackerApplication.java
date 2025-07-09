package com.milford.vehicletracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicletrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicletrackerApplication.class, args);
	}

	/* 
	@Bean
	CommandLineRunner commandLineRunner(PlaneService planeService) {
		
		/* return args -> {

			String laMin = "lamin=50.0";
			String laMax = "lamax=54.0";
			String loMin = "lomin=-1.0";
			String loMax = "lomax=3.0";

			PlaneURIHelper pHelper = new PlaneURIHelper();

			List<String> queries = new ArrayList<>();
			queries.add(laMin);
			queries.add(loMin);
			queries.add(laMax);
			queries.add(loMax);
			queries.add("extended=1");

			//String query = pHelper.ConstructPlaneURIQueries(queries);

			//List<PlaneDTO>> planes = planeService.queryPlanes(query);
			//System.out.println(planes);

			
		}; 
		} */
}
