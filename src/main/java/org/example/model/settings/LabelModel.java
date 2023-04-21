package org.example.model.settings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
        return new JLabel(text);
    }
}
