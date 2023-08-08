# Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest currentSum and return its currentSum.

# A subarray is a contiguous part of an array.

# Example 1:

# Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
# Output: 6
# Explanation: [4,-1,2,1] has the largest currentSum = 6.
# Example 2:

# Input: nums = [1]
# Output: 1
# Example 3:

# Input: nums = [5,4,-1,7,8]
# Output: 23
 
# Constraints:
# 1 <= nums.length <= 105
# -104 <= nums[i] <= 104 


array1 = [-2,1,-3,4,-1,2,1,-5,4]
# function sumCounter that loops through one continuous variation of the array to find the 
# top sum which is the highest value of continuous numbers.
def sumCounter(testArray):
    # currentSum and topSum both begin as the first element in the array, currentSum adds the following element
    # during every loop and does this until current sum is the sum of all the elements in the array. top sum is 
    #updated accordingly when eveey sum is compared.
    currentSum = testArray[0]
    topSum = testArray[0]
    for i in range(len(testArray)-1):
        currentSum = currentSum + testArray[i+1]
        if topSum < currentSum:
            topSum = currentSum
            
    return(topSum)


# main function
def main(array):
    mainTopSum = sumCounter(array)
    for i in range(len(array)-1):
        # every time in the for loop when sumCounter is called, the forst element in the array is excluded through slicing
        # and the following element becomes the first element. for loop ends after the last element in the original array
        # becomes the first element. the challengeTopSum is the highest value of contunuous elements in the current array 
        # that is being tested. The mainTopSum is the highest challengeTopSum so far.
        testArray = array[i:]
        challengeTopSum = sumCounter(testArray)
        if mainTopSum < challengeTopSum:
            mainTopSum = challengeTopSum
    print(mainTopSum)

    

main(array1)



        

            

            
    
    

