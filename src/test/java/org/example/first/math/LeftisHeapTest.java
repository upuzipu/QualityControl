package org.example.first.math;

import org.example.second.LeftistHeap;
import org.example.second.LeftistNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LeftistHeapTest {
    private LeftistHeap heap;

    @BeforeEach
    void setUp() {
        heap = new LeftistHeap();
    }

    @Test
    void testInsertAndDeleteMin() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        assertEquals(3, heap.deleteMin());
        assertEquals(5, heap.deleteMin());
        assertEquals(7, heap.deleteMin());
        assertThrows(NoSuchElementException.class, heap::deleteMin);
    }

    @Test
    void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.insert(1);
        assertFalse(heap.isEmpty());
        heap.deleteMin();
        assertTrue(heap.isEmpty());
    }

    @Test
    void testMakeEmpty() {
        heap.insert(1);
        heap.insert(2);
        assertFalse(heap.isEmpty());
        heap.makeEmpty();
        assertTrue(heap.isEmpty());
    }

    @Test
    void testMerge() {
        LeftistHeap heap1 = new LeftistHeap();
        LeftistHeap heap2 = new LeftistHeap();

        heap1.insert(1);
        heap1.insert(2);
        heap2.insert(3);
        heap2.insert(4);

        heap1.merge(heap2);

        assertTrue(heap2.isEmpty());
        assertEquals(1, heap1.deleteMin());
        assertEquals(2, heap1.deleteMin());
        assertEquals(3, heap1.deleteMin());
        assertEquals(4, heap1.deleteMin());
        assertThrows(NoSuchElementException.class, heap1::deleteMin);
    }

    @Test
    void testMergeRhs() {
        LeftistHeap heap1 = new LeftistHeap();
        LeftistHeap heap2 = heap1;

        heap1.insert(1);
        heap1.insert(2);
        heap1.insert(3);

        LeftistNode rootBeforeMerge = heap1.root;

        heap1.merge(heap2);
        assertEquals(rootBeforeMerge, heap1.root);
    }

    @Test
    void testPrivateMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LeftistNode node1 = new LeftistNode(1);
        LeftistNode node2 = new LeftistNode(2);
        Method method = LeftistHeap.class.getDeclaredMethod("merge", LeftistNode.class, LeftistNode.class);
        method.setAccessible(true);
        LeftistNode result = (LeftistNode) method.invoke(heap, node1, node2);
        assertEquals(1, result.getElement());
    }

}