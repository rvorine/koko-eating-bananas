fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    var right = piles.max()

    while (left < right) {
        val mid = left + (right - left) / 2
        var hours = 0L
        for (pile in piles) {
            hours += (pile + mid - 1) / mid // ceil(pile / mid)
        }
        if (hours <= h) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

fun main() {
    println(minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))          // 4
    println(minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))    // 30
    println(minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6))    // 23
}
