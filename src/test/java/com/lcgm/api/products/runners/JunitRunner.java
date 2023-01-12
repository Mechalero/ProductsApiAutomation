package com.lcgm.api.products.runners;


import org.junit.jupiter.api.BeforeEach;

//import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

@ExtendWith(SerenityJUnit5Extension.class)
public class JunitRunner {
	
	private final String theRestApiBaseUrl = "http://localhost:8080";
	private Actor sam;
	
	@BeforeEach
	public void setUp() {
		 sam = Actor.named("lcgm")
                 .whoCan(CallAnApi.at(theRestApiBaseUrl));
	}
	
	
	@Test
	public void create_a_product() {

		sam.attemptsTo(
		        Post.to("/")
		                .with(request -> request.header("Content-Type", "application/json") 
		                                        .body("{ \"code\":123123, \"name\":\"Prueba\",\"price\":15000, \"description\":\"\", \"stock\":0}") 
		                                        
		                )
		);

		sam.should(
		        seeThatResponse("The user should have been successfully create",
		                        response -> response.statusCode(201))
		        );
	}
	
	
	@Test
	public void list_all_products() {

	    sam.attemptsTo(
	            Get.resource("/")
	    );

//	    sam.should(
//	    		seeThatResponse("all the expected products should be returned",
//	                    response -> response.statusCode(200)
//	                                        .body("$.first_name", hasItems("George", "Janet", "Emma")))
//	    );
	    sam.should(
	    		seeThatResponse("all the expected products should be returned",
	                    response -> response.statusCode(200))
	    );
	}
}