package euler;

public class problem10 {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();

//    testAndPrintSieve();

    System.out.println(problem10(2000000));

    System.out.println("Time Elapsed " + (System.currentTimeMillis() - start));
  }

  private static void testAndPrintSieve() {
    boolean[] sieve = buildSieve(1000);
    System.out.print("[");
    for (int i=0; i<sieve.length; i++) {
      if(sieve[i]) System.out.print(i + " ");
    }
    System.out.println("]");
  }

  public static int problem10(int primesUpTo) {
    boolean[] sieve = buildSieve(primesUpTo);

    int sum = 0;
    for(int i=0; i<sieve.length; i++) {
      sum += sieve[i] ? i : 0;
    }

    return sum;
  }

  private static boolean[] buildSieve(int primesUpTo) {
    boolean[] sieve = new boolean[primesUpTo];
    for (int i = 0; i < primesUpTo; i++) {
      sieve[i] = true;
    }

    for(int multiple=2; multiple<primesUpTo/2; multiple++) {
      for(int i=2; multiple*i < primesUpTo; i++) {
        sieve[multiple * i] = false;
      }
    }
    return sieve;
  }
}
