package org.example.model.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LangController {

    private LangList langList;

    public void setLangList(LangList langList) {
        this.langList = langList;
        runObserver();
    }


    private ArrayList<LangObserver> listObserver;

    public void addObserver(LangObserver Observer){
        listObserver.add(Observer);
        Observer.apply(langList);
    }

    public void runObserver(){
        listObserver.forEach(langObserver -> langObserver.apply(langList));
    }
}

