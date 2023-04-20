package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.model.Settings;
import org.example.model.settings.AppConfig;
import org.example.model.settings.CheckBoxModel;
import org.example.model.settings.ComboBoxModel;
import org.example.model.settings.PanelConfigModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
//       new MyFrame();
        AppConfig appConfig = new AppConfig();
        appConfig.setItems(new ArrayList<>(List.of(
                new CheckBoxModel("mgshgsjhhjzn",true)
                ,
                new ComboBoxModel(new ArrayList<>(List.of("t","g")),"t")
                ,
                new PanelConfigModel("tak",
                        new ArrayList<>(List.of(
                        new CheckBoxModel("todhshasn",true)
                        ,
                        new ComboBoxModel(new ArrayList<>(List.of("t","g")),"t")

                )))
                )));
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        try {
            om.writeValue(new File("src/main/resources/test.yaml"), appConfig);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
//        appConfig.open();



        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("test.yaml").getFile());

        try {
            AppConfig settings = om.readValue(file, AppConfig.class);
            settings.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}