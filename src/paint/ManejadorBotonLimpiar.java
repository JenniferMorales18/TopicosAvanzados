package paint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ManejadorBotonLimpiar implements ActionListener {

    Lienzo lienzo;

    public ManejadorBotonLimpiar(Lienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void actionPerformed(ActionEvent ae) {
        lienzo.repaint();
    }
}
