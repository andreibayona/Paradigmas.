
solucion :-
    iniciar( Start),
    primer_paso( [ [Start] ], Solucion),
    %se soluciona en orden inverso
    write(Solucion), nl,
    imprimir_solucion(Solucion).

% paso contiene los canivales y misioneros
paso(0, _).
paso(3, _).
paso(X, X).

% los estados representa el numero de misioneros, nuemro de canibales y
% la canoa
iniciar(estado(3,3,1)).
consulta(estado(0,0,0)).
consulta_camino([Nodo | _]) :- consulta(Nodo).

%se mueve d e estado 1 a estado 2
mover( estado( M1, C1, 1),   % antes de moverse
      estado( M2, C1, 0) )  % despues de moverse
   :- M1 > 1, M2 is M1-2, paso(M2, C1).  % Two missionaries from east to west

mover( estado( M1, C1, 0),   % antes de moverse
      estado( M2, C1, 1) )  % despues de moverse
   :- M1 < 2, M2 is M1+2, paso(M2, C1).  % dos misioneros de izquierda a derecha
mover( estado( M1, C1, 1),   % antes de moverse
      estado( M1, C2, 0) )  % despues de moverse
   :- C1 > 1, C2 is C1-2, paso(M1, C2).  % dos canibales de izquierda a derecha

mover( estado( M1, C1, 0),   % antes de moverse
      estado( M1, C2, 1) )  % despues de moverse
   :- C1 < 2, C2 is C1+2, paso(M1, C2).  % Two dos canibales de derecha a izquierda

mover( estado( M1, C1, 1),   % antes de moverse
      estado( M1, C2, 0) )  % despues de moverse
   :- C1 > 0, C2 is C1-1, paso(M1, C2).  % un canibales de derecha a izquierda

mover( estado( M1, C1, 0),   % antes de moverse
      estado( M1, C2, 1) )  % despues de moverse
   :- C1 < 3, C2 is C1+1, paso(M1, C2).  % un canibal de derecha a izquierda

mover( estado( M1, C1, 1),   % antes de moverse
      estado( M2, C2, 0) )  % despues de moverse
   :- M1 > 0, M2 is M1-1,  % un misionero y un canibal de derecha a i zquierda
      C1 > 0, C2 is C1-1, paso(M2, C2).

mover( estado( M1, C1, 0),   % antes de moverse
      estado( M2, C2, 1) )  % despues de moverse
   :- M1 < 3, M2 is M1+1,  % un misionero y un canibal de izquierda a derecha
      C1 < 3, C2 is C1+1, paso(M2, C2).

imprimir_solucion([X]) :- write(X), write(': estado inicial'), nl.
imprimir_solucion([X,Y|Z]) :- imprimir_solucion([Y | Z]), write(X), explain(Y, X), nl.

explain(estado(M1, C1, 1), estado(M2, C2, _)) :-
    X is M1-M2, Y is C1-C2,
    write(': '), write(X), write(' misioneros y '),
    write(Y), write(' mover canibales de derecha a izquierda ').
explain(estado(M1, C1, 0), estado(M2, C2, _)) :-
    X is M2-M1, Y is C2-C1,
    write(': '), write(X), write(' misioneros y'),
    write(Y), write(' canibales mover de izquierda a derecha ').



% implementacion de busqueda de primer paso
%  % Cada paso representa [Nodo | Antesesor], donde Node está en la lista abierta y
%  Antesesor es una ruta desde el nodo padre al nodo inicial del
%  árbol de búsqueda. Solución es un camino (en orden inverso) desde la
%  inicial hasta una meta.


primer_paso( [ Camino | _], Camino)  :-
    consulta_camino( Camino ).   %if si camino es consulta_camino entonces es la solucion

primer_paso( [Camino | Caminos], Solucion)  :-
  extend( Camino, Nuevocamino),
  append( Caminos, Nuevocamino, Caminos1),
  primer_paso( Caminos1, Solucion).

% recoje todas las condiciones.
extend( [Nodo | Camino], Nuevocamino)  :-
  setof( [Nuevonodo, Nodo | Camino],
         ( mover( Nodo, Nuevonodo), no(member( Nuevonodo, [Nodo | Camino] )) ),
         Nuevocamino),
  !.

extend( _, [] ).             % setof no tiene sucesor

no(P) :- P, !, fail.
no(_).



















