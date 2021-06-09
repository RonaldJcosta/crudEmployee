package br.com.ronald.api;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.util.BeanUtil;

import br.com.ronald.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/employee")
@Api(description = "the employee API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-06-07T13:47:40.434991-03:00[America/Sao_Paulo]")
public class EmployeeApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Create employee", notes = "", response = Employee.class, tags={ "create" })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Crerated employee", response = Employee.class)
    })
    public Response addUser(@Valid @NotNull Employee user) {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
    			.build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

    	 SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
    	session .beginTransaction();
    	int employee_id = (int) session.save(user);
    	session.getTransaction().commit();
    	factory.close();
		session.close();
    	
		return Response.ok().entity(employee_id).build();

    }

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    @ApiOperation(value = "returns an employee", notes = "", response = Employee.class, tags={ "consult" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Employee.class)
    })
    
    public Response getEmployee(@PathParam("id") @ApiParam("update") Integer id) {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("from Employee where employee_id = :id");
		query.setParameter("id", id);
		Employee employee = query.getSingleResult();
		factory.close();
		session.close();
		return Response.ok().entity(employee).build();
    }

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "returns all the employees", notes = "", response = Employee.class, responseContainer = "List", tags={ "consult" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "response OK", response = Employee.class, responseContainer = "List")
    })
    public Response getEmployees() {
    	List<Employee> list;
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
    			.build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

    	 SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();

			Query<Employee> query = session.createQuery("from Employee");
			list = query.list();
			factory.close();
			session.close();
			return Response.ok().entity(list).build();




    }

    @SuppressWarnings("unchecked")
	@DELETE
    @Path("/{id}")
    @ApiOperation(value = "Remove the employee", notes = "", response = Void.class, tags={ "remove" })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "removed employee", response = Void.class)
    })
    public Response removeEmployee( @PathParam("id") Integer id) {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	 SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
    	@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("from Employee where employee_id = :id");
		query.setParameter("id", id);
		Employee employee = query.getSingleResult();
		session.beginTransaction();
		session.delete(employee);
		session.getTransaction().commit();
		factory.close();
		session.close();

        return Response.status(204).entity("Deletado com sucesso").build();
    }

    @PUT
    @Path("/{id}")
    @Produces({ "application/json" })
    @ApiOperation(value = "Update employee", notes = "", response = Employee.class, tags={ "update" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "employee alterado.", response = Employee.class)
    })
    public Response updateEmployee(@Valid Employee employee, @PathParam("id") @ApiParam("update") Integer id) {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	Session session = factory.openSession();
    	
    	Employee newEmployee = (Employee) session.load(Employee.class, id);

		try {
			BeanUtils.copyProperties(newEmployee, employee);
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}

		session.beginTransaction();

		session.update(newEmployee);
		session.getTransaction().commit();
    	factory.close();
		session.close();
    	
    	return Response.ok().entity(newEmployee).build();
    }
}
