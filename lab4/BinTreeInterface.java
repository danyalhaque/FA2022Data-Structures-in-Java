package lab4;

// interface for a binary tree class
//
// the tree is unbounded. fields are
//     info: the value stored in the node (generic type)
//     left:   pointer to the left subtree
//     right:  pointer to the right subtree
//     parent: pointer to the parent
//
// left, right, and parent are public to allow the client code
// to manipulate the tree as needed
//

public interface BinTreeInterface<T> {

// return the info field stored in the tree
    public T getInfo();

// set the info field to the value given in the parm
    public void setInfo(T newitem);

// attach the parm as the left subtree; throw TreeViolationException if
// there is already a left subtree
    public void attachLeft(BinTree<T> tree);

// attach the parm as the right subtree; throw TreeViolationException if
// there is already a right subtree
    public void attachRight(BinTree<T> tree);

// remove the left subtree and return it
    public BinTree<T> detachLeft();

// remove the right subtree and return it
    public BinTree<T> detachRight();

// return the root of the tree
    public BinTree<T> root();
    
// return true if the tree is empty, false otherwise
    public boolean isEmpty();

// create queue of tree nodes in preorder
    public void preOrder(BinTree<T> tree);

// call preorder to create queue of nodes in the tree
    public void reset();

// remove and return the next node in the preorder queue
// return null if the queue is empty
    public T getNext();

}


