1. The input will be a .class file, located anywhere in the file system.

    Clasele Cat si CatTest

2. Load the specified class in memory, identifying dynamically its package.

    Am folosit un ClassLoader si metoda acestuia loadClass() pentru a da load clasei si prin metoda getPackage() a obiectului de tip Class rezultat am extras pachetul

3. Using reflection, extract as many information about the class (at least its methods).

    Am folosit metoda getMethods() a clasei Class

4. Using reflection, invoke the static methods, with no arguments, annotated with @Test.

    Pentru clasa de test, am verificat cele 3 conditii. Am pus in acea metoda si un mesaj care se afiseaza in consola, deoarece am mock-uit rularea acelei metode prin invoke()