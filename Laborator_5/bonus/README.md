1. Use Apache Tika in order to extract metadata from your catalog items and implement the command info in order to display them.

    In clasa InfoCommand, am folosit un Parser din API-ul Apache Tika pentru a parsa metadate despre documentele din catalog si am afisat acele informatii in consola. 

2. Each document has a set of tags (extracted metadata, or manually set by user). Two documents are related if they have a common tag.
Using a minimum number of colors (labels), assign each document a color such that related documents have distinct colors.
You may want to read about exact algorithms for the graph coloring problem.
Implement using Graph4J API Brown coloring algorithm or other coloring algorithm.

    Aceasta problema e gestionata in clasa GraphColoring. 
    Mai intai, am creat functia buildGraph() care creaza un graf ce contine ca noduri id-urile documentelor si exista o muchie de la un nod la celalalt daca acestea au cel putin un tag in comun.
    Am scris un algoritm in metoda greedyColoring() pentru colorarea nodurilor folosind culori (ce au ca labeluri numere) si strategia algoritmului e sa parcurga lista de noduri si, pentru acel nod, sa aleaga prima culoare care este disponibila (prima culoare dintr-o lista de culori cu proprietatea ca nu exista un vecin al nodului respectiv care sa aiba acea culoare). 
    Am afisat la consola id-ul nodului impreuna cu culoarea asociata in urma executarii algoritmului, coloarea prezentandu-se ca un Map ce contine id-ul nodului si culoarea asociata.

3. Create large instances of the problem and test your algorithm (against JGraphT or other library implementations).

    Pentru a crea instante ale problemei, am creat o clasa InstanceGenerator care ia in constructor un numar X si va genera X instante ale problemei, adica un catalog cu X documente. 
    Pentru asta, m-am folosit de libraria Jackson pentru a atribui date random documentelor din catalog.
    Am folosit algoritmul BrownBacktrackColoring din libraria JGraphT si am obtinut un rezultat asemanator cu algoritmul Greedy implementat de mine.