# Write a program such that when a certain value is added to a number in a list, print true or false statements
# depending in whether it is the largest number in the array.
lst = [2, 4, 6, 8, 7, 3, 9, 5]
value = 3
length = len(lst)

def number_checker(lst, value, length):
    for i in range(length):
        new_value = lst[i] + value
        trial = 0
        for j in range(length):
            trial += 1

            if new_value < lst[j]:
                print(trial)
                print("num is not largest")

                break
            elif j == length - 1:
                print(length)
                print("num is largest")












number_checker(lst, value,length)
