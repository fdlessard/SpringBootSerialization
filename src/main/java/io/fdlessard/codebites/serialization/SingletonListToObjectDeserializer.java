package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import java.io.IOException;

public class SingletonListToObjectDeserializer<T> extends JsonDeserializer<T> implements ContextualDeserializer {

    private Class<T> typeParameterClass;

    @Override
    public JsonDeserializer<T> createContextual(DeserializationContext context, BeanProperty property) {
        typeParameterClass = (Class<T>) property.getType().getRawClass();
        return this;
    }

    @Override
    public T deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {

        ObjectCodec oc = parser.getCodec();
        JsonNode node = parser.getCodec().readTree(parser);

        return oc.treeToValue(node.get(0), typeParameterClass);
    }

}
