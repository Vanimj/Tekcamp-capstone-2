Object Oriented Programming Concept Questions

As you should know by now, there are 4 pillars of Object Oriented Programming.

********************
1. Encapsulation

Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates.Other way to think about encapsulation is, it is a protective shield that prevents the data from being accessed by the code outside this shield.

Technically in encapsulation, the variables or data of a class is hidden from any other class and can be accessed only through any member function of own class in which they are declared.
As in encapsulation, the data in a class is hidden from other classes using the data hiding concept which is achieved by making the members or methods of class as private and the class is exposed to the end user or the world without providing any details behind implementation using the abstraction concept, so it is also known as combination of data-hiding and abstraction..

Encapsulation can be achieved by: Declaring all the variables in the class as private and writing public methods in the class to set and get the values of variables.

// Java program to demonstrate encapsulation 
public class Encapsulate 
{ 
    // private variables declared  
    // these can only be accessed by  
    // public methods of class 
    private String geekName; 
    private int geekRoll; 
    private int geekAge; 
  
    // get method for age to access  
    // private variable geekAge 
    public int getAge()  
    { 
      return geekAge; 
    } 
   
    // get method for name to access  
    // private variable geekName 
    public String getName()  
    { 
      return geekName; 
    } 
      
    // get method for roll to access  
    // private variable geekRoll 
    public int getRoll()  
    { 
       return geekRoll; 
    } 
   
    // set method for age to access  
    // private variable geekage 
    public void setAge( int newAge) 
    { 
      geekAge = newAge; 
    } 
   
    // set method for name to access  
    // private variable geekName 
    public void setName(String newName) 
    { 
      geekName = newName; 
    } 
      
    // set method for roll to access  
    // private variable geekRoll 
    public void setRoll( int newRoll)  
    { 
      geekRoll = newRoll; 
    } 
} 
In the above program the class EncapsulateDemo is encapsulated as the variables are declared as private. The get methods like getAge() , getName() , getRoll() are set as public, these methods are used to access these variables. The setter methods like setName(), setAge(), setRoll() are also declared as public and are used to set the values of the variables.

The program to access variables of the class EncapsulateDemo is shown below:


public class TestEncapsulation 
{     
    public static void main (String[] args)  
    { 
        Encapsulate obj = new Encapsulate(); 
          
        // setting values of the variables  
        obj.setName("Harsh"); 
        obj.setAge(19); 
        obj.setRoll(51); 
          
        // Displaying values of the variables 
        System.out.println("Geek's name: " + obj.getName()); 
        System.out.println("Geek's age: " + obj.getAge()); 
        System.out.println("Geek's roll: " + obj.getRoll()); 
          
        // Direct access of geekRoll is not possible 
        // due to encapsulation 
        // System.out.println("Geek's roll: " + obj.geekName);         
    } 
} 





********************
2. Inheritance

Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object. It is an important part of OOPs (Object Oriented programming system).

The idea behind inheritance in Java is that you can create new classes that are built upon existing classes. When you inherit from an existing class, you can reuse methods and fields of the parent class. Moreover, you can add new methods and fields in your current class also.

Inheritance represents the IS-A relationship which is also known as a parent-child relationship.

Why use inheritance in java
For Method Overriding (so runtime polymorphism can be achieved).
For Code Reusability.

Terms used in Inheritance

Class: A class is a group of objects which have common properties. It is a template or blueprint from which objects are created.
Sub Class/Child Class: Subclass is a class which inherits the other class. It is also called a derived class, extended class, or child class.
Super Class/Parent Class: Superclass is the class from where a subclass inherits the features. It is also called a base class or a parent class.
Reusability: As the name specifies, reusability is a mechanism which facilitates you to reuse the fields and methods of the existing class when you create a new class. You can use the same fields and methods already defined in the previous class.

