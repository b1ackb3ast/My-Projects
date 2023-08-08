# Construct an algorithm such that you compare the first two elements of the array and then sort them. After that you
# take the third element in the array and compare it with the first two elements and insert it at the right index.
# Continue this throughout the array.

def insertion_sort(array):
    j = i = 0
    k = i+2
    for k in range(len(array)):
        for i in range(1, i+2):

            if array[i] > array[j]:
                j = i + 1
                array[i], array[j] = array[j], array[i]





