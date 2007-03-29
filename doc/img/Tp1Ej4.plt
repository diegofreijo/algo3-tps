set style data lines
set term png



set xlabel "n"
set ylabel "Operaciones básicas"

set output "Tp1Ej4(todos).png"
#set xrange [1:150]
#set yrange [1:150]
plot '..\..\ej4\dat\Tp1Ej4(todos).dat' tit 'Práctica', x*sqrt(x) tit 'Teórica'

set output "Tp1Ej4(primos).png"
#set xrange [1:150]
#set yrange [1:150]
plot '..\..\ej4\dat\Tp1Ej4(primos).dat' tit 'Práctica (primos)', x*sqrt(x) tit 'Teórica'



set output
set terminal win