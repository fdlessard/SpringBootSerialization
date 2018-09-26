package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @JsonSerialize(using = WrapperSerializer.class)
    @JsonDeserialize(using = WrapperDeserializer2.class)
    private String id;
    @JsonSerialize(using = WrapperSerializer.class)
    @JsonDeserialize(using = WrapperDeserializer2.class)
    private int intId;
    @JsonSerialize(using = WrapperSerializer.class)
    @JsonDeserialize(using = WrapperDeserializer2.class)
    private Integer integerId;

    @JsonSerialize(using = PropertyToSingletonListSerializer.class)
    private String codeString;
    @JsonSerialize(using = PropertyToSingletonListSerializer.class)
    private Integer codeInteger;

    @JsonSerialize(using = ObjectToSingletonListSerializer.class)
    private Names names;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class Names {
        private String firstNames;
        private String lastName;
    }
}

