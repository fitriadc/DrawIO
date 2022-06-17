/*
 Mini Project DDP 2 Tahun Ajaran 2021/2022
 ________________________

 Name : Fitria Dwi Cahya (2106751410)
 Colaborators : 
    - Devina Hana Azhara (2106751032)
    - Syifa Afra Kamila Mumtaz (2106707151)
________________________

 Program Name : DrawIO
 Program Description : 
    Draw IO is GUI application for digital drawing where the results
    of drawing can be saved in XML or CSV type files.
 */

import javax.swing.*;

import FrontEnd.HomeGUI;

public class DrawIO {
    public static void main(String[] args) {
        // Make main frame
        JFrame frame = new JFrame("Draw IO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(900, 650);
        new HomeGUI(frame);
        frame.setVisible(true);
    }
}
