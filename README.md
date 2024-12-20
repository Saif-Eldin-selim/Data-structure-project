# Data-structure-project
 Point Data Container Operations
Introduction to Data Structures
 Point Data Container Operations
 Project Description
 Problem Description
 You are tasked with implementing a Java class, PointsContainer, that represents a container for storing points of
 a specific data type in a linked list-based structure. The class should support various operations, including search,
 insert, delete, add, and sort (based on point magnitude). Additionally, it should handle errors gracefully using custom
 exceptions.
 Class Definition
 Your task is to implement the PointsContainer class with the following specifications:– The class should use a linked list data structure to store points, where each point is of a specific data type.– The class should provide the following public methods, grouped by their operation type:– Constructors:– PointsContainer(): No-argument constructor that initializes an empty linked list with no bound on
 capacity.– PointsContainer(int capacity): Constructor that initializes an empty linked list with a specified max
imum capacity.– Insertion and Deletion:– void insert(Point point, int index): Methodtoinsertapointataspecifiedindex in the container. If
 the index is invalid or if the container has reached its maximum capacity, throw a CapacityExceededException.– void delete(Point point): Method to delete a point from the container. If the point is not found,
 throw a PointNotFoundException.– Point deleteAt(int index): Method to delete a point at a specified position in the container. If the
 index is invalid, throw a IndexOutOfBoundsException. If the point is successfully deleted, it should return
 the deleted point.– void add(Point point): Method to add a point to the end of the container. If the container has reached
 its maximum capacity, throw a CapacityExceededException. This method should ensure that duplicate
 points are not added.– Search and Retrieval:– boolean search(Point point): Method that searches for the presence of a given point within the con
tainer. It should return true if the point exists and false otherwise.– int indexOf(Point point): Method to find the index of a given point in the container. If the point is
 not found, return-1.– int lastIndexOf(Point point): Method to find the last index of a given point in the container. If the
 point is not found, return-1.– Point get(int index): Method to retrieve the point at a specified index in the container. If the index
 is invalid, throw a IndexOutOfBoundsException.
 1
– Sorting and Capacity Management:– void sort(): Method to sort the points in the container in ascending order based on their magnitude
 (distance from the origin). If the container is empty, throw a EmptyContainerException.– void growCapacity(int newCapacity): Method to grow the capacity of the container dynamically if
 needed. This should only be used if the container was initialized with a specified capacity; otherwise, it
 throws an UnsupportedOperationException exception.– Utility Methods:– int size(): Method to return the number of points currently in the container.– Iterator<Point> iterator(): Bonus method to return an iterator for traversing the points in the con
tainer.
 Additional Specifications– Define in Point data type appropriate methods for calculating magnitude and comparison.– Ensure the linked list implementation supports dynamic resizing.– Customexceptions such as PointNotFoundException, EmptyContainerException, CapacityExceededException,
 UnsupportedOperationException, and IndexOutOfBoundsException should be implemented to handle error
 scenarios.– You are required to implement the attached ContainerOps interface and ensure that the PointsContainer class
 conforms to this interface. The interface defines a set of operations that must be implemented for the container
 to function correctly.
 2
import java.util.Iterator;
 /**
 * Ageneric interface for managing a container of elements with various
 * operations
 * such as insertion, deletion, searching, and sorting.
 *
 * @param <Type> the type of elements maintained by this container.
 */
 public interface ContainerOps<Type>{
 /**
 * Inserts the specified element at the specified position in this container.
 *
 * @param element the element to insert.
 * @param index the position at which the element is to be inserted.
 * @throws IndexOutOfBoundsException if the index is out of range.
 * @throws CapacityExceededException if the container has reached its maximum
 *
 capacity.
 */
 void insert(Type element, int index);
 /**
 * Deletes the specified element from this container.
 *
 * @param element the element to be deleted.
 * @throws EmptyContainerException if the container is empty.
 */
 void delete(Type element);
 /**
 * Deletes the element at the specified position in this container and returns
 * it.
 *
 * @param index the index of the element to delete.
 * @return the element previously at the specified position.
 * @throws IndexOutOfBoundsException if the index is out of range.
 * @throws EmptyContainerException if the container is empty.
 */
 Type deleteAt(int index);
 /**
 * Adds the specified element to the end of this container.
 *
 * @param element the element to be added.
 * @throws CapacityExceededException. if the container has reached its maximum
 *
 capacity.
 */
 void add(Type element);
 1
/**
 * Searches for the specified element in this container.
 *
 * @param element the element to search for.
 * @return {@code true} if the container contains the specified element,
 *
 {@code false} otherwise.
 */
 boolean search(Type element);
 /**
 * Returns the index of the first occurrence of the specified element in this
 * container.
 *
 * @param element the element to search for.
 * @return the index of the first occurrence of the specified element, or
 *
 {@code −1} if not found.
 */
 int indexOf(Type element);
 /**
 * Returns the index of the last occurrence of the specified element in this
 * container.
 *
 * @param element the element to search for.
 * @return the index of the last occurrence of the specified element, or
 *
 {@code −1} if not found.
 */
 int lastIndexOf(Type element);
 /**
 * Returns the element at the specified position in this container.
 *
 * @param index the index of the element to return.
 * @return the element at the specified position.
 * @throws IndexOutOfBoundsException if the index is out of range.
 */
 Type get(int index);
 /**
 * Sorts the elements in this container in ascending order.
 * @throws EmptyContainerException if the container is empty.
 */
 void sort();
 /**
 * Grows the capacity of this container to the specified value.
 * This method is only applicable if the container is initialized with a fixed
 * capacity.
 *
 * @param newCapacity the new capacity of the container.
 * @throws UnsupportedOperationException if the container does not have a fixed
 2
*
 */
 void growCapacity(int newCapacity);
 /**
 capacity.
 * Returns the number of elements in this container.
 *
 * @return the size of the container.
 */
 int size();
 /**
 * Returns an iterator over the elements in this container.
 *
 * @return an {@code Iterator} over the elements in this container.
 */
 Iterator<Type> iterator();
 }
