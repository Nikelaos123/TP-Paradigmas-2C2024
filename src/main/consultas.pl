%valores maximos promedios:
%Vida: 200
%Mana: 50
%Defensa 100
%Ataque 125

% rival(Nombre, Vida, Defensa)
rival(raul, 100, 20).
rival(pepe, 0, 0).
rival(jose, 20, 0).
rival(manuel, 10, 200).
rival(luis, 200, 100).


%decisiones de estrategia

curarse(Vida):- Vida < 50.

defenderse(Defensa):- Defensa < 25.


menosVida(Rival) :-
    rival(Rival, Vida, Def), Vida > 0, PT1 is Vida + Def,
    \+ ( rival(_, VidaMenor, DefMenor), VidaMenor > 0,
       ( VidaMenor + DefMenor) < (PT1) ).
        
    
    
    
    