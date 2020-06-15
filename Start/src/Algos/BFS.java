package Algos;

import Main.node;
import Main.tree;

public class BFS<T> implements IAlgo<T> {
    private int countCheck = 0 ;

    @Override
    public boolean isThereVariable(tree<T> coll, T var) {
        return false;
    }

    @Override
    public node<T> returnNode(tree<T> coll, T var) {
        return null;
    }

    @Override
    public int getCountChecks() {
        return 0;
    }
}
