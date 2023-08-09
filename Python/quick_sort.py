def quicksort(sequence):
    length = len(sequence)
    if length <= 1:
        return sequence
    else:
        pivot = sequence.pop()
    items_greater = []
    items_lower = []
    for item in sequence:
        if item < pivot:
            items_lower.append(item)
        else:
            items_greater.append(item)
    return quicksort(items_lower) + [pivot] + quicksort(items_greater)

test_sequence = [1, 3, 4, 7, 2, 9, 9, 3, 6, 4, 7, 2, 8, 8, 10, 77]
print(quicksort(test_sequence))





























