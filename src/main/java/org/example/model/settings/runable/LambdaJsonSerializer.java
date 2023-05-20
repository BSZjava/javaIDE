package org.example.model.settings.runable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Deprecated
public class LambdaJsonSerializer extends JsonSerializer<SerializableRunnable> {

    @Override
    public void serialize(SerializableRunnable value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            outputStream.writeObject(value);
            gen.writeBinary(byteArrayOutputStream.toByteArray());
        }
    }
}
