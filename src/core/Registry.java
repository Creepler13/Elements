package core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import core.interfaces.IElement;
import core.properties.ElementProperty;
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

	public HashMap<Integer, ArrayList<Reaction>> reactionRegistry = new HashMap<>();

	public void registerReaction(IElement e1, IElement e2, Element e1out, Element e2out) {
		Reaction reaction = new Reaction(e1, e2, e1out, e2out);
		addReaction(e1, e2, reaction);
	}

	public void registerReaction(IElement e1, IElement e2, CustomReaction customReaction) {
		Reaction reaction = new Reaction(e1, e2, customReaction);
		addReaction(e1, e2, reaction);
	}

	public ArrayList<Reaction> getReactions(int id) {
		return reactionRegistry.get(id);
	}

	public ArrayList<Reaction> getReactions(Element element) {
		return reactionRegistry.get(element.getID());
	}

	private void addReaction(IElement e1, IElement e2, Reaction reaction) {
		if (e1 instanceof ElementProperty) {
			for (Element element : elementRegistry.idReg.values()) {
				if (element.hasProperty((ElementProperty) e1)) {
					addReactionToReg(element.getID(), reaction);
				}
			}
		} else {
			addReactionToReg(((Element) e1).getID(), reaction);
		}
		if (e2 instanceof ElementProperty) {
			for (Element element : elementRegistry.idReg.values()) {
				if (element.hasProperty((ElementProperty) e2)) {
					addReactionToReg(element.getID(), reaction);
				}
			}
		} else {
			addReactionToReg(((Element) e2).getID(), reaction);
		}
	}

	private void addReactionToReg(int id, Reaction reaction) {
		ArrayList<Reaction> temp = new ArrayList<>();
		if (reactionRegistry.containsKey(id))
			temp = reactionRegistry.get(id);
		temp.add(reaction);
		reactionRegistry.put(id, temp);
	}

}
