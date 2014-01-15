package com.codechef.school.superfunction;

import java.io.IOException;
import java.util.Scanner;
 
public class SuperFunction {
    long N;
    int K;
    long mod;
    long[][] M = new long[15][15];
    long[] primes = new long[50];
    int primeCount = 0;
    long[][][] powersOfM = new long[50][15][15];  //powersOfM[k] denotes (M ^ k)%mod
    long[][] tmp;
 
 
    public static void main(String[] args) throws IOException {
        SuperFunction main = new SuperFunction();
        Scanner input = new Scanner(System.in);
        main.N = input.nextLong();
        main.K = input.nextInt();
        main.mod = input.nextLong();
        //System.out.println(main.N + " " + main.K + " " + main.mod );
        main.computePrimeFactors();
        main.prepareMatrix();
        main.computeAnswer();
    }
 
    private void computePrimeFactors() {
        long X = N;
        long i;
        for (i = 2; i != 1 && i * i < X; i++) {
            if (X % i == 0) {
                primes[primeCount++] = i;
                do {
                    X /= i;
                } while (X % i == 0);
            }
        }
        if (X != 1) primes[primeCount++] = X;
        for (long pri : primes) {
			System.out.print(pri + "-");
		}
        System.out.println();
    }
 
    private void prepareMatrix() {
        for (int i = 0; i < K + 1; i++) {
            M[i][0] = 1l;
            M[i][i] = 1l;
            for (int j = 1; j < i; j++) {
                M[i][j] = M[i - 1][j] + M[i - 1][j - 1];
                if (M[i][j] >= mod) M[i][j] -= mod;
            }
        }
 
        for (int j = 0; j < K + 1; j++) {
            M[K + 1][j] = M[K][j];
        }
 
        M[K + 1][K + 1] = 1l;
        powersOfM[0] = M;
        for (int i = 1; i < 50; i++) {
            powersOfM[i][0][0] = -1; //denotes M ^ (2 ^ i) is not yet computed
        }
 
        tmp = new long[K + 2][K + 2];
    }
 
    private void computeAnswer() {
        long ans = getSumOfKthPowers(N);
        int coeff;//coeff of current subset contribution in inclusion exclusion sum
        for (int mask = 1; mask < (1 << primeCount); mask++) {
            long x = 1l;
            coeff = 1;
            for (int i = 0; i < primeCount; i++) {
                if (((1 << i) & mask) > 0) {
                    x = x * primes[i];
                    coeff *= -1;
                }
            }
            ans = ans + coeff * mul(pow(x, K), getSumOfKthPowers(N / x));
            if (ans < 0) ans += mod;
            if (ans >= mod) ans -= mod;
        }
        System.out.println(ans);
    }
 
    private long pow(long n, long e) {
        n = n % mod;
        long ans = 1l;
        while (e != 0) {
            if ((e & 1) != 0) {
                ans = mul(ans, n);
            }
            e = e >> 1;
            n = mul(n, n);
        }
        //if (ans < 0) throw new RuntimeException();
        return ans;
    }
 
    private long[] matrixPowerMultipliedByVector(long e) {
        long[] V = new long[K + 2];
        V[0] = 1;
        int n = 0;
        while (e != 0) {
            if ((e & 1) != 0) {
                V = matrixVectorMultiplication(powersOfM[n], V);
            }
            e = e >> 1;
            if (powersOfM[n+1][0][0] == -1) {
                powersOfM[n + 1] = new long[K + 2][K + 2];
                multiplyMatrices(powersOfM[n], powersOfM[n], powersOfM[n + 1]);
            }
            n += 1;
        }
        return V;
    }
 
    private long[] matrixVectorMultiplication(long[][] M, long[] V) {
        long[] tmp = new long[K+2];
        for (int i = 0; i < K + 2; i++) {
            tmp[i] = 0;
            for (int j = 0; j < K + 2; j++) {
                tmp[i] = tmp[i] + mul(M[i][j], V[j]);
                if (tmp[i] >= mod) tmp[i] -= mod;
            }
        }
        return tmp;
    }
 
 
    private void multiplyMatrices(long A[][], long B[][], long result[][]) {
        int i, j, k;
        for (i = 0; i < K + 2; i++) {
            for (j = 0; j < K + 2; j++) {
                tmp[i][j] = 0l;
                for (k = 0; k < K + 2; k++) {
                    tmp[i][j] = tmp[i][j] + mul(A[i][k], B[k][j]);
                    if (tmp[i][j] >= mod) tmp[i][j] -= mod;
                }
                result[i][j] = tmp[i][j];
            }
        }
    }
 
    private long getSumOfKthPowers(long X) {
        long[] vector = matrixPowerMultipliedByVector(X);
        return vector[K + 1];
    }
 
    private long mul(long a, long b) {
        long result = 0;
        a %= mod;
        b %= mod;
        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        while (a != 0) {
            if (a % 2 != 0) {
                result += b;
                if (result >= mod) result -= mod;
                a -= 1;
            }
            a /= 2;
            b += b;
            if (b >= mod) b -= mod;
        }
        System.out.println(result);
        return result;
    }
 
}