1. Create an object-oriented model of the problem. You should have (at least) the following classes: Location, Road.
The location and road types will be implemented as enums.

    Am creat urmatoarele clase: 
        - Location:
              - are 4 private data members: name, type, x, y
              - constructor care are ca 4 argumente pentru initializarea celor 4 data members
              - getters / setters pentru fiecare data member
              - metoda toString() care afiseaza informatii despre instanta
           - Road:
               - are 5 private data members: length, speedLimit, roadType, loc1, loc2 (ultimele 2 fiind de tip Location definit anterior)
               - constructor care are ca 5 argumente pentru initializarea celor 5 data members si valideaza ca lungimea sa nu fie mai mica decat distanta euclidiana, altfel returneaza o exceptie
               - getters / setters pentru fiecare data member
               - metoda validateLength() care verifica daca length introdus e valid
               - metoda toString() care afiseaza informatii despre instanta

2. Each class should have appropriate constructors, getters and setters.
Use the IDE features for code generation, such as generating getters and setters.
3. The toString method form the Object class must be properly overridden for all the classes.
Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
4. Create and print on the screen various objects of the two classes.

    Am folosit metoda toString() pentru a afisa informatii careia i-am dat override la punctul anterior