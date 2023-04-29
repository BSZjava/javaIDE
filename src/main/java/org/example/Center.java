package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListResourceBundle;
import java.util.Scanner;
import java.util.stream.Stream;

public class Center extends JTabbedPane {

    public Center() {
        super();


    }


    public Component add(String URL) throws FileNotFoundException {
        ScrollPane scrollPane = new ScrollPane();
        JTextArea component = new JTextArea();

        File file = new File(URL);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext())
        component.append(scanner.nextLine() + "\n");

        scrollPane.add(component);
        super.addTab(URL, scrollPane);
        return component;

    }
}
