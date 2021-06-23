# BlackJack-with-GUI
Aplicatia constra intr-un joc de Blackjack cu sistem de betting.\
Jocul de Blackjack se joaca intre doi jucatori (dealer si jucator), castigatorul fiind cel care face cea mai apropiata suma de 21 (dar nu peste) din cartile sale.O explicatie mai detaliata a regulilor poate fi gasita in aplicatie in tabul "Reguli Blackjack".\
Mai jos se va regasi o scurta prezentare a claselor precum si cateva poze ale jocului.\
_Majoritatea codului contine comentarii explicative_

## Clasele Jocului si prezentare a metodelor importante :
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
## Prezentarea unui joc
### Meniul jocului
![image](https://user-images.githubusercontent.com/61537857/123121744-16ccf300-d44e-11eb-8153-ed28a4790f0c.png)

#### Se pot citi regulile apasand butonul "Game Rules"
![image](https://user-images.githubusercontent.com/61537857/123121639-00bf3280-d44e-11eb-96d5-9f5282964110.png)

#### Se plaseaza bet-ul
**Acesta trebuie sa fie un numar <= balanta din cont**
![image](https://user-images.githubusercontent.com/61537857/123121313-bdfd5a80-d44d-11eb-8a6f-6fc0b03ec87a.png)
![image](https://user-images.githubusercontent.com/61537857/123121396-cc4b7680-d44d-11eb-8acb-931df7155a75.png)
![image](https://user-images.githubusercontent.com/61537857/123121452-d8373880-d44d-11eb-80bf-5ea98fdc655a.png)



