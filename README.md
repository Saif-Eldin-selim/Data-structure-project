Details:
Points:

Each point is represented by x and y coordinates.
Points include a function to calculate the magnitude (distance or strength) from the origin point (0, 0).

Supported Operations:
Addition and Deletion:

Add a new point to the end of the list or at a specific position.
Delete a specific point or delete a point at a specific position.
Prevent adding duplicate points.
Search and Retrieval:

Search for a specific point.
Get the location of the first or last occurrence of a specific point.
Retrieve a point from a specific position.
Sorting:

Sort points based on their distance from the origin.
Capacity Management:

Set a maximum capacity for the container with the ability to dynamically increase it.
Helper Methods:

Get the number of stored points.
Provide a tool for navigating through the points (Iterator).
Custom Exceptions:
PointNotFoundException: Thrown when a point to be deleted is not found.
EmptyContainerException: Thrown if the container is empty during an operation that requires points.
CapacityExceededException: Thrown when attempting to add points exceeding the maximum capacity.
UnsupportedOperationException: Thrown if trying to increase the capacity of an unlimited container.
IndexOutOfBoundsException: Thrown when trying to access an invalid position.
Technical Implementation:
The program relies on a LinkedList to store the points.

Provides two constructors:

A container with no specific capacity.
A container with a specified capacity.
Implements a generic interface (ContainerOps) to ensure all required functionalities are met.

Project Goals:
Learn how to manage dynamic structures.
Understand how to handle errors using exceptions.
Develop flexible code that is easy to modify and extend.
How the Iterator Works:
The Iterator allows you to navigate using three main operations:

hasNext():

Checks if there is a next element in the collection.
Returns true if there is an upcoming element.
next():

Moves to the next element and retrieves it.