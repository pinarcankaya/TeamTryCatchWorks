package java_works.codingbat;

public class Ders4 {
    public static void main(String[] args) {



    }

    public static int[] midThree(int[] nums) {
        int[] arr = new int[3];

        if (nums.length == 3)
            return nums;

            if (nums.length % 2 != 0) {
                arr[0] = nums[(nums.length - 1) / 2 - 1];
                arr[1] = nums[(nums.length - 1) / 2];
                arr[2] = nums[(nums.length - 1) / 2 + 1];
            }
            return arr;

        }


}


