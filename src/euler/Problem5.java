package euler;

public class Problem5 {
  public static void main(String[] args) {
    int i = 1;
    while(!hasAllDivisors(i, 2, 20)) {
      i++;
    }
    System.out.println("Omg I found all the effing divisors in " + i);
  }

  public static boolean hasAllDivisors(int num, int startDivisor, int stopDivisor) {
    for(int divisor=startDivisor; divisor<=stopDivisor; divisor++) {
      if(!divides(num, divisor)) return false;
    }
    return true;
  }

  public static boolean divides(int num, int divisor) {
    return num % divisor == 0;
  }
}
