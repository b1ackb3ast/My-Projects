# There is a hidden integer array that consists of n non-negative integers.
# It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1].
# For example, if arr = [1,0,2,1], then encoded = [1,2,3].
# You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
# Return the original array arr. It can be proved that the answer exists and is unique.

# Input: encoded = [1,2,3], first = 1
# Output: [1,0,2,1]
# Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]

# Input: encoded = [6,2,7,3], first = 4
# Output: [4,2,0,7,4]

def decimal_to_binary(value):
    quotient = 0
    remainder = ""
    if value == 0:
        remainder = 0
    while value >= 1:
        quotient += 1
        if value % 2 == 1:
            remainder = "1" + remainder
        elif value % 2 != 1:
            remainder = "0" + remainder
        value = value // 2
    return int(remainder)

def binary_to_decimal(binary):
    position = 0
    final_value = 0
    while binary > 0:
        remainder = binary % 10
        value = remainder * 2**position
        position += 1
        binary = binary // 10


        final_value += value

    return int(final_value)




first_num = 4
enc_decimal_lst = [6, 2, 7, 3]
def decoder(first_num, enc_decimal_lst):
    length = len(enc_decimal_lst) + 1
    decoded_lst = []
    dec_binary_lst = []
    enc_binary_lst = []
    for i in range(len(enc_decimal_lst)):
        enc_binary_lst.append(decimal_to_binary(enc_decimal_lst[i]))
    dec_binary_lst.append(decimal_to_binary(first_num))
    value = False
    while value is False:
        for j in range(length):
            new_str = ""
            if len(dec_binary_lst) >= length:
                value = True
            else:
                old_value = str(enc_binary_lst[j])
                new_value = str(dec_binary_lst[j])
                if len(old_value) < len(new_value):
                    old_value = (len(new_value) - len(old_value))*"0" + old_value

                elif len(new_value) < len(old_value):
                    new_value = (len(old_value) - len(new_value))*"0" + new_value
                target = False
                while target is False:
                    for k in range(len(new_value), 0, -1):
                        if new_value[k-1] == old_value[k-1]:
                            new_str = "0" + new_str
                        elif new_value[k-1] != old_value[k-1]:
                            new_str = "1" + new_str
                    dec_binary_lst.append(int(new_str))
                    target = True
    for num in range(len(dec_binary_lst)):
        decoded_lst.append(binary_to_decimal(dec_binary_lst[num]))
    print(decoded_lst)


decoder(first_num, enc_decimal_lst)








