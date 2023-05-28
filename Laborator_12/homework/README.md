The input may be a folder (containing .class files) or a .jar. You must explore it recursively.

    - Am facut o metoda de loadClassesFromDirectory() care primeste ca argument un path si parcurge continutul acestuia. Daca intalneste director => apeleaza recursiv aceeasi functie; altfel, adauga in lista clasa.

Create the complete prototype, in the same manner as javap tool.

    - Am creat o metoda de classDetails() care afiseaza informatii despre clasa

Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not.

    - Folosind Modifier si metode specifice unui obiect de tipul Method, am identificat metodele cerute si le-am invocat

If a method requires primitive (at least int) or String arguments, generate mock values for them.
Print a statistics regarding the tests.

    - in testStatistics() am afisat detalii despre teste dintr-o clasa data ca parametru