class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length)
            return findMedianSortedArrays(b, a);
        int m = a.length, n = b.length;
        int l = 0, r = m;
        while (l <= r) {
            int p1 = (l + r) / 2;
            int p2 = (m + n + 1) / 2 - p1;
            int left1 = (p1 == 0) ? Integer.MIN_VALUE : a[p1 - 1];
            int right1 = (p1 == m) ? Integer.MAX_VALUE : a[p1];
            int left2 = (p2 == 0) ? Integer.MIN_VALUE : b[p2 - 1];
            int right2 = (p2 == n) ? Integer.MAX_VALUE : b[p2];
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 1)
                    return Math.max(left1, left2);
                return (Math.max(left1, left2)
                      + Math.min(right1, right2)) / 2.0;
            }
            if (left1 > right2)
                r = p1 - 1;
            else
                l = p1 + 1;
        }
        return 0.0;
    }
}