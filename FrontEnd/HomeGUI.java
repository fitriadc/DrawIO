package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/*
The Home GUI class is used to create some of the required panels.
Panels will be inserted into the main frame and displayed alternately.
*/

public class HomeGUI {
    private final CardLayout layout = new CardLayout();
    private JFrame frame;
    private final JPanel mainPanel = new JPanel();
    private final Map<String, SistakaPanel> panelMap = new HashMap<>();
    public static String shown;

    public HomeGUI(JFrame frame) {
        this.frame = frame;
        mainPanel.setLayout(layout);
        initGUI();
        frame.setContentPane(mainPanel);
    }

    private void initGUI() {

        SistakaPanel welcomePanel = new WelcomePanel(this);
        panelMap.put("welcomePanel", welcomePanel);
        mainPanel.add(welcomePanel, "welcomePanel");

        SistakaPanel drawIOPanel = new DrawIOPanel(this);
        panelMap.put("drawIOPanel", drawIOPanel);
        mainPanel.add(drawIOPanel, "drawIOPanel");

        SistakaPanel saveImagePanel = new SaveImagePanel(this, DrawIOPanel.getGeomObjects());
        panelMap.put("saveImagePanel", saveImagePanel);
        mainPanel.add(saveImagePanel, "saveImagePanel");
    }

    // method to change the panel to be displayed
    public void setPanel(String target) {
        layout.show(mainPanel, target);
    }

    // method to exit the programe
    public void exit() {
        frame.dispose();
    }
}