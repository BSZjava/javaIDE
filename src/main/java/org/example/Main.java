package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.model.Settings;
import org.example.model.settings.AppConfig;
import org.example.model.settings.CheckBoxModel;
import org.example.model.settings.ComboBoxModel;
import org.example.model.settings.PanelConfigModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
       new MyFrame();



    }
}