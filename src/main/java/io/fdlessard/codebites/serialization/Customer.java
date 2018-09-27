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
    @JsonDeserialize(using = WrapperDeserializer.class)
    private String id;
    @JsonSerialize(using = WrapperSerializer.class)
    @JsonDeserialize(using = WrapperDeserializer.class)
    private int intId;
    @JsonSerialize(using = WrapperSerializer.class)
    @JsonDeserialize(using = WrapperDeserializer.class)
    private Integer integerId;

    @JsonSerialize(using = PropertyValueToSingletonListSerializer.class)
    @JsonDeserialize(using = SingletonListToPropertyDeserializer.class)
    private String codeString;

    @JsonSerialize(using = PropertyValueToSingletonListSerializer.class)
    @JsonDeserialize(using = SingletonListToPropertyDeserializer.class)
    private Integer codeInteger;

    @JsonSerialize(using = PropertyObjectToSingletonListSerializer.class)
    @JsonDeserialize(using = SingletonListToObjectDeserializer.class)
    private Names names;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class Names {
        private String firstNames;
        private String lastName;
    }
}
