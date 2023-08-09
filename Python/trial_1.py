array_1 = [3,4,6,2,5,7]
def divide(array):
    length = len(array_1)
    mid = array_1[length // 2]

    left_array = array_1[:mid+1]
    right_array = array_1[mid+1:]
    print(left_array)

divide(array_1)