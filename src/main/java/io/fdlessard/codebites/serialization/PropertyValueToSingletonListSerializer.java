package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.Value;

import java.io.IOException;
import java.util.Collections;

public class PropertyValueToSingletonListSerializer<T> extends JsonSerializer<T> {

    @Override
    public void serialize(
            T value,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeObject(Collections.singleton(new Wrapper<T>(value)));
    }

    @Value
    private class Wrapper<T> {
        private T value;
    }
}
