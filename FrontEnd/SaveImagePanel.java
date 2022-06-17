package FrontEnd;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.io.FileNotFoundException;
import BackEnd.CSVWriterGeom;
import BackEnd.GeomObject;
import BackEnd.WriterGeom;
import BackEnd.XMLWriterGeom;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

/*
The Save Image Panel class is used to decorate panel that can save the drawing to the file.
*/

public class SaveImagePanel extends SistakaPanel implements ActionListener {
    private JTextField jtfFileName = new JTextField();
    private JRadioButton jrbXML = new JRadioButton("XML");
    private JRadioButton jrbCSV = new JRadioButton("CSV");
    private JButton jbtSave = new JButton("Save");
    private JButton jbtBack = new JButton("Back");
    ArrayList<GeomObject> geomObjects;

    public SaveImagePanel(HomeGUI homeGUI, ArrayList<GeomObject> geomObjects) {
        super(homeGUI);
        this.geomObjects = geomObjects;
        setLayout(null);

        // set background picture
        ImageIcon saveImagePanelImg = new ImageIcon("Assets/bg-save-file.png");
        JPanel iconSaveImagePanel = new JPanel();
        JLabel imgSaveImagePanel = new JLabel();
        imgSaveImagePanel.setIcon(saveImagePanelImg);
        iconSaveImagePanel.add(imgSaveImagePanel);
        iconSaveImagePanel.setBounds(0, 0, 950, 630);
        saveImagePanelImg.setImage(saveImagePanelImg.getImage().getScaledInstance(950, 600, Image.SCALE_DEFAULT));

        // decorate component
        jtfFileName.setBounds(82, 280, 300, 50);
        jrbXML.setBounds(82, 350, 100, 50);
        jrbXML.setSelected(true);
        jrbCSV.setBounds(192, 350, 100, 50);
        jbtSave.setBounds(82, 430, 210, 50);
        jbtBack.setBounds(297, 430, 210, 50);

        // add component to panel
        add(jtfFileName);
        add(jrbXML);
        add(jrbCSV);
        add(jbtSave);
        add(jbtBack);
        add(iconSaveImagePanel);

        // add listener to component
        jrbCSV.addActionListener(this);
        jrbXML.addActionListener(this);
        jbtSave.addActionListener(this);
        jbtBack.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // update selected radio button type of File
        if (e.getSource() == jrbXML) {
            jrbCSV.setSelected(false);
        } else if (e.getSource() == jrbCSV) {
            jrbXML.setSelected(false);
        }

        if (e.getSource() == jbtSave) {
            // save drawing to the file
            try {
                String fileName = jtfFileName.getText();
                if (jrbXML.isSelected()) {
                    WriterGeom writer = new XMLWriterGeom(fileName, geomObjects);
                    writer.write();
                } else if (jrbCSV.isSelected()) {
                    WriterGeom writer = new CSVWriterGeom(fileName, geomObjects);
                    writer.write();
                }
                JOptionPane.showMessageDialog(null, String.format(
                        "Karyamu sudah berhasil disimpan ke dalam file " + fileName
                                + " ! Silahkan lihat folder DrawIO ! :)"),
                        "Info", JOptionPane.INFORMATION_MESSAGE);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        } else if (e.getSource() == jbtBack) {
            main.setPanel("drawIOPanel");
        }
    }
}
