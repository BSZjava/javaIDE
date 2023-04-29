package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.model.MainController;

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
        JCheckBox jCheckBox = new JCheckBox();

        MainController.langController.addObserver(l->{

            jCheckBox.setText(l.find(text));

        });

        jCheckBox.setSelected(selected);
        jCheckBox.addItemListener(e -> {
            selected = !selected;
            MainController.controllerObserver.apply();
        });
        return jCheckBox;
    }
}
