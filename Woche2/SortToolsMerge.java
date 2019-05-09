import java.util.Random;

import static java.lang.System.nanoTime;
import static java.util.Arrays.copyOf;

public class SortToolsMerge {
    
    
    //1a
    // TODO: zum kompilieren bringen, weil natürlich heißt die Vorlesung "Java und Generische Methoden"
    
    public static <T extends Comparable<T>> void merge(T[] A, int left, int middle, int right) {
        int leftBracket = middle - left + 1;
        int rightBracket = right - middle;
        
        
        T[] L = (T[])new Object[leftBracket];     //  hier hätte ein normales array stehen können
        T[] R = (T[])new Object[rightBracket];    //  maile mich an Zykov@students.uni-marburg.de und ich schicke eine Lösung ohne Generics, dafür gibt es wohl eh keine Punkte
        
        // HELP bringt mir bitte Generics bei, das ist grauenvoll!!
        
        for (int leftSubPointer = 0; leftSubPointer < leftBracket; leftSubPointer++) {
            L[leftSubPointer] = A[left + leftSubPointer];
        }
        for (int rightSubPointer = 0; rightSubPointer < rightBracket; rightSubPointer++) {
            R[rightSubPointer] = A[middle + 1 + rightSubPointer];
        }
        
        int leftSubPointer = 0;
        int rightSubPointer = 0;
        int masterPointer = left;
        while (leftSubPointer < leftBracket && rightSubPointer < rightBracket) ;
        {
            if (L[leftSubPointer].compareTo(R[rightSubPointer]) <= 0) {
                A[masterPointer] = L[leftSubPointer];
                leftSubPointer++;
            } else {
                A[masterPointer] = R[rightSubPointer];
                rightSubPointer++;
            }
            masterPointer++;
        }
        while (leftSubPointer < leftBracket) {
            A[masterPointer] = L[leftSubPointer];
            leftSubPointer++;
            masterPointer++;
        }
        while (rightSubPointer < rightBracket) {
            A[masterPointer] = R[rightSubPointer];
            rightSubPointer++;
            masterPointer++;
        }
    }
    
