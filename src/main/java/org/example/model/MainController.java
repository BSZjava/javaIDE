package org.example.model;

import org.example.model.lang.LangControllerSingleton;
import org.example.model.lang.LangList;
import org.example.model.settings.*;

import java.util.ArrayList;

@Deprecated
public class MainController {

//    private static AppConfig readConfig(){
//        try {
//            return AppConfig.factory("configTmp.yaml");
//        } catch (Exception ee) {
//            try {
//                return AppConfig.factory("config.yaml");
//            } catch (Exception eee) {
//                throw new RuntimeException(eee);
//            }
//        }
//    }
//
//    private static LangList readLang(String lang){
//
//        try {
//            return LangList.factory("lang/"+lang+".yaml");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    public ConfigController configController = new ConfigController(readConfig(),new ArrayList<>());
//
//    public LangController langController = new LangController(readLang("en"),new ArrayList<>());
//
//    public ControllerObserver controllerObserver = () ->{
//        configController.runObserver();
//    };
//
////    private static Predicate<Integer> staticConstructor = (code)->{
////
////        configController.addObserver(a->{
////
////            String selected = a.find(e -> e.getPanel().equals("IDE"), PanelConfigModel.class).get().find(e -> e.getText().equals("interface language"), ComboBoxModel.class).get().getSelected();
////            langController.setLangList(readLang(selected));
////
////        });
////
////        return true;
////    };
////    public static boolean status = staticConstructor.test(1);
//    private static MainController instance;
//
//    private MainController() {
//
//        configController.addObserver(a->{
//
//            String selected = a.find(e -> e.getPanel().equals("IDE"), PanelConfigModel.class).get().find(e -> e.getText().equals("interface language"), ComboBoxModel.class).get().getSelected();
//            langController.setLangList(readLang(selected));
//
//        });
//
//    }
//
//    public static MainController getInstance() {
//        if (instance == null) {
//            instance = new MainController();
//        }
//        return instance;
//    }
}
