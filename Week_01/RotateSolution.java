public class RotateSolution {

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverseArray(nums, 0, nums.length - 1);
    reverseArray(nums, 0, k - 1);
    reverseArray(nums, k, nums.length - 1);
  }

  private void reverseArray(int nums[], int srcPos, int destPos) {
    for (int i = srcPos; srcPos < destPos; srcPos++, destPos--) {
      int temp = nums[srcPos];
      nums[srcPos] = nums[destPos];
      nums[destPos] = temp;
    }
  }
}
