package com.code.testbinarytree;

import com.code.binarytree.BinaryTreeWithParent;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nitinchhabra on 4/10/15.
 */
public class TestBinaryTreeWithParent {
    @Test
    public void test1()
    {
        BinaryTreeWithParent tree = new BinaryTreeWithParent(10);
        BinaryTreeWithParent left = new BinaryTreeWithParent(20);
        BinaryTreeWithParent right = new BinaryTreeWithParent(30);

        tree.setLeftChild(left);
        tree.setRightChild(right);
        left.setParent(tree);
        right.setParent(tree);

        BinaryTreeWithParent lca = tree.lowestCommonAncestor(left,right);
        Assert.assertTrue(lca.equals(tree));
    }

    @Test
    public void test2()
    {
        BinaryTreeWithParent tree = new BinaryTreeWithParent(10);
        BinaryTreeWithParent lca = tree.lowestCommonAncestor(null,null);
        Assert.assertTrue(lca==null);
    }

    @Test
    public void test3()
    {
        BinaryTreeWithParent tree = new BinaryTreeWithParent(10);
        BinaryTreeWithParent left = new BinaryTreeWithParent(20);
        BinaryTreeWithParent right = new BinaryTreeWithParent(30);

        tree.setLeftChild(left);
        tree.setRightChild(right);
        left.setParent(tree);
        right.setParent(tree);

        BinaryTreeWithParent right1 = new BinaryTreeWithParent(40);
        right.setRightChild(right1);
        right1.setParent(right);

        BinaryTreeWithParent right2 = new BinaryTreeWithParent(50);
        right2.setParent(right1);
        right1.setLeftChild(right2);

        BinaryTreeWithParent.printTree(tree);
        BinaryTreeWithParent lca = tree.lowestCommonAncestor(right1,right2);
        Assert.assertTrue(lca.equals(right1));

    }

}
