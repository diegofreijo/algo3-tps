set style data points
set term png


set xlabel "Dimensiones de la matriz (k)"
set ylabel "Operaciones b�sicas"
set output "Tp1Ej3(multiplicar).png"
plot '..\..\ej3\dat\Tp1Ej3(multiplicar).dat' tit 'Pr�ctica', x*x*x tit 'Te�rica [k^3]', x*x*x+5*x*x tit 'Te�rica ajustada [k^3 + 5*k^2]


set xlabel "Exponente (n)"
set ylabel "Cantidad de multiplicaciones"
set output "Tp1Ej3(cant_mul).png"
plot '..\..\ej3\dat\Tp1Ej3(cant_mul).dat' tit 'Pr�ctica', log(x) tit 'Te�rica [log(n)]', 2*log(x)/log(2) tit 'Te�rica ajustada [2*log2(n)]'


set xlabel "Dimensiones de la matriz (k)"
set ylabel "Exponente (n)"
set zlabel "Operaciones b�sicas"
set output "Tp1Ej3(potenciar).png"
splot '..\..\ej3\dat\Tp1Ej3(potenciar).dat' tit 'Pr�ctica', log(y)/log(2)*x*x*x tit 'Te�rica [log2(n)*k^3]', log(y)/log(2)*x*x*x + 7*x*x*x tit 'Te�rica ajustada [log2(n)*k^3 + 7*k^3]'


set xlabel "Dimensiones de la matriz (k)"
set ylabel "Exponente (n)"
set zlabel "Operaciones b�sicas"
set output "Tp1Ej3(potenciar_fb).png"
splot '..\..\ej3\dat\Tp1Ej3(potenciar).dat' tit '�ptimo', '..\..\ej3\dat\Tp1Ej3(potenciar_fb).dat' tit 'Fuerza Bruta'


set output
set terminal win