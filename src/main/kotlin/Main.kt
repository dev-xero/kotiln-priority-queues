import datastructures.priorityqueues.MaxPriorityQueue
import datastructures.priorityqueues.MinPriorityQueue

fun main() {
    val maxPriorityQueue = MaxPriorityQueue<Int>()
    val minPriorityQueue = MinPriorityQueue<Int>()

    maxPriorityQueue.insertItem(1)
    maxPriorityQueue.insertItem(2)
    maxPriorityQueue.insertItem(7)
    maxPriorityQueue.insertItem(3)
    maxPriorityQueue.insertItem(6)

    println("Max Item: ${maxPriorityQueue.max()}")
    maxPriorityQueue.removeMax()
    println("New Size: ${maxPriorityQueue.size}")

    minPriorityQueue.insertItem(8)
    minPriorityQueue.insertItem(3)
    minPriorityQueue.insertItem(2)
    minPriorityQueue.insertItem(6)
    minPriorityQueue.insertItem(1)

    println("\nMin Item: ${minPriorityQueue.removeMin()}")
    println("New Min Item: ${minPriorityQueue.removeMin()}")
    println("New Size ${minPriorityQueue.size}")
    println("New Min: ${minPriorityQueue.min()}")
}