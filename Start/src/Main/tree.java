package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class tree<T> implements Collection {
    private node<T> root;
    private int size;
    private int depth;
    private int avgDegree;
    public tree(T firstValue)
    {
        root = new node(null,firstValue);
        this.depth = 0;
        this.avgDegree = 0;
        makeSons(null,0,0);
    }
    public tree(int depth, int avgDegree, T firstValue) {
        int currNumOfSons = (int) (Math.random() * avgDegree * 2) + 1;
        root = new node(null, firstValue);
        this.depth = depth;
        this.avgDegree = avgDegree;
        makeSons(root, depth, avgDegree);
    }

    public int getDepth() {
        return depth;
    }

    public int getAvgDegree() {
        return avgDegree;
    }

    private void makeSons(node<T> currNode, int depth, int avgDegree) {
        // This function makes tree with depth:depth and an average degree of:
        // avgDegree
        size++;
        if (depth == 0)
            return;
        ArrayList<node<T>> sonsArray = new ArrayList<>();
        int currNumOfSons = (int) (Math.random() * avgDegree * 2) + 1;
        for (int i = 0; i < currNumOfSons; i++) {
            node<T> newSon = null;
            if (root.getValue() instanceof Integer)
                newSon = new node(currNode, (int) (Math.random() * depth * avgDegree));
            else
                newSon = new node<T>(currNode, null);

            sonsArray.add(newSon);
            makeSons(newSon, depth - 1, avgDegree);
        }
        currNode.setSons(sonsArray);
    }

    public node<T> getRoot() {
        return root;
    }

    public void setRoot(node<T> root) {
        this.root = root;
    }

    public void printTree() {
        System.out.println("\nTree:");
        printCurrNode(root, "");
        System.out.println("\nEnd tree");
    }

    private void printCurrNode(node<T> currNode, String printDepth) {
        System.out.println(printDepth + currNode.getValue().toString());
        for (node<T> currSon : currNode.getSons())
            printCurrNode(currSon, printDepth + "\t");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if(o == null)
            return false;
        T toAdd = (T)o;
        node<T> currSon = root;
        while(currSon.getSons().size() != 0)
        {
            boolean wantToContinueToSons = Math.random() > 0.2;//highly possible to continue to sons
            ArrayList<node<T>> currSons = (ArrayList<node<T>>) currSon.getSons();
            if(!wantToContinueToSons) {
                currSons.add(new node(currSon, toAdd));
                currSon.setSons(currSons);
                size++;
                return true;
            }
            else
            {
                int chosenSonIndex = (int) (Math.random() * (currSons.size()));
                currSon = currSons.get(chosenSonIndex);
            }
        }
        ArrayList<node<T>> currSons = (ArrayList<node<T>>) currSon.getSons();
        currSons.add(new node(currSon, toAdd));
        currSon.setSons(currSons);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
