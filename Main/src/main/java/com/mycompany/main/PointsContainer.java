/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Iterator;
import exceptions.*;
import java.util.NoSuchElementException;



/**
 *
 * @author saif
 */



public class PointsContainer implements ContainerOps<Point> {
    private Node head;
    private int size;
    private int capacity;

    // Constructors
    public PointsContainer() {
        this.head = null;
        this.size = 0;
        this.capacity = Integer.MAX_VALUE; // No capacity limit
    }

    public PointsContainer(int capacity) {
        this.head = null;
        this.size = 0;
        this.capacity = capacity;
    }

@Override
    public void insert(Point point, int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size >= capacity) throw new CapacityExceededException("");

        Node newNode = new Node(point);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public void delete(Point point) {
        if (head == null) throw new EmptyContainerException("");

        Iterator<Point> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(point)) {
                remove(point);
                return;
            }
        }
        throw new PointNotFoundException("");
    }

    @Override
    public Point deleteAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (head == null) throw new EmptyContainerException("");

        Node current = head;
        if (index == 0) {
            head = current.next;
            size--;
            return current.data;
        }

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node toDelete = current.next;
        current.next = toDelete.next;
        size--;

        return toDelete.data;
    }

    @Override
    public void add(Point point) {
        if (size >= capacity) throw new CapacityExceededException("");

        Node newNode = new Node(point);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    @Override
    public boolean search(Point point) {
        Iterator<Point> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(point)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Point point) {
        int index = 0;
        Iterator<Point> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(point)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Point point) {
        int lastIndex = -1;
        int index = 0;
        Iterator<Point> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(point)) {
                lastIndex = index;
            }
            index++;
        }
        return lastIndex;
    }

    @Override
    public Point get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public void sort() {
        if (size == 0) throw new EmptyContainerException("");

        Point[] points = new Point[size];
        int index = 0;

        Iterator<Point> it = iterator();
        while (it.hasNext()) {
            points[index++] = it.next();
        }

        // Sort based on magnitude (distance from the origin)
        java.util.Arrays.sort(points, (a, b) -> Double.compare(a.magnitude(), b.magnitude()));

        // Rebuild the linked list with sorted points
        head = null;
        size = 0;
        for (Point point : points) {
            add(point);
        }
    }

    @Override
    public void growCapacity(int newCapacity) {
        if (capacity == Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Cannot grow capacity on an unbounded container.");
        }
        if (newCapacity <= capacity) {
            throw new IllegalArgumentException("New capacity must be greater than the current capacity.");
        }
        capacity = newCapacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Point next() {
                if (!hasNext()) throw new NoSuchElementException("");
                Point point = current.data;
                current = current.next;
                return point;
            }
        };
    }

    private void remove(Point point) {
        if (head == null) throw new EmptyContainerException("");

        if (head.data.equals(point)) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(point)) {
            current = current.next;
        }

        if (current.next == null) {
            throw new PointNotFoundException("");
        }

        current.next = current.next.next;
        size--;
    }
}