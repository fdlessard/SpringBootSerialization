package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;

public class WrapperSerializer<T> extends JsonSerializer<T> {

    @Override
    public void serialize(
            T value,
            JsonGenerator gen,
            SerializerProvider provider
    ) throws IOException {
        gen.writeObject(new Wrapper<T> (value));
    }

    @Data
    @AllArgsConstructor
    private class Wrapper<T> {
        private T value;
    }
}