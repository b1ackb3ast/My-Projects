# Objective of this algorithm is to determine if a certain integer is present in an array that is numerically sorted
# in ascending order.

def recur_binary_search(array, integer, left, right):
    # base case if right is smaller than left which means the integer is not present
    if left > right:
        print("Number is not present in the array.")

    # recursive cases if right is bigger than left which means the integer is present
    else:
        mid = (left + right) // 2
        mid_value = array[mid]
        if mid_value == integer:
            print("Number is present in the array.")

        elif mid_value > integer:
            right = mid - 1
            recur_binary_search(array, integer, left, right)

        elif mid_value < integer:
            left = mid + 1
            recur_binary_search(array, integer, left, right)

test_array = [2, 3, 5, 6, 8, 9]
test_integer = 77
test_left = 0
test_right = len(test_array) - 1


recur_binary_search(test_array, test_integer, test_left, test_right)