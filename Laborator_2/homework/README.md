1. Create a class that describes an instance of the problem.

    Am numit clasa BestRouteProblem si contine ca date membru:
    - locations -> un ArrayList cu toate localitatile
    - roads -> un ArrayList cu toate drumurile
   Pe langa constructor, settere si gettere, contine metodele:
    - addLocation() -> adauga o localitate in locations
    - addRoute() -> adauga un drum in roads
    - validInstance() -> verifica ca toate drumurile sa fie determinate de locatii deja existente
    - isAnyRoad() -> construieste un graf cu localitatile (locations) ca noduri si drumurile (roads) ca muchii si apeleaza o metoda a grafului numita checkIfConnected() care ruleaza un algoritm DFS pentru a verifica existenta drumului

2. Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice.
   
   Pentru cele doua clase, metoda equals verifica daca doua obiecte de acel tip au aceleasi metode prin apelarea metodei toString().

3. Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific propertes (population, number of terminals, gas price, etc.)

   Am facut clasele City, Airport, GasStation care mostenesc clasa Location si clasele Express, Highway si Country care mostenesc clasa Road.

4. Implement a method that determines if a problem's instance is valid.

   Metoda ceruta este validInstance() de la punctul 1.

5. Implement an algorithm for determining if it is possible to go from one location to another using the given roads.

   In clasa Graph, am facut o metoda  checkIfConnected() care ia ca argumente doua localitati si, foloseste un algoritm DFS utilizant o stiva si un vector visited (pentru a contoriza localitatile deja vizitate) pentru a determina daca exista drum intre doua localitati.

6. Write doc comments in your source code and generate the class documentation using javadoc.