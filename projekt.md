# Tesztelési módszerek projekt

## A csapat tagjai

- Hajdú Zalán
- Rácz Norbert
- Vörös László

## A projekt

https://github.com/iFlameU/szakdolgozat

Rácz Norbert csapattársunk szakdolgozatát választottuk projektként. Ez egy Java nyelven írt projekt, JavaFX-et használ GUI-hoz, tesztek alapból nem voltak benne. JUnitot és Mockitot használtunk a teszteléshez

## A feladat

> Tesztesetek bővítése függvény szintű lefedettség alapján.

>     Eljárás szintű lefedettség-mérés megvalósítása.
>     Eljárás lefedettség növelése.
>     Teszt redundancia csökkentése.

## A tesztelés menete

- A feladatokat Githubon issuek formájában tartottuk számon, AI segítséggel írtunk egy szkriptet, ami a GitHub CLI-n keresztül minden egyes fájlhoz rendel egy issuet, így ezeket nem manuálisan kellett létrehozni, és mindenki hozzárendelte magához a fájlt, amit tesztelni kívánt, így a többiek nem tesztelték párhuzamosan. Így az Exception osztályokhoz is rendelt issuekat, azokat lezártuk, hisz nem volt bennük semmi override. 
- Az elkészített tesztekhez a csapat a jacoco lefedettségmérőjét és az Idea lefedettségmérőjét vegyesen használta. 
- Szükség volt reflection használatára privát metódusokhoz/adattagokhoz.
- Voltak tesztesetek, amikhez mockolni kellett osztályokat
- Mivel catch ágak tesztelésére szükség volt, és azokban van printStackTrace(), ezért a konzolra a tesztelés során kiírásra kerülnek hibaüzenetek, azonban ez a tesztek futását nem akadályozza.

## Elért eredmények

A kiindulási lefedettség egyértelműen 0 % volt. A kiinduló kód megtekinthető a `6f3d3fea` commit alatt.

A tesztelés végére az Idea alapján 55 % eljárás szintű lefedettséget értünk el. Míg ez a Jacoco szerint 53,56 %. Mivel alapból nem voltak tesztek, ezért megemlítenénk a többi lefedettséget is (azokat csak az Idea alapján): 49 % osztálylefedettség, 49% sorlefedettség.

A jacoco eredményt a zipben mellékeljük.

A teszt redundancia minimalizálása érdekében egy metódust csak egyszer teszteltünk (kivételt ezalól a konstruktorok jelenthetnek)

A tesztelés során pár hibára fény derült, ezeket a tesztek sikeres futtatása érdekében javítottuk.