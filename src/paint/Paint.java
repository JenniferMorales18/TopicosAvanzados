
package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;


public class Paint extends JFrame{
    int i = -1;
    JPanel Dibujo, Botones, Colores;
    JButton salir, limpiar, cambiarcolor, Dibujar;
    JComboBox opcion;
    JLabel jl, jlcolor, jlAlto, jlAncho, xpos, ypos, jlpos;
    JSlider sliderAlto, sliderAncho;
    String[] stringColores = null;
    Color[] colores = null;
    Container cp = getContentPane();
    Color color;
    Lienzo lienzo;
    public Paint(){
        super("Paint");
        this.setLayout(new BorderLayout());
        stringColores = new String[]{"Gris", "Rojo", "Amarillo", "Azul", "Verde"};
        colores = new Color[]{Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};
        Botones = new JPanel();
        Colores = new JPanel();
        Colores.setLayout(new BoxLayout(Colores, BoxLayout.Y_AXIS));
        xpos = new JLabel("X:");
        ypos = new JLabel("Y:");
        jlpos = new JLabel("Posicion Cursor");
        jl = new JLabel("Dibujar");
        jlcolor = new JLabel("Color Actual");
        jlcolor.setForeground(Color.BLACK);
        jlcolor.setFont(new Font("Algerian", Font.BOLD, 15));
        jlAlto = new JLabel("Alto");
        jlAlto.setAlignmentY(Component.CENTER_ALIGNMENT);
        jlAlto.setFont(new Font("Algerian", Font.BOLD, 15));
        jlAncho = new JLabel("Ancho");
        jlAncho.setAlignmentY(Component.CENTER_ALIGNMENT);
        jlAncho.setFont(new Font("Algerian", Font.BOLD, 15));
        //Sliders
        int initValue = 1;
        int minimum = 1;
        int maximum = 700;
        sliderAncho = new JSlider(minimum, maximum, initValue);
        sliderAncho.setPaintTicks(true);
        sliderAncho.setBounds(250, 50, 150, 30);
        sliderAlto = new JSlider(minimum, maximum, initValue);
        sliderAlto.setPaintTicks(true);
        sliderAlto.setBounds(250, 50, 150, 30);
        //radiobuton
        JRadioButton rbColores[] = new JRadioButton[stringColores.length];
        ButtonGroup grup = new ButtonGroup();
        for (int i = 0; i < stringColores.length; i++) {
            rbColores[i] = new JRadioButton(stringColores[i]);
            rbColores[i].setActionCommand(stringColores[i]);
            rbColores[i].setAlignmentY(Component.CENTER_ALIGNMENT);
            grup.add(rbColores[i]);
            Colores.add(rbColores[i]);
			rbColores[i].addActionListener(new ManejadorRadioButton(this));
        }
        salir = new JButton("Salir");
        limpiar = new JButton("Limpiar");
        Dibujar = new JButton("Dibujar");
        cambiarcolor = new JButton("Mas Colores");
        cambiarcolor.setAlignmentX(Component.CENTER_ALIGNMENT);
        opcion = new JComboBox();
        opcion.addItem("");
        opcion.addItem("Linea");
        opcion.addItem("Cuadrado/Rectangulo");
        opcion.addItem("Circulo/Elipse");
        opcion.addItem("Libre");
        opcion.setEnabled(false);
        cp.add(new Lienzo(this), BorderLayout.CENTER);
        cp.add(Colores, BorderLayout.EAST);
        cp.add(Botones, BorderLayout.SOUTH);
        Botones.add(Dibujar);
        Botones.add(jl);
        Botones.add(opcion);
        Botones.add(limpiar);
        Botones.add(salir);
        Colores.add(cambiarcolor);
        Colores.add(jlcolor);
        Colores.add(jlAlto);
        Colores.add(sliderAlto);
        Colores.add(jlAncho);
        Colores.add(sliderAncho);
        Colores.add(jlpos);
        Colores.add(xpos);
        Colores.add(ypos);
        sliderAlto.setEnabled(false);
        sliderAncho.setEnabled(false);
        Colores.setVisible(false);
        Dibujar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                opcion.setEnabled(true);
                Colores.setVisible(true);
            }
        });
        cambiarcolor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(Colores, "Selecciona un color", jlcolor.getForeground());
                if (color != null) {
                    jlcolor.setForeground(color);
                }
            }
        });
        opcion.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                JComboBox fuente = (JComboBox) ie.getSource();
                i = fuente.getSelectedIndex();
            }
        });
        salir.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
        });
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(7);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
    }
    public static void main(String[] args) {
        new Paint().setVisible(true);
    }
}
