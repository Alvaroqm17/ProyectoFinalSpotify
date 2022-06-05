package elemntosvisuales;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class BotonLista extends JButton {
	public BotonLista(String m) {
		super(m);
		estiloPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 0, 0));
				setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
				setSize(152, 37);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}
		});
	}

	private void estiloPorDefecto() {
		this.setBackground(new Color(0, 0, 0));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Cascadia Mono", Font.PLAIN, 14));
		this.setForeground(new Color(255, 255, 255));
		setSize(152, 37);
	}

}
