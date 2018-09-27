package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fdlessard.codebites.serialization.Customer.Names;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SerializationApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SerializationApplication.class, args);

        Customer.Names name = new Names("prenom", "nom de famille");
        Customer customer = new Customer("TotoId", 4, Integer.hashCode(10), "totoCode", Integer.valueOf(10), name);

        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(customer);

        System.out.println(s);

        String ss = "{\n"
                + "  \"id\": {\n"
                + "    \"value\": \"TotoId\"\n"
                + "  },\n"
                + "  \"intId\": {\n"
                + "    \"value\": 4\n"
                + "  },\n"
                + "  \"integerId\": {\n"
                + "    \"value\": 10\n"
                + "  },\n"
                + "  \"codeString\": [\n"
                + "    {\n"
                + "      \"value\": \"totoCode\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"codeInteger\": [\n"
                + "    {\n"
                + "      \"value\": 10\n"
                + "    }\n"
                + "  ],\n"
                + "  \"names\": [\n"
                + "    {\n"
                + "      \"firstNames\": \"prenom\",\n"
                + "      \"lastName\": \"nom de famille\"\n"
                + "    }\n"
                + "  ]\n"
                + "}";

        System.out.println(ss);


        Customer customer2 = objectMapper.readValue(ss, Customer.class);
        System.out.println(customer2);


    }
}
