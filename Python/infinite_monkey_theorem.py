# The way we will simulate this is to write a function that generates a string that is 35 characters long by
# choosing random letters from the 26 letters in the alphabet plus space. We will write another function that will
# score each generated string by comparing the randomly generated string to the goal. A third function will repeatedly
# call generate and score, then if 100% of the letters are correct we are done. If the letters are not correct then we
# will generate a whole new string. To make it easier to follow, our program should keep track of the best string
# generated so far.

import random
import string
goal_str = "kevin"
num = 5

def random_str(str_len):
    new_string = ""
    for element in range(str_len):
        new_string = new_string + random.choice(string.ascii_lowercase + " ")

    return new_string
# this function will check every letter of the randomly generated string with 'kevin'. if the randomly generated string is kevin,
# the score will be 5. if not it will be less than 5.
def keep_score(test_string, goal_string, str_len):
    score = 0
    for i in range(str_len):
        if test_string[i] == goal_string[i]:
            score += 1
        else:
            break
    return score

def checker(goal_string, str_len):
    trials = 0
    best_score = 0
    target = False
    while target is False:
        trial_string = random_str(str_len)
        # as long as the score generated in keep_score is less than 5, the value of new score will be less than 1
        new_score = (keep_score(trial_string, goal_string, str_len)) / len(goal_string)
        trials += 1
        if new_score > best_score:
            best_score = new_score
            print("String is:", trial_string)
            print("Trial number:", trials)
            print("Best score is:", best_score)
        
        # if the score is 1, that means all the characters in the random string match the goal string -> break out of while loop by making
        # target true.
        elif new_score == 1:
            target = True




checker(goal_str, num)












