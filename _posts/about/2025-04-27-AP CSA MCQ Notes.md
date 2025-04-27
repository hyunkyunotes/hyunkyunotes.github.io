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
e.g. a Person object
- **extends** keyword: subclass inherits from superclass (“is-a” relationship)  
- Constructors aren’t inherited. If you don’t call `super(...)`, Java inserts an implicit no-arg `super()`.  
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

  @Override //Not strictly required but improves readability
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

- Primitives are passed by value; object references are passed by value (copy of pointer)  
### Example
{% highlight java linenos %}
int x = 10;
int y = x;
System.out.print(y); //prints 10
int x+= 5;
System.out.print(y); //still prints 10 because y is assigned the value of x, not x itself
{% endhighlight %}
- **Aliasing**: two references point to the same object/array → mutations via one reflect in the other  
### Example
{% highlight java linenos %}
int[] arr1 = new int[5];
// Initialize arr1
for (int i = 0; i < 5; i++)
{
  arr1[i] = i; 
}
int[] arr2 = arr1; // Assigns reference of arr1 to arr2, i.e. assigns arr1 to arr2 not just value
System.out.print(arr2[0]); //prints 0
arr1[0] = 20;
System.out.print(arr2[0]); //prints 20
{% endhighlight %}

## Arrays & ArrayLists  

### Arrays  
- Fixed size; can hold primitives or objects (user-defined classes)
- Defaults: numeric → `0`, boolean → `false`, reference → `null`  
- 2D arrays: `arr.length` gives number of rows, `arr[0].length` gives number of columns.
- Accessing outside `0 … length-1` → `IndexOutOfBoundsException`  

### ArrayList  
- Dynamic resizing, flexible size
- `add(item)` appends (returns `true`)
- `add(index, item)` inserts at position (no negative index allowed, no return)  
- `remove(index)` or `remove(object)`  
- Other methods: `size()`, `get(i)`, `set(i, item)`  

## Loops & Control  

- **Enhanced for-loop**:
{% highlight java linenos %}
  for (Integer num : list) {
      // num is a copy; reassigning num does NOT change the list
  }
{% endhighlight %}
- Mutating the list inside this loop → `ConcurrentModificationException`
- **Standard loops**: for, while
- Single-statement loops may omit {}
### Example
{% highlight java linenos %}
if (a > b)
  System.out.print(a); //Prints only when a > b
{% endhighlight %}
But
{% highlight java linenos %}
if (a>b)
  a++; //increments only when a > b
  System.out.print(a); //prints regardless of whether a > b
{% endhighlight %}
- Beware off-by-one errors in loop bounds
- Operator precedence: `! > && > ||` (all short-circuit)

Short-circuit means the conditional terminates once the evaluation of the condition is determined. 
Example:
{% highlight java linenos %}
if (a > b && b < c) // if a < b, terminates since regardless of the output of b < c, the condition is false
{% endhighlight %}

## Exceptions & Errors  

- **NullPointerException**: calling a method or accessing a field on a `null` reference  
- **IndexOutOfBoundsException**: accessing an array or list with an illegal index  
- **ConcurrentModificationException**: mutating a collection during an enhanced-for traversal 
### Example
{% highlight java linenos %}
ArrayList<Integer> arr = new ArrayList<Integer>();
for (Integer num : arr) {
    arr.remove(num);
    }
  {% endhighlight %}
**Remark** This exception only happens for arraylist, not arrays.
- **StackOverflowError**: too-deep recursion or excessively large call stack. This occurs when a recursive function will not terminate.
### Example
{% highlight java linenos %}
public int errorFunction(int x)
{
  if (x < 0)
    return 0;
  
  return errorFunction(x+1);
}
errorFunction(100); //function will never end as the parameter is always above 0
{% endhighlight %}
- **OutOfMemoryError**: heap exhausted (e.g., infinite object creation), occurs in an infinite loop.
### Example
{% highlight java linenos %}
ArrayList<Integer> arr = new ArrayList<>();
while(true)
{
  arr.add(1); // Will infinitely assign memory as each element gets added and result in OutOfMemoryError
}
{% endhighlight %}

## Strings & Wrappers  

- **String methods**:  
  - `s.length()` vs. `arr.length` for arrays  
  - `s.substring(from, to)` returns characters `from` … `to-1`; omit `to` to go to end  
  ### Note
  {% highlight java linenos %}
  String s = "abcde";
  s.substring(1); //substring from index 1 to end;
  s.substring(5); //Does not throw exception, but is just the empty string
  s.substring(6); //Throws IndexOutOfBounds
  // i.e. s.substring(s.length()+1) is the first number that throws exception
  {% endhighlight %}
  - `s.indexOf(str)` returns first index or `-1` if not found  
  - `s.compareTo(other)` returns `<0`, `0`, or `>0`  
  ### Note
  {% highlight java linenos %}
  String s1 = "abcde";
  String s2 = "abcdef";
  System.out.print(s1.compareTo(s2)); //Prints -1 (abcde is alphabetically earlier than s2)
  {% endhighlight %}
  - `s.equals(other)` for content equality  
- **Wrapper classes**: `Integer`, `Double`, etc.  
  - **Autoboxing**: primitive → wrapper automatically (e.g., `int` → `Integer`)  
  ### Example
  {% highlight java linenos %}
  public static int addOne(Integer a)
  {
    return a.intValue() + 1;
  }
  int x = 5;
  System.out.print(x); //Works
  {% endhighlight %}
  - **Unboxing**: wrapper → primitive when needed  
  {% highlight java linenos %}
  public static Integer box(int a)
  {
    return a;
  }
  {% endhighlight %}
  - `intValue()`, `doubleValue()`, etc., to extract primitive  

