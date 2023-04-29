package org.example.model.lang;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.model.settings.AppConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.ListResourceBundle;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LangList{

    public static LangList factory(String nameFile) throws Exception {
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(nameFile).getFile());
        LangList langList = om.readValue(file, LangList.class);
        return langList;
    }

    private ArrayList<LangNode> list;

    public String find(String expression){
        Optional<LangNode> first = list.stream().filter(e-> e.getKey().equals(expression)).findFirst();
        if (first.isEmpty()) return expression;
        return first.get().getValue();
    }

//    ListResourceBundle
    public Object[][] getContents() {
        Object[][] objects = new Object[list.size()][2];

        for (int i = 0; i < list.size(); i++) {

            LangNode langNode = list.get(i);
            objects[i] = new Object[]{langNode.getKey(),langNode.getValue()};

        }

        return  objects;
    }
}
