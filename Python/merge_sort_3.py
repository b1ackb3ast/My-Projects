def mergeSort(array):
    if len(array) > 1:
        # splitting the unsorted array into to parts, left side and right side
        mid = len(array) // 2
        rightArray = array[mid:]
        leftArray = array[:mid]
        # calling mergesort on the 2 halves. this will continue until the individual elements
        # of the orignal array are split apart and are individually in the left array or the right
        # array.   
        mergeSort(rightArray)
        mergeSort(leftArray)
        # sorting the right array and left array by comparing the elements at the respective indexes
        # in each array. (after the part of the code where each array only has one array on completed
        # the left and right arrays are automatically sorted in ascending order so this is possible when
        # mergesort is called recursively.)
        i = j = k = 0
        while i < len(leftArray) and j < len(rightArray):
            if rightArray[j] < leftArray[i]:
                array[k] = rightArray[j]
                j += 1
            else:
                array[k] = leftArray[i]
                i += 1
            k += 1
        while j < len(rightArray):
            array[k] = rightArray[j]
            j+= 1
            k += 1
        while i < len(leftArray):
            array[k] = leftArray[i]
            i += 1
            k += 1




        
array = [6,8,2,5,9,1,10,13,7]

mergeSort(array)
print(array)