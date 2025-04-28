---
title: AP CSA FRQ Notes
categories: [AP]
tags: [CSA]
datacamp: 1
maths: 1
toc: 1
---

{% include toc.html %}

## Q1: Methods & Control Structures

- Usually you’re given a class; your job is to write one or more methods on it  
- Methods almost always involve either control statements (`if`/`else`) _or_ loops (`for`/`while`)

### Tip 
- Figure out what you think the method should do. Read the program specification and write keywords

### Example
{% highlight java linenos %}

public class SquirrelFeeder
{
    private int currentNuts;

    /**
     * Simulates one day with numSquirrels squirrels or possibly a raccoon at the feeder,
     * as described in part (a)
     * Precondition: numSquirrels > 0
     */
    public void simulateOneDay(int numSquirrels)
    { /* to be implemented in part (a) */ }

    /**
     * Returns the number of days squirrels or a raccoon found food to eat at the feeder in this simulation,
     * as described in part (b)
     * Preconditions: numSquirrels > 0, numDays > 0
     */
    public int simulateManyDays(int numSquirrels, int numDays)
    { /* to be implemented in part (b) */ }
}


{% endhighlight %}

(a) On a normal day (90% chance), each squirrel eats between 5 and 15 nuts (inclusive), randomly. On an abnormal day (10% chance), a raccoon eats everything. If the total intended consumption exceeds the available food, the feeder is emptied.
Implement `simulateOneDay`.

(b) Implement `simulateManyDays` to return the number of days where food was available to be eaten.



## Q2: Class Implementation from a Spec

When they give you a program specification, you must build the entire class:

### Tips
1. **Read** the spec and list out the **private** instance variables you think you’ll need  
2. **Write** the constructor header as specified  
3. **Double-check**: Are your instance variables sufficient? Add or remove as needed  
4. **Repeat** same procedure for each method you need to implement.

**Inheritance notes**  
- Use `extends` to subclass  
- **Do not** recreate variables/methods already in the superclass  
- In your subclass constructor, call `super(...)` first  
- If you override a method but still need the base behavior, call `super.methodName(...)` inside it  
- Access inherited members via their public methods, not by hacking fields

### Example
{ % highlight java linenos %}
public class MatchTracker
{
    public MatchTracker(String team1, String team2) { /* implementation not shown */ }

    /**
     * Records an outcome for the active team.
     * A positive value adds to their score.
     * A 0 ends their turn.
     * Precondition: points >= 0
     */
    public void recordPlay(int points)
    { /* to be implemented */ }

    /**
     * Returns current score in format: "Team1Score-Team2Score-ActiveTeamName"
     */
    public String getScore()
    { /* to be implemented */ }
}
{ % endhighlight %}
Create the `recordPlay` and `getScore` methods. Alternate teams when points == 0. Maintain scores separately and alternate turns properly.


## Q3: Arrays & ArrayLists

- Generally involves, `Creation`, `traversal`, `manipulation`

### Tips
- `Watch out` for these common mistakes:  
  - Using `[]` instead of `.get()` / `.set()` on an `ArrayList`  
  - Declaring an `ArrayList<int>` (invalid)—use `ArrayList<Integer>`  
  - Removing elements while iterating: always `loop backwards` to avoid index shifts
  - Adding elements while iterating: check example

### Examples

<!-- 1. Removing while iterating
2. Adding while iterating
3. Actual  -->

{% highlight java linenos %}
public class CourseProgress
{
    private ArrayList<Integer> progress;

    public CourseProgress()
    { /* initializes progress as an empty list */ }

    /**
     * Adds a daily completion percentage (0 to 100 inclusive).
     * A student may have incomplete (less than 100%) days.
     */
    public void addDailyProgress(int percent)
    { /* to be implemented in part (a) */ }

    /**
     * Returns true if the average of the last N days is at least threshold.
     * If fewer than N days, return false.
     */
    public boolean isOnTrack(int numDays, double threshold)
    { /* to be implemented in part (b) */ }
}
{% endhighlight %}

(a) Implement `addDailyProgress` by appending to the progress list.
(b) Implement `isOnTrack` to compute average of the most recent `numDays` entries.

## Q4: 2D Arrays

- Don't be afraid just because it's 2D. There's nothing different from 1D array.
- To get dimensions:  
  - **Rows** = `arr.length`  
  - **Cols** = `arr[0].length`  
- **Common problem**: “Mirror” a 2D array or reverse rows/columns

### Examples
{% highlight java linenos %}
public class SensorData
{
    private ArrayList<Double> readings;

    public SensorData(ArrayList<Double> data)
    { /* initializes readings with a deep copy of data */ }

    /**
     * Removes any values outside the range [min, max] (inclusive).
     */
    public void filter(double min, double max)
    { /* to be implemented */ }

    /**
     * Returns average of the remaining values.
     * If no readings remain, return -1.
     */
    public double getAverage()
    { /* to be implemented */ }
}
{% endhighlight %}
Implement `filter` to remove values from the list that fall outside `[min, max]`. Implement `getAverage` to return the average of the remaining values, or `-1` if the list is empty.



## Comprehensive Practice

- **String methods** you’ll see everywhere:  
  - `s.length()` vs. `arr.length`  
  - `s.substring(a, b)`  
  - `s.indexOf(…)` (returns `-1` if not found)  
  - `s.compareTo(…)`, `s.equals(…)`  
- **Handwriting** your code:  
  1. Read spec; don’t jump to examples unless you’re stuck  
  2. Outline variables and high-level steps on scrap paper  
  3. Jump into code fast—even if messy, you can cross out as you refine  
- **`static`**: Only use for utility methods, never for accessors/mutators in FRQs

## General FRQ Strategies

- Coding rewards `pattern recognition`
	- In other words, work through many past frq problems and frq problems in test prep books
- If there are more than one method in a problem. For the later ones, review the question to check if you need/can use a previously implemented method.

## Common Pitfalls

- `=` vs. `==` for comparison  
- Chained comparisons like `a <= b <= c` (invalid)—use `a <= b && b <= c`  
- **Off-by-one** when adding/removing array or list elements  
- **Variable names** matter—choose meaningful names for grader readability  
- **Stuck on spec?** Skip it, come back  
  - If still stuck, write a mini-outline of variables & you’ll earn partial credit  
- **Searching** patterns:  
  {% highlight java linenos %}
  for(...) {
    if (condition) return true; 
  }
  return false;
  {% endhighlight %}

- make sure the return false condition is outside the iteration

### Example

