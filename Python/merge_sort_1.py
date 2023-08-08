# You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
# representing the number of elements in nums1 and nums2 respectively.
# Merge nums1 and nums2 into a single array sorted in non-decreasing order.
# The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
# To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
# merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

# Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
# Output: [1,2,2,3,5,6]
# Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
# The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

array_1 = [3,4,6,2,5,7]
def divide(array):
    length = len(array)
    mid = array_1[length // 2]

    left_array = array[:mid+1]
    right_array = array[mid+1:]
    return left_array



def merge(small_1, small_2):
    new_small = []
    target = True
    index = 0
    while target is True:

        if not small_1:
            for i in range(len(small_2)):
                new_small.append(small_2[i])
                target = False

        elif not small_2:
            for i in range(len(small_1)):
                new_small.append(small_1[i])
                target = False

        elif small_1[0] <= small_2[0]:
            new_small.insert(index, small_1[0])
            small_1 = small_1[1:]


        elif small_1[0] > small_2[0]:
            new_small.insert(index, small_2[0])
            small_2 = small_2[1:]

        index += 1
    print(new_small)





def merge_sort(array_1):
    length = len(array_1)
    mid = array_1[length // 2]

    left_array = array_1[:mid + 1]
    right_array = array_1[mid + 1:]
    value = True
    while value is True:
        if len(left_array) == 1:
            break
        else:

            left_array = divide(left_array)
            print(left_array)


    print(left_array)

merge_sort([2,5,4,7,3,6,8,1])












