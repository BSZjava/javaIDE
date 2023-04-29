package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.model.MainController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PanelConfigModel implements ConfigItems {

    private String panel;
    private ArrayList<ConfigItems> items;

    public <T> Optional<T> find(Predicate<? super T> predicate, Class<T> valueType){

        return items.stream().filter(e-> e.getClass()==valueType).map(e->(T)e).filter(predicate).findFirst();

    }

    @Override
    public JComponent JPrint() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,1));


        items.forEach(e->{
            jPanel.add(e.JPrint());
        });

        MainController.langController.addObserver(l->{

            jPanel.setBorder(BorderFactory.createTitledBorder(l.find(panel)));

        });
        return jPanel;
    }
}
