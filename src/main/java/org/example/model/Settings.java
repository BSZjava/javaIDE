package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Settings {

    private ArrayList<Boolean> listCheckBox = new ArrayList<>();

    public void add(Boolean b){

        listCheckBox.add(b);

    }
    private String jezyk;

}
