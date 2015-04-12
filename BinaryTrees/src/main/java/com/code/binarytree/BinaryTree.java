package com.code.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nitinchhabra on 4/10/15.
 */
public class BinaryTree {

    private BinaryTree leftChild;
    private BinaryTree rightChild;
    private int value;

    public BinaryTree (int value)
    {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getValue()
    {
        return value;
    }

    public void setLeftChild(BinaryTree leftChild)
    {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTree rightChild)
    {
        this.rightChild = rightChild;
    }

    private Boolean getPathUtil (BinaryTree root, BinaryTree node, List<BinaryTree> pathList)
    {
        if (null == root || null == node)
            return false;

        if (node == root)
        {
            pathList.add(root);
            return true;
        }

        if (getPathUtil(root.leftChild, node, pathList) || getPathUtil(root.rightChild, node, pathList))
        {
            pathList.add(root);
            return true;
        }
        return false;
    }

    private List<BinaryTree> getPath(BinaryTree root, BinaryTree node)
    {
        List<BinaryTree> pathList = new ArrayList<BinaryTree>();
        getPathUtil (root, node, pathList);

        return pathList;
    }

    public BinaryTree findLCAUsingArrayIntersection(BinaryTree root, BinaryTree node1, BinaryTree node2)
    {
        List<BinaryTree> pathNode1 = getPath(root, node1);

        List<BinaryTree> pathNode2 = getPath(root, node2);

        BinaryTree lca = null;

        if (pathNode1.size()==0 || pathNode2.size()==0)
            return null;

        int iterator1 = pathNode1.size()-1;
        int iterator2 = pathNode2.size()-1;

        for ( ;iterator1>=0 && iterator2>=0; iterator1--, iterator2-- )
        {
            if (pathNode1.get(iterator1)!=pathNode2.get(iterator2))
            {
                /*Possible Array index out of bounds check needed */

                if (iterator1 < pathNode1.size())
                    lca = pathNode1.get(iterator1+1);
                else
                    lca = null;
                break;
            }
        }

        if (iterator1 < 0)
            lca = pathNode1.get(0);
        if (iterator2 < 0)
            lca = pathNode2.get(0);

        return lca;

    }


}


