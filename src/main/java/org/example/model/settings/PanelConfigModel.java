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
public class PanelConfigModel implements ConfigItems {

    private String panel;
    private ArrayList<ConfigItems> items;
    @Override
    public JComponent JPrint() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,1));


        items.forEach(e->{
            jPanel.add(e.JPrint());
        });

//        jPanel.setPreferredSize(new Dimension(width -20,200));
        jPanel.setBorder(BorderFactory.createTitledBorder(panel));
        return jPanel;
    }
}
