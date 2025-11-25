# 🎓 **Student Record Entry with Exception Handling & Multithreading**

# 📘 *Java Programming Project*

**Name:** Yashieta Sethi
**Roll No.:** 2401010187
**Course Name:** Java Programming
**Programme:** B.Tech CSE CORE
**Session:** 2025–26

---

## 📝 **Description**

This Java console application demonstrates **Exception Handling**, **Custom Exception**, **Multithreading**, **Wrapper Classes**, and **Interface implementation** using a simple **Student Record Entry** example.

The program takes input from the user (roll no, name, email, course, marks), validates it, simulates a loading process using a separate thread, and then displays the full student details along with the calculated grade.

---

## ✨ **Features**

* 🧾 Enter Student Details:

  * Roll Number (`Integer` – Wrapper Class)
  * Name
  * Email
  * Course
  * Marks (`Double` – Wrapper Class)
* 🧮 Automatic Grade Calculation (A, B, C, D, F) based on marks
* ⚠️ **Custom Exception** → `StudentNotFoundException` (for empty Name or Course)
* 🧵 **Multithreading**:

  * `Loader` class implements `Runnable`
  * Shows `"Loading....."` with `Thread.sleep(2000)`
* 🧠 **Wrapper Classes & Autoboxing**:

  * `Integer.valueOf()` and `Double.valueOf()`
* 🛡️ Robust Exception Handling:

  * `StudentNotFoundException` (custom)
  * `NumberFormatException` (invalid numeric input)
  * `ArithmeticException` (invalid marks range)
* 🔁 `finally` block to indicate completion of execution
* 🧩 Interface `RecordActions` implemented by `StudentManager`

---

## 🧠 **Concepts Used**

### 🔹 Custom Exception

* `class StudentNotFoundException extends Exception`

  * Thrown when **Name** or **Course** is empty.

### 🔹 Multithreading

* `class Loader implements Runnable`

  * Prints: `"Loading....."`
  * Uses `Thread.sleep(2000)` to simulate delay.
* In `StudentManager.addStudent()`:

  * `Thread t = new Thread(new Loader());`
  * `t.start();`
  * `t.join();` (main thread waits until loader thread finishes)

### 🔹 Wrapper Classes & Autoboxing

* `Integer rollNo` and `Double marks` used instead of `int`/`double`.
* `Integer.valueOf(sc.nextLine())`
* `Double.valueOf(sc.nextLine())`

### 🔹 Interface Implementation

* `interface RecordActions` with method:

  * `void addStudent() throws Exception;`
* `class StudentManager implements RecordActions`

  * Provides implementation of `addStudent()`.

### 🔹 Exception Handling

Inside `addStudent()`:

* `try { ... } catch (...) { ... } finally { ... }`
* Catches:

  * `StudentNotFoundException` → `"Name or Course cannot be empty!"`
  * `NumberFormatException` → `"Invalid Input! Please enter correct numeric values."`
  * `ArithmeticException` → `"Invalid Marks! Must be between 0–100."`
* `finally` → Always prints: `"Program execution completed."`

---

## 📊 **Grade Criteria**

| Marks Range | Grade |
| ----------- | ----- |
| ≥ 90        | A     |
| 75–89       | B     |
| 60–74       | C     |
| 40–59       | D     |
| < 40        | F     |

---

## ▶️ **How to Run**

### 1️⃣ Save the file as:

```bash
LabAssignment3.java
```

### 2️⃣ Compile the program:

```bash
javac LabAssignment3.java
```

### 3️⃣ Run the program:

```bash
java LabAssignment3
```

---

## 🧪 **Sample Execution Flow (Conceptual)**

1. User enters:

   * Roll No, Name, Email, Course, Marks
2. If **Name** or **Course** is empty → `StudentNotFoundException` is thrown.
3. If **Marks** is not a number → `NumberFormatException`.
4. If **Marks** < 0 or > 100 → `ArithmeticException`.
5. `Loader` thread prints `"Loading....."` and simulates delay.
6. Student details are displayed with **calculated grade**.
7. `finally` prints `"Program execution completed."`

---

## ✅ **Conclusion**

This program is an excellent demonstration of:

* **Custom Exceptions**
* **Multithreading (Runnable + Thread + join)**
* **Wrapper Classes & Autoboxing**
* **Interface-based Design**
* **Exception Handling with try–catch–finally**



