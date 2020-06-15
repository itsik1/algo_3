package tests;

import Algos.BFS;
import Algos.DFS;
import Algos.dfid;
import Main.node;
import Main.tree;
import Utils.ConsoleColors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class test1 {
    tree<Integer> tr1;

    @Before
    public void init() {
        int[] parentIndexes = {-1, 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5};
        Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        tr1 = new tree<>(parentIndexes, values);
    }

    public void testTree1() {
        tree<Integer> tr = new tree<>(4, 4, 130);
        System.out.println(tr.getRoot().getSons());
        tr.printTree();
    }

    public void printGivenWithLine(tree<Integer> tr, node<Integer> n) {
        printCurrWithIndentation(tr.getRoot(), n, "");
    }

    private void printCurrWithIndentation(node<Integer> currNode, node<Integer> n, String s) {
        if (currNode == n)// same node
            System.out.println(ConsoleColors.BLUE + s + currNode.getValue() + ConsoleColors.RESET);
        else
            System.out.println(s + currNode.getValue());

        for (node<Integer> currSon : currNode.getSons())
            printCurrWithIndentation(currSon, n, s + "\t");
    }
//
//    @Test
//    public void testMock()
//    {
//
//    }


    @Test
    public void testTree2() {
        int rootValue = 130;
        tree<Integer> tr = new tree<>(4, 4, rootValue);
        assertThat(tr.getRoot().getValue(), is(rootValue));
    }

    @Test
    public void testTree3() {
        tree<Integer> tr = new tree<>(4, 2, 130);
//        tr.printTree();
        dfid<Integer> d = new dfid<>();
        Assert.assertTrue(d.isThereVariable(tr, tr.getRoot().getValue()));
    }

    @Test
    public void test_add_value_to_tree() {
        tree<Integer> tr = new tree<>(130);
        Assert.assertTrue(tr.add(1));
        dfid<Integer> d = new dfid<>();
        Assert.assertTrue(d.isThereVariable(tr, 1));
//        tr.printTree();
    }

    @Test
    public void test_add_array() {
        tree<Integer> tr = new tree<>(130);
        for (int i = 1; i <= 10; i++) {
            tr.add(i);
            dfid<Integer> d = new dfid<>();
            Assert.assertTrue(d.isThereVariable(tr, i));
        }
    }


    @Test
    public void test_find_value() {
        node<Integer> chosenNode = tr1.getRoot().getSons().get(1).getSons().get(1);
        System.out.println("Value = " + chosenNode.getValue());

        printGivenWithLine(tr1, chosenNode);

    }

    @Test
    public void test_find_with_Dfid_given_value_only_Dfid() {
        int wantedValue = 16;
        dfid<Integer> d = new dfid<>();
        node<Integer> n = d.returnNode(tr1, wantedValue);
        assertThat(n, is(not(nullValue())));
        assertThat(n.getValue(), is(wantedValue));
        assertThat(d.getCountChecks(), is(27));
    }

    @Test
    public void test_find_not_existing_Dfid() {
        int wantedValue = -16;
        dfid<Integer> d = new dfid<>();
        node<Integer> n = d.returnNode(tr1, wantedValue);
        assertThat(n, is(nullValue()));
        assertThat(d.getCountChecks(), is(31));
    }

    @Test
    public void test_find_not_existing_BFS() {
        int wantedValue = -16;
        BFS<Integer> b = new BFS<>();
        node<Integer> n = b.returnNode(tr1, wantedValue);
        assertThat(n, is(nullValue()));
        assertThat(b.getCountChecks(), is(31));
    }

    @Test
    public void test_find_not_existing_DFS() {
        int wantedValue = -16;
        DFS<Integer> d = new DFS<>();
        node<Integer> n = d.returnNode(tr1, wantedValue);
        assertThat(n, is(nullValue()));
        assertThat(d.getCountChecks(), is(0));
    }


    @Test
    public void test_find_with_BFS_value_Only() {
        int wantedValue = 16;
        BFS<Integer> b = new BFS<>();
        node<Integer> n = b.returnNode(tr1, wantedValue);
        assertThat(n, is(not(nullValue())));
        assertThat(n.getValue(), is(wantedValue));
        assertThat(b.getCountChecks(), is(27));
    }

    @Test
    public void test_find_with_DFS_value_Only() {
        int wantedValue = 16;
        DFS<Integer> d = new DFS<>();
        node<Integer> n = d.returnNode(tr1, wantedValue);
        assertThat(n, is(not(nullValue())));
        assertThat(n.getValue(), is(wantedValue));
        assertThat(d.getCountChecks(), is(14));
    }


    /* @Test
     public void test_tree_depth() {
         tree<Integer> tr = new tree<>(4, 10, 130);
         ArrayList<node<Integer>> al = new ArrayList();
         al.add(tr.getRoot());
         int count = 0;
         node<Integer> currNode;
         while (!al.isEmpty() && count < 10000) {
             count++;
             currNode = al.remove(0);

         }
     }*/

}
