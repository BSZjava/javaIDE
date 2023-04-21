package org.example.model.settings;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.swing.JComponent;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ComboBoxModel.class, name = "ComboBox"),
        @JsonSubTypes.Type(value = CheckBoxModel.class, name = "CheckBox"),
        @JsonSubTypes.Type(value = PanelConfigModel.class, name = "PanelConfig"),
        @JsonSubTypes.Type(value = LabelModel.class, name = "Label")
}
)
public interface ConfigItems {

    public JComponent JPrint();

}
