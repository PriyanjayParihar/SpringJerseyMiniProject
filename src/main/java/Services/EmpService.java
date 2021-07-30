package Services;

import Dao.DataStore;
import POJO.Employee;
import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.HashMap;

@Path("/EmpService")
public class EmpService  {
    HashMap<String, Employee> empMap=new HashMap<>();

    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "hello";
    }
    @Path("addEmp")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addEmp(Employee emp) {
        System.out.println("in add emp");
        System.out.println(emp);
        if (DataStore.addEmp(emp)==null)
            return "Employee Added "+emp;
        return "Emp for this id is already present";
    }

    @Path("getEmp/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Object getEmp(@PathParam("id") String id) {
        System.out.println(id);
        if(DataStore.getEmp(id)==null){
            return "No Emp for id "+id+" is present";
        }
        return DataStore.getEmp(id);
    }


    @DELETE
    @Path("delEmp/{id}")

    public String delEmp(@PathParam("id") String id){
        Employee e=DataStore.delEmp(id);
        if(e==null){
            return "No Emp for Id "+id+" is Present";

        }
        return "Data Deleted for Emp "+e;
    }
    @Path("getAllEmp")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object getAllEmp(){
        if(DataStore.getAllEmp().isEmpty())
            return  "no Emp is registered till now";
        return DataStore.getAllEmp();
    }

    @Path("updateEmp")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object updateEmp(Employee emp){

        System.out.println("in add emp");
        System.out.println(emp);
        if (DataStore.updateEmp(emp)==null)
            return "Employee Updated "+emp;
        return "Emp for this id is already present ";
    }

}
