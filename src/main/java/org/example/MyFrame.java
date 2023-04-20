package org.example;

import org.example.model.Settings;

import javax.swing.*;
import java.awt.*;
import java.io.File;


//W górnym panelu (Taskbar) należy ułożyć 2-wa panele jeden POD drugim
//        W tych panelach elementy mają układać się jeden ZA drugim (drugi panel ma mieć zawijanie)
//        Na prawo od obszaru edytora Textarea należy umieścić Panel boczny rozpoczynający się POD panelem Taskbar aż do dolnej krawędzi
//        Pod listą oraz pod Textarea należy umieścić panel z zakładkami (Terminal, Komunikaty, Brudnopis), który kończy się pod Textarea i zostawia miejsce na Panel boczny
//        Układy do zastosowania: Border Layout, Flow Layout, Grid Layout, Card Layout (tabbed)
public class MyFrame extends JFrame {


    JMenuBar menuBar;
    JMenu plik;
    JMenuItem ot,zap,settings;
    JPanel top,left;

    JTabbedPane center;

    JList<String> jList;
    DefaultListModel<String> defaultListModel;

    JScrollPane sp;
    public MyFrame() throws HeadlessException {

        super("sIDE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        plik = new JMenu("plik");
        ot = new JMenuItem("otworz");
        ot.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();

            int res = fileChooser.showOpenDialog(null);

            if(res == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.println(file);
                defaultListModel.addElement(file.getPath());
            }

        });
        zap = new JMenuItem("zapisz");


        settings = new JMenuItem("setiings");
        settings.addActionListener(e -> {

            new AppSettings();

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



           center.add( jList.getSelectedValue(),new JTextArea());

            System.out.println("t");
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


        center = new JTabbedPane();
        this.add(center,BorderLayout.CENTER);
        // /center


        this.setSize(new Dimension(400,550));
        this.setVisible(true);
    }
}
