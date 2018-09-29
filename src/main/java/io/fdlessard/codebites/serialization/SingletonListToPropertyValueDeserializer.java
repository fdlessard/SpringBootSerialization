package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import java.io.IOException;

public class SingletonListToPropertyValueDeserializer<T> extends JsonDeserializer<T> implements ContextualDeserializer {

    private Class<T> typeParameterClass;

    @Override
    public JsonDeserializer<T> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        typeParameterClass = (Class<T>) beanProperty.getType().getRawClass();
        return this;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);

        return objectCodec.treeToValue(node.get(0).get("value"), typeParameterClass);
    }

}
