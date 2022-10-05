# Simple binary search tree implementation.

This project is just a simple implementation of a binary search tree.

My implementation of a binary search tree impelements a couple of iterators to iterate the tree in pre-, post- and in- order traversal.

```
Note! In order to impelement these iterators a queue was impemented since
a binary search tree node doesn't know about their parent nodes.
```

Methods available:

| Method Name |                                                                 |
| ----------- | --------------------------------------------------------------- |
| `getRoot`   | Returns the root node of the tree.                              |
| `size`      | Returns the size of the tree.                                   |
| `height`    | Returns the height of the tree.                                 |
| `remove`    | Removes a specific node from the tree                           |
| `removeKth` | Removes the kth largest node from the tree.                     |
| `contains`  | Rreturns true / false if node exists/doesn't exist in the tree. |

| Iterators           |                                           |
| ------------------- | ----------------------------------------- |
| `InOrderIterator`   | Traverse the tree in order traversal.     |
| `preOrderIterator`  | Traverse the node in preorder traversal.  |
| `PostOrderIterator` | Traverse the tree in postorder traversal. |

### Example use:

```Java
    Binary_search_tree bst = new Binary_search_tree();

        bst.add(4);
        bst.add(2);
        bst.add(6);
        bst.add(5);
        bst.add(9);
        bst.add(7);
        bst.add(11);

       Iterator<BSTNode> i = bst.postOrdIterator();

        while (i.hasNext())
            System.out.println(i.next().key);

    // Prints out => 5 7 11 9 6 4


```
