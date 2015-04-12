package com.code.testbinarytree;
import com.code.binarytree.BinaryTree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by nitinchhabra on 4/10/15.
 */
public class TestBinaryTree
{

    @Test
    public void test1() {
        BinaryTree root = new BinaryTree(10);
        BinaryTree left1 = new BinaryTree(20);
        BinaryTree right1 = new BinaryTree(30);

        root.setLeftChild(left1);
        root.setRightChild(right1);

        BinaryTree left2 = new BinaryTree(40);
        left1.setRightChild(left2);

        BinaryTree left3 = new BinaryTree(50);
        left2.setLeftChild(left3);

        BinaryTree lca;

        lca = root.findLCAUsingArrayIntersection(root, left1, left3);

        Assert.assertTrue(lca.equals(left1));
    }

    @Test
    public void test2() {
        BinaryTree root = new BinaryTree(10);
        BinaryTree left1 = new BinaryTree(20);
        BinaryTree right1 = new BinaryTree(30);

        root.setLeftChild(left1);
        root.setRightChild(right1);

        BinaryTree left2 = new BinaryTree(40);
        left1.setRightChild(left2);

        BinaryTree left3 = new BinaryTree(50);
        left2.setLeftChild(left3);

        BinaryTree lca;

        lca = root.findLCAUsingArrayIntersection(root, null, null);
        Assert.assertTrue(lca == null);
    }


    @Test
    public void test3() {
        BinaryTree root = new BinaryTree(10);
        BinaryTree left1 = new BinaryTree(20);
        BinaryTree right1 = new BinaryTree(30);

        root.setLeftChild(left1);
        root.setRightChild(right1);

        BinaryTree left2 = new BinaryTree(40);
        left1.setRightChild(left2);

        BinaryTree left3 = new BinaryTree(50);
        left2.setLeftChild(left3);

        BinaryTree lca;

        lca = root.findLCAUsingArrayIntersection(root, root, root);

        Assert.assertTrue(lca.equals(root));

    }

}
