# Simple binary search tree implementation.

This project is just a simple implementation of a binary search tree.

My implementation of a binary search tree impelements a couple of iterators to iterate the tree in pre-, post- and in- order traversal.

```
Note! In order to impelement these iterators a queue was impemented-
for the simple reason that a binary search tree node doesn't know about it's parent.
```

Methods available:

| Method Name |                                                                |
| ----------- | -------------------------------------------------------------- |
| `GetRoot`   | Returns the root node of the tree.                             |
| `size`      | Returns the size of the tree.                                  |
| `height`    | Returns the height of the tree;                                |
| `remove`    | Removes a sspecific node from the tree                         |
| `removeKth` | R removes the kth largest node from the tree.                  |
| `contains`  | Returns the size of the tree.                                  |
| `size`      | Rreturns true / false if node exists/doesnt exist in the tree. |

| Iterators           |                                           |
| ------------------- | ----------------------------------------- |
| `InOrderIterator`   | Traverse the tree in order traversal.     |
| `preOrderIterator`  | Traverse the node in preorder traversal.  |
| `PostOrderIterator` | Traverse the tree in postorder traversal. |
