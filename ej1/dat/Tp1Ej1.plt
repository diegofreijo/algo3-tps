set style data points
set term png

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(totales).png"
plot 'Tp1Ej1(totales).dat' tit 'Práctica', 4*(x**2)+x+x*log(x) tit 'Teórica [O(4n^2+n+n*log(n))]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(QS vs SS).png"
plot 'Tp1Ej1(QS).dat' tit 'Práctica [QS]', 'Tp1Ej1(SS).dat' tit 'Práctica[SS]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(ah vs bus).png"
plot 'Tp1Ej1(ah).dat' tit 'Práctica [Iteraciones Ahorradas]', 'Tp1Ej1(busc).dat' tit 'Práctica[Interaciones Hechas]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(ah vs bus)2.png"
plot x**2, 'Tp1Ej1(busc).dat' tit 'Práctica[Interaciones Hechas]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(bus).png"
plot 'Tp1Ej1(bus).dat' tit 'Práctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(may).png"
plot 'Tp1Ej1(may).dat' tit 'Práctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(orl).png"
plot 'Tp1Ej1(orl).dat' tit 'Práctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(ord).png"
plot 'Tp1Ej1(ord).dat' tit 'Práctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones básicas"
set output "Tp1Ej1(val).png"
plot 'Tp1Ej1(val).dat' tit 'Práctica [Iteraciones]'

set output
set terminal win