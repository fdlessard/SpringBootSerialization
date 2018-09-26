package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonDeserialize(using = StringWrapperDeserializer.class)
    private String id;
    private String code;
    @JsonSerialize(using = WrapperSerializer.class)
    @JsonDeserialize(using = IntegerWrapperDeserializer.class)
    private int intId;
    @JsonSerialize(using = WrapperSerializer.class)
    @JsonDeserialize(using = IntegerWrapperDeserializer.class)
    private Integer integerId;
}
