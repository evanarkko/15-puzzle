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


Toteutus:

Ohjelma on siis erityislaatuinen järjestämisalgoritmi. Algoritmi järjestää kaksiuloitteisen
taulukon käyttämällä vain tiettyjä liikkeitä: arvo (laatta) siirtyy nykyiseltä taulukolta edelliseen
tai seuraavaan taulukkoon samalle indeksille (ylös/alas) tai arvo siirtyy nykyisellä taulukolla
indeksin taakse tai eteen (vasen/oikea). Paikka, johon siirrytään, on oltava myös tietenkin tyhjä.
Ratkaisualgoritmini järjestää taulukon arvo kerrallaan: ensin 1 paikoilleen, sitten 2, jne. 

Oma algoritmini on eriokoistunut 15-peliin, eli se toimii vain 4x4-taulukolla. Arvelen, että
yleistäminen mielivaltaisen suurelle taulukolle ei ole kovin vaikeaa valmiin algoritmini pohjalta.
Ratkaisulogiikka pelissä pysyy täysin samana koosta huolimatta. Vain välimatkat pitenisivät.

Pisin välimatka pelilaudalla on yhdestä nurkasta vastakkaiseen nurkkaan. Tämä on 3 siirtoa
vaakasuunnassa ja 3 siirtoa pystysuunnassa. Jokainen kys. siirroista pitää lisäksi alustaa
viemällä tyhjä tila siirrettävän laatan viereen. Alustaminen vie pahimmassa tapauksessa 6
siirtoa. Pelin ratkaisuun tarvitaan siis nopealla analyysillä "pahimmassa tapauksessa" 
15*(3+3)*6=540 siirtoa. Tämä pahin tapaus on kuitenkin käytännössä mahdoton. 20:n
suorituskerran keskiarvo oli 131 siirtoa. Minimi ja maksimi olivat 106 ja 195. 

Koska jokainen siirto on vakioaikainen operaatio, toimii järjestysalgoritmini ajassa O(n), 
missä n on syötteen koko, eli tässä tapauksessa 15. Aikavaativuus pysyisi toki samana, vaikka
algoritmini yleistäisi suuremmalle taulukolle. Tilavaativuus on sama, minkä arvioin
määrittelydokumentaatiossa eli O(n). Ratkaisualgortimi ei pidä siirtoja muistissa vaan arvioi
aina seuraavaksi parhaan siirron uudestaan.

Suorituskykytestauksessa ratkaisussa kestää keskimäärin 8,4ms (20 ensimmäistä otantaa).
Ratkaisuvauhti kuitenkin nopeutuu muutaman suorituskerran jälkeen. 10:n jälkimmäisen otannan
vauhti oli keskimäärin vain 3,7ms. En ole varma mistä muutos johtuu. Laudan sekoittaminen on
joka kerta yhtä monta satunnaista siirtoa (250).

Optimoimalla ratkaisualgoritmia arvelen, että keskimääräistä siirtomäärää voisi vähentää noin
30:llä siirrolla eli saada keskiarvo noin 100 siirtoon. Tässä ei muuttuisi aikavaativuus, vaan
nopeutuminen perustuisi parempaan ratkaisulogiikkaan. Pystyn itse ratkaisemaan pelin aina
noin 80:llä siirrolla.


Testaus:

Ohjelman peruslogiikka on testattu JUnitilla kattavasti. Ratkaisija luokan testaaminen
ei ole yhtä triviaalia. Ratkaisija luokan konkreettisimat metodit ovat testattu JUnitilla,
mutta koska ratkaisija-olion seuraava siirto riippuu aina senhetkiosestä uniikista
pelitilanteesta, on ratkaisualgoa testattu vain käsin: suorittamalla ratkaisu useaan 
kertaan ja tulkitsemalla lopputulosta.
