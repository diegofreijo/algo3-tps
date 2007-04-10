set style data points
set term png

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(totales).png"
plot 'Tp1Ej1(totales).dat' tit 'Pr�ctica', 4*(x**2)+x+x*log(x) tit 'Te�rica [O(4n^2+n+n*log(n))]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(QS vs SS).png"
plot 'Tp1Ej1(QS).dat' tit 'Pr�ctica [QS]', 'Tp1Ej1(SS).dat' tit 'Pr�ctica[SS]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(ah vs bus).png"
plot 'Tp1Ej1(ah).dat' tit 'Pr�ctica [Iteraciones Ahorradas]', 'Tp1Ej1(busc).dat' tit 'Pr�ctica[Interaciones Hechas]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(ah vs bus)2.png"
plot x**2, 'Tp1Ej1(busc).dat' tit 'Pr�ctica[Interaciones Hechas]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(bus).png"
plot 'Tp1Ej1(bus).dat' tit 'Pr�ctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(may).png"
plot 'Tp1Ej1(may).dat' tit 'Pr�ctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(orl).png"
plot 'Tp1Ej1(orl).dat' tit 'Pr�ctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(ord).png"
plot 'Tp1Ej1(ord).dat' tit 'Pr�ctica [Iteraciones]'

set xlabel "Cantidad de elementos"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej1(val).png"
plot 'Tp1Ej1(val).dat' tit 'Pr�ctica [Iteraciones]'

set output
set terminal win