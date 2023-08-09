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
    print(int(remainder))

decimal_to_binary(3)