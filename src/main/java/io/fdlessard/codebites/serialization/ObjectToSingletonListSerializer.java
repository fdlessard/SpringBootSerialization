package io.fdlessard.codebites.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Collections;

public class ObjectToSingletonListSerializer<T> extends JsonSerializer<T> {

    @Override
    public void serialize(
            T value,
            JsonGenerator gen,
            SerializerProvider provider
    ) throws IOException {
        gen.writeObject(Collections.singleton(value));
    }
}
