set style data points
set term png

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(totales).png"
plot 'Tp1Ej1(totales).dat' tit 'Práctica', 6*x + 3*(x**2) + (x*log(x)) tit 'Teórica [O(6n + 3n^2 + n log(n)))]'



set output
set terminal win