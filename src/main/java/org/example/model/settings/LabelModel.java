package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.model.MainController;
import org.example.model.lang.LangControllerSingleton;
import org.w3c.dom.Text;

import javax.swing.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LabelModel implements ConfigItems{

    private String text;
    @Override
    public JComponent JPrint() {
        JLabel jLabel = new JLabel();
        LangControllerSingleton.getInstance().addObserver(l->{

            jLabel.setText(l.find(text));

        });
        return jLabel;
    }
}
