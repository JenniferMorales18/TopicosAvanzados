package paint;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

public class SelectorAlto implements ChangeListener {

    Lienzo lienzo;

    public SelectorAlto(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        lienzo.alto = slider.getValue();
    }
}