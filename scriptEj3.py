import random
import sys
import math
k = int(sys.argv[1])
matriz = [k]*k
for i in range(0,k):
	matriz[i] = []
	matriz[i][0:k] = random.sample(xrange(50), k)

salida = open("Tp1Ej3.in", 'w')
for n in range(1,20):
	salida.write(str(n) + ' ' + str(k) + '\n')
	#salida.writelines(matriz)
	for i in range(0,k):
		for j in range(0,k):
			salida.write(str(matriz[i][j]) + ' ')	
		salida.write('\n')
salida.close()