package com.helman.Webservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.helman.Entity.Employee;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
/*
  @project order
  @Author Mahdieh Parhizkari
  @Date 3/4/21
  @Time 3:47 AM
  Created by Intellije IDEA
  Description: JPA - Criteria
*/

public class EmployeeWsTest {
    final String restServicePath = "http://localhost:8080/order/rest/employee";

    @Test
    public void findall() {
        try {
            Client client = ClientBuilder.newClient();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
            client.register(feature);

            WebTarget webTarget = client.target(restServicePath).path("all");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            System.out.println(response.getStatus());
            if (response.getStatus() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                List<Employee> list = mapper.readValue(response.readEntity(String.class), new TypeReference<List<Employee>>() {
                });
                System.out.println(list);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void findById() {
        try {
            Client client = ClientBuilder.newClient();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
            client.register(feature);

            WebTarget webTarget = client.target(restServicePath).path("find").path("1001");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            System.out.println(response.getStatus());
            if (response.getStatus() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                Employee obj = mapper.readValue(response.readEntity(String.class), new TypeReference<Employee>() {
                });
                System.out.println(obj);
            }
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        try {
            Client client = ClientBuilder.newClient();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
            client.register(feature);

            WebTarget webTarget = client.target(restServicePath).path("insert");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Employee emp = new Employee();
            emp.setEmployeeNumber(Long.valueOf(1000));
            emp.setLastName("Parhizkari");
            emp.setFirstName("Helman");
            emp.setExtension("x5800");
            emp.setEmail("helman@gmail.com");
            emp.setOfficeCode("1");
            emp.setReportsTo(Long.valueOf(1002));
            emp.setJobTitle("IT");
            FilterProvider filters = new SimpleFilterProvider().addFilter("Employeefilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept("employeeNumber", "lastName", "firstName", "extension", "email", "officeCode", "reportsTo", "jobTitle"));
            String employeeJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(emp);
            Response response = invocationBuilder.post(Entity.json(employeeJson));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        try {
            Client client = ClientBuilder.newClient();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
            client.register(feature);

            WebTarget webTarget = client.target(restServicePath).path("insert");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Employee emp = new Employee();
            emp.setEmployeeNumber(Long.valueOf(1000));
            emp.setLastName("Parhi");
            emp.setFirstName("Hely");
            emp.setExtension("x5800");
            emp.setEmail("hely@gmail.com");
            emp.setOfficeCode("1");
            emp.setReportsTo(Long.valueOf(1002));
            emp.setJobTitle("ITman");
            FilterProvider filters = new SimpleFilterProvider().addFilter("Employeefilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept("employeeNumber", "lastName", "firstName", "extension", "email", "officeCode", "reportsTo", "jobTitle"));
            String employeeJson = (new ObjectMapper()).writer(filters).withDefaultPrettyPrinter().writeValueAsString(emp);
            Response response = invocationBuilder.put(Entity.json(employeeJson));
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        try {
            Client client = ClientBuilder.newClient();
            HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "123");
            client.register(feature);

            WebTarget webTarget = client.target(restServicePath).path("delete").path("1004");
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.delete();
            System.out.println(response.getStatus());
            System.out.println(response.readEntity(String.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}