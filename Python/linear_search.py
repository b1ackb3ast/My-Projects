
def linear_search(int_list, target_num):
    found = False
    position = 0
    while position < len(int_list):
        if int_list[position] == target_num:
            found = True
            break
        else:
            position = position + 1
    if found is True:
        print("number is present in the list at the index", position)

    else:
        print("number is absent")



test_list = [2,4,3,6,1,7,8,13,33,21,46,57,32,77,86,67,99,54,24]
test_num = 54
linear_search(test_list, test_num)


