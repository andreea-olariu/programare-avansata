- Create a package with the name res. Inside this package create the files: Messages.properties, Messages_ro.properties.
    
    - In resources/res se afla cele 2 fisiere de limba romana si limba engleza. 


- Create the package com and implement the following classes describing commands:\
DisplayLocales: to display all available locales

  - In clasa DisplayLocales iau toate locatiile existente prin Locale.getAvailableLocales()
  - se afiseaza numele tarii + codul tarii, limba vorbita + codul limbii.


- SetLocale: to set the application current locale.

  - In clasa SetLocale schimb locatia se schimba prin Locale.setDefault() si codul limbii vorbite in acea tara.


- Info: to display informations about the current or a specific locale.
When the user sets a specific language tag, various information obtained using standard Java classes such as Currency or DateFormatSymbols should be displayed in a text area, as in the following example:
Country: Romania (România)
Language: Romanian (română)
Currency: RON (Romanian Leu)
Week Days: luni, marţi, miercuri, joi, vineri, sâmbătă, duminică
Months: ianuarie, februarie, martie, aprilie, mai, iunie, iulie, august, septembrie, octombrie, noiembrie, decembrie
Today: May 8, 2016 (8 mai 2016)

    - In clasa Info se afiseaza date despre locatia default sau una data ca parametru cu tagul limbii
    - se afiseaza numele tarii, codul tarii, limba si codul acesteia, moneda, zilele saptamanii si lunile.

  
- Create the package app and the main class LocaleExplore. Inside this class, read commands from the keyboard and execute them.

    - In clasa LocaleExplore citesc comenzi cu un Scanner si in functie de acestea afisez / cer detalii de la utilizator.

    
- All the locale-sensitive information should be translated in at least two languages (english-default and romanian), using the resource files.

    - Prin comanda set citita cu Scanner se schimba limba in functie de tagul dat si cele doua fisiere in engleza si romana.