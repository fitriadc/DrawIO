package FrontEnd;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.w3c.dom.events.MouseEvent;
import java.awt.event.MouseMotionListener;
import BackEnd.Circle;
import BackEnd.GeomObject;
import BackEnd.Oval;
import BackEnd.Square;
import BackEnd.Triangle;
import BackEnd.Rectangle;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

/*
The Draw IO Panel class is used to create the main aplication.
User can draw anthing in the canvas.
*/

public class DrawIOPanel extends SistakaPanel implements ActionListener, MouseMotionListener {
    public static Font fontA1 = new Font("Consolas", Font.PLAIN, 20);
    public static Font fontA2 = new Font("Consolas", Font.PLAIN, 15);
    private JButton saveButton = new JButton("Save");
    private JButton resetButton = new JButton("Reset");
    private JButton increaseButton = new JButton("+");
    private JButton decreaseButton = new JButton("-");
    private JButton eraserOn = new JButton("Off");
    private JButton brushOn = new JButton("Off");
    private boolean isRemove = false;
    private boolean isBrush = false;
    private JTextArea sizeBrushLabel = new JTextArea();
    private JRadioButton circleButton = new JRadioButton();
    private JRadioButton rectangleButton = new JRadioButton();
    private JRadioButton squareButton = new JRadioButton();
    private JRadioButton triangleButton = new JRadioButton();
    private JRadioButton ovalButton = new JRadioButton();
    private String[] colors = { "Red", "Yellow", "Green", "Gray", "Blue", "Cyan", "Black", "Orange", "Pink" };
    private JComboBox jcbColors = new JComboBox<>(colors);
    private JTextField textField = new JTextField();
    private CentralPanel canvas = new CentralPanel();
    private static ArrayList<GeomObject> geomObjects = new ArrayList<>();
    private GeomObject geomObject = new Circle(20, 20, 10, Color.RED);
    private String strColor = "Red";
    private String geomName = "Circle";
    private JPanel colorViewPanel = new JPanel();
    private JLabel sizeShape = new JLabel("Radius");
    private int x = -10, y = -10;
    private int sizeBrush = 4;

    public DrawIOPanel(HomeGUI homeGUI) {
        super(homeGUI);
        setLayout(null);

        // set backgorund image
        ImageIcon welcomeImg = new ImageIcon("Assets/bg-main.png");
        JPanel iconWelcome = new JPanel();
        JLabel imgWelcome = new JLabel();
        imgWelcome.setIcon(welcomeImg);
        iconWelcome.add(imgWelcome);
        iconWelcome.setBounds(0, 0, 900, 600);
        welcomeImg.setImage(welcomeImg.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT));

        // decorate shapes
        squareButton.setBounds(581, 200, 50, 50);
        circleButton.setBounds(680, 200, 50, 50);
        rectangleButton.setBounds(782, 200, 50, 50);
        circleButton.setSelected(true);
        triangleButton.setBounds(581, 290, 50, 50);
        ovalButton.setBounds(680, 290, 50, 50);

        // decorate side of shape
        sizeShape.setBounds(764, 230, 200, 40);
        sizeShape.setFont(fontA2);
        textField.setBounds(764, 264, 112, 50);
        textField.setFont(fontA1);
        textField.setText("20");

        // decorate size of Brush and Eraser Component
        sizeBrushLabel.setBounds(675, 375, 85, 30);
        sizeBrushLabel.setText(String.valueOf(sizeBrush));
        sizeBrushLabel.setEditable(false);
        sizeBrushLabel.setBorder(BorderFactory.createMatteBorder(
                1, 5, 1, 1, Color.GRAY));
        sizeBrushLabel.setAlignmentY(CENTER_ALIGNMENT);
        sizeBrushLabel.setAlignmentX(CENTER_ALIGNMENT);
        sizeBrushLabel.setFont(fontA1);
        brushOn.setBounds(600, 355, 50, 50);
        eraserOn.setBounds(600, 405, 50, 50);
        increaseButton.setBounds(675, 410, 45, 45);
        decreaseButton.setBounds(718, 410, 45, 45);

        // decorate color
        colorViewPanel.setLayout(null);
        colorViewPanel.setBounds(778, 375, 80, 50);
        colorViewPanel.setBackground(Color.RED);
        jcbColors.setBounds(775, 420, 100, 50);

        // decorate save and reset button
        saveButton.setBounds(572, 520, 207, 45);
        resetButton.setBounds(572, 470, 207, 45);

        // decorate canvas
        canvas.setBounds(55, 110, 470, 450);
        canvas.setBackground(Color.WHITE);

        // add component to panel
        add(sizeShape);
        add(textField);
        add(saveButton);
        add(circleButton);
        add(squareButton);
        add(rectangleButton);
        add(increaseButton);
        add(sizeBrushLabel);
        add(eraserOn);
        add(decreaseButton);
        add(jcbColors);
        add(colorViewPanel);
        add(resetButton);
        add(canvas);
        add(brushOn);
        add(ovalButton);
        add(triangleButton);
        add(iconWelcome);

