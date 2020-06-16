package Algos;

import Main.node;
import Main.tree;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class DFSTest {
    tree<Integer> tr1;

    @Before
    public void init() {
        int[] parentIndexes = {-1, 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5};
        Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        tr1 = new tree<>(parentIndexes, values);
    }
    @Test
    public void isThereVariable() {
        int wantedValue = -16;
        DFS<Integer> d = new DFS<>();
        assertThat(d.isThereVariable(tr1, wantedValue), is(false));
        assertThat(d.getCountChecks(), is(18));
    }
    @Test
    public void isThereVariable2() {
        int wantedValue = 16;
        DFS<Integer> d = new DFS<>();
        assertThat(d.isThereVariable(tr1, wantedValue), is(true));
        assertThat(d.getCountChecks(), is(14));
    }

    @Test
    public void returnNode2() {
        int wantedValue = 16;
        DFS<Integer> d = new DFS<>();
        node<Integer> n = d.returnNode(tr1, wantedValue);
        assertThat(n, is(not(nullValue())));
        assertThat(n.getValue(), is(wantedValue));
        assertThat(d.getCountChecks(), is(14));
    }

    @Test
    public void returnNode() {
        int wantedValue = -16;
        DFS<Integer> d = new DFS<>();
        node<Integer> n = d.returnNode(tr1, wantedValue);
        assertThat(n, is(nullValue()));
        assertThat(d.getCountChecks(), is(18));
    }
}