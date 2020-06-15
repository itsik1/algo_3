package Main;

public class mainFunc {
	public static void main(String[] args) {
	/*	tree<Integer> tr = new tree<>(4, 2,130);
		System.out.println(tr.getRoot().getSons());
		tr.printTree();*/

		int[] parentIndexes = {0,0,0,1,1,2,2,2,2,3,3,3,3,3,4,4,5,5};
		Integer[] values = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		tree<Integer> tr1 = new tree(parentIndexes, values);

	}

}
