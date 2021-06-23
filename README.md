# BlackJack-with-GUI
Aplicatia constra intr-un joc de Blackjack cu sistem de betting.\
Jocul de Blackjack se joaca intre doi jucatori (dealer si jucator), castigatorul fiind cel care face cea mai apropiata suma de 21 (dar nu peste) din cartile sale.O explicatie mai detaliata a regulilor poate fi gasita in aplicatie in tabul "Reguli Blackjack".\
Mai jos se va regasi o scurta prezentare a claselor precum si cateva poze ale jocului.\
_Majoritatea codului contine comentarii explicative_

### Clasele Jocului si prezentare a metodelor importante :
 - Card (clasa cartii de joc):
 ```
 Aceasta clasa reprezinta cartea de joc ca un obiect, aceasta avand simbol si numar
 ```
 - CardDeck (clasa pentru pachetul de carti de joc):
 ```
- constructor care construieste pachetul de carti
- metoda getCard(): selecteaza o carte din pachet (o returneaza si ii da remove)
- metoda shuffleDeck(): shuffle pachetului de carti
 ```
 - CardHand (clasa pentru a mentine mainile jucatorilor)
 ```
 - metoda addCard(Card x): adauga o carte la o mana de joc
 - metoda sumHard(): calculeaza valoarea cartilor unei maini
 ```
 - Blackjack ( clasa jocului)
 ```
 - constructorul clasei initializeaza jocul, primul screen al aplicatiei in care se poate plasa bet-ul (se si verifica validitatea acestuia) si se pot citi regulile
 - metoda stardGame() este practic jocul in sine
 - metoda drawCard(String ImageName, int poz, String type) este folosita pentru a desena cartile de joc pe GUI
 ```
 - GUI ( o clasa folosita doar pentru a testa functionalitatile swing / inactiva in proiect)
 - MainBlackJack (se ruleaza pentru a se juca jocul in consola)
 - BetaTest (se ruleaza pentru a se juca jocul cu interfata GUI)
  ```
  Se apeleaza clasa jocului
 ```
### Prezentarea unui joc

