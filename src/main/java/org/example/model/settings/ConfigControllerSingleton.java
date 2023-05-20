package org.example.model.settings;

import lombok.*;
import org.example.model.lang.LangControllerSingleton;

import java.util.ArrayList;


public class ConfigControllerSingleton{
    @Getter
    private AppConfig appConfig;

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
        runObserver();
    }

    private ArrayList<ModelObserver> listObserver = new ArrayList<>();

    public void addObserver(ModelObserver Observer){
        listObserver.add(Observer);
        Observer.apply(appConfig);
    }

    public void runObserver(){
        listObserver.forEach(appC -> appC.apply(appConfig));
    }

    private static ConfigControllerSingleton instance;

    private ConfigControllerSingleton () {
        readConfig();
    }

    public static ConfigControllerSingleton getInstance() {
        if (instance == null) {
            instance = new ConfigControllerSingleton();
        }
        return instance;
    }

    public void readConfig(){
        try {
            appConfig = AppConfig.factory("configTmp.yaml");
        } catch (Exception ee) {
            try {
                appConfig = AppConfig.factory("config.yaml");
            } catch (Exception eee) {
                throw new RuntimeException(eee);
            }
        }
    }


}
