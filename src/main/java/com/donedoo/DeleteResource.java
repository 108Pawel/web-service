package com.donedoo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.donedoo.model.Change;
import com.donedoo.model.ExistsCheck;
import com.donedoo.model.Task;
import com.donedoo.model.User;
import com.donedoo.repository.RepositoryInterface;
import com.donedoo.repository.RepositoryStub;

@Path("delete")
public class DeleteResource {

	private RepositoryInterface repository = new RepositoryStub();

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		System.out.println("Deleting  " + id);

		repository.delete(id);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("user/{groupname}/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("username") String userName, @PathParam("groupname") String groupname) {
		System.out.println("Deleting  " + userName);

		repository.deleteUser(userName, groupname);
		return Response.ok().build();
	}

}
