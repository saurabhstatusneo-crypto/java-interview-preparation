# Java Stream API – Senior Level Interview Coding Problems

This document contains **online-style coding problem statements** focused on **Java 8+ Stream API**, designed for **10+ years experienced Java developers**. These problems are commonly seen (or inspired by) interviews at **top product companies, FAANG, fintechs, and large-scale enterprise systems**.

> **Instructions**:
>
> * Use **Java Stream API only** unless stated otherwise
> * Avoid explicit loops (`for`, `while`)
> * Focus on correctness, readability, and performance
> * Assume immutable output collections where possible

---

## 1. Top-K Elements Per Group

**Problem Statement:**
Given a list of `Employee` objects with fields:

* `id`
* `name`
* `department`
* `salary`

Return a `Map<String, List<Employee>>` where:

* Key = department name
* Value = **top 3 highest-paid employees** in that department
* Employees must be sorted by salary in descending order

**Constraints:**

* Employee records are unique
* If a department has fewer than 3 employees, return all of them

---

## 2. First Non-Repeating Character

**Problem Statement:**
Given a string input, find the **first non-repeating character** while preserving the original order.

**Constraints:**

* Case-sensitive (`'A'` and `'a'` are different)
* Return empty result if no such character exists

---

## 3. Merge & Aggregate Data

**Problem Statement:**
Given a list of `Order` objects with fields:

* `orderId`
* `customerId`
* `amount`

Produce a `Map<Long, BigDecimal>` where:

* Key = customerId
* Value = total amount spent by that customer

**Constraints:**

* Multiple orders may exist for the same customer
* Use Stream API collectors for aggregation

---

## 4. Flatten Nested Collections

**Problem Statement:**
Given a `List<List<Integer>>`, return a **sorted list of unique integers**.

**Constraints:**

* Remove duplicates
* Result should be sorted in ascending order
* Use Stream API only

---

## 5. Partition by Business Rule

**Problem Statement:**
Given a list of `Transaction` objects with fields:

* `id`
* `status` (`SUCCESS` or `FAILED`)
* `amount`

Partition the transactions into:

* Successful transactions
* Failed transactions

**Constraints:**

* Preserve original order within each partition
* Output type should clearly represent the partitioning

---

## 6. Detect Parallel Stream Issue

**Problem Statement:**
Analyze the following code and explain why it produces inconsistent results:

```java
List<Integer> result = new ArrayList<>();
IntStream.range(1, 1000)
         .parallel()
         .forEach(result::add);
```

Then, rewrite it to produce correct and thread-safe output.

**Constraints:**

* Explain the root cause
* Provide a safe Stream-based solution

---

## 7. Convert List to Map with Conflict Resolution

**Problem Statement:**
Given a list of `Employee` objects with fields:

* `id`
* `name`
* `salary`

Convert it into a `Map<Long, Employee>` where:

* Key = employee id
* Value = employee object

**Constraints:**

* If duplicate IDs exist, keep the employee with the **higher salary**
* Do not throw exception for duplicate keys

---

## 8. Find Longest Element

**Problem Statement:**
Given a list of strings, find the **longest string** using Java Stream API.

**Constraints:**

* If multiple strings have the same maximum length, return the first one
* Do not use `Collections.max`

---

## 9. Lazy Evaluation & Short-Circuiting

**Problem Statement:**
Given a list of `Employee` objects with a `salary` field, check whether **any employee earns more than 1,000,000**.

**Constraints:**

* Processing must stop as soon as the condition is met
* Avoid unnecessary traversal of the entire list

---

## 10. Rolling / Moving Average

**Problem Statement:**
Given a list of `Transaction` objects with an `amount` field, ordered by time, compute a **moving average of the last 3 transactions** for each transaction.

**Constraints:**

* For the first and second transactions, calculate the average using available elements
* Output list size must match input list size

---

## Usage

These problem statements can be used for:

* Senior Java interview preparation
* Machine coding rounds
* Internal technical assessments
* Java Stream API mastery practice

---

**End of Document**
