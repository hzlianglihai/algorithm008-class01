public class PlusOneSolution {

  public int[] plusOne(int[] digits) {
    digits[digits.length - 1] += 1;
    for (int i = digits.length - 1; i >= 1; i--) {
      if (digits[i] >= 10) {
        digits[i] = 0;
        digits[i - 1] += 1;
      } else {
        return digits;
      }
    }
    if (digits[0] >= 10) {
      digits[0] = 0;
      int[] array = new int[digits.length + 1];
      array[0] = 1;
      System.arraycopy(array, 1, digits, 0, digits.length);
      return array;
    }
    return digits;
  }
}
