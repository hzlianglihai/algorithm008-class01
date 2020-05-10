import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionFifteen {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int l = i + 1, r = nums.length - 1;
      int target = -nums[i];
      if ((i > 0 && nums[i] == nums[i - 1]) || nums[i] > 0) {
        continue;
      }
      while (l < r) {
        while (l < r && nums[l] + nums[r] < target) {
          l++;
        }
        while (l < r && nums[l] + nums[r] > target) {
          r--;
        }
        if (l < r && nums[l] + nums[r] == target) {
          list.add(Arrays.asList(nums[i], nums[l], nums[r]));
          l++;
          r--;
        }
        while (l < r && nums[l] == nums[l - 1]) {
          l++;
        }
        while (l < r && nums[r] == nums[r + 1]) {
          r--;
        }
      }
    }
    return list;
  }
}
