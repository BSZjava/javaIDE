package org.example.model.settings.runable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
public class RuleMessage {
    private String id;
    private SerializableRunnable sRunnable;

    @JsonCreator
    public RuleMessage(@JsonProperty("id") String id, @JsonProperty("sRunnable") SerializableRunnable sRunnable) {
        this.id = id;
        this.sRunnable = sRunnable;
    }

    public String getId() {
        return id;
    }

    public SerializableRunnable getsRunnable() {
        return sRunnable;
    }
}