        // add listener to component
        circleButton.addActionListener(this);
        squareButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        jcbColors.addItemListener(new ColorsListener());
        saveButton.addActionListener(this);
        resetButton.addActionListener(this);
        canvas.addMouseMotionListener(this);
        canvas.addMouseListener(new CanvasListener());
        brushOn.addActionListener(this);
        increaseButton.addActionListener(this);
        decreaseButton.addActionListener(this);
        eraserOn.addActionListener(this);
        triangleButton.addActionListener(this);
        ovalButton.addActionListener(this);

    }

    //
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if (isRemove) { // eraser is On, ready to remove anthing
            updateGeom(new Circle(x, y, "White", Integer.toString(sizeBrush)));
        } else if (isBrush) { // brush is On, ready to draw line from the specific shape
            updateGeomHelper(Integer.toString(sizeBrush), textField.getText());
        }
        // remove or draw line
        geomObjects.add(geomObject);
        canvas.repaint();
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            main.setPanel("saveImagePanel");

        } else if (e.getSource() == resetButton) {
            geomObjects.clear();
            repaint();

        } else if (e.getSource() == squareButton) {
            updateGeomName("Square");
            updateRbShapeOn(squareButton);
            sizeShape.setText("Side:");
            textField.setText("20");

        } else if (e.getSource() == circleButton) {
            updateGeomName("Circle");
            updateRbShapeOn(circleButton);
            sizeShape.setText("Radius:");
            textField.setText("40");

        } else if (e.getSource() == rectangleButton) {
            updateGeomName("Rectangle");
            updateRbShapeOn(rectangleButton);
            sizeShape.setText("Width,Heigth:");
            textField.setText("40,20");

        } else if (e.getSource() == triangleButton) {
            updateGeomName("Triangle");
            updateRbShapeOn(triangleButton);
            sizeShape.setText("Side:");
            textField.setText("20");

        } else if (e.getSource() == ovalButton) {
            updateGeomName("Oval");
            updateRbShapeOn(ovalButton);
            sizeShape.setText("Width,Heigth:");
            textField.setText("40,30");

        } else if (e.getSource() == jcbColors) {
            String str = ((String) jcbColors.getSelectedItem());
            strColor = str;

        } else if (e.getSource() == increaseButton) {
            if ((sizeBrush + 2) > 40) {
                JOptionPane.showMessageDialog(null,
                        String.format(
                                "Maaf, ukuran brush dan penghapus telah mencapai batas maksimum. Kamu tidak dapat memperbesar ukuran lagi! :( "),
                        "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            sizeBrush += 2; // size of Brush and eraser will increase

        } else if (e.getSource() == decreaseButton) {
            if ((sizeBrush - 2) < 0) {
                JOptionPane.showMessageDialog(null,
                        String.format(
                                "Maaf, ukuran brush dan penghapus telah mencapai batas minimum. Kamu tidak dapat memperkecil ukuran lagi! :( "),
                        "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            sizeBrush -= 2; // size of Brush and eraser will decrease

        } else if (e.getSource() == eraserOn) {
            // button eraser is updated (on or off)
            if (isRemove) {
                isRemove = false;
                eraserOn.setText("Off");
                return;
            }
            isRemove = true;
            eraserOn.setText("On");
            isBrush = false;
            brushOn.setText("Off");
            return;

        } else {
            // button brush is updated (on or off)
            if (isBrush) {
                isBrush = false;
                brushOn.setText("Off");
                return;
            }
            isBrush = true;
            brushOn.setText("On");
            isRemove = false;
            eraserOn.setText("Off");
            return;
        }
        // update label of brush and eraser size
        sizeBrushLabel.setText(String.valueOf(sizeBrush));
    }

    class CentralPanel extends JPanel { // Inner class
        // geometry object and line is created and added to the canvas
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < geomObjects.size(); i++) {
                GeomObject geom = geomObjects.get(i);
                g = geom.draw(g, geom);
            }
        }
    }

    class ColorsListener implements ItemListener { // Inner class
        // when color is changed, the data of color is also change
        @Override
        public void itemStateChanged(ItemEvent e) {
            String str = ((String) e.getItemSelectable().getSelectedObjects()[0]);
            strColor = str;
            // user can see the color that is used right now
            colorViewPanel.setBackground(GeomObject.transformColour(strColor));
        }
    }

    class CanvasListener implements MouseListener { // Inner class

        public void mousePressed(MouseEvent e) {
        }

        public void mouseMoved(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            x = e.getX();
            y = e.getY();
            // geometry object is created
            updateGeomHelper(textField.getText(), textField.getText());
            geomObjects.add(geomObject);
            canvas.repaint();
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
        }

    }

    public void updateGeomName(String s) {
        this.geomName = s;
    }

    public void updateGeom(GeomObject geomObject) {
        this.geomObject = geomObject;
    }

    public void updateGeomHelper(String sizeA, String sizeB) {
        if (geomName.equals("Circle")) {
            updateGeom(new Circle(x, y, strColor, sizeA));
        } else if (geomName.equals("Square")) {
            updateGeom(new Square(x, y, strColor, sizeA));
        } else if (geomName.equals("Triangle")) {
            updateGeom(new Triangle(x, y, strColor, sizeA));
        } else if (geomName.equals("Oval")) {
            updateGeom(new Oval(x, y, strColor, sizeB));
        } else {
            updateGeom(new Rectangle(x, y, strColor, sizeB));
        }
    }

    public void updateRbShapeOn(JRadioButton namaButton) {
        ovalButton.setSelected(false);
        squareButton.setSelected(false);
        rectangleButton.setSelected(false);
        circleButton.setSelected(false);
        triangleButton.setSelected(false);
        if (namaButton == ovalButton) {
            ovalButton.setSelected(true);
            return;
        } else if (namaButton == rectangleButton) {
            rectangleButton.setSelected(true);
            return;
        } else if (namaButton == squareButton) {
            squareButton.setSelected(true);
            return;
        } else if (namaButton == triangleButton) {
            triangleButton.setSelected(true);
            return;
        } else if (namaButton == circleButton) {
            circleButton.setSelected(true);
            return;
        }
    }

    public static ArrayList<GeomObject> getGeomObjects() {
        return geomObjects;
    }
}
