/**
 * QUEUE AND DEQUE IN JAVA
 * ------------------------
 * ✅ Queue (java.util.Queue)
 *   - Follows FIFO (First In, First Out) order.
 *   - Common Implementations:
 *     - LinkedList
 *     - PriorityQueue
 *
 * ✅ Deque (java.util.Deque)
 *   - “Double-ended queue” – allows insertion and removal from both ends.
 *   - Common Implementations:
 *     - ArrayDeque
 *     - LinkedList
 *
 * Key Methods:
 * - add(e), offer(e): insert elements
 * - remove(), poll(): remove and return head
 * - element(), peek(): return head without removing
 * - For Deque → addFirst(), addLast(), removeFirst(), removeLast()
 *
 * Topics Covered:
 * 1. Basic Queue Operations (LinkedList)
 * 2. PriorityQueue (Natural Ordering)
 * 3. Deque with ArrayDeque
 * 4. Stack Behavior using Deque
 * 5. Iterating Queues and Deques
 * 6. Comparison Summary
 */

import java.util.*;

public class QueueAndDequeDemo {

    /** ==========================================
     *  1. Basic Queue Operations (LinkedList)
     * ========================================== */
    static void basicQueueDemo() {
        System.out.println("------------------------------------");
        System.out.println("* 1. Basic Queue Operations (LinkedList) *");

        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("Alice");
        queue.add("Bob");
        queue.offer("Charlie"); // offer() is safer (doesn’t throw exception if full)

        System.out.println("Queue after additions: " + queue);

        // Accessing head element
        System.out.println("Head element using peek(): " + queue.peek());

        // Removing elements
        System.out.println("Removed using remove(): " + queue.remove());
        System.out.println("Queue after removal: " + queue);

        // poll() removes but returns null if empty
        queue.poll();
        queue.poll();
        System.out.println("After polling all → Empty queue: " + queue.poll());
    }

    /** ==========================================
     *  2. PriorityQueue (Natural Ordering)
     * ========================================== */
    static void priorityQueueDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 2. PriorityQueue (Natural Ordering) *");

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(50);
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);

        System.out.println("PriorityQueue elements (internal order not guaranteed): " + pq);

        // Elements retrieved in natural order (smallest first)
        System.out.print("Polling in priority order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  3. Deque with ArrayDeque
     * ========================================== */
    static void dequeDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 3. Deque with ArrayDeque *");

        Deque<String> deque = new ArrayDeque<>();

        // Add elements at both ends
        deque.addFirst("Front");
        deque.addLast("Back");
        deque.offerFirst("Start");
        deque.offerLast("End");

        System.out.println("Deque after additions: " + deque);

        // Peek elements
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        // Remove from both ends
        deque.removeFirst();
        deque.removeLast();

        System.out.println("Deque after removals: " + deque);
    }

    /** ==========================================
     *  4. Stack Behavior using Deque (LIFO)
     * ========================================== */
    static void stackUsingDeque() {
        System.out.println("\n------------------------------------");
        System.out.println("* 4. Stack Behavior using Deque (LIFO) *");

        Deque<Integer> stack = new ArrayDeque<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack (using Deque): " + stack);

        // Pop elements (LIFO)
        System.out.println("Popped element: " + stack.pop());
        System.out.println("After popping: " + stack);
    }

    /** ==========================================
     *  5. Iterating Queues and Deques
     * ========================================== */
    static void iterationDemo() {
        System.out.println("\n------------------------------------");
        System.out.println("* 5. Iterating Queues and Deques *");

        Queue<String> queue = new LinkedList<>(List.of("One", "Two", "Three"));
        Deque<String> deque = new ArrayDeque<>(List.of("Alpha", "Beta", "Gamma"));

        System.out.print("Queue (for-each): ");
        for (String s : queue) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.print("Deque (Iterator): ");
        Iterator<String> it = deque.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.print("Deque (Reverse using descendingIterator): ");
        Iterator<String> revIt = deque.descendingIterator();
        while (revIt.hasNext()) {
            System.out.print(revIt.next() + " ");
        }
        System.out.println();
    }

    /** ==========================================
     *  Main Method
     * ========================================== */
    public static void main(String[] args) {
        System.out.println("=== Java Queue & Deque Demo ===\n");

        basicQueueDemo();
        priorityQueueDemo();
        dequeDemo();
        stackUsingDeque();
        iterationDemo();

        System.out.println("\n------------------------------------");
        System.out.println("* 6. Comparison Summary *");
        System.out.println("- Queue → FIFO (LinkedList / PriorityQueue).");
        System.out.println("- Deque → Double-ended (ArrayDeque / LinkedList).");
        System.out.println("- Stack (LIFO) → Implemented using Deque.");
        System.out.println("- PriorityQueue → Orders elements by natural or custom comparator.");
        System.out.println("- ArrayDeque → Faster than Stack & LinkedList for queue/stack operations.");
    }
}
