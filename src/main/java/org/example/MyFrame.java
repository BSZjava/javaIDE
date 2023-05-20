package org.example;

import org.example.model.MainController;
import org.example.model.lang.LangControllerSingleton;
import org.example.model.lang.LangList;
import org.example.model.settings.ConfigControllerSingleton;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;


//W górnym panelu (Taskbar) należy ułożyć 2-wa panele jeden POD drugim
//        W tych panelach elementy mają układać się jeden ZA drugim (drugi panel ma mieć zawijanie)
//        Na prawo od obszaru edytora Textarea należy umieścić Panel boczny rozpoczynający się POD panelem Taskbar aż do dolnej krawędzi
//        Pod listą oraz pod Textarea należy umieścić panel z zakładkami (Terminal, Komunikaty, Brudnopis), który kończy się pod Textarea i zostawia miejsce na Panel boczny
//        Układy do zastosowania: Border Layout, Flow Layout, Grid Layout, Card Layout (tabbed)


public class MyFrame extends JFrame {




//    public static AppConfig config = readConfig();
//
//    public static LangController lang = readLang();


    JMenuBar menuBar;
    JMenu plik;
    JMenuItem ot,zap,settings;
    JPanel top,left;

    Center center;

    JList<String> jList;
    DefaultListModel<String> defaultListModel;

    JScrollPane sp;
    public MyFrame() throws HeadlessException {

        super("sIDE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        plik = new JMenu();
        LangControllerSingleton.getInstance().addObserver(
                l->{
                    plik.setText(l.find("File"));
                });

        ot = new JMenuItem();

        ot.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();

            int res = fileChooser.showOpenDialog(null);

            if(res == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.println(file);
                defaultListModel.addElement(file.getPath());
            }

        });
        zap = new JMenuItem();
        zap.addActionListener(e -> {

            try {
                LangControllerSingleton.getInstance().setLangList(LangList.factory("lang/pl.yaml"));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });


        settings = new JMenuItem();
        LangControllerSingleton.getInstance().addObserver(l->{
            settings.setText(l.find("setting"));
            zap.setText(l.find("zapisz"));
            ot.setText(l.find("otworz"));
        });
        settings.addActionListener(e -> {

         ConfigControllerSingleton.getInstance().getAppConfig().open();

        });

        plik.add(ot);
        plik.add(zap);
        plik.add(settings);

        menuBar.add(plik);
        this.setJMenuBar(menuBar);




// top
        top = new JPanel();
        top.setLayout(new FlowLayout());

        top.setPreferredSize(new Dimension(100,30));
        top.setBackground(Color.GRAY);

        this.add(top,BorderLayout.NORTH);
// /top

        // left
        left = new JPanel();
        left.setPreferredSize(new Dimension(100,100));
        left.setBackground(Color.GRAY);
        left.setLayout(new FlowLayout());


        defaultListModel = new DefaultListModel<>();


        jList = new JList<>(defaultListModel);

        jList.addListSelectionListener(e -> {

            if (e.getValueIsAdjusting()) {
                try {
                    center.add(jList.getSelectedValue());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });


        sp = new JScrollPane(
                jList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        sp.setPreferredSize(new Dimension(90,300));

        left.add(sp);

        this.add(left,BorderLayout.WEST);
        // /left


        center = new Center();
        this.add(center,BorderLayout.CENTER);
        // /center


        this.setSize(new Dimension(400,550));
        this.setVisible(true);
    }
}