    public static <T extends Comparable<T>> void mergeSort(T[] A, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(A, left, middle);
            mergeSort(A, middle + 1, right);
            merge(A, left, middle, right);
        }
    }
    
    public static <T extends Comparable<T>> void mergeNew(T[] A, int left, int lefty, int righty, int right) {
        int leftBracket = lefty - left + 1;
        int rightBracket = right - righty + 1;
        int middleBracket = righty - lefty + 1;
        
        T[] L = (T[])new Object[leftBracket];
        T[] M = (T[])new Object[middleBracket];
        T[] R = (T[])new Object[rightBracket];
        
        
        for (int leftSubPointer = 0; leftSubPointer < leftBracket; leftSubPointer++) {
            L[leftSubPointer] = A[left + leftSubPointer];
        }
        for (int midSubPointer = 0; midSubPointer < middleBracket; midSubPointer++) {
            M[midSubPointer] = A[lefty + 1 + midSubPointer];
        }
        
        for (int rightSubPointer = 0; rightSubPointer < rightBracket; rightSubPointer++) {
            R[rightSubPointer] = A[righty + 1 + rightSubPointer];
        }
        
        int leftSubPointer = 0;
        int midSubPointer = 0;
        int rightSubPointer = 0;
        int masterPointer = left;
        while ((leftSubPointer < leftBracket && rightSubPointer < rightBracket) && midSubPointer < middleBracket) ;
        {
            if (L[leftSubPointer].compareTo(M[midSubPointer]) <= 0) {
                A[masterPointer] = L[leftSubPointer];
                leftSubPointer++;
            } else if (M[midSubPointer].compareTo(R[rightSubPointer]) <= 0) {
                A[masterPointer] = M[midSubPointer];
                midSubPointer++;
            } else {
                A[masterPointer] = R[rightSubPointer];
                rightSubPointer++;
            }
            masterPointer++;
        }
        while (leftSubPointer < leftBracket) {
            A[masterPointer] = L[leftSubPointer];
            leftSubPointer++;
            masterPointer++;
        }
        while (midSubPointer < middleBracket) {
            A[masterPointer] = M[midSubPointer];
            midSubPointer++;
            masterPointer++;
        }
        while (rightSubPointer < rightBracket) {
            A[masterPointer] = R[rightSubPointer];
            rightSubPointer++;
            masterPointer++;
        }
        
        
    }
    
    public static <T extends Comparable<T>> void mergeSortNew(T[] A, int left, int right) {
        if (left < right) {
            int lefty = (left + right) / 3;
            int righty = (right + lefty) / 2;
            mergeSortNew(A, left, lefty);
            mergeSortNew(A, lefty + 1, righty);
            mergeSortNew(A, righty + 1, right);
            mergeNew(A, left, lefty, righty, right);
        }
    
    }
    
    // **** legacy code from week 1 follows ****
    
        //increasing sequence from 1 to n, of length n
        public static int[] createSequenceInc ( int n){
            int[] seqInc = new int[n];
            for (int i = 0; i < n; i++) {
                seqInc[i] = i + 1;
            }
            return seqInc;
        }
    
    
        //decreasing sequence from n to 1, of length n
        public static int[] createSequenceDec ( int n){
            int[] seqDec = new int[n];
            for (int i = 0; i < n; i++) {
                seqDec[i] = n - i;
            }
            return seqDec;
        }
    
    
        //random sequence from 1 to n, of length n
        public static int[] createSequenceRand ( int n){
            int[] seqRand = new int[n];
            Random generator = new Random();
            for (int i = 0; i < n; i++) {
                seqRand[i] = 1 + generator.nextInt((n));
            }
            return seqRand;
        }
    
    
        // alternating sequence of 1s and 2s, of length n
        public static int[] createSequenceAlt ( int n){
            int[] seqAlt = new int[n];
            for (int i = 0; i < n; i++) {
                seqAlt[i] = (i % 2) + 1;
            }
            return seqAlt;
        }
    
        
        public static void insertionSort ( int[] A){
        
            for (int j = 1; j < A.length; j++) {
                int s = A[j];
                int i = j - 1;
                while (i >= 0 && A[i] > s) {
                    A[i + 1] = A[i];
                    i--;
                }
                A[i + 1] = s;
            }
        }
    
        
        //1c
        public static void main (String[]args){
            
            
            int sizes[] = {100, 1000, 10000, 100000, 200000};
            for (int size : sizes) {
                System.out.println("Average time for insertionSort for sequence of size " + size + " is:");
                double times = 0.0;
                for (int i = 0; i < 10; i++) {
                    long start = nanoTime();
                    insertionSort(createSequenceDec(size));
                    long finish = nanoTime();
                    long diff = finish - start;
                    times = (double) diff + times;
                }
                System.out.println(times/10);
                
            }
    
            int sizes[] = {100, 1000, 10000, 100000, 200000};
            for (int size : sizes) {
                System.out.println("Average time for insertionSort for sequence of size " + size + " is:");
                double times = 0.0;
                for (int i = 0; i < 10; i++) {
                    long start = nanoTime();
                    mergeSort(createSequenceDec(size), 0, size);
                    long finish = nanoTime();
                    long diff = finish - start;
                    times = (double) diff + times;
                }
                System.out.println(times/10);
        
            }
    
            int sizes[] = {100, 1000, 10000, 100000, 200000};
            for (int size : sizes) {
                System.out.println("Average time for insertionSort for sequence of size " + size + " is:");
                double times = 0.0;
                for (int i = 0; i < 10; i++) {
                    @SuppressWarnings("unchecked")
                    T[] A = (T[])new Object[size];
                    A = copyOf(createSequenceDec(size), size);
                    // mal ehrlich, ein array in eine generische Methode vernünftig einzupacken ist mir zu viel verlangt für zu wenige Punkte
                    long start = nanoTime();
                    mergeSortNew(copyOf(, size), 0, size);
                    long finish = nanoTime();
                    long diff = finish - start;
                    times = (double) diff + times;
                }
                System.out.println(times/10);
                
                
            }
        }
}


}
