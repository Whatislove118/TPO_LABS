package com.lab1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class SecondEx {
    ArrayList<Integer> insertTestFirstCase;
    ArrayList<Integer> insertTestSecondCase;
    ArrayList<Integer> insertTestThirdCase;
    ArrayList<Integer> deleteTestFirstCase;
    ArrayList<Integer> deleteTestSecondCase;
    ArrayList<Integer> deleteTestThirdCase;
    ArrayList<Integer> changeTestFirstCase;
    ArrayList<Integer> changeTestSecondCase;
    ArrayList<Integer> extractMinTestFirstCase;
    ArrayList<Integer> extractMinTestSecondCase;



    String predictionValues;
    BinomialHeap bh;


    @ServiceMethod
    public String unpackBh(){
        String actual = bh.displayHeap();

        return null;
    }

    @Before
    public void setUp(){
        predictionValues = "";
        bh = new BinomialHeap();
        insertTestFirstCase = new ArrayList<>();
        for (int i = 1; i<9; i++){
            insertTestFirstCase.add(i);
        }

        insertTestSecondCase = new ArrayList<>();
        insertTestSecondCase.add(2);
        insertTestSecondCase.add(3);
        insertTestSecondCase.add(4);
        insertTestSecondCase.add(1);

        insertTestThirdCase = new ArrayList<>();
        for (int i = 0; i<4; i++){
            insertTestThirdCase.add(1);
        }

        deleteTestFirstCase = new ArrayList<>();
        deleteTestFirstCase.add(5);
        deleteTestFirstCase.add(1);
        deleteTestFirstCase.add(6);
        deleteTestFirstCase.add(7);


        deleteTestSecondCase = new ArrayList<>();
        for (int i = 0; i<4; i++){
            deleteTestSecondCase.add(1);
        }

        deleteTestThirdCase = new ArrayList<>();
        deleteTestThirdCase.add(3);
        deleteTestThirdCase.add(6);
        deleteTestThirdCase.add(9);
        deleteTestThirdCase.add(4);

        changeTestFirstCase = new ArrayList<>();
        changeTestFirstCase.add(7);
        changeTestFirstCase.add(2);
        changeTestFirstCase.add(4);
        changeTestFirstCase.add(9);

        changeTestSecondCase = new ArrayList<>();
        changeTestSecondCase.add(1);
        changeTestSecondCase.add(2);
        changeTestSecondCase.add(3);
        changeTestSecondCase.add(4);

        extractMinTestFirstCase = new ArrayList<>();
        for(int i = 0; i <8; i++){
            extractMinTestFirstCase.add(1);
        }

        extractMinTestSecondCase = new ArrayList<>();
        extractMinTestSecondCase.add(1);
        extractMinTestSecondCase.add(2);
        extractMinTestSecondCase.add(4);
        extractMinTestSecondCase.add(3);




    }

    @After
    public void cleanHeap(){
        bh.makeEmpty();
    }

    @Test
    public void testInsertFirstCase(){
        predictionValues = "8 7 6 5 4 3 2 1 ";
        System.out.println("expected = " + predictionValues);

        for (int i = 0; i<insertTestFirstCase.size(); i++){
            bh.insert(insertTestFirstCase.get(i));
        }
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);


        Assert.assertEquals(predictionValues, actual);
    }

    @Test
    public void testInsertSecondCase(){
        predictionValues = "3 2 4 1 ";
        System.out.println("expected = " + predictionValues);

        for (int i = 0; i<insertTestSecondCase.size(); i++){
            bh.insert(insertTestSecondCase.get(i));
        }
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);

        Assert.assertEquals(predictionValues, actual);
    }

    @Test
    public void testInsertThirdCase(){
        predictionValues = "1 1 1 1 ";
        System.out.println("expected = " + predictionValues);

        for (int i = 0; i<insertTestThirdCase.size(); i++){
            bh.insert(insertTestThirdCase.get(i));
        }
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);

        Assert.assertEquals(predictionValues, actual);

    }

    @Test
    public void testDeleteFirstCase(){
        predictionValues = "5 7 6 ";
        System.out.println("expected = " + predictionValues);
        for (int i = 0; i<deleteTestFirstCase.size(); i++){
            bh.insert(deleteTestFirstCase.get(i));
        }
        bh.delete(1);
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);
        Assert.assertEquals(predictionValues, actual);

    }

    @Test
    public void testDeleteSecondCase(){
        predictionValues = "1 1 1 ";
        System.out.println("expected = " + predictionValues);
        for (int i = 0; i<deleteTestSecondCase.size(); i++){
            bh.insert(deleteTestSecondCase.get(i));
        }
        bh.delete(1);
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);
        Assert.assertEquals(predictionValues, actual);


    }

    @Test
    public void testDeleteThirdCase(){
        predictionValues = "6 9 3 ";
        System.out.println("expected = " + predictionValues);
        for (int i = 0; i<deleteTestThirdCase.size(); i++){
            bh.insert(deleteTestThirdCase.get(i));
        }
        bh.delete(4);
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);
        Assert.assertEquals(predictionValues, actual);
    }


    @Test
    public void testChangeFirstCase(){
        predictionValues = "4 2 7 1 ";
        System.out.println("expected = " + predictionValues);
        for (int i = 0; i<changeTestFirstCase.size(); i++){
            bh.insert(changeTestFirstCase.get(i));
        }
        bh.decreaseKeyValue(9, 1);
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);
        Assert.assertEquals(predictionValues, actual);

    }

    @Test
    public void testChangeSecondCase(){
        predictionValues = "4 1 2 0 ";
        System.out.println("expected = " + predictionValues);
        for (int i = 0; i<changeTestSecondCase.size(); i++){
            bh.insert(changeTestSecondCase.get(i));
        }
        bh.decreaseKeyValue(3, 0);
        String actual = bh.displayHeap();
        System.out.println("actual = " + actual);
        Assert.assertEquals(predictionValues, actual);

    }

    @Test
    public void extractMinTestFirstCase(){
        predictionValues = "1 ";
        System.out.println("expected min = " + predictionValues);
        for (int i = 0; i<extractMinTestFirstCase.size(); i++){
            bh.insert(extractMinTestFirstCase.get(i));
        }
        bh.extractMin();
        String actual = bh.extractMin() + " ";
        System.out.println("actual min = " + actual);
        Assert.assertEquals(predictionValues, actual);

        actual = bh.displayHeap();
        predictionValues = "1 1 1 1 1 1 ";
        System.out.println("expected heap = " + predictionValues);
        System.out.println("actual heap = " + actual);
        Assert.assertEquals(predictionValues, actual);
    }

    @Test
    public void extractMinTestSecondCase(){
        predictionValues = "1 ";
        System.out.println("expected min first = " + predictionValues);
        for (int i = 0; i<extractMinTestSecondCase.size(); i++){
            bh.insert(extractMinTestSecondCase.get(i));
        }
        String actual = bh.extractMin() + " ";
        System.out.println("actual min first= " + actual);
        Assert.assertEquals(predictionValues, actual);

        actual = bh.extractMin() + " ";
        predictionValues = "2 ";
        System.out.println("expected min second = " + predictionValues);
        System.out.println("actual min second= " + actual);
        Assert.assertEquals(predictionValues, actual);

        actual = bh.displayHeap();
        predictionValues = "4 3 ";
        System.out.println("expected heap = " + predictionValues);
        System.out.println("actual heap = " + actual);
        Assert.assertEquals(predictionValues, actual);

    }




}



