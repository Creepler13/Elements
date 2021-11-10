package core;

import core.properties.ElementProperty;
import gui.Camera;
import gui.Window;

public class Main {

	public static void main(String[] args) {
		Camera cam = new Camera();

		cam.setPosition(0, 400);
		cam.setSize(100, 100);
		Window window = new Window();
		Registry registry = new Registry();
		Init.elementInit(registry);
		Init.reactionInit(registry);
		Map map = new Map(500, 500);

		Tools.fillRect(map, registry.getElement("wood"), 0, 300, 500, 500);

		Tools.fillRect(map, registry.getElement("fire"), 0, 300, 5, 5);

		Tools.fillRect(map, registry.getElement("water"), 0, 400, 500, 500);

		Tools.fillRect(map, registry.getElement("sugar"), 50, 50, 50, 50);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					try {
						Thread.sleep(5);
					} catch (InterruptedException e1) {

					}

					Map tempMap = map.copy();
					for (int x = 0; x < tempMap.width; x++) {
						for (int y = 0; y < tempMap.height; y++) {
							Element e = registry.getElement(tempMap.get(x, y));
							for (Reaction reaction : registry.getReactions(e)) {
								reaction.action(x, y, map, registry);
							}

						}
					}

					tempMap = map.copy();
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
