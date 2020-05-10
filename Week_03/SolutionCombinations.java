

public class SolutionCombinations {

  //参考题解的代码
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      temp.add(0);
    }
    int i = 0;
    while (i >= 0) {
      temp.set(i, temp.get(i) + 1);
      if (temp.get(i) > n) {
        i--;
      } else if (i == k - 1) {
        ans.add(new ArrayList<>(temp));
      } else {
        i++;
        temp.set(i, temp.get(i - 1));
      }
    }
    return ans;
  }
}
