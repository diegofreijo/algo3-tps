import random
import sys
familia = sys.argv[1]
familia = int(familia)
enemigos = sys.argv[2]
enemigos = int(enemigos)
f=open("salida", 'w')
f.write(str(familia))
f.write(" ")
f.write(str(enemigos))
f.write('\n')
i=0
for i in range(0, enemigos):
	enemigo1 = random.randrange(familia)
	enemigo2 = random.randrange(familia)
	while enemigo1 == enemigo2:
		enemigo2 = random.randrange(familia)
	f.write(str(enemigo1))
	f.write(" ")
	f.write(str(enemigo2))
	f.write('\n')
	i=i+1
f.write(str(0))