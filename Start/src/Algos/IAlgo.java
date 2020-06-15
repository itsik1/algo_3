package Algos;

import Main.node;
import Main.tree;


public interface IAlgo<T> {
    boolean isThereVariable(tree<T> coll, T var);

    node<T> returnNode(tree<T> coll, T var);

    int getCountChecks();
}