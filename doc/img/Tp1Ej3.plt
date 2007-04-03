set style data lines
set term png


set xlabel "Dimensiones de la matriz"
set ylabel "Operaciones básicas"
set output "Tp1Ej3(multiplicar).png"
plot '..\..\ej3\dat\Tp1Ej3(multiplicar).dat' tit 'Práctica', x*x*x tit 'Teórica'

set xlabel "Exponente"
set ylabel "Cantidad de multiplicaciones"
set output "Tp1Ej3(cant_mul).png"
plot '..\..\ej3\dat\Tp1Ej3(cant_mul).dat' tit 'Práctica', sqrt(x) tit 'Teórica', log(x)

set style data points
set xlabel "Dimensiones de la matriz"
set ylabel "Exponente"
set zlabel "Operaciones básicas"
set output "Tp1Ej3(potenciar).png"
splot '..\..\ej3\dat\Tp1Ej3(potenciar).dat' tit 'Práctica', x*y*y*y tit 'Teórica'


set output
set terminal win