class Employee{  
 float salary=40000;  
}  
class Programmer extends Employee{  
 int bonus=10000;  
 public static void main(String args[]){  
   Programmer p=new Programmer();  
   System.out.println("Programmer salary is:"+p.salary);  
   System.out.println("Bonus of Programmer is:"+p.bonus);  
}  
} 

Types of inheritance in java

1. Single
2. Multilevel
3. Hierarchical
4. Multiple
5. Hybrid 





********************
3. Abstraction

Abstraction in Java is a process of hiding the implementation details and showing only functionality to the user.Another way, it shows only essential things to the user and hides the internal details, 

for example:  sending SMS where you type the text and send the message. You don't know the internal processing about the message delivery.

Abstraction lets you focus on what the object does instead of how it does it.

Ways to achieve Abstraction
There are two ways to achieve abstraction in java

Abstract class (0 to 100%)
Interface (100%)

Abstract class in Java
A class which is declared as abstract is known as an abstract class. It can have abstract and non-abstract methods. It needs to be extended and its method implemented. It cannot be instantiated.

Points to Remember
An abstract class must be declared with an abstract keyword.
It can have abstract and non-abstract methods.
It cannot be instantiated.
It can have constructors and static methods also.
It can have final methods which will force the subclass not to change the body of the method.

abstract class Bike{  
  abstract void run();  
}  
class Honda4 extends Bike{  
void run(){System.out.println("running safely");}  
public static void main(String args[]){  
 Bike obj = new Honda4();  
 obj.run();  
}  
}



********************
4. Polymorphism
   

The word polymorphism means having many forms. In simple words, we can define polymorphism as the ability of a message to be displayed in more than one form.

Real life example of polymorphism: A person at the same time can have different characteristic. Like a man at the same time is a father, a husband, an employee. So the same person posses different behaviour in different situations. This is called polymorphism.

Polymorphism is considered as one of the important features of Object Oriented Programming. Polymorphism allows us to perform a single action in different ways. In other words, polymorphism allows you to define one interface and have multiple implementations. The word “poly” means many and “morphs” means forms, So it means many forms.

In Java polymorphism is mainly divided into two types:

Compile time Polymorphism
Runtime Polymorphism

Compile time polymorphism: 

It is also known as static polymorphism. This type of polymorphism is achieved by function overloading or operator overloading.

Method Overloading: When there are multiple functions with same name but different parameters then these functions are said to be overloaded. Functions can be overloaded by change in number of arguments or/and change in type of arguments.
Example: By using different types of arguments

// Java program for Method overloading 
  
class MultiplyFun { 
  
    // Method with 2 parameter 
    static int Multiply(int a, int b) 
    { 
        return a * b; 
    } 
  
    // Method with the same name but 2 double parameter 
    static double Multiply(double a, double b) 
    { 
        return a * b; 
    } 
} 
  
class Main { 
    public static void main(String[] args) 
    { 
  
        System.out.println(MultiplyFun.Multiply(2, 4)); 
  
        System.out.println(MultiplyFun.Multiply(5.5, 6.3)); 
    } 


Runtime polymorphism:

 It is also known as Dynamic Method Dispatch. It is a process in which a function call to the overridden method is resolved at Runtime. This type of polymorphism is achieved by Method Overriding.
Method overriding, on the other hand, occurs when a derived class has a definition for one of the member functions of the base class. That base function is said to be overridden.
Example:

// Java program for Method overridding 
  
class Parent { 
  
    void Print() 
    { 
        System.out.println("parent class"); 
    } 
} 
  
class subclass1 extends Parent { 
  
    void Print() 
    { 
        System.out.println("subclass1"); 
    } 
} 
  
class subclass2 extends Parent { 
  
    void Print() 
    { 
        System.out.println("subclass2"); 
    } 
} 
  
class TestPolymorphism3 { 
    public static void main(String[] args) 
    { 
  
        Parent a; 
  
        a = new subclass1(); 
        a.Print(); 
  
        a = new subclass2(); 
        a.Print(); 
    } 
} 





Please write 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  