## Math & Operators  

- Arithmetic: `+`, `-`, `*`, `/`, `%` (modulo)  
- **Rounding** for positives: `(int)(x + 0.5)`;for negatives: `(int) (x-0.5)`
- **Math** utility methods:  
  - `Math.abs(x)`  
  - `Math.pow(base, exponent)`  
  - `Math.sqrt(x)`  
  - `Math.random()` returns `0.0 ≤ x < 1.0`  

## Algorithms & Complexity  

- **Common tasks**:  
  - Find min/max  
  ### Example
  {% highlight java linenos %}
  public int findMin(int[] arr)
  {
    int min = arr[0]; //Alternatives: Integer.MAX_VALUE, -1 (if arr is positive
    for (Integer num : arr)
    {
      if (num < min)
        min = num;
    }
    return min;
  }

  public int findMax(int[] arr)
  {
    int max = arr[0]; //Alternatives: Integer.MIN_VALUE
    for (Integer num : arr)
    {
      if (num > max)
        max = num;
    }
    return max;
  }
  {% endhighlight %}
  - Compute sum, average
  - Check if any/all elements satisfy a property  
  ### Example
  {% highlight java linenos %}
  public ArrayList<Integer> checkCondition(ArrayList<Integer> list)
  {
    for(int i = list.size()-1 ; i >= 0; i--)
    {
      if (list.get(i) > 100)
        list.remove(i);
    }
    return list;
  }
  {% endhighlight %}
  - Count elements meeting criteria  

  ### Example
  {% highlight java linenos %}
  public int countElementsMeetingCondition(int[] arr)
  {
    int count = 0;
    for (Integer num : arr)
    {
      if (num > 0)
        count++;
    }
    return count;
  }
  {% endhighlight %}
- **Sorting**:  
  - **Selection sort**: In all cases, takes nearly same amount of time

### Example
{% highlight java linenos %}
public int[] selectionSort(int[] arr)
{
  for (int i = 0; i < arr.length; i++)
  {
    int min_index = i;
    for (int j = i; j < arr.length; j++)
    {
      if(arr[j] < arr[min_index])
        min_index = j; //Search for smallest element
    }
      //Place smallest element infront
      int temp = arr[i];
      arr[i] = arr[min_index];
      arr[min_index] = temp;
  }
  return arr;
}
{% endhighlight %}
  - **Insertion sort**: Time depends on arrangement. Best case is already arranged. Worst is reversely arranged.
{% highlight java linenos %}
public int[] insertionSort(int[] arr)
{
  for (int i = 1; i < arr.length; i++)
  {
    if (arr[i] > arr[i-1])
      continue; //If the array to index i is already sorted properly, continue to next index
    else
    {  
      for (int j = i-1; j > 0; j--)
      {
        if(arr[j] < arr[j-1])
      {          
        //Swap position if current position is greater than previous
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = arr[j]}
      }
    }
  }
  return arr;
}
{% endhighlight %}
- **Searching**:  
  - **Binary search** Only works when array/list is already sorted. Maximum comparisons = ⌊log₂n⌋ + 1  
### Example
{% highlight java linenos %}
/**
Return:
- if arr has an element matching target, returns the index of that element
- else returns -1
 */
public int binarySearch(int[] arr, int target)
{
  int low = 0; //Lower boundary of range
  int high = arr.length - 1; //Higher boundary

  while(low <= high) //Termination condition, i.e. target is not in arr
  {
    int mid = low + (high - low) / 2; //Middle index

    if(arr[mid] == target)
      return mid;
    if (arr[mid] < target)
    {
      //This means target is either within the range mid+1 to high, or is not in the array
      //So, we set new low to mid+1 and continue search
      low = mid+1;
    }
    else
    {
      high = mid - 1;
    }
  }
  return -1;
}
{% endhighlight %}
- **Array transforms**: reverse (mirror)
### Example
{% highlight java linenos %}
/**
Mirrors a square matrix along its vertical axis (left-right flip)
Modifies the input matrix directly
*/
public static void mirrorLeftRight(int[][] matrix) {
  for (int[] row : matrix) {
    for (int i = 0; i < row.length / 2; i++) {
      //Copies element at left side to right side;
      row[row.length - 1 - i] = row[i];
    }
  }
}
{% endhighlight %}


## Recursion  

- Must include:  
  - **Base case** (stops recursion)  
  - **Recursive step** (reduces problem)  
  - **Termination guarantee** (eventually hits base case)  
- Common examples: factorial, Fibonacci, divide-and-conquer on arrays/lists  
### Example
{% highlight java linenos %}
{
  /**
  Returns:
  - 1*2*3*4*...*n
   */
  public int factorial(int n)
  {
    //Base Case/Termination condition
    if (n == 0 || n == 1)
      return 1;
    
    return n * factorial(n-1); //Recursive step
  }
}
{% endhighlight %}

## Methods & Signatures  

- **Signature** = method name + parameter list  
- **Overloading**: multiple methods/constructors with same name, different parameters  
- **Overriding**: subclass provides implementation for superclass method (same signature + compatible return type)  
- All parameters are passed by **value** (even object references)  
- Return type must match signature  