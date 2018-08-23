package com.linnelservices.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.linnelservices.restws.entity.Passenger;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml, application/x-www-form-urlencoded")
public interface PassengerService {

	@Path("/passengers")
	@GET
	public abstract List<Passenger> getPassenger(@QueryParam("start") int start, @QueryParam("size") int size);
//	
//	@Path("/passengers")
//	@POST
//	public abstract Passenger addPassenger(Passenger passenger);
	
	@Path("/passengers")
	@POST
	public abstract void addPassenger(@FormParam("firstName") String firstName, @FormParam("lastName")  String lastName, 
										@HeaderParam("agent") String agent, @Context HttpHeaders headers);
}
