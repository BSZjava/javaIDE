package org.example.model.settings.runable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@Deprecated
@JsonSerialize(using = LambdaJsonSerializer.class)
@JsonDeserialize(using = LambdaJsonDeserializer.class)
public interface SerializableRunnable extends Runnable, Serializable {
}
