package br.com.springdata.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springdata.model.Customer;
import br.com.springdata.repository.CustomerRepository;

@Path("/customer")
public class CustomerApi {

	@Autowired
	CustomerRepository customerRepository;
	
	@POST
	@Path("/addOrUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Add(Customer customer) {
		customerRepository.save(customer);
		return Response.ok().entity(customer).build();
	}
	
	@POST
	@Path("/getById")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetById(Customer customer) {
		customer = customerRepository.findById(customer.getId()).get();
		return Response.ok().entity(customer).build();
	}
	
	@POST
	@Path("/delete") 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Delete(Customer customer) {
		customer = customerRepository.findById(customer.getId()).get();
		customerRepository.delete(customer);
		Message message = new Message();
		message.setMensagem("Deleted");
		return Response.ok().entity(message).build(); 
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response List() {
		Iterable<Customer> list = customerRepository.findAll();
		return Response.ok().entity(list).build();
	}
	
}

class Message {
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}