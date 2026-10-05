using System;
using System.Linq;

class KokoEatingBananas
{
    static int MinEatingSpeed(int[] piles, int h)
    {
        int left = 1, right = piles.Max();

        while (left < right)
        {
            int mid = left + (right - left) / 2;
            long hours = 0;
            foreach (int pile in piles)
            {
                hours += (pile + mid - 1) / mid; // ceil(pile / mid)
            }
            if (hours <= h)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }

    static void Main()
    {
        Console.WriteLine(MinEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));          // 4
        Console.WriteLine(MinEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));    // 30
        Console.WriteLine(MinEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));    // 23
    }
}
