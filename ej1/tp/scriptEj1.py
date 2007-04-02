import random
import sys
a=[]
b=[]
x=sys.argv[2]
x=int(x)
rango=2*x
cantidad = sys.argv[1]
cantidad = int(cantidad)
i = 0
while i < cantidad:
	a[0:x] =random.sample(xrange(rango), x)
	b[0:x] =random.sample(xrange(rango), x)
	a.sort()
	a.reverse()
	b.sort()
	b.reverse()
	salida="salida"+str(i)+".txt"
	f=open(salida, 'w')
	f.write(str(x))
	f.write('\n')
	for y in a:
		f.write(str(y))
		f.write('\n')
	for y in b:
		f.write(str(y))
		f.write('\n')
	f.write("0")
	i=i+1