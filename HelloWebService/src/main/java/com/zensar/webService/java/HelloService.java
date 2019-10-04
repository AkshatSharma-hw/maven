package com.zensar.webService.java;

import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")

public class HelloService {
	private String name;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	
	public String sayPlainHello() {
		
		
		return("Welcome to zensar hello Service");
	}
	
	@GET
	@Path("/{name}")
	public String sayHelloUser(@PathParam("anam") String name) {
		return("Dear "+ name+ " Welcome to hello service.");
	}
	
	@GET
	@Path("res/{res}")
	public Response helloUser(@PathParam("res") String name) {
		Response res = Response.status(200).entity("Dear "+ name+ " Welcome to hello service.").build();
		
		return(res);
	}
	
	
	@GET
	@Path("nam/{dd}/{mm}/{yy}")
	public Response happyBirthday(@PathParam("dd") int date, @PathParam("mm")int month,@PathParam("yy") int year) {
		LocalDate birthdate = LocalDate.of(year, month, date);
		Response res = Response.status(200).entity("Dear "+ name+ " Happy birthday on "+birthdate).build();
		
		return(res);
	}
}
