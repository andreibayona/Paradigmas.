use_module(library(lists)).
/*
n_reinas
Usage es: n_queen(4,X).
*/

n_reinas(N, Solucion) :-
	%crea las variables de la lista
	length(Solucion, N),%recorre la lista

	reina(Solucion, N). %busca la posible solucion de la reina


% devuelve la lista de enteros con los posibles resultados  (1,3,X) X =
% [1,2,3]
posible(N,N,[N]) :-!.
posible(J,N,[J|Adicional]) :- J < N, J1 is J+1, posible(J1, N, Adicional).


reina([],_). %no contiene reinas ala solucion

reina([X|Xlista],N) :-

	reina(Xlista, N), %se resuelve un subproblema

	%genera nna  posible solucion
	posible(1,N,Posible_solucion),

	%se elige una posicion
	member(X, Posible_solucion),

	%verifica la colocacion de la reina
	verificar_solucion(X,Xlista, 1).



verificar_solucion(_,[], _).

verificar_solucion(X,[X1|Xlista],Xdist) :-
	X =\= X1, % no es la misma fila
	Prueba is abs(X1-X),
	Prueba =\= Xdist, %diagonal
	Xdist1 is Xdist + 1,
	verificar_solucion(X,Xlista,Xdist1).


















