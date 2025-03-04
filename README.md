<h1>Overview</h1>
This java project was for my second year Computing Data Structures module. The project was about using my own LinkedList data structure, with my own versions of the java LinkedList methods. There is no program associated with this project, instead, a series of JUnit tests.
<br>
<h1>Details</h1>
<h2>Object Classes</h2>
<h3>Song</h3>
A wrapper class for holding two attributes: String artist, String title, as well as getters/setters for both attributes. Song also has an overridden equals() & hashCode() method for helping with finding duplicates.
<br>
<h3>LinkedList</h3>
My LinkedList stores object instances of type Song that are wrapped in a LinkedList sub-class Node that contains three attributes for storing a Song data & referencing the Node prev & Node next nodes in the LinkedList. LinkedList has two attributes: Node first & Node last for referencing the first & last Node objects in LinkedList.
