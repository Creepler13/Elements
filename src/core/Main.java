package core;

import core.properties.ElementProperty;
import gui.Window;

public class Main {

	public static void main(String[] args) {
		Window window = new Window();
		Registry registry = new Registry();
		Init.elementInit(registry);
		Map map = new Map(500, 500);

		
		map.set(2, 0, 0);

	

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					try {
						Thread.sleep(16);
					} catch (InterruptedException e1) {

					}

					Map tempMap = map.copy();
					for (int x = 0; x < tempMap.width; x++) {
						for (int y = 0; y < tempMap.height; y++) {
							Element e = registry.getElement(tempMap.get(x, y));
							for (ElementProperty property : e.getProperties().elementProperties) {
								property.action(x, y, map, registry);
							}

						}
					}
				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {

					}

					window.render(map, registry);
				}
			}
		}).start();

	}

}
