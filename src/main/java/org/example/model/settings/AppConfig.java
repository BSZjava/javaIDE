package org.example.model.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppConfig {

    public static AppConfig factory(String nameFile) throws Exception {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(nameFile).getFile());
            AppConfig config = om.readValue(file, AppConfig.class);
            return config;
    }
    private String out;
    private ArrayList<ConfigItems> items;

    public <T> Optional<T> find(Predicate<? super T> predicate, Class<T> valueType){

        return items.stream().filter(e-> e.getClass()==valueType).map(e->(T)e).filter(predicate).findFirst();

    }

    public void open(){
        JFrame fr = new JFrame("Config");
        fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        fr.setLayout(new GridLayout(0,1));

        JButton save = new JButton("save2file");
        save.addActionListener(e->{

            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            try {
                om.writeValue(new File("src/main/resources/"+out), this);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        fr.add(save);

        items.forEach(e->{
            fr.add(e.JPrint());
        });


        fr.pack();
        fr.setVisible(true);
    }

}
