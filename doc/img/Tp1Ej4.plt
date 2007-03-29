set style data lines
set term png



set xlabel "n"
set ylabel "Operaciones b�sicas"

set output "Tp1Ej4(todos).png"
#set xrange [1:150]
#set yrange [1:150]
plot '..\..\ej4\dat\Tp1Ej4(todos).dat' tit 'Pr�ctica', x*sqrt(x) tit 'Te�rica'

set output "Tp1Ej4(primos).png"
#set xrange [1:150]
#set yrange [1:150]
plot '..\..\ej4\dat\Tp1Ej4(primos).dat' tit 'Pr�ctica (primos)', x*sqrt(x) tit 'Te�rica'



set output
set terminal win