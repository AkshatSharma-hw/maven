package com.zensar.webService.user;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserProfileService {
	@POST
	@Path("/add")
	@Produces("text/html")
	
	public Response addUser(@FormParam("cname")String name, @FormParam("gender")String gender, @FormParam("age")int age) {
		return Response.status(200).entity("User record added. "+name).build();
		
	}
}
