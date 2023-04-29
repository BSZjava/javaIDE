package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.model.MainController;
import org.example.model.lang.LangList;
import org.example.model.lang.LangNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       new MyFrame();


        System.out.println(Arrays.deepToString(MainController.langController.getLangList().getContents()));


    }
}