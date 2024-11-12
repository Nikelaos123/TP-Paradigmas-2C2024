%valores maximos promedios:
%Vida: 200
%Mana: 50
%Defensa 100
%Ataque 125


%Biblioteca de funciones

vivos(Res):-
    rival(Res,Vida,_), Vida > 0.


%decisiones de estrategia

curarse(Vida):- Vida < 10.

defenderse(Defensa):- Defensa < 15.

menosVida(Rival) :-
    rival(Rival, Vida, Def), Vida > 0, PT1 is Vida + Def,
    \+ ( rival(_, VidaMenor, DefMenor), VidaMenor > 0,
       ( VidaMenor + DefMenor) < (PT1) ).
        
    
    
    
    