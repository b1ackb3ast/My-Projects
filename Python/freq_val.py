# Input: nums = [1,2,3,4]
# Output: [2,4,4,4]
# Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
# The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
# At the end the concatenation [2] + [4,4,4] is [2,4,4,4].

# Constraints:
#
# 2 <= nums.length <= 100
# nums.length % 2 == 0
# 1 <= nums[i] <= 100

old_lst = [4, 3, 6, 5, 7, 2, 3, 4]
length = len(old_lst)
def main(old_lst,length):
    new_lst = []
    if length % 2 != 0:
        print("length of list must be even")
    else:
        for i in range(0, length, 2):
            for j in range(old_lst[i]):
                new_lst.append(old_lst[i+1])
        print(old_lst)
        print(new_lst)

        
main(old_lst, length)

