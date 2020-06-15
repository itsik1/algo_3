package Algos;

import Main.node;
import Main.tree;

public class DFS<T> implements IAlgo<T> {

    private int countChecks;

    @Override
    public boolean isThereVariable(tree<T> coll, T var) {
        setCountChecks(0);
        if (coll == null || coll.getRoot() == null)
            return false;
        return recursiveIsThereVariable(coll.getRoot(), var);
    }

    private boolean recursiveIsThereVariable(node<T> currNode, T var) {
        setCountChecks(countChecks + 1);
        if (currNode.getValue().equals(var))
            return true;
        for (node<T> currSon : currNode.getSons())
            if (recursiveIsThereVariable(currSon, var))
                return true;
        return false;
    }

    @Override
    public node<T> returnNode(tree<T> coll, T var) {
        setCountChecks(0);
        if (coll == null || coll.getRoot() == null)
            return null;
        return recursiveReturnNode(coll.getRoot(), var);
    }

    private node<T> recursiveReturnNode(node<T> currNode, T var) {
        setCountChecks(countChecks + 1);
        if (currNode.getValue().equals(var))
            return currNode;
        for (node<T> currSon: currNode.getSons()) {
            node<T> n = recursiveReturnNode(currSon, var);
            if (n != null)
                return n;
        }
        return  null;
    }

    @Override
    public int getCountChecks() {
        return countChecks ;
    }

    public synchronized void setCountChecks(int countChecks) {
        this.countChecks = countChecks;
    }
}
