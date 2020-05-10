import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class SolutionPattern290 {

  public boolean wordPattern(String pattern, String str) {
    LinkedHashMap<Character, String> mapPattern = new LinkedHashMap<>();
    HashSet<String> set = new HashSet<>();
    String[] array = str.split(" ");
    if (array.length != pattern.length()) {
      return false;
    }
    for (int i = 0; i < pattern.length(); i++) {
      if (!mapPattern.containsKey(pattern.charAt(i))) {
        if (set.contains(array[i])) {
          return false;
        }
        set.add(array[i]);
        mapPattern.put(pattern.charAt(i), array[i]);
      } else if (!Objects.equals(mapPattern.get(pattern.charAt(i)), array[i])) {
        return false;
      }
    }
    return true;
  }
}

