package org.example.model.lang;

import java.util.ArrayList;
public class LangControllerSingleton {

    private LangList langList;

    public void setLangList(LangList langList) {
        this.langList = langList;
        runObserver();
    }

    private ArrayList<LangObserver> listObserver = new ArrayList<>();

    public void addObserver(LangObserver Observer){
        listObserver.add(Observer);
        Observer.apply(langList);
    }

    public void runObserver(){
        listObserver.forEach(langObserver -> langObserver.apply(langList));
    }

    private static LangControllerSingleton instance;

    private LangControllerSingleton() {
        readLang("en");
    }

    public static LangControllerSingleton getInstance() {
        if (instance == null) {
            instance = new LangControllerSingleton();
        }
        return instance;
    }

    public void readLang(String lang){

        try {
             setLangList(LangList.factory("lang/"+lang+".yaml"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void readLangPath(String path){

        try {
            setLangList(LangList.factory(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

