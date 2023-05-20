package org.example;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.model.MainController;
import org.example.model.lang.LangControllerSingleton;
import org.example.model.settings.ComboBoxModel;
import org.example.model.settings.ConfigControllerSingleton;
import org.example.model.settings.PanelConfigModel;
import org.example.model.settings.runable.RuleMessage;
import org.example.model.settings.runable.SerializableRunnable;


import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // config
        ConfigControllerSingleton.getInstance().addObserver(a->{

            String selected = a.find(e -> e.getPanel().equals("IDE"), PanelConfigModel.class).get().find(e -> e.getText().equals("interface language"), ComboBoxModel.class).get().getSelected();
            LangControllerSingleton.getInstance().readLang(selected);

        });


       new MyFrame();

    }


//    public static void main(String[] args) throws IOException {
////        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
////        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
////        SerializableRunnable action = () -> System.out.println("jo");
////        SerializableRunnable action1 = () -> System.out.println("jo1");
////        String json = mapper.writeValueAsString(new RuleMessage("1", action));
////        System.out.println(json);
//
////        RuleMessage ruleMessage = mapper.readValue(json, RuleMessage.class);
////        ruleMessage.getsRunnable().run();
//
//
//
//        MainController.configController.getAppConfig().getMassage().getsRunnable().run();
//    }

    //{
    //  "id" : "1",
    //  "sRunnable" : "rO0ABXNyACFqYXZhLmxhbmcuaW52b2tlLlNlcmlhbGl6ZWRMYW1iZGFvYdCULCk2hQIACkkADmltcGxNZXRob2RLaW5kWwAMY2FwdHVyZWRBcmdzdAATW0xqYXZhL2xhbmcvT2JqZWN0O0wADmNhcHR1cmluZ0NsYXNzdAARTGphdmEvbGFuZy9DbGFzcztMABhmdW5jdGlvbmFsSW50ZXJmYWNlQ2xhc3N0ABJMamF2YS9sYW5nL1N0cmluZztMAB1mdW5jdGlvbmFsSW50ZXJmYWNlTWV0aG9kTmFtZXEAfgADTAAiZnVuY3Rpb25hbEludGVyZmFjZU1ldGhvZFNpZ25hdHVyZXEAfgADTAAJaW1wbENsYXNzcQB+AANMAA5pbXBsTWV0aG9kTmFtZXEAfgADTAATaW1wbE1ldGhvZFNpZ25hdHVyZXEAfgADTAAWaW5zdGFudGlhdGVkTWV0aG9kVHlwZXEAfgADeHAAAAAGdXIAE1tMamF2YS5sYW5nLk9iamVjdDuQzlifEHMpbAIAAHhwAAAAAHZyABBvcmcuZXhhbXBsZS5NYWluAAAAAAAAAAAAAAB4cHQAN29yZy9leGFtcGxlL21vZGVsL3NldHRpbmdzL3J1bmFibGUvU2VyaWFsaXphYmxlUnVubmFibGV0AANydW50AAMoKVZ0ABBvcmcvZXhhbXBsZS9NYWludAAWbGFtYmRhJG1haW4kNWM0YjZhMDgkMXEAfgALcQB+AAs="
    //}

//    ---
//    id: "1"
//    sRunnable: !!binary |-
//    rO0ABXNyACFqYXZhLmxhbmcuaW52b2tlLlNlcmlhbGl6ZWRMYW1iZGFvYdCULCk2hQIACkkADmlt
//    cGxNZXRob2RLaW5kWwAMY2FwdHVyZWRBcmdzdAATW0xqYXZhL2xhbmcvT2JqZWN0O0wADmNhcHR1
//    cmluZ0NsYXNzdAARTGphdmEvbGFuZy9DbGFzcztMABhmdW5jdGlvbmFsSW50ZXJmYWNlQ2xhc3N0
//    ABJMamF2YS9sYW5nL1N0cmluZztMAB1mdW5jdGlvbmFsSW50ZXJmYWNlTWV0aG9kTmFtZXEAfgAD
//    TAAiZnVuY3Rpb25hbEludGVyZmFjZU1ldGhvZFNpZ25hdHVyZXEAfgADTAAJaW1wbENsYXNzcQB+
//    AANMAA5pbXBsTWV0aG9kTmFtZXEAfgADTAATaW1wbE1ldGhvZFNpZ25hdHVyZXEAfgADTAAWaW5z
//    dGFudGlhdGVkTWV0aG9kVHlwZXEAfgADeHAAAAAGdXIAE1tMamF2YS5sYW5nLk9iamVjdDuQzlif
//    EHMpbAIAAHhwAAAAAHZyABBvcmcuZXhhbXBsZS5NYWluAAAAAAAAAAAAAAB4cHQAN29yZy9leGFt
//    cGxlL21vZGVsL3NldHRpbmdzL3J1bmFibGUvU2VyaWFsaXphYmxlUnVubmFibGV0AANydW50AAMo
//    KVZ0ABBvcmcvZXhhbXBsZS9NYWludAAWbGFtYmRhJG1haW4kNWM0YjZhMDgkMXEAfgALcQB+AAs=
}


