---
title: Python Refresher
categories: [ML]
tags: [CS224N]
datacamp: 1
maths: 1
toc: 1
date: 2025-04-29
---

{% include toc.html %}

## List Comprehension

- Input sequence
- Variable representing members
- Optional predicate
- Output expression

### Examples

{% highlight python linenos %}
points = [(1, 2), (3, 4)]
[x + y for (x, y) in points]  # Result: [3, 7]
{% endhighlight %}

{% highlight python linenos %}
matrix = [[1, 2], [3, 4], [5, 6]]

# Get even numbers from a matrix:
evens = [num for row in matrix for num in row if num % 2 == 0]
# Result: [2, 4, 6]
{% endhighlight %}

{% highlight python linenos %}
combinations = [(color, size) for color in colors for size in sizes]
# Result: [('red', 'S'), ('red', 'M'), ('green', 'S'), ('green', 'M')]
{% endhighlight %}

{% highlight python linenos %}
matrix = [[1, 2], [3, 4]]
result = [(i, num) for i, row in enumerate(matrix) for num in row]
# Result: [(0, 1), (0, 2), (1, 3), (1, 4)]
{% endhighlight %}



## Methods

- to create string from iterable `join(iterable)`
- to return multiple `return a, b`
- to create iterable with `(index, element)`, `enumerate(iterable, start=0)`
- to get length `len()`
- `type(x)`
- `'%s %s %d' % (nerdy, koreankid, 19)` [printf](https://www.nv5geospatialsoftware.com/docs/Format_Codes_CPrintf.html) style formatting
- [String Methods](https://docs.python.org/3.5/library/stdtypes.html#string-methods)

## Containers

### List

- [Docs][https://docs.python.org/3/tutorial/datastructures.html]
- `a[::]`, `pop()`, `enumerate`

### Set

- [Docs](https://docs.python.org/3/library/stdtypes.html#set-types-set-frozenset)
- declared with curly braces or `set()`
- distinct, unordered, unchangeable (after creation, but can add/remove), can contain diff data types
- `add(a)` adds is `a not in set`, `remove(a)`

#### Example
{% highlight python linenos %}
corpus_words = sorted(list({word for doc in corpus for word in doc}))
{% endhighlight %}



### Dictionary
- [Docs](https://docs.python.org/3/library/stdtypes.html#mapping-types-dict)
- `{'key': 'value'}`
- `a in d` checks if `a in d.keys()`
- `d.get(a, b)`, returns `d[a] if a in d.keys()`, else `b`

{% highlight python linenos %}
d = {'person': 2, 'cat': 4, 'spider': 8}
for animal in d:
    legs = d[animal]
    print('A %s has %d legs' % (animal, legs))
{% endhighlight %}

- `d.items()` for `(key, value)`
- Dictionary comprehension

{% highlight python linenos %}
even_num_to_square = {x: x ** 2 for x in nums if x % 2 == 0}
{% endhighlight %}

### Tuple

- [Docs](https://docs.python.org/3/library/stdtypes.html#tuples)
- immutable
- can be used as keys in dictionaries, and elements in sets (lists can't)

### Example

{% highlight python linenos %}
d = {(x, x + 1): x for x in range(10)}  # Create a dictionary with tuple keys
t = (5, 6)        # Create a tuple
print(type(t))    # Prints "<class 'tuple'>"
print(d[t])       # Prints "5"
print(d[(1, 2)])  # Prints "1"
{% endhighlight %}

## Operators

- `//` floor division
- `^` XOR, sets each bit to 1 iff only one of two bits is 1
- `&` Bitwise AND
- `~` NOT, inverts all bits (e.g. ~3 = -4)
- `<<` binary left shift
- `>>` binary right shift
- `not`, `and`, `or`, `in`, `not in`, `is`, `not is`
- `:=`, (e.g. `print(x:=3)` $\\equiv$ `x=3	print(x)`)

### Functions

- [Docs](https://docs.python.org/3/tutorial/controlflow.htmls)
- `def foo(a, b=false)`, parameters with default value must come at end
- can specify parameter value during function call
- `for-else`: `else` runs when `for` loop exits without breaking/return
- `match-case`: `case _:` is the default case, can combine multiple using `|`
- `lambda arguments : expression`

{% highlight python linenos %}
def combined_example(pos_only, /, standard, *, kwd_only):
    print(pos_only, standard, kwd_only)
{% endhighlight %}


### Class

- [Docs](https://docs.python.org/3/tutorial/classes.html)

### Instantiation
{% highlight python linenos %}
class Something:
	#Variables

	def __init__(self):
		#initialization
{% endhighlight %}

### Inheritance
{% highlight python linenos %}
class DerivedClassName(modname.BaseClassName): #if baseclass from same module, can be omitted
{% endhighlight %}

## Numpy 

### Arrays

- [Docs](https://numpy.org/doc/stable/user/basics.creation.html#arrays-creation)
- all same type, indexed by tuple, dimension = `rank`, size = `shape`

{% highlight python linenos %}
a = np.array([1, 2, 3])   # Create a rank 1 array
print(type(a))            # Prints "<class 'numpy.ndarray'>"
print(a.shape)            # Prints "(3,)"
print(a[0], a[1], a[2])   # Prints "1 2 3"
a[0] = 5                  # Change an element of the array
print(a)                  # Prints "[5, 2, 3]"

b = np.array([[1,2,3],[4,5,6]])    # Create a rank 2 array
print(b.shape)                     # Prints "(2, 3)"
print(b[0, 0], b[0, 1], b[1, 0])   # Prints "1 2 4"
{% endhighlight %}

<div class="mt-2 mb-2" data-datacamp-exercise data-lang="python">
	<!-- <code data-type="pre-exercise-code">
		# This will get executed each time the exercise gets initialized
		b = 6
	</code> -->
	<code data-type="sample-code">
		import numpy as np
		a = np.array([2, 3, 4], dtype=np.uint32)
		b = np.array([5, 6, 7], dtype=np.uint32)
		c_unsigned32 = a - b
		print('unsigned c:', c_unsigned32, c_unsigned32.dtype)

		c_signed32 = a - b.astype(np.int32)
		print('signed c:', c_signed32, c_signed32.dtype)
	</code>
	<!-- <div data-type="hint">Use the assignment operator (<code><-</code>) to create the variable <code>a</code>.</div> -->
</div>

### Other useful
- `np.eye(n)`: Identitiy matrix. `n` is a tuple (dimension of matrix) or `integer` `n x n` matrix.
- `np.diag()`: If argument is a matrix, returns the diagonal elements. Else, creates a diagonal matrix
{% highlight python linenos %}
np.diag([1, 2, 3], 1)

a = np.array([[1, 2], [3, 4]])
{% endhighlight %}
- `np.vander(x, n)`: `x` is an input 1D array/list/type. `n-1` is the highest polynomial
<div class='mt-2 mb-2' data-datacamp-exercise data-lang='python'>
<code data-type='sample-code'>
import numpy as np
np.vander((1, 2, 3, 4), 4)
</code>
</div>

- `np.zeros()`, `np.ones()`
- Must use `.copy()` or will point at same array
- `np.random.random()` creates array with random values

### Indexing

- `b = a[:2, 1:3]`
{% highlight python linenos %}
row_r1 = a[1, :]    # Rank 1 view of the second row of a
row_r2 = a[1:2, :]  # Rank 2 view of the second row of a
{% endhighlight %}

<div class='mt-2 mb-2' data-datacamp-exercise data-lang='python'>
<code data-type='sample-code'>
import numpy as np

a = np.array([[1,2], [3, 4], [5, 6]])

# An example of integer array indexing.
# The returned array will have shape (3,) and
print(a[[0, 1, 2], [0, 1, 0]])  # Prints "[1 4 5]"

# The above example of integer array indexing is equivalent to this:
print(np.array([a[0, 0], a[1, 1], a[2, 0]]))  # Prints "[1 4 5]"

# When using integer array indexing, you can reuse the same
# element from the source array:
print(a[[0, 0], [1, 1]])  # Prints "[2 2]"
</code>
</div>