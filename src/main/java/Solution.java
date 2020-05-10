import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {

  public String getHint(String secret, String guess) {
    int a = 0, b = 0;
    boolean[] visit = new boolean[secret.length()];
    Arrays.fill(visit, false);
    for (int i = 0; i < guess.length(); i++) {
      char gc = guess.charAt(i);
      a += getPositionAndNum(secret, i, gc, visit);
      b += getNumButNoPosition(secret, i, gc, visit);
    }
    return String.format("%dA%dB", a, b);
  }

  private int getNumButNoPosition(String secret, int i, char a, boolean[] visit) {
    int index = secret.indexOf(a);
    if (index != -1 && index != i) {
      if (!visit[index]) {
        visit[index] = true;
        return 1;
      }
      for (int j = 0; j < secret.length() && j != index; j++) {
        if (secret.charAt(j) == a) {
          visit[j] = true;
          return 1;
        }
      }
    }
    return 0;
  }

  private int getPositionAndNum(String secret, int i, char a, boolean[] visit) {
    if (secret.charAt(i) == a) {
      visit[i] = true;
      return 1;
    }
    return 0;
  }

  //  public static void main(String[] args) {
//    HashMap<Integer, Integer> leftNum = new HashMap<Integer, Integer>();
//    List<String> list = new ArrayList<String>();
//    char ch = 'A';
//    System.out.printf("%x : ",(int)ch);
//  }
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("[a-zA-Z]");
    String test = "dsd-sd-f$#dsjd";
    for (int i = 0; i < test.length(); i++) {
      System.out.println(pattern.matcher(String.valueOf(test.charAt(i))).matches());
    }
  }
}
