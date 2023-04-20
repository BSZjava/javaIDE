package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.model.settings.AppConfig;
import org.example.model.settings.CheckBoxModel;
import org.example.model.settings.ComboBoxModel;
import org.example.model.settings.PanelConfigModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//       new MyFrame();
        AppConfig appConfig = new AppConfig();
        appConfig.setItems(new ArrayList<>(List.of(
                new CheckBoxModel("m",true)
                ,
                new ComboBoxModel(new ArrayList<>(List.of("t","g")),"t")
                ,
                new PanelConfigModel("tak",
                        new ArrayList<>(List.of(
                        new CheckBoxModel("m",true)
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
    }
}