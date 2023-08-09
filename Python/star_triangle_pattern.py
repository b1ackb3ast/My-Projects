# Given an input by the user in the form of a positive integer, the program should print out a triangle-shaped
# pattern made of the star character (*). The input should be stored in a variable called N.
# N represents the number of rows in the pattern. The number of stars in each row increases by 2 each time.


def main(n):
    if n <= 0:
        print("n must be larger than 0")
    star_str = "*"
    space = n - 1
    stars = 1

    for i in range(n):

        if i == 0:
            print(n * " " + star_str + n * " ")

        else:
            star_str = space*" " + stars*"*" + star_str + stars*"*"
            print(star_str)
            stars += 1
            space -=1
            star_str = "*"





main(10)


