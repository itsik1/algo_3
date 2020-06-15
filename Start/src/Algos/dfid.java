package Algos;

import Main.node;
import Main.tree;

/**
 * @param <T> generic param
 * @author איציק
 * @version 1.0
 * @since כ"ג סיוון תש"פ
 */
public class dfid<T> implements IAlgo<T> {

    private boolean thereAreMoreAtNextLevel = true;
    private int maxDepth = 0;
    private int countChecks = 0;

    @Override
    public int getCountChecks() {
        return countChecks;
    }


    public synchronized void setCountChecks(int countChecks) {
        this.countChecks = countChecks;
    }

    private synchronized void setThereAreMoreAtNextLevel(boolean thereAreMoreAtNextLevel) {
        this.thereAreMoreAtNextLevel = thereAreMoreAtNextLevel;
    }

    @Override
    public boolean isThereVariable(tree<T> tr, T var) {
        if (tr.size() == 0)
            return false;
        boolean ans;
        maxDepth = 0;
        setCountChecks(0);
        while (thereAreMoreAtNextLevel) {
            setThereAreMoreAtNextLevel(false);

            if (checkLevel(tr.getRoot(), var, 0))
                return true;
            maxDepth++;
        }
        return false;
    }

    /***
     *  In this function we shell return the node that has the value var - if we don't find it we return null
     * @param tr - the tree to search in
     * @param var - the wanted value to search
     * @return the node that it's value is var, or null if it not exists
     */
    @Override
    public node<T> returnNode(tree<T> tr, T var) {
        //If there it's empty - returning null
        if (tr.size() == 0)
            return null;
        //Start depth and count checks
        maxDepth = 0;
        countChecks = 0;
        //Now go over the tree recursively in iterations
        while (thereAreMoreAtNextLevel) {
            //First we don't know if there is more levels
            setThereAreMoreAtNextLevel(false);
            //Checking the level
            node<T> currLevel = checkLevelWithNodeReturning(tr.getRoot(), var, 0);
            if (currLevel != null)
                return currLevel;
            maxDepth++;
        }
        //If we didn't find var we return null
        return null;
    }

    /***
     * In this function we check recursively if we found the value till maxDepth
     * @param currNode - the current node the check if it's the node with the value var
     * @param var - the value the search for
     * @param currDepth - our depth in the tree - which we check if we pass the maxDepth
     * @return node that it's value is var, or null if we did't find it.
     */
    private node<T> checkLevelWithNodeReturning(node<T> currNode, T var, int currDepth) {
        //++ to count checks
        setCountChecks(countChecks + 1);
        //We check if we got to the wanted value
        if (currNode.getValue().equals(var))
            return currNode;
        //otherwise we check if we acceded the limit of depth
        if (currDepth >= maxDepth) {
            //If we have more sons - there is more levels
            if (!thereAreMoreAtNextLevel && currNode.getSons().size() > 0)
                setThereAreMoreAtNextLevel(true);
            return null;
        }
        //Now we go over the sons
        for (node<T> currSon : currNode.getSons()) {
            //now we active the recursion
            node<T> currAns = checkLevelWithNodeReturning(currSon, var, currDepth + 1);
            //if we got not null - we return it
            if (currAns != null)
                return currAns;
        }
        //If we didn't got the value we shell return null
        return null;
    }


    private boolean checkLevel(node<T> currNode, T var, int currDepth) {
        setCountChecks(countChecks + 1);
        if (currNode.getValue().equals(var))
            return true;

        if (currDepth >= maxDepth) {
            if (!thereAreMoreAtNextLevel && currNode.getSons().size() > 0)
                setThereAreMoreAtNextLevel(true);
            return false;
        }
        for (node<T> currSon : currNode.getSons()) {
            if (checkLevel(currSon, var, currDepth + 1))
                return true;
        }
        return false;
    }
}
