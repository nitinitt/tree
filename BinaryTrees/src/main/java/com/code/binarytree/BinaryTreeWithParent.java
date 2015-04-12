package com.code.binarytree;

/**
 * Created by nitinchhabra on 4/10/15.
 */
public class BinaryTreeWithParent {
    private BinaryTreeWithParent leftChild;
    private BinaryTreeWithParent rightChild;
    private BinaryTreeWithParent parent;
    private int value;

    public BinaryTreeWithParent (int value)
    {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public BinaryTreeWithParent getLeftChild()
    {
        return leftChild;
    }

    public BinaryTreeWithParent getParent()
    {
        return parent;
    }

    public BinaryTreeWithParent getRightChild()
    {
        return rightChild;
    }

    public void setLeftChild(BinaryTreeWithParent leftChild)
    {
        this.leftChild = leftChild;
    }

    public void setParent(BinaryTreeWithParent parent)
    {
        this.parent = parent;
    }

    public void setRightChild(BinaryTreeWithParent rightChild)
    {
        this.rightChild = rightChild;
    }

    public static void printTree(BinaryTreeWithParent node)
    {
        if (null!=node)
        {
            printTree(node.leftChild);
            System.out.println(node.value);
            printTree(node.rightChild);
        }
    }

    public BinaryTreeWithParent lowestCommonAncestor (BinaryTreeWithParent node1, BinaryTreeWithParent node2)
    {
        BinaryTreeWithParent tempNode;
        tempNode = node1;
        int height1 = 0;
        int height2 = 0;

        while (null!=tempNode)
        {
            tempNode=tempNode.parent;
            height1++;
        }

        tempNode = node2;
        while (null!=tempNode)
        {
            tempNode=tempNode.parent;
            height2++;
        }

        if (height1 > height2)
        {
            for (int i=0; i<(height1 - height2); i++ )
                node1 = node1.parent;
        }
        else
        {
            for (int i=0; i<(height2 - height1); i++ )
                node2 = node2.parent;
        }

        while(node1!=node2)
        {
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return node1;
    }
}
