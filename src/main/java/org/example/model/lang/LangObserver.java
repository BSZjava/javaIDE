package org.example.model.lang;

import java.util.function.Function;

@FunctionalInterface
public interface LangObserver {
    void apply(LangList t);

}
