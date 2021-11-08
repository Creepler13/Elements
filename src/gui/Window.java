package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import core.Element;
import core.Map;
import core.Registry;

public class Window {

	private JFrame frame;
	private JBackgroundPanel JBC;

	public Window() {
		frame = new JFrame();
		frame.setBounds(0, 0, 500, 500);

		JBC = new JBackgroundPanel();
		JBC.setBounds(0, 0, 500, 500);

		frame.setContentPane(JBC);

		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

		});

		frame.setVisible(true);

	}

	public void render(Map map, Registry reg) {

		BufferedImage i = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);

		for (int x = 0; x < 500; x++) {
			for (int y = 0; y < 500; y++) {
				int id = map.get(x, y);
				Element elem = reg.getElement(id);
				if (elem == null) {
					System.err.println("Element with id:" + id + " not Registered");
					continue;
				}
				i.setRGB(x, y, elem.getColor().getRGB());
			}
		}

		JBC.setBackground(i);

	}

}
