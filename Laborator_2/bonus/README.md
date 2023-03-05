1. Create a class to describe the solution.

    Clasa BestRouteSolution contine:
   - length -> lungimea drumului
   - locations -> Locatiile prin care a trecut drumul
   - roads -> drumurile care alcatuiesc BestRoute

2. Implement an algorithm to find the best route from a location to another, either as the shortest route, or the fastest route.

    In clasa Graph, metoda shortestPath() calculeaza cel mai scurt drum la lungime dintre doua localitati pe baza algoritmului lui Dijkstra. Fata de tema, am schimbat reprezentarea grafului cu una pe baza de matrice (nu liste de adiacenta cum era la tema) pentru a calcula costurile drumului mai usor.
    Fiecarei localitati i-am atribuit un id unic pentru a construi matricea.
    Structuri de date folosite:
    - visited -> un HashSet pentru a asigura unicitatea fiecarui element unde se afla nodurile vizitate la un moment dat
    - costs -> un HashMap unde fiecare Location (key) are un cost (value) pentru a ajunge la ea din loc1 (data ca parametru)
    - before -> un HashMap unde fiecare Location (key) are un alt nod vizitat anterior (value) care e tot de tip Location

3. Generate large random instances of the problem and analyze the performance of your algorithm (running times, memory consumption).
    
    Pentru a calcula timpul, la inceputul algoritmului am calculat timpul folosind System.currentTimeMillis() si la final am facut la fel, ulterior am calculat diferenta.
    Pentru a calcula memoria folosita, am folosit un obiect de tipul Runtime si am facut diferenta runtime.totalMemory() - runtime.freeMemory() dupa ce am sugerat Garbage Collectorului sa porneasca prin runtime.gc();
