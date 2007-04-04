set style data points
set term png


set xlabel "Número entrada (n)"
set ylabel "Operaciones básicas"
set output "Tp1Ej4(es_primo).png"
plot '..\..\ej4\dat\Tp1Ej4(es_primo).dat' tit 'Práctica', sqrt(x) tit 'Teórica [sqrt(n)]'


set xlabel "Número entrada (n)"
set ylabel "Cantidad de llamadas a EsPrimo"
set output "Tp1Ej4(cant_ep).png"
plot '..\..\ej4\dat\Tp1Ej4(cant_ep).dat' tit 'Práctica', x tit 'Teórica [n]', x/2, x/3, x/4


set xlabel "Número entrada (n)"
set ylabel "Operaciones básicas"
set output "Tp1Ej4(factorizacion).png"
plot '..\..\ej4\dat\Tp1Ej4(factorizacion).dat' tit 'Práctica', x*sqrt(x) tit 'Teórica [n*sqrt(n)]'


set output
set terminal win