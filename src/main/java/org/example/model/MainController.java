package org.example.model;

import org.example.model.lang.LangController;
import org.example.model.lang.LangList;
import org.example.model.settings.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class MainController {

    private static AppConfig readConfig(){
        try {
            return AppConfig.factory("configTmp.yaml");
        } catch (Exception ee) {
            try {
                return AppConfig.factory("config.yaml");
            } catch (Exception eee) {
                throw new RuntimeException(eee);
            }
        }
    }

    private static LangList readLang(String lang){

        try {
            LangList factory = LangList.factory("lang/"+lang+".yaml");
            return factory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }





    public static ConfigController configController = new ConfigController(readConfig(),new ArrayList<>());

    public static LangController langController = new LangController(readLang("en"),new ArrayList<>());

    public static ControllerObserver controllerObserver = () ->{
        configController.runObserver();
    };

    private static Predicate<Integer> staticConstructor = (code)->{

        configController.addObserver(a->{

            String selected = a.find(e -> e.getPanel().equals("IDE"), PanelConfigModel.class).get().find(e -> e.getText().equals("interface language"), ComboBoxModel.class).get().getSelected();
            langController.setLangList(readLang(selected));

        });



        return true;
    };
    public static boolean status = staticConstructor.test(1);

}
