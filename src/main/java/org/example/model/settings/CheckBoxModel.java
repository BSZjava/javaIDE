package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.swing.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckBoxModel implements ConfigItems{

    private String text;
    private Boolean selected;

    @Override
    public JComponent JPrint() {
        JCheckBox jCheckBox = new JCheckBox(text);
        jCheckBox.setSelected(selected);
        return jCheckBox;
    }
}
