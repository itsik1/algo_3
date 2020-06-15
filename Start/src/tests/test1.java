package tests;

import Dfid.dfid;
import Main.tree;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.beans.Transient;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsNot.not;
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
        Assert.assertTrue(d.isThereVariable(tr, tr.getRoot().getValue()));
    }

    @Test
    public void test_add_value_to_tree() {
        tree<Integer> tr = new tree<>(130);
        Assert.assertTrue(tr.add(1));
        dfid d = new dfid();
        Assert.assertTrue(d.isThereVariable(tr, 1));
//        tr.printTree();
    }

    @Test
    public void test_add_array() {
        tree<Integer> tr = new tree<>(130);
//        int[] t = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 1; i <= 10; i++) {
            tr.add(i);
            dfid d = new dfid();
            Assert.assertTrue(d.isThereVariable(tr, i));
        }
    }


    @Test
    public void test_find_value() {
        int[] parentIndexes = {-1, 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5};
        Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        tree<Integer> tr1 = new tree(parentIndexes, values);

        node<Integer> chosenNode = tr1.getRoot().getSons().get(1).getSons().get(1);
        System.out.println("Value = " + chosenNode.getValue());

        printGivenWithLine(tr1, chosenNode);
    }

    @Test
    public void test_find_with_Dfid_given_value_only()
    {
        int[] parentIndexes = {-1, 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5};
        Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        tree<Integer> tr1 = new tree(parentIndexes, values);
        int wantedValue = 16;
        dfid d = new dfid();
        node<Integer> n = d.returnNode(tr1, wantedValue);

        assertThat(n, is(not(nullValue())));
        assertThat(n.getValue(), is(wantedValue));
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
    public class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

        // Background
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
        public static final String RED_BACKGROUND = "\033[41m";    // RED
        public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
        public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    }
}
