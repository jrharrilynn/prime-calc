import java.util.Vector;

public class Sieve
{
    private int numPrime;
    private Vector<Integer> arr = new Vector<Integer>();

    public Sieve(int size) {
        int sum = 0;
        //creates boolean array, "P[0...n]"
        //initialize as true, make multiples of prime numbers false, as they have a divisor != 1.
        //true = prime
        //false = not prime
        boolean prime[] = new boolean[size + 1];
        for (int i = 0; i <= size; i++) {
            prime[i] = true;
        }
        //find multiples of prime numbers, starting with 2, make them false
        for (int j = 2; j * j <= size; j++) {
            if (prime[j] == true) {
                for (int k = j * j; k <= size; k += j) {
                    prime[k] = false;
                }
            }
        }
        for (int i = 2; i <= size; i++) {
            if (prime[i] == true) {
                arr.add(i);
                ++sum;
            }
        }
        setNumPrime(sum);
        //System.out.println("the amount of prime numbers is: " + sum);

    }

    public void setNumPrime(int n) {
        numPrime = n;
    }

    public int getNumPrime() {
        return numPrime;
    }

    public Vector<Integer> getPrimeArray() {
        return arr;
    }

    public boolean isPrime(int n) {
        for (int i = 0; i <= n; i++) {
            if (arr.get(i) == n)
                return true;
        }
        return false;
    }
}