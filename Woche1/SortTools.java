import java.util.Arrays;
import java.util.Random;

import static java.lang.System.nanoTime;

public class SortTools {
    
    //1a
    //increasing sequence from 1 to n, of length n
    public static int[] createSequenceInc(int n) {
        int[] seqInc = new int[n];
        for (int i = 0; i < n; i++) {
            seqInc[i] = i + 1;
        }
        return seqInc;
    }
    
    
    //decreasing sequence from n to 1, of length n
    public static int[] createSequenceDec(int n) {
        int[] seqDec = new int[n];
        for (int i = 0; i < n; i++) {
            seqDec[i] = n - i;
        }
        return seqDec;
    }
    
    
    //random sequence from 1 to n, of length n
    public static int[] createSequenceRand(int n) {
        int[] seqRand = new int[n];
        Random generator = new Random();
        for (int i = 0; i < n; i++) {
            seqRand[i] = 1 + generator.nextInt((n));
        }
        return seqRand;
    }
    
    
    //alternating sequence of 1s and 2s, of length n
    public static int[] createSequenceAlt(int n) {
        int[] seqAlt = new int[n];
        for (int i = 0; i < n; i++) {
            seqAlt[i] = (i % 2) + 1;
        }
        return seqAlt;
    }
    
    //1b
    public static void insertionSort(int[] A) {
        
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
    
    //1d
    //TODO: Generics
    
    //1c
    public static void main(String[] args) {
        
        int sizes[] = {100, 1000, 10000, 100000, 200000};
        for (int size : sizes) {
            System.out.println("Times for sequence of size " + size + " are:");
            for (int i = 0; i < 10; i++) {
                long start = nanoTime();
                insertionSort(createSequenceDec(size));
                long finish = nanoTime();
                long diff = finish - start;
                System.out.println(diff);
            }
            
        }
        /*
            Times for sequence of size 100 are:
            202400
            186100
            183300
            253300
            196700
            183700
            196100
            188700
            184200
            299100
            Times for sequence of size 1000 are:
            4808400
            3942200
            1687700
            6835500
            895400
            405200
            380900
            394500
            410400
            424600
            Times for sequence of size 10000 are:
            35644500
            31757700
            32410700
            34482900
            37121400
            34023400
            24421800
            32184500
            34054700
            30601400
            Times for sequence of size 100000 are:
            2655996200
            2068410200
            2044484900
            2029957600
            2022042400
            2067248700
            2040909200
            2051996400
            2063085300
            2037502300
            Times for sequence of size 200000 are:
            8129192500
            8120242600
            8086042300
            8033794000
            8051166300
            8059016200
            8129477300
            8059836600
            8309747500
            8057383500
         */
        
    }
}
