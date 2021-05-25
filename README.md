# Backgammon

## Dezvoltatori:
* [Gosman Vlad Andrei](https://github.com/GosmanVlad)
* [Luca Andrei Iulian](https://github.com/andreiiulianluca)

## Planificare dezvoltare

Logica generala:

- Initial piesele vor fi impartite pe tabla dupa regula jocului.
- Primul jucator va fi culoarea alba (ne vom gandi la o solutie random pentru ca fiecare jucator sa fie in egalitate).
- Fiecare triunghi va reprezenta un slot de pe tabla, care va retine numarul de piese detinute si culoarea lor. In functie de numarul sloturilor ne putem da seama daca mutarea unei piese este posibila. Totodata, ne putem da seama daca un jucator este in bearoff (pe margine/mancat).
- Se va aplica logica jocului standard (sa NU poti muta inapoi/deasupra unei piese oponente/in slotul gresit/sa muti daca nu exista mutari posibile/esti in bearoff si vrei sa muti alta piesa/sa mananci o piesa oponenta daca in slotul lui sunt cel putin 2 piese/sa scoti piese de pe tabla daca nu ai toate piesele in casa/sa scoti piese de pe tabla de pe slotul gresit (ai 2 pe zar si vrei sa scoti o piesa de pe slotul 3 sau de pe slotul 1 avand piese pe slotul 4, 5,etc).
- Fiecare triunghi va reprezenta un slot de pe tabla de joc
- Fiecare slot va fi defapt un obiect al unei clase care va contine piesele proprii (Ex: Daca avem 6 piese pe slotul 2 - obiectul slot va contine un int cu numarul de piese si culoarea care ocupa acel slot. Astfel, vom putea implementa logica jocului)
- Daca un slot va avea ca numar de piese = 6, piesele de aceeasi culoare care vor ocupa acest slot, vor fi asezate deasupra pieselor existente cu un view care sa sugereze asta).


# Tasks

## Prezentare baza de date
- S-a creat doua tabele: players si games; In tabela players vor fi inregistrati cei doi jucatori a caror nume este introdus la inceputu jocului. In tabela games vor fi inregistrati jucatorii la finalul jocului (jucatorul1, jucatorul2 si castigatorul)
- Dezvoltatori functionalitate: Andrei (75%), Vlad (15%)


## Pozitionare click
- In functie de pozitia click-ului dat, se identifica slotul aferent.

- Dezvoltatori: Vlad (75%), Andrei (15%)

## Mutare piese
- De adaugat posibilitatea de a muta piesele pe tabla.

- Dezvoltatori: Vlad (50%), Andrei (50%)

## Design
- De creat JFrame-ul principal
- De creat tabla de joc in sine (triunghiuri, bearoff + zona unde vor fi plasata piesele scoase)
- De impartit piesele pe tabla
- De adaugat design pentru zaruri
- De adaugat design pentru punctele de pe zar, reprezentand numarul generat random la aruncarea zarurilor
- Cand selectezi o piesa de pe tabla, sa iti apara un marker pe slotul respectiv.

- Dezvoltatori: Vlad (50% - design zaruri + piese + marker piesa selectata), Andrei (50% - design tabla + triunghiuri + text info + marker piesa selectata)

# Bugs
## #1 Bug zaruri
- Daca este randul jucatorului WHITE si are aceste zaruri: 5 si 3 (sau altele, dar diferite), iar jucatorul WHITE muta o piesa peste 5 sloturi (foloseste zarul 5), zarul nu dispare, iar mutarea este posibila de 5 ori.

- Status: ***rezolvat***

## #2 Mutare piese de pe margine
- Atunci cand un jucator este pe margine (mancat) si arunca cu zarul, nu poate muta pe nici un slot disponibil, primeste "Mutare invalida"

- Status: ***rezolvat***


# Nu s-a putut implementa:
- Conectarea in retea
- Inteligenta artificiala

# Imagine generala:
![Joc](https://i.postimg.cc/SxY7hGNk/Untitled.png)