/* Class BinomialHeapNode */
class BinomialHeapNode
{
    int key, degree;
    BinomialHeapNode parent;
    BinomialHeapNode sibling;
    BinomialHeapNode child;

    /* Constructor */
    public BinomialHeapNode(int k)
    {
        key = k;
        degree = 0;
        parent = null;
        sibling = null;
        child = null;
    }
    /* Function reverse */
    public BinomialHeapNode reverse(BinomialHeapNode sibl)
    {
        BinomialHeapNode ret;
        if (sibling != null)
            ret = sibling.reverse(this);
        else
            ret = this;
        sibling = sibl;
        return ret;
    }
    /* Function to find min node */
    public BinomialHeapNode findMinNode()
    {
        BinomialHeapNode x = this, y = this;
        int min = x.key;

        while (x != null) {
            if (x.key < min) {
                y = x;
                min = x.key;
            }
            x = x.sibling;
        }

        return y;
    }
    /* Function to find node with key value */
    public BinomialHeapNode findANodeWithKey(int value)
    {
        BinomialHeapNode temp = this, node = null;

        while (temp != null)
        {
            if (temp.key == value)
            {
                node = temp;
                break;
            }
            if (temp.child == null)
                temp = temp.sibling;
            else
            {
                node = temp.child.findANodeWithKey(value);
                if (node == null)
                    temp = temp.sibling;
                else
                    break;
            }
        }

        return node;
    }
    /* Function to get size */
    public int getSize()
    {
        return (1 + ((child == null) ? 0 : child.getSize()) + ((sibling == null) ? 0 : sibling.getSize()));
    }
}

/* class BinomialHeap */
class BinomialHeap
{
    private BinomialHeapNode Nodes;
    private int size;
    String actualInsert = "";

