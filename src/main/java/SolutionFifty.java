import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SolutionFifty {

  public char firstUniqChar(String s) {
    LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<Character, Integer>();
    for (int i = 0; i < s.length() - 1; i++) {
      Integer remove = linkedHashMap.get(s.charAt(i));
      if (remove == null) {
        linkedHashMap.put(s.charAt(i), 1);
      } else {
        linkedHashMap.put(s.charAt(i), linkedHashMap.get(s.charAt(i)) + 1);
      }
    }
    linkedHashMap.forEach((K, V) -> {
      if (V == 1) {
        return K.charValue();
      }
    });
    for (Map.Entry<Character,Integer> item : linkedHashMap.entrySet()) {
      if (item.getValue() == 1) {
        return item.getKey();
      }
    }
    Iterator<Entry<Character, Integer>> iterator = linkedHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getValue() == 1) {
        return iterator.next().getKey();
      }
    }
    return ' ';
  }
}
