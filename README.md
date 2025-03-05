# Delayed Stack and Queue

## Project Overview
This project involves implementing two data structures in Java: a **Delayed Stack** and a **Delayed Queue**. Both structures enforce a delay condition where elements cannot be removed until a specified number of elements have been added. The stack follows the Last-In-First-Out (LIFO) principle, while the queue follows the First-In-First-Out (FIFO) principle. The delay condition resets whenever a new element is added after a sequence of removals.

## Key Features
- **Delayed Stack**:
  - Supports `push` and `pop` operations with a configurable delay condition.
  - Delay resets after a `push` operation following a sequence of `pop` operations.
- **Delayed Queue**:
  - Supports `enqueue` and `dequeue` operations with a configurable delay condition.
  - Delay resets after an `enqueue` operation following a sequence of `dequeue` operations.
- **Dynamic Delay Adjustment**:
  - The maximum delay can be changed dynamically, but the change takes effect only after the next reset.

## Technical Details
- **Programming Language**: Java
- **Core Classes**:
  - `MyStack`: Implements the `DelayedStack` interface.
  - `MyQueue`: Implements the `DelayedQueue` interface.
- **Constraints**:
  - No external libraries or Java standard library imports are allowed.
- **Testing**:
  - JUnit tests are required for both `MyStack` and `MyQueue`.

## Learning Outcomes
- **Data Structures**: Gain hands-on experience with stacks and queues.
- **Object-Oriented Design**: Practice encapsulation and interface implementation.
- **Testing**: Write comprehensive JUnit tests to ensure code correctness.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/delayed-stack-queue.git
2. Compile and run the tests:
   ```bash
   javac MyStack.java MyQueue.java MyStackTest.java MyQueueTest.java
   java org.junit.runner.JUnitCore MyStackTest MyQueueTest
