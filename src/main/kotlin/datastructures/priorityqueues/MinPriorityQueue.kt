package datastructures.priorityqueues

import datastructures.definitions.PriorityQueue

class MinPriorityQueue<T: Comparable<T>> : PriorityQueue<T>() {
    fun removeMin(): T? {
        if (isEmpty()) return null
        if (size == 1) return heapArray.removeAt(0)

        val minElement = heapArray[0]

        heapArray[0] = heapArray.removeAt(size - 1)
        heapifyDown()

        return minElement
    }

    fun insertItem(item: T) {
        heapArray.add(item)
        heapifyUp(size - 1)
    }

    fun min(): T? {
        return heapArray.firstOrNull()
    }

    private fun heapifyDown() {
        var currentIndex = 0

        while (true) {
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2
            var smallest = currentIndex

            if (leftChildIndex < size && heapArray[leftChildIndex] < heapArray[smallest])
                smallest = leftChildIndex

            if (rightChildIndex < size && heapArray[rightChildIndex] < heapArray[smallest])
                smallest = rightChildIndex

            if (smallest == currentIndex)
                break

            heapArray.swap(currentIndex, smallest)
            currentIndex = smallest
        }
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index

        while (currentIndex > 0) {
            val parentIndex = (currentIndex - 1) / 2

            if (heapArray[parentIndex] <= heapArray[currentIndex])
                break

            heapArray.swap(currentIndex, parentIndex)
            currentIndex = parentIndex
        }
    }
}