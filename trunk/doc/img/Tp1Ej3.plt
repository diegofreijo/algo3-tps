set style data lines
set term png


set xlabel "Dimensiones de la matriz"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej3(multiplicar).png"
plot '..\..\ej3\dat\Tp1Ej3(multiplicar).dat' tit 'Pr�ctica', x*x*x tit 'Te�rica'

set xlabel "Exponente"
set ylabel "Cantidad de multiplicaciones"
set output "Tp1Ej3(cant_mul).png"
plot '..\..\ej3\dat\Tp1Ej3(cant_mul).dat' tit 'Pr�ctica', sqrt(x) tit 'Te�rica', log(x)

set style data points
set xlabel "Dimensiones de la matriz"
set ylabel "Exponente"
set zlabel "Operaciones b�sicas"
set output "Tp1Ej3(potenciar).png"
splot '..\..\ej3\dat\Tp1Ej3(potenciar).dat' tit 'Pr�ctica', x*y*y*y tit 'Te�rica'


set output
set terminal win