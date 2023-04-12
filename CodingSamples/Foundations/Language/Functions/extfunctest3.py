import ctypes

lib = ctypes.CDLL('./primes.so') #dynamic linking
n = int(input('Upper Limit: '))
print('Number of Primes =', lib.CountPrimes(1, n))

