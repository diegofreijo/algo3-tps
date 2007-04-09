set style data points
set term png


set xlabel "N�mero entrada (n)"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej4(es_primo).png"
plot '..\..\ej4\dat\Tp1Ej4(es_primo).dat' tit 'Pr�ctica', sqrt(x) tit 'Te�rica [sqrt(n)]'


set xlabel "N�mero entrada (n)"
set ylabel "Cantidad de llamadas a EsPrimo"
set output "Tp1Ej4(cant_ep).png"
plot '..\..\ej4\dat\Tp1Ej4(cant_ep).dat' tit 'Pr�ctica', x tit 'Te�rica [n]', x/2 tit 'n/2', x/3 tit 'n/3', x/4 tit 'n/4'


set xlabel "N�mero entrada (n)"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej4(factorizacion).png"
plot '..\..\ej4\dat\Tp1Ej4(factorizacion).dat' tit 'Pr�ctica', x*sqrt(x) tit 'Te�rica [n*sqrt(n)]'


set xlabel "N�mero entrada (n)"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej4(factorizacion_fb).png"
plot '..\..\ej4\dat\Tp1Ej4(factorizacion).dat' tit '�ptimo', '..\..\ej4\dat\Tp1Ej4(factorizacion_fb).dat' tit 'Fuerza Bruta'


set output
set terminal win