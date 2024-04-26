package org.example.second;

import java.util.*;

// Class for Leftist Heap
public class LeftistHeap {
    public LeftistNode root; // Root of the Leftist Heap

    // Constructor for LeftistHeap
    public LeftistHeap() {
        root = null;
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Make heap empty
    public void makeEmpty() {
        root = null;
    }

    // Insert an element into heap
    public void insert(int x) {
        root = merge(new LeftistNode(x), root);
    }

    // Delete and return the minimum element from heap
    public int deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        int minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }

    // Merge two heaps
    private LeftistNode merge(LeftistNode x, LeftistNode y) {
        if (x == null)
            return y;
        if (y == null)
            return x;
        if (x.element > y.element) {
            LeftistNode temp = x;
            x = y;
            y = temp;
        }

        x.right = merge(x.right, y);

        if (x.left == null) {
            x.left = x.right;
            x.right = null;
        } else {
            if (x.left.dist < x.right.dist) {
                LeftistNode temp = x.left;
                x.left = x.right;
                x.right = temp;
            }
            x.dist = x.right.dist + 1;
        }
        return x;
    }

    // Merge current heap with another heap
    public void merge(LeftistHeap rhs) {
        if (this == rhs)
            return;
        root = merge(root, rhs.root);
        rhs.root = null;
    }
}

