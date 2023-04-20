package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.swing.*;
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
        return new JPanel();
    }
}