    /* Constructor */
    public BinomialHeap()
    {
        Nodes = null;
        size = 0;
    }
    /* Check if heap is empty */
    public boolean isEmpty()
    {
        return Nodes == null;
    }
    /* Function to get size */
    public int getSize()
    {
        return size;
    }
    /* clear heap */
    public void makeEmpty()
    {
        Nodes = null;
        size = 0;
    }
    /* Function to insert */
    public void insert(int value)
    {
        if (value > 0)
        {
            BinomialHeapNode temp = new BinomialHeapNode(value);
            if (Nodes == null)
            {
                Nodes = temp;
                size = 1;
            }
            else
            {
                unionNodes(temp);
                size++;
            }
        }
    }
    /* Function to unite two binomial heaps */
    private void merge(BinomialHeapNode binHeap)
    {
        BinomialHeapNode temp1 = Nodes, temp2 = binHeap;

        while ((temp1 != null) && (temp2 != null))
        {
            if (temp1.degree == temp2.degree)
            {
                BinomialHeapNode tmp = temp2;
                temp2 = temp2.sibling;
                tmp.sibling = temp1.sibling;
                temp1.sibling = tmp;
                temp1 = tmp.sibling;
            }
            else
            {
                if (temp1.degree < temp2.degree)
                {
                    if ((temp1.sibling == null) || (temp1.sibling.degree > temp2.degree))
                    {
                        BinomialHeapNode tmp = temp2;
                        temp2 = temp2.sibling;
                        tmp.sibling = temp1.sibling;
                        temp1.sibling = tmp;
                        temp1 = tmp.sibling;
                    }
                    else
                    {
                        temp1 = temp1.sibling;
                    }
                }
                else
                {
                    BinomialHeapNode tmp = temp1;
                    temp1 = temp2;
                    temp2 = temp2.sibling;
                    temp1.sibling = tmp;
                    if (tmp == Nodes)
                    {
                        Nodes = temp1;
                    }
                    else
                    {

                    }
                }
            }
        }
        if (temp1 == null)
        {
            temp1 = Nodes;
            while (temp1.sibling != null)
            {
                temp1 = temp1.sibling;
            }
            temp1.sibling = temp2;
        }
        else
        {

        }
    }
    /* Function for union of nodes */
    private void unionNodes(BinomialHeapNode binHeap)
    {
        merge(binHeap);

        BinomialHeapNode prevTemp = null, temp = Nodes, nextTemp = Nodes.sibling;

        while (nextTemp != null)
        {
            if ((temp.degree != nextTemp.degree) || ((nextTemp.sibling != null) && (nextTemp.sibling.degree == temp.degree)))
            {
                prevTemp = temp;
                temp = nextTemp;
            }
            else
            {
                if (temp.key <= nextTemp.key)
                {
                    temp.sibling = nextTemp.sibling;
                    nextTemp.parent = temp;
                    nextTemp.sibling = temp.child;
                    temp.child = nextTemp;
                    temp.degree++;
                }
                else
                {
                    if (prevTemp == null)
                    {
                        Nodes = nextTemp;
                    }
                    else
                    {
                        prevTemp.sibling = nextTemp;
                    }
                    temp.parent = nextTemp;
                    temp.sibling = nextTemp.child;
                    nextTemp.child = temp;
                    nextTemp.degree++;
                    temp = nextTemp;
                }
            }
            nextTemp = temp.sibling;
        }
    }
    /* Function to return minimum key */
    public int findMinimum()
    {
        return Nodes.findMinNode().key;
    }
    /* Function to delete a particular element */
    public void delete(int value)
    {
        if ((Nodes != null) && (Nodes.findANodeWithKey(value) != null))
        {
            decreaseKeyValue(value, findMinimum() - 1);
            extractMin();
        }
    }
    /* Function to decrease key with a given value */
    public void decreaseKeyValue(int old_value, int new_value)
    {
        BinomialHeapNode temp = Nodes.findANodeWithKey(old_value);
        if (temp == null)
            return;
        temp.key = new_value;
        BinomialHeapNode tempParent = temp.parent;

        while ((tempParent != null) && (temp.key < tempParent.key))
        {
            int z = temp.key;
            temp.key = tempParent.key;
            tempParent.key = z;

            temp = tempParent;
            tempParent = tempParent.parent;
        }
    }
    /* Function to extract the node with the minimum key */
    public int extractMin()
    {
        if (Nodes == null)
            return -1;

        BinomialHeapNode temp = Nodes, prevTemp = null;
        BinomialHeapNode minNode = Nodes.findMinNode();

        while (temp.key != minNode.key)
        {
            prevTemp = temp;
            temp = temp.sibling;
        }

        if (prevTemp == null)
        {
            Nodes = temp.sibling;
        }
        else
        {
            prevTemp.sibling = temp.sibling;
        }

        temp = temp.child;
        BinomialHeapNode fakeNode = temp;

        while (temp != null)
        {
            temp.parent = null;
            temp = temp.sibling;
        }

        if ((Nodes == null) && (fakeNode == null))
        {
            size = 0;
        }
        else
        {
            if ((Nodes == null) && (fakeNode != null))
            {
                Nodes = fakeNode.reverse(null);
                size = Nodes.getSize();
            }
            else
            {
                if ((Nodes != null) && (fakeNode == null))
                {
                    size = Nodes.getSize();
                }
                else
                {
                    unionNodes(fakeNode.reverse(null));
                    size = Nodes.getSize();
                }
            }
        }

        return minNode.key;
    }

    /* Function to display heap */
    public String displayHeap()
    {
        //System.out.println(result);
        displayHeap(Nodes);
        return actualInsert;

    }
    public void displayHeap(BinomialHeapNode r)
    {
        StringBuilder result = new StringBuilder();
        if (r != null)
        {
            displayHeap(r.child);
            actualInsert += r.key +" ";
            displayHeap(r.sibling);
        }


    }
}


