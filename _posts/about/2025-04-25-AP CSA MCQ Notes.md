---
title: AP CSA MCQ Notes
categories: [AP]
tags: [CSA]
datacamp: 1
maths: 1
toc: 1
---

{% include toc.html %}

## Object-Oriented Concepts  

- **Class**: blueprint (defines attributes + methods)  
- **Object**: specific instance of a class in memory  
- **extends** keyword: subclass inherits from superclass (“is-a” relationship)  
- Constructors aren’t inherited. If you don’t call `super(...)`, Java inserts an implicit no-arg `super()`.  
- **Abstract classes** vs concrete classes  
- **Composition** (“has-a”): Class A holds a reference to class B as an instance variable  
- **Encapsulation** via access modifiers:  
  - `public`: anywhere  
  - `private`: only within declaring class  
- **Accessor** (getter) vs **Mutator** (setter) methods  
- `static` vs instance members: static belong to the class (no `this`), instances each have their own fields  
- Use `this(...)` to chain constructors; `super(...)` to call superclass constructor  

## Polymorphism & Binding  

{% highlight java linenos %}
public class Animal
{
  // ... some instance var/method

  public void static speak()
  {
      System.out.println("Hello");
  }
}

public class Dog extends Animal // Dog is subclass of Animal
{
  //...

  @Override
  public void static speak()
  {
    System.out.println("Hi");
  }
  
  public void static bark()
  {
    System.out.println("Woof!");
  }
}
{% endhighlight %}
- **Polymorphism**: treat subclass objects as instances of their superclass  
  {% highlight java linenos %}
  Animal myDog = new Dog();  // upcasting
  {% endhighlight %}
- **Upcasting** (automatic): subclass → superclass reference
  {% highlight java linenos %}
  if (myDog instanceof Dog) {
    Dog yourDog = (Dog) myDog;
}
{% endhighlight %}
- **Downcasting (manual)**: superclass reference → subclass
- **Static binding (compile-time):** method calls resolved by reference type
Example:
{% highlight java linenos %}
myDog.bark(); //returns error because compiler uses the Animal (reference) type as reference
{% endhighlight %}
- **Dynamic binding (runtime):** JVM chooses the overriding method in the actual object
Example:
{% highlight java linenos %}
myDog.speak(); //prints "Hi"
{% endhighlight %}

## Memory, Aliasing & `new`  

- `new` allocates objects on the heap; heap exhaustion → `OutOfMemoryError`  
- Primitives are passed by value; object references are passed by value (copy of pointer)  
- **Aliasing**: two references point to the same object/array → mutations via one reflect in the other  
- Primitives and their wrappers aren’t aliased (you get copies)

## Arrays & ArrayLists  

### Arrays  
- Fixed size; can hold primitives or objects  
- Defaults: numeric → `0`, boolean → `false`, reference → `null`  
- 2D/3D arrays: `arr.length` gives size of the first (outer) dimension only  
- Accessing outside `0 … length-1` → `IndexOutOfBoundsException`  

### ArrayList  
- Dynamic resizing (`java.util.ArrayList`)  
- `add(item)` appends (returns `true` for `ArrayList`)  
- `add(index, item)` inserts at position (no negative index allowed)  
- `remove(index)` or `remove(object)`  
- Other methods: `size()`, `get(i)`, `set(i, item)`  

## Loops & Control  

- **Enhanced for-loop**:
{% highlight java linenos %}
  for (Integer num : list) {
      // num is a copy; reassigning num does NOT change the list
  }
{% endhighlight %}
- Mutating the list inside this loop → ConcurrentModificationException
- **Standard loops**: for, while, do-while
- Single-statement loops may omit {}
- Beware off-by-one errors in loop bounds
- Operator precedence: ! > && > || (all short-circuit)
Short-circuit means the conditional terminates once the evaluation of the condition is determined. 
Example:
{% highlight java linenos %}
if (a > b && b < c) // if a < b, terminates since regardless of the output of b < c, the condition is false
{% endhighlight %}
- if / else if / else chains for branching

## Exceptions & Errors  

- **NullPointerException**: calling a method or accessing a field on a `null` reference  
- **IndexOutOfBoundsException**: accessing an array or list with an illegal index  
- **ConcurrentModificationException**: mutating a collection during an enhanced-for traversal  
- **StackOverflowError**: too-deep recursion or excessively large call stack  
- **OutOfMemoryError**: heap exhausted (e.g., infinite object creation)  

## Strings & Wrappers  

- **String methods**:  
  - `s.length()` vs. `arr.length` for arrays  
  - `s.substring(from, to)` returns characters `from` … `to-1`; omit `to` to go to end  
  - `s.indexOf(str)` returns first index or `-1` if not found  
  - `s.compareTo(other)` returns `<0`, `0`, or `>0`  
  - `s.equals(other)` for content equality  
- **Wrapper classes**: `Integer`, `Double`, etc.  
  - **Autoboxing**: primitive → wrapper automatically (e.g., `int` → `Integer`)  
  - **Unboxing**: wrapper → primitive when needed  
  - `intValue()`, `doubleValue()`, etc., to extract primitive  

## Math & Operators  

- Arithmetic: `+`, `-`, `*`, `/`, `%` (modulo)  
- **Rounding** for positives: `(int)(x + 0.5)`; negatives truncate toward zero (e.g., `(int)-5.5` → `-5`)  
- **Math** utility methods:  
  - `Math.abs(x)`  
  - `Math.pow(base, exponent)`  
  - `Math.sqrt(x)`  
  - `Math.random()` returns `0.0 ≤ x < 1.0`  

## Algorithms & Complexity  

- **Common tasks**:  
  - Find min/max  
  - Compute sum, average, mode  
  - Check if any/all elements satisfy a property  
  - Access consecutive pairs  
  - Detect duplicates  
  - Count elements meeting criteria  
- **Sorting**:  
  - **Selection sort**: O(n²) in all cases  
  - **Insertion sort**: O(n²) worst, O(n) best  
- **Searching**:  
  - **Binary search** on sorted data: O(log n); maximum comparisons = ⌊log₂n⌋ + 1  
- **Array transforms**: reverse (mirror), rotate (e.g., 90° matrix rotation)  
- **Mutating during traversal**: if removing in a classic `for (i=0; i<…; i++)`, decrement `i` after removal  

## Recursion  

- Must include:  
  - **Base case** (stops recursion)  
  - **Recursive step** (reduces problem)  
  - **Termination guarantee** (eventually hits base case)  
- Common examples: factorial, Fibonacci, divide-and-conquer on arrays/lists  

## Methods & Signatures  

- **Signature** = method name + parameter list  
- **Overloading**: multiple methods/constructors with same name, different parameters  
- **Overriding**: subclass provides implementation for superclass method (same signature + compatible return type)  
- All parameters are passed by **value** (even object references)  
- Return type must match signature  

## Additional Tips  

- Use `instanceof` before downcasting to avoid `ClassCastException`  
- Mark constants/methods/classes with `final` to prevent modification/overriding/extension  
- Practice **encapsulation**: keep fields private, expose public getters/setters  
- Use **interfaces** for loose coupling and multiple “type” inheritance  
- Always consider **time complexity** (Big-O) when writing FRQ algorithms  
- In FRQs: state pre/post conditions, loop invariants; for recursion, sketch the call tree or stack frames  
