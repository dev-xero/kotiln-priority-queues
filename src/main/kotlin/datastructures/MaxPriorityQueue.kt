package datastructures

class MaxPriorityQueue<T: Comparable<T>> : PriorityQueue<T>() {

    fun insertItem(item: T) {
        heapArray.add(item)
        heapifyUp(size - 1)
    }

    fun removeMax(): T? {
        if (isEmpty()) return null
        if (size == 1) return heapArray.removeAt(0)

        val maxElement = heapArray[0]
        heapArray[0] = heapArray.removeAt(size - 1)
        heapifyDown()

        return maxElement
    }

    fun max(): T? {
        return heapArray.firstOrNull()
    }

    private fun heapifyDown() {
        var currentIndex = 0

        while (true) {
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2
            var largest = currentIndex

            if (leftChildIndex < heapArray.size && heapArray[leftChildIndex] > heapArray[largest])
                largest = leftChildIndex

            if (rightChildIndex < heapArray.size && heapArray[rightChildIndex] > heapArray[largest])
                largest = rightChildIndex

            if (largest == currentIndex)
                break

            heapArray.swap(currentIndex, largest)
            currentIndex = largest
        }
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index

        while (currentIndex > 0) {
            val parentIndex = (currentIndex - 1) / 2
            if (heapArray[currentIndex] <= heapArray[parentIndex]) break

            heapArray.swap(currentIndex, parentIndex)
            currentIndex = parentIndex
        }
    }
}