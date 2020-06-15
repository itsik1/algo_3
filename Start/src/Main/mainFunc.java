package Main;

public class mainFunc {
	public static void main(String[] args) {
		tree<Integer> tr = new tree<>(4, 2,130);
		System.out.println(tr.getRoot().getSons());
		tr.printTree();
	}

}
