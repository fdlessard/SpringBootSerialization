package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.Value;

import java.io.IOException;

public class WrapperSerializer<T> extends JsonSerializer<T> {

    @Override
    public void serialize(
            T value,
            JsonGenerator generator,
            SerializerProvider serializerProvider
    ) throws IOException {
        generator.writeObject(new Wrapper<T>(value));
    }

    @Value
    private class Wrapper<T> {
        private T value;
    }
}