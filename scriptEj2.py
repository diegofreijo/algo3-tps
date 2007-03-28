import random
import sys
import math
def pertenece (a,b):
	ret = False
	i = 0
	if a.count(b):
		ret = True
	return ret

familia = sys.argv[1]
familia = int(familia)
enemigos = sys.argv[2]
enemigos = int(enemigos)
instancias = sys.argv[3]
instancias = int(instancias)
x = pow(2,familia)
if enemigos > x:
	print "Los enemigos son mayores a la cantidad posible"
else:
	f=open("salida", 'w')
	f.write(str(familia))
	f.write(" ")
	f.write(str(enemigos))
	f.write('\n')
	for i in range (0, instancias):
		a = []
		i=0
		while len(a) < enemigos:
			print len(a)
			enemigo1 = random.randrange(familia)
			enemigo2 = random.randrange(familia)
			while enemigo1 == enemigo2:
				enemigo2 = random.randrange(familia)
			b= enemigo1, enemigo2
			if pertenece(a,b):
				a = a
			else:
				a.append(b)
			#f.write(str(enemigo1))
			#f.write(" ")
			#f.write(str(enemigo2))
			#f.write('\n')
	f.write(str(0))