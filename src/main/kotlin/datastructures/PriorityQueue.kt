package datastructures

abstract class PriorityQueue<T: Comparable<T>> {
    val heapArray = mutableListOf<T>()

    val size: Int
        get() = heapArray.size

    fun isEmpty() = heapArray.isEmpty()

    fun MutableList<T>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}