package org.example.model.settings.runable;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Deprecated
public class LambdaJsonDeserializer extends JsonDeserializer<SerializableRunnable> {
    @Override
    public SerializableRunnable deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        byte[] value = p.getBinaryValue();
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(value);
             ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (SerializableRunnable) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
}
