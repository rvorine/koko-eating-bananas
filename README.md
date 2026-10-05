[![Instagram](https://img.shields.io/badge/Instagram-lacopydepastel-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://instagram.com/lacopydepastel)
[![YouTube](https://img.shields.io/badge/YouTube-%40rvorine-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://youtube.com/@rvorine)

# Koko Eating Bananas (LeetCode 875)

## Problem

Koko has `n` piles of bananas, `piles[i]` bananas in pile `i`. Guards return in `h` hours. Each hour Koko picks one pile and eats up to `k` bananas from it — if the pile has fewer than `k`, she finishes it and **waits out the rest of the hour**. Find the **minimum integer eating speed `k`** that lets her finish all bananas within `h` hours.

Example:

```
Input:  piles = [3,6,7,11], h = 8             Output: 4
Input:  piles = [30,11,23,4,20], h = 5        Output: 30
Input:  piles = [30,11,23,4,20], h = 6        Output: 23
```

## Solution

Binary search on the answer — search the speed `k`, not the array.

Eating speed has a clean monotonic property: if speed `k` finishes within `h` hours, any faster speed does too. That lets us binary search the range of possible speeds.

1. Search range: `left = 1` (slowest possible), `right = max(piles)` (eating the largest pile in one hour — never need faster).
2. For a candidate speed `mid`, total hours needed = sum of `ceil(pile / mid)` over all piles.
3. If `hours <= h` → `mid` is fast enough, but a slower speed might also work → `right = mid`.
4. Otherwise → too slow → `left = mid + 1`.
5. When `left == right`, that's the minimum feasible speed.

**Time:** O(n log m) — `n` piles checked per iteration, binary search over `m = max(piles)`.
**Space:** O(1) — a few variables, no extra structures.

## Implementations

| Language | File |
|---|---|
| Python | [`python/koko_eating_bananas.py`](python/koko_eating_bananas.py) |
| Java | [`java/KokoEatingBananas.java`](java/KokoEatingBananas.java) |
| Kotlin | [`kotlin/KokoEatingBananas.kt`](kotlin/KokoEatingBananas.kt) |
| JavaScript | [`javascript/kokoEatingBananas.js`](javascript/kokoEatingBananas.js) |
| C# | [`csharp/KokoEatingBananas.cs`](csharp/KokoEatingBananas.cs) |
