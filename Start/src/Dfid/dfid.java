package Dfid;

import Main.node;
import Main.tree;

import java.util.ArrayList;

public class dfid<T> implements IAlgo<T> {

    boolean thereAreMoreAtNextLevel = true;
    int maxDepth = 0;

    @Override
    public boolean isThereVariable(tree<T> coll, T var) {
        if (coll.size() == 0)
            return false;
        boolean ans;
        while (thereAreMoreAtNextLevel) {
            thereAreMoreAtNextLevel = false;

            if (checkLevel(coll.getRoot(), var, 0))
                return true;
            maxDepth++;
        }
        return false;
    }


    private boolean checkLevel(node<T> currNode, T var, int currDepth) {
        if (currNode.getValue().equals(var))
            return true;

        if (currDepth >= maxDepth) {
            if (!thereAreMoreAtNextLevel && currNode.getSons().size() > 0)
                thereAreMoreAtNextLevel = true;
            return false;
        }
        for (node<T> currSon : currNode.getSons()) {
            if (checkLevel(currSon, var, currDepth + 1))
                return true;
        }
        return false;
    }
}
