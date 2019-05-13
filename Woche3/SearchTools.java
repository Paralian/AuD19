import static java.lang.System.nanoTime;

public class SearchTools {
    
    public static int[] createSequenceInc(int n) {
        int[] c = new int[n];
        for (int a = 0; a < n; a++) {
            c[a] = a + 1;
        }
        return c;
    }
    
    public static int linSearch(int[] A, int x) {
        int i = -1;
        if (A.length > 0) {
            for (i = 0; i < A.length; i++) {
                if (A[i] == x) break;
            }
        }
        return i;
    }
    
    public static int binSearch(int[] A, int x, int l, int r) {
        if (r >= 1) {
            int d = (l + r - 1) / 2;
            if (A[d] == x) return d;                                             // on point
            else if (A[d] > x) return binSearch(A, x, l, d - 1);             // check left half
            else return binSearch(A, x, d + 1, r);                          // check right half
        }
        return -1;
    }
    
    
    public static int binSearchNew(int[] A, int x, int l, int m, int r) {
        while (r >= 1) {
            int mleft = l + (r - l) / 3;
            int mright = r - (r - l) / 3;
            if (x == A[mleft]) return mleft;
            if (x == A[mright]) return mright;
            if (x < A[mleft]) r = mleft - 1;
            else if (x > A[mright]) l = mright + 1;
            else {
                l = mleft + 1;
                r = mright - 1;
            }
        }
        return -1;
        
        
    }
    
    public static double stopwatchLin(int[] A, int x) {
        double sum = 0;
        int reps = 1000;
        for (int i = 0; i < reps; i++) {
            long start = nanoTime();
            linSearch(A, x);
            long finish = nanoTime();
            long diff = finish - start;
            sum += diff;
        }
        return sum / reps;
    }
    
    public static double stopwatchBin(int[] A, int x) {
        double sum = 0;
        int reps = 1000;
        for (int i = 0; i < reps; i++) {
            long start = nanoTime();
            binSearch(A, x, A[0], A[A.length - 1]);
            long finish = nanoTime();
            long diff = finish - start;
            sum += diff;
        }
        return sum / reps;
    }
    
    public static double stopwatchBinNew(int[] A, int x) {
        double sum = 0;
        int reps = 1000;
        for (int i = 0; i < reps; i++) {
            long start = nanoTime();
            binSearchNew(A, x, A[0], (A[0] + A[A.length - 1]) / 2, A[A.length - 1]);
            long finish = nanoTime();
            long diff = finish - start;
            sum += diff;
        }
        return sum / reps;
    }
    
    
    public static void main(String[] args) {
        
        /*
            Hier erstmal die Zeiten:
           
            
            Avg time for linear search of a random int in array of size 100000 is:
            68711.3
            Avg time for linear search of a random int in array of size 1000000 is:
            590405.3
            Avg time for linear search of a random int in array of size 100000000 is:
            3.84319737E7
            Avg time for linear search of a random int in array of size 685154321 is:
            2.611264345E8
            Avg time for linear search of a -1 in array of size 100000 is:
            36457.6
            Avg time for linear search of a -1 in array of size 1000000 is:
            773531.8
            Avg time for linear search of a -1 in array of size 100000000 is:
            3.69495662E7
            Avg time for linear search of a -1 in array of size 685154321 is:
            2.611049497E8
            Avg time for binary search of a random int in array of size 100000 is:
            629.2
            Avg time for binary search of a random int in array of size 1000000 is:
            237.6
            Avg time for binary search of a random int in array of size 100000000 is:
            284.5
            Avg time for binary search of a random int in array of size 685154321 is:
            220.5
            Avg time for binary search of a -1 in array of size 100000 is:
            186.7
            Avg time for binary search of a -1 in array of size 1000000 is:
            139.8
            Avg time for binary search of a -1 in array of size 100000000 is:
            364.6
            Avg time for binary search of a -1 in array of size 685154321 is:
            174.9
            Avg time for ternary search of a random int in array of size 100000 is:
            651.0
            Avg time for ternary search of a random int in array of size 1000000 is:
            862.0
            Avg time for ternary search of a random int in array of size 100000000 is:
            307.3
            Avg time for ternary search of a random int in array of size 685154321 is:
            179.3
            Avg time for ternary search of a -1 in array of size 100000 is:
            148.0
            Avg time for ternary search of a -1 in array of size 1000000 is:
            158.2
            Avg time for ternary search of a -1 in array of size 100000000 is:
            375.9
            Avg time for ternary search of a -1 in array of size 685154321 is:
            331.2

         */
        
        
        int sizes[] = {100_000, 1_000_000, 100_000_000, 685_154_321};
        for (int i = 0; i < 4; i++) {
            System.out.println("Avg time for linear search of a random int in array of size "
                    + sizes[i] + " is: \n" + stopwatchLin(createSequenceInc(sizes[i]), (int) Math.random() * sizes[i] / 2));
        
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Avg time for linear search of a -1 in array of size "
                    + sizes[i] + " is: \n" + stopwatchLin(createSequenceInc(sizes[i]), -1));
        }
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Avg time for binary search of a random int in array of size "
                    + sizes[i] + " is: \n" + stopwatchBin(createSequenceInc(sizes[i]), (int) Math.random() * sizes[i] / 2));
            
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Avg time for binary search of a -1 in array of size "
                    + sizes[i] + " is: \n" + stopwatchBin(createSequenceInc(sizes[i]), -1));
        }
        
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Avg time for ternary search of a random int in array of size "
                    + sizes[i] + " is: \n" + stopwatchBinNew(createSequenceInc(sizes[i]), (int) Math.random() * sizes[i] / 2));
            
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Avg time for ternary search of a -1 in array of size "
                    + sizes[i] + " is: \n" + stopwatchBinNew(createSequenceInc(sizes[i]), -1));
        }
    }
}