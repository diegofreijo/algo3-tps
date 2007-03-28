import random
import sys
import math
def pertenece (a,b):
	ret = False
	if a.count(b):
		ret = True
	return ret

def noreverso(a,b):
	ret = False
	c = b[1], b[0]
	ret = pertenece(a,c)
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
		while len(a) < enemigos:
			print len(a)
			enemigo1 = random.randrange(familia)
			enemigo2 = random.randrange(familia)
			while enemigo1 == enemigo2:
				enemigo2 = random.randrange(familia)
			b= enemigo1, enemigo2
			if pertenece(a,b) or noreverso(a,b):
				a = a
			else:
				a.append(b)
		for i in a:
			f.write(str(i[0]))
			f.write(" ")
			f.write(str(i[1]))
			f.write('\n')
	f.write(str(0))