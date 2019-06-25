# BIFI

TODO:
* 🗹 - MongoDb opzetten en connectie maken met de server - Nynke
* 🗹 - MySql opzetten - Nick
* 🗹 - Modelen maken - Robin
* 🗹 - Modelen exporteren naar .eif - Robin
* 🗹 - Jar inlezen - Patrick
* 🗹 - Gegevens inlezen in model - Luuk
* 🗹 - Gegevens inlezen vanuit jar. - Luuk


1. Je runt de JAR (java programma) met CLI argument: maand nummer (e.g 1)
2. Applicatie haalt alle bedrijven op
3. Loopt over alle bedrijven en haalt gegevens op.
4. Stopt gegevens in Model
5. Model wordt geparsed naar .eif.
6. .eif wordt naar disk geschreven.


Rekening houden met:
* Mag maar 1 bedrijf (type k) per .ief bestand.
* Date format is int en ddmmyy (e.g 010119)
* Textregel wordt aangemaakt als factuur regel omscrhijving langer dan 60 chars is.
* dobuel (5,2): 10,04 = 0001004
* Indien staatnaam begint met een - dan wordt het addres uit de jar gehaald.
