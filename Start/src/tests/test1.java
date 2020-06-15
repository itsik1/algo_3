package tests;

import Dfid.dfid;
import Main.tree;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class test1 {

    public void testTree1() {
        tree<Integer> tr = new tree<>(4, 4, 130);
        System.out.println(tr.getRoot().getSons());
        tr.printTree();
    }

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
        dfid d = new dfid();
        Assert.assertTrue(d.isThereVariable(tr,tr.getRoot().getValue()));
    }

    @Test
    public void test_add_value_to_tree(){
        tree<Integer> tr = new tree<>(130);
        Assert.assertTrue(tr.add(1));
        dfid d = new dfid();
        Assert.assertTrue(d.isThereVariable(tr,1));
//        tr.printTree();
    }
    @Test
    public void test_add_array()
    {
        tree<Integer> tr = new tree<>(130);
//        int[] t = {1,2,3,4,5,6,7,8,9,10};
        for(int i=1; i<=10; i++)
        {
            tr.add(i);
            dfid d = new dfid();
            Assert.assertTrue(d.isThereVariable(tr,i));
        }
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
