package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public abstract class WrapperDeserializer<T> extends JsonDeserializer<T> {

    private  Class<T> typeParameterClass;

    public WrapperDeserializer(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        T s = oc.treeToValue(node.get("value"), typeParameterClass);
        return s;
    }

}