public class KokoEatingBananas {

    static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) right = Math.max(right, pile);

        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // ceil(pile / mid)
            }
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));          // 4
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));    // 30
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));    // 23
    }
}
