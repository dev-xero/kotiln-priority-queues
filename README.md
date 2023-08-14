# Priority Queues
Balanced binary tree implementation of min and max priority queues in Kotlin

## Time Complexities
1. Insertion: `O(log n)`
2. Removal: `O(log n)`
3. Returning max or min: `O(1)`

## Implementation
1. Min Priority Queues:  
   Removing and inserting to the priority queue uses helper functions `heapifyDown()` and `heapifyUp()` to maintain heap properties.  
   
    ```kotlin
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
    }
    ```
  
2. Max Priority Queues:  
   They also maintain heap properties using the helper functions.  
   
    ```kotlin
    class MaxPriorityQueue<T: Comparable<T>> : PriorityQueue<T>() {
        fun removeMax(): T? {
            if (isEmpty()) return null
            if (size == 1) return heapArray.removeAt(0)
    
            val maxElement = heapArray[0]
            heapArray[0] = heapArray.removeAt(size - 1)
            heapifyDown()
    
            return maxElement
        }
    
        fun insertItem(item: T) {
            heapArray.add(item)
            heapifyUp(size - 1)
        }
    
        fun max(): T? {
            return heapArray.firstOrNull()
        }
    }
    ```
