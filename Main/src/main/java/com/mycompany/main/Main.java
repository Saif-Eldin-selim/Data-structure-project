/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.util.Iterator;

/**
 *
 * @author saif
 */
public class Main {
    public static void main(String[] args) {
        // Create PointsContainer with a capacity limit of 5
        PointsContainer container = new PointsContainer(5);

        // Create some Points (assuming a Point class exists)
        Point p1 = new Point(3, 4); // Example Point with coordinates (3, 4)
        Point p2 = new Point(1, 1); // Example Point with coordinates (1, 1)
        Point p3 = new Point(5, 12); // Example Point with coordinates (5, 12)

        // Add points to the container
        container.add(p1);
        container.add(p2);
        container.add(p3);

        // Insert a point at a specific index
        Point p4 = new Point(0, 0);
        container.insert(p4, 1); // Insert at index 1
Iterator<Point> iterator = container.iterator();

        while (iterator.hasNext()) {
            Point point = iterator.next();
            System.out.println("Point: (" + point.getX() + ", " + point.getY() + "), Magnitude: " + point.magnitude());
        }
        // Search for a point
        boolean found = container.search(p1);
        System.out.println("Found p1: " + found);

        // Get index of a point
        int index = container.indexOf(p2);
        System.out.println("Index of p2: " + index);

        // Get last index of a point
        int lastIndex = container.lastIndexOf(p2);
        System.out.println("Last index of p2: " + lastIndex);

        // Get a point at a specific index
        Point pointAtIndex = container.get(2);
        System.out.println("Point at index 2: " + pointAtIndex);

        // Delete a point by value
        container.delete(p3); // Removes p3 from the container
        System.out.println("Deleted p3");

        // Delete a point at a specific index
        Point deletedPoint = container.deleteAt(1); // Removes the point at index 1
        System.out.println("Deleted point at index 1: " + deletedPoint);

        // Sort the points based on their magnitude (distance from origin)
        container.sort();
        System.out.println("Points after sorting:");

        
        
        // Iterate through the container and print points
      //  for (Point point : container) {
        //    System.out.println(point);
        //}

        // Grow the capacity of the container
        container.growCapacity(10); // Increase the capacity to 10
        System.out.println("Capacity increased.");

        // Get the size of the container
        int size = container.size();
        System.out.println("Container size: " + size);
    }
}

