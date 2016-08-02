DOKUMENTAATIO

Määrittely:
Toteutan ja ratkasien työssäni klassisen 15-pelin. Pelin trkoituksena on
järjestää 15 laattaa laudalla, jossa voi siirtää vain yhtä laattaa kerrallaan
vain tiettyyn tyhjään paikkaan.
 
Pyrin käyttämään vain perustietorakenteita kuten 2-uloitteista taulukkoja
ja xy-koordinaatteja. Olen tosin jo käyttänyt ArrayList-rakennetta eli
dynaamista taulukkoa. Implementoi sen myöhemmin itse. Peli on idealtaan 
erittäin yksinkertainen, joten en usko tarvitsevani mitään muuta merkittävää.

Työn mielekkyys nojaa suurimmaksi osaksi ratkaisualgoritmin luomiseen.
Kyseisellä algoritmilla ei ole nimeä ja kehitän sen itse. Muita keskeisiä, 
mutta helpompia asiioita ovat satunnaisen palikkajärjestyksen generointi sekä
järjestyksen tarkistus (eli onko peli valmis vai ei).

Ohjelma ottaa syötteena käskyjä, jotka kertovat siirrettävän palikan
koordinaatit pelilaudalla sekä siirtosuunnan. Ohjelma tarkistaa, onko siirto 
laillinen, ja myönteisessä tapauksessa siirtää palikkaa kyseiseen suuntaan.
Teen peliin kuitenkin pelaajalle GUI:n joka toimii "click and drag"-periaatteella.

Aikavaativuustavoitteeni joudun asettamaan aika korkealle näin aluksi ainakin.
Ratakisualgoritmini tulisi toimia O(n²)-vauhdilla. Voi olla, että tämäkin jää
haaveeksi ja että aikavaativuudesta tuleekin eksponentiaalinen. Satunnaisen
järjestyksen generointi sekä järjestyksen tarkistus saadaan mukavasti O(n)
vauhtiin.

Tilavaativuus ohjelmalle on toki O(n). Pelin konsepti on tarpeeksi helppo.
Muistissa on ainoastaan pidettävä laattojen järjestys. Muu on turhaa.

Lähteet: HY:n Tietorakenteet ja Algoritmit -kurssin luentomateriaali
syksy 2015 (Luennoitsija Patrik Floreen) 
