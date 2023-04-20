package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.model.Settings;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class AppSettings extends JFrame {

    ObjectMapper om = new ObjectMapper(new YAMLFactory());
    JComboBox<String> stringJComboBox;
    ArrayList<JCheckBox> listC= new ArrayList<>();

    private void setSettings(){

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("setting.yaml").getFile());
        try {
            Settings settings = om.readValue(file, Settings.class);
            AtomicInteger ile = new AtomicInteger();
            stringJComboBox.setSelectedItem(settings.getJezyk());
            listC.forEach(e->{
                try {
                    e.setSelected(settings.getListCheckBox().get( ile.getAndIncrement()));
                }catch (IndexOutOfBoundsException error){
                    e.setSelected(false);
                }
            });


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }

   private static int width = 500;
    public AppSettings() throws HeadlessException {
        super("ustawienia");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLayout(new FlowLayout());



        JPanel saveBox = new JPanel();
        saveBox.setLayout(new GridLayout(0,1));

        JLabel jLabelSave = new JLabel("Dostepne ustawienia");
        saveBox.add(jLabelSave);

        JButton jButton = new JButton("odrzuc");
        jButton.addActionListener((e)-> {

            setSettings();

        });
        saveBox.add(jButton);

        JButton jButton1 = new JButton("zachowj");
        jButton1.addActionListener((e)->{

            Settings settings = new Settings();
            settings.setJezyk((String) stringJComboBox.getSelectedItem());
            listC.forEach( (element)->{

                settings.add(element.isSelected());

            });

            try {
                om.writeValue(new File("src/main/resources/setting.yaml"), settings);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        saveBox.add(jButton1);

        saveBox.setPreferredSize(new Dimension(width - 20,200));
        this.add(saveBox);


        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,1));

        listC.add( new JCheckBox("uruchom wysrodkwane"));
        jPanel.add(listC.get(listC.size()-1));

        listC.add( new JCheckBox("uruchom zmaksymalizowane"));
        jPanel.add(listC.get(listC.size()-1));

        listC.add( new JCheckBox("zapamietaj pozycje"));
        jPanel.add(listC.get(listC.size()-1));

        listC.add( new JCheckBox("zapamietaj pozycje"));
        jPanel.add(listC.get(listC.size()-1));

        jPanel.setPreferredSize(new Dimension(width -20,200));
        jPanel.setBorder(BorderFactory.createTitledBorder("okno"));
        this.add(jPanel);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(0,1));

        JLabel jLabel = new JLabel("jezyk interfejsu");
        jPanel2.add(jLabel);

        stringJComboBox = new JComboBox<>(new String[]{"polski","angielski"});
        jPanel2.add(stringJComboBox);

        listC.add(new JCheckBox("zapamientaj katalog przeglądania") );
        jPanel2.add(listC.get(listC.size()-1));

        listC.add(new JCheckBox("zapamientaj otwarte pliki") );
        jPanel2.add(listC.get(listC.size()-1));


        jPanel2.setPreferredSize(new Dimension(width -20,200));
        jPanel2.setBorder(BorderFactory.createTitledBorder("IDE"));
        this.add(jPanel2);

        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayout(0,1));

        listC.add(new JCheckBox("ukryj menu głowne") );
        jPanel3.add(listC.get(listC.size()-1));

        listC.add(new JCheckBox("odpiety pasek narzedziowy") );
        jPanel3.add(listC.get(listC.size()-1));

        listC.add(new JCheckBox("zablokuj pasek narzedziowy") );
        jPanel3.add(listC.get(listC.size()-1));

        listC.add(new JCheckBox("tryb ciemny") );
        jPanel3.add(listC.get(listC.size()-1));

        jPanel3.setPreferredSize(new Dimension(width -20,200));
        jPanel3.setBorder(BorderFactory.createTitledBorder("IDE"));
        this.add(jPanel3);

        setSettings();

        this.setSize(new Dimension(width,850));
        this.setVisible(true);
    }
}
