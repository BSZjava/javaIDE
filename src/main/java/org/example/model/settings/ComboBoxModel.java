package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComboBoxModel implements ConfigItems{

    private ArrayList<String> options;
    private String selected;


    @Override
    public JComponent JPrint() {

        JComboBox<String> jComboBox=new JComboBox<>(new Vector<String>(options));
        jComboBox.setSelectedItem(selected);
        jComboBox.addItemListener(e->{
            if (e.getStateChange() == 1){
                selected = (String) e.getItem();
            }
        });

        return jComboBox;
    }
}
