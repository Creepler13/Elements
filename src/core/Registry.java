package core;

import java.awt.Color;

import core.properties.ElementPropertyList;

public class Registry {

	public GameRegistry<Element> elementRegistry = new GameRegistry<>();

	public void registerElement(int id, String name, Color color, ElementPropertyList properties) {
		Element e = new Element(id, name, color, properties);
		elementRegistry.putIfAbsent(id, e);
		elementRegistry.putIfAbsent(name, e);
	}

	public Element getElement(int id) {
		if (!elementRegistry.containsKey(id))
			System.err.println("Element with id:" + id + " not Registered");
		return elementRegistry.get(id);
	}

	public Element getElement(String name) {
		if (!elementRegistry.containsKey(name))
			System.err.println("Element with name:" + name + " not Registered");
		return elementRegistry.get(name);
	}

}
