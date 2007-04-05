set style data points
set term png

set xlabel "Tama�o entrada (n)"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(op_bas).png"
plot 'Tp1Ej1.dat' tit 'Pr�ctica', x**2 tit 'Te�rica [n^2]'

set output
set terminal win