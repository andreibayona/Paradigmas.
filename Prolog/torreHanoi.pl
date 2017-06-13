
/*torre de hanoi de forma recrusiva
@autor Jorge Andrei Bayona  leal
@licence https://www.gnu.org/licenses/old-licenses/gpl-2.0.html*/

torre_hanoi(0,_,_,_). %para ingresar el numero de discos

torre_hanoi(N,Origen,Auxiliar,Destino):- N1 is N-1,% n son el numero de discos

torre_hanoi(N1,Origen,Destino,Auxiliar), % variables que se utilizan

def_pasos(Origen,Destino),% se definen los pasos que se deban hacer

torre_hanoi(N1,Auxiliar,Origen,Destino).

def_pasos(Origen,Destino):-%regla

write(' desde '),

write(Origen),% imprime el origen del dico

write(' hasta '),

write(Destino),% imprime el destino del dico

write('\n').%salto de linea








