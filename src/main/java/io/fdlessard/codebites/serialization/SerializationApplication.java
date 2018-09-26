package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import java.io.File;

@SpringBootApplication
public class SerializationApplication {


    public static void main(String[] args) throws Exception{
        SpringApplication.run(SerializationApplication.class, args);

       Customer customer = new Customer("TotoId", "TotoCode", 4, Integer.hashCode(10));
       // Customer customer = new Customer("TotoId", "TotoCode");


        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(customer);

        System.out.println(s);

        String ss = "{\n" +
                "  \"id\": {\n" +
                "    \"value\": \"TotoId\"\n" +
                "  },\n" +
                "  \"code\": \"TotoCode\",\n" +
                "  \"intId\": {\n" +
                "    \"value\": 4\n" +
                "  },\n" +
                "  \"integerId\": {\n" +
                "    \"value\": 10\n" +
                "  }\n" +
                "}";

        System.out.println(ss);


        Customer customer2 = objectMapper.readValue(ss, Customer.class);
        System.out.println(customer2);


    }
}
