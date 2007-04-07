import random
import sys
def randomSinCero(a):
	ret = 0
	while ret <= 1:
		ret = random.randrange(a)
	return ret

a=[]
b=[]
##arg2 = sys.argv[2]
##arg2 = int(arg2)
cantidad = sys.argv[1]
cantidad = int(cantidad)
i = 0
salida = "Tp1Ej1pruebas.in"
f=open(salida, 'w')
f.close()
f=open(salida, 'a')
while i < cantidad:
	x = i+2
	rango=2*x
	a = []
	b = []
	a[0:x] =random.sample(xrange(rango), x)
	b[0:x] =random.sample(xrange(rango), x)
	a.sort()
	a.reverse()
	b.sort()
	b.reverse()
	f.write(str(x))
	f.write('\n')
	for y in a:
		f.write(str(y))
		f.write('\n')
	for y in b:
		f.write(str(y))
		f.write('\n')
	i=i+1
f.write("0")
f.close()