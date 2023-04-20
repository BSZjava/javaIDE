package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppConfig {

    private ArrayList<ConfigItems> items;

    public void open(){
        JFrame fr = new JFrame("Config");
        fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        fr.setLayout(new GridLayout(0,1));


        items.forEach(e->{
            fr.add(e.JPrint());
        });


        fr.pack();
        fr.setVisible(true);
    }

}
