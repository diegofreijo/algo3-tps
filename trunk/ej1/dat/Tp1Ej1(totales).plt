set style data points
set term png

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(totales).png"
plot 'Tp1Ej1(totales).dat' tit 'Pr�ctica', 6*x + 3*(x**2) + (x*log(x)) tit 'Te�rica [O(6n + 3n^2 + n log(n)))]'



set output
set terminal win