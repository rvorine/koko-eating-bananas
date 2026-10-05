import math


def min_eating_speed(piles, h):
    left, right = 1, max(piles)

    while left < right:
        mid = (left + right) // 2
        hours = sum(math.ceil(pile / mid) for pile in piles)
        if hours <= h:
            right = mid
        else:
            left = mid + 1

    return left


if __name__ == "__main__":
    print(min_eating_speed([3, 6, 7, 11], 8))          # 4
    print(min_eating_speed([30, 11, 23, 4, 20], 5))    # 30
    print(min_eating_speed([30, 11, 23, 4, 20], 6))    # 23
