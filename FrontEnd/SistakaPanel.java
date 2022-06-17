package FrontEnd;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

abstract class SistakaPanel extends JPanel {
    protected final HomeGUI main;

    public SistakaPanel(HomeGUI main) {
        this.main = main;
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}
