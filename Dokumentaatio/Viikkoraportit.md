Viikko 1:
Valitsin aiheeksi 15-pelin. Ohjelmointikieli on Java. Aihe oli selvä jo kauan
sitten. Aloitin kohtalaisella innolla, ja tähän mennessä olen tehnyt GUI:n
melkein valmiiksi. Peli on nimeltään 15-peli, mutta tein mahdolliseksi valita
ruudukon koon (laattojen määrän) ennen pelin alkua. Näin voit halutessasi
pelata vaikka 99-peliä! En ole kuitenkaan vielä varma, tuleeko algoritmini
ratkaisemaan yleistettyä versiota. Tulen kehittämään ratkaisualgoritmin itse.

Olennaisia etenemiskohtia tähän mennessä ovat taulukon generointi,
satunnaisen laattajärjestyksen generointi sekä laattojen siirtämislogiikka.
Olen käyttänyt ArrayListiä kerran apuna, mutta implementoin sen myöhemmin
itse. En ole aloittanut vielä ratkaisualgoritmin kirjoittamista.


Viiko 2:
Koodia on tällä viikolla tullut hyvin vähän. Tein viime viikolla niin runsaasti, että ajattelin
ottaa nyt iisimmin. Olen pelannut itseni eteväksi 15-pelissä ja alkanut suunnittelemaan, miten ratkaisun
voisi artikuloida koodiksi.

Olennaisimmat etenemioskohdat ovat varmaan laudan oikean järjestyksen tarkistus (O(n)) sekä 
koordinaattien hallinassa auttava apuolio.

Siirrot ovat tähän mennessä hyvin köykäisiä. Siirtoanimaatiota ei ole. Tein koordinaattien muuntaja -olion,
joka palauttaa syötteen perusteella joko laatan todelliset koordinaatit tai pelikoordinaatit.
Tätä käytän apuna animaation tekemisessä. Opiskelin myös Java MouseListener apia, mutta en implementoinut
vielä mitään. Nämä seikat ovat vain pelaajaa varten. Käytännössä olen valmis aloittamaan
itse ratkaisualgoritmin teon.

Viikko 3:
Paljon koodia sekä ideoita. Olen pelaillut 15-peliä paljon ja ratkaisun artikulointi koodiksi valkenee
pikkuhiljaa. Tajusin esim. että siirtoja on kahdenlaisia: olennaista laattaa siirtävä, sekä tyhjää tilaa
siirtävä. Aijon lähestyä ratkaisua rivi kerrallaan (rivien 1-3 ratkaisut ovat täysin/lähes identtiset).

Tärkein lisä projektiin on Ratkaisija-luokka, joka sisältää pelin ratkaisevan tekoälyn. Ratkaisu tulee 
koostumaan lukuisista metodeista, jotka kutsuvat systemaattisesti toisiaan. Ratkaisija-luokassa on
reilu 100 riviä koodia, mutta arvioin, että siihen tulee tähän vielä moninkertainen määrä.

Ohjelmoin myös animaatiota hallinnoivan peliloopin, joka kutsuu piirtoalustan repant-metodia. Pelilooppi
sijaitsee uudessa Peli-luokassa. Siirrot ovat edelleen köykäisiä (Laatta katoaa ja ilmestyy viereen).
Aloitin paremman animaation näpertelyn. Lopetin kuitenkin nopeasti, sillä toistaiseksi
tärkeintä on saada itse ratkaisualgo valmiiksi.

Viikko 4:
Käytin suurimman osan ajasta ydinaiheen kehittämiseen. Ratkaisija ratkoo jo koko pelin mutta ei täysin
jokaisesta alkutilanteesta. Bugeja on siis etsittävä ja korjattava. Muutama bugi onkin jo löytynyt vaikka
en niitä ole korjaamaan ehtinyt. Rivit 1 ja 2 ratkaistaan jokaisesta alkutilanteesta mitä olen viimeaikoina
testaillut.

Rivejä on tullut useita satoja, mutta koodia on turhankin paljon ja käytän paljon switch statementia.
Muutama metodi on myös yltynyt turhan pitkäksi ratkaisija luokassa. Rivien 1 ja 2 ratkaisevat metodit ovat
erilliset, mutta logiikaltaan identtiset, joten ne voisi varmaankin yhdistää. 

Aloitin omien tietorakenteiden tekemistä. Implementoin vain ArrayListin, joten hirveästi tekemistä ei ole.
Katsoin ArrayList java apista apua ja muualtakin netistä. Homma vaikuttaa aika selvältä. Oma ArrayListini
ei silti ole vielä valmis.


Viikko 5:
Päätehtävä lopullisesti valmiiksi. Sain sen jo tietämättäni viime viikolla valmiiksi muutamaa bugia lukuun
ottamatta. Muutin lähestymistapaa ratkaisuun ja huomasin, että ratkaisu ei vieläkään toimi vaan jää
joskus loputtomaan pyörittelylooppiin pelin lopussa. Hoksasin, että peliä ei ehkä olekaan edes mahdollista
ratkaista jokaisesta alkutilanteesta. Googlailin vähän ja tämä osoittautui todeksi. Vika olikin siis
laattojen arpovassa metodissa. Se ei saa olla täysin satunnainen. Vietin hävettävän paljon aikaa
yrittäen muokata ratkaisualgoa turhaan.

Tein siis uuden laattoja lisäävän metodin, joka koostuu kahdesta osasta: laattojen lisäämisestä oikeaan
järjestykseen ja niiden sekoittamisesta. Sekoitusmetodi on 200 iterointikierrosta satunnaisia
siirtoja. Implementoin myös siis satunnainenSiirto()-metodin.

Perus GUI ja työ on nyt valmis. Peli ei ole vielä käyttäjälle pelattava. Aloitin jo pari viikkoa sitten
MouseListenerin luomisen, mutta lopetin kesken. Tulevalla viikolla aion tehdä tämän loppuun, tehdä GUI:sta 
hieman paremman ja muutenvaan siistiä koodia.
