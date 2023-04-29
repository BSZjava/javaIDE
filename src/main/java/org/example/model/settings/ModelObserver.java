package org.example.model.settings;

import org.example.model.lang.LangList;

@FunctionalInterface
public interface ModelObserver {

    void apply(AppConfig c);

}
