package org.example.second;

// Node class for Leftist Heap
public class LeftistNode {
    int element, dist; // Node elements and distance
    LeftistNode left, right; // Left and right child of a node

    // Constructor for LeftistNode
    public LeftistNode(int element) {
        this(element, null, null);
    }

    // Constructor for LeftistNode
    public LeftistNode(int element, LeftistNode left, LeftistNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.dist = 0;
    }

    public int getElement() {
        return element;
    }
}
