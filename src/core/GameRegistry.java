package core;

import java.util.HashMap;

public class GameRegistry<E> {

	HashMap<Integer, E> idReg = new HashMap<>();
	HashMap<String, E> nameReg = new HashMap<>();

	public boolean containsKey(String name) {
		return nameReg.containsKey(name);
	}

	public boolean containsKey(int id) {
		return idReg.containsKey(id);
	}

	public boolean containsValue(E value) {
		return nameReg.containsValue(value) || idReg.containsValue(value);
	}

	public E put(String name, E value) {
		return nameReg.put(name, value);
	}

	public E put(int id, E value) {
		return idReg.put(id, value);
	}

	public E putIfAbsent(String name, E value) {
		return nameReg.putIfAbsent(name, value);
	}

	public E putIfAbsent(int id, E value) {
		return idReg.putIfAbsent(id, value);
	}

	public E get(String name) {
		return nameReg.get(name);
	}

	public E get(int id) {
		return idReg.get(id);
	}

}
