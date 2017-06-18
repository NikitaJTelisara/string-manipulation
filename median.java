public class median {
    public static void main(String[] args) {
        int[] e = {1, 2};
        int[] e1 = {3,4};
        System.out.println(findMedianSortedArrays(e, e1));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] res = mergeArray(nums1, nums2);
        int m = (res.length / 2);
        if (res.length % 2 != 0) {
            return (res[m]);
        } else {
            return ((res[m] + res[m - 1]) / 2);
        }
    }


    public static double[] mergeArray(int[] nums1, int[] nums2) {
        double [] result = new double[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else if (nums1[i] >= nums2[j]) {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            result[k] = nums2[j];
            j++;
            k++;
        }
        return result;
    }
}
