package Algos;

import Main.node;
import Main.tree;

import java.util.concurrent.LinkedBlockingQueue;

public class BFS<T> implements IAlgo<T> {
    private int countCheck = 0;

    public synchronized void setCountCheck(int countCheck) {
        this.countCheck = countCheck;
    }


    @Override
    public boolean isThereVariable(tree<T> coll, T var) {
        if (coll == null || coll.getRoot() == null)
            return false;
        LinkedBlockingQueue<node<T>> q = new LinkedBlockingQueue<>();
        q.add(coll.getRoot());
        setCountCheck(1);
        while (!q.isEmpty()) {
            setCountCheck(countCheck + 1);
            node<T> currNode = q.poll();
            if (currNode.getValue().equals(var))
                return true;
            q.addAll(currNode.getSons());
        }
        return false;
    }

    @Override
    public node<T> returnNode(tree<T> coll, T var) {
        if (coll == null || coll.getRoot() == null)
            return null;
        LinkedBlockingQueue<node<T>> q = new LinkedBlockingQueue<>();
        q.add(coll.getRoot());
        setCountCheck(1);
        while (!q.isEmpty()) {
            setCountCheck(countCheck + 1);
            node<T> currNode = q.poll();
            if (currNode.getValue().equals(var))
                return currNode;
            q.addAll(currNode.getSons());
        }
        return null;
    }

    @Override
    public int getCountChecks() {
        return countCheck;
    }
}
