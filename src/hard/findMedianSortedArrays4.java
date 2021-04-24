package hard;

public class findMedianSortedArrays4 {
    public static void main(String[] args) {
        findMedianSortedArrays4 t = new findMedianSortedArrays4();
        t.test();
    }

    private void test() {
        int[][] eg1 = {{0, 0, 0, 0, 0}, {1, 3}, {1, 2}, {0, 0}, {}, {2}};
        int[][] eg2 = {{-1, 0, 0, 0, 0, 0, 1}, {2}, {3, 4}, {0, 0}, {1}, {}};
        for (int i = 0; i < eg1.length; i++) {
            System.out.println(find1(eg1[i], eg2[i]));
        }
    }

    //100%，双指针
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int p1 = 0, p2 = 0;
        double mid = Double.MIN_VALUE;
        int midIndex = (len2 + len1 - 1) / 2;
        while (p1 < len1 || p2 < len2) {
            if (p2 == len2 || (p1 < len1 && p2 < len2 && nums1[p1] < nums2[p2])) {
                /* 如果是4的话，取(4-1)/2=1和2
                 * 如果是3的话，直接取(3-1)/2=1 */
                if (p1 + p2 == midIndex) {
                    mid = nums1[p1];
                    if ((len1 + len2) % 2 != 0) {
                        break;
                    }
                }
                if (p1 + p2 > midIndex) {
                    mid = (nums1[p1] + mid) / 2;
                    break;
                }
                p1++;
            } else {
                if (p1 + p2 == midIndex) {
                    mid = nums2[p2];
                    if ((len1 + len2) % 2 != 0) {
                        break;
                    }
                }
                if (p1 + p2 > midIndex) {
                    mid = (nums2[p2] + mid) / 2;
                    break;
                }
                p2++;
            }
        }
        return mid;
    }

    public double find1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int midI = (len1 + len2 - 1) / 2;
        int i1 = 0, i2 = 0;
        double num1 = 0, num2 = 0;
        while (i1 < len1 || i2 < len2) {
            if (i2 != len2 && (i1 == len1 || nums2[i2] < nums1[i1])) {
                if (i1 + i2 == midI + 1) {
                    num2 = nums2[i2];
                    break;
                }
                if (i1 + i2 == midI) {
                    num1 = nums2[i2];
                }
                i2++;
            } else {
                if (i1 + i2 == midI + 1) {
                    num2 = nums1[i1];
                    break;
                }
                if (i1 + i2 == midI) {
                    num1 = nums1[i1];
                }
                i1++;
            }
        }
        return (len1 + len2) % 2 == 0 ? (num1 + num2) / 2f : num1;
    }
}
