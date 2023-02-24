1. Let n be an integer given as a command line argument. Validate the argument!

 Am creat clasa CommandLine in care metoda printIntArg() ia ca argument un String si incearca sa il converteasca intr-un int, daca nu poate apare o exceptie si un mesaj de numar invalid. In clasa Main am creat o instanta a clasei CommandLine si am apelat functia printIntArg cu primul argument dat la linia de comanda.

2. Create a n x n Latin Square as a matrix, having as symbols numbers from 1 to n.
  
  Pentru asta am creat o clasa Matrix a carei metode o sa le folosesc si pentru celelalte cerinte. Pentru a crea latinSquare, imi aloc un array de array de int si, pe fiecare linie a acestei matrici, pun o permutare a 1...n. Am observat ca linia i (numerotat de la 0) ar trebui sa inceapa cu i+1 si valorile cresc cu +1 atat timp cat raman <=n, de aceea am facut %n.
  
  
3. For each line, and each column of the matrix, create and display on the screen String objects representing the concatenation of the symbols in the respective line or column.

  Pe linia k si pe coloana k apar aceleasi elemente in aceeasi ordine, de aceea am o singura metoda, getSymbolsFromLineOrColumn() care imi concateneaza elementele de pe linia k, respectiv coloana k. Am pus restricta if(n < 2000), deoarece la cerinta urmatoare ne cere ca pentru numere mari sa afisam doar timpul. 
  
  
4. For larger n display ONLY the running time of the application in nanoseconds or milliseconds. Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.

  Folosind metoda System.currentTimeMillis() am calculat atat timpul inainte de constructia latinSquare (start), dar si timpul dupa constructia acesteia (end). Timpul pentru crearea latinSquare este diferenta dintre end si start.

5. Launch the application from the command line, for example: java Lab1 9.

  Am folosit comenzile javac Main.java si java Main 4 (4 fiind argumentul dat la linia de comanda pentru punctul 1).
