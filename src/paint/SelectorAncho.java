package paint;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

public class SelectorAncho implements ChangeListener {

    Lienzo lienzo;

    public SelectorAncho(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        lienzo.ancho = slider.getValue();
    }
}