package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConfigController {

    private AppConfig appConfig;

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
        runObserver();
    }

    private ArrayList<ModelObserver> listObserver;

    public void addObserver(ModelObserver Observer){
        listObserver.add(Observer);
        Observer.apply(appConfig);
    }

    public void runObserver(){
        listObserver.forEach(appC -> appC.apply(appConfig));
    }


}
