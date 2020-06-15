package Main;

import java.util.ArrayList;
import java.util.List;

public class node<T> {
	private node<T> father;
	private T value;
	private List<node<T>> sons;

	public node(node<T> father, List<node<T>> sons, T value) {
		this.value = value;
		this.father = father;
		this.sons = sons;
	}
	public node(node<T> father, T value) {
		this(father,new ArrayList<node<T>>(),value);
	}
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}



	public node<T> getFather() {
		return father;
	}

	public void setFather(node<T> father) {
		this.father = father;
	}

	public List<node<T>> getSons() {
		return sons;
	}

	public void setSons(List<node<T>> sons) {
		this.sons = sons;
	}

}
