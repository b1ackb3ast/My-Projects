# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to
# target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.

# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Output: Because nums[0] + nums[1] == 9, we return [0, 1].

def two_sum(nums, target):
    target_array = []
    cycle = 0
    for i in range(len(nums)):
        cycle += 1
        if cycle == len(nums):
            break
        elif nums[i] + nums[i+1] == target:
            target_array.append(nums[i])
            target_array.append(nums[i+1])
            print(target_array)


nums = [3, 2, 4]
target = 6
two_sum(nums, target)

