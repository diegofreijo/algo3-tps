set style data points
set term png

set xlabel "Tamaño entrada (n)"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(op_bas).png"
plot 'Tp1Ej1.dat' tit 'Práctica', x**2 tit 'Teórica [n^2]'

set output
set terminal win