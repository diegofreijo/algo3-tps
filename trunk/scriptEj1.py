import random
a=[]
b=[]
x=100
a[0:x] =random.sample(xrange(1000), x)
b[0:x] =random.sample(xrange(1000), x)
a.sort()
a.reverse()
b.sort()
b.reverse()
f=open('salida.txt', 'w')
f.write(str(x))
f.write('\n')
for y in a:
	f.write(str(y))
	f.write('\n')
for y in b:
	f.write(str(y))
	f.write('\n')
f.write("0")