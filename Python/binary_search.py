def binary_search(num_list, target):
    high = len(num_list) - 1
    low = 0
    found = False
    while low <= high and found is False:
        mid = (high + low) / 2
        print(mid)
        if num_list[int(mid)] == target:
            print("target found")
            found = True
        elif num_list[int(mid)] > target:
            high = mid - 1
        else:
            low = mid + 1
    return found



num_list = [2, 4, 6, 7, 9, 10, 13]
target = 10
if (binary_search(num_list, target)) is True:

    print("number is present")
else:
    print("number is absent")