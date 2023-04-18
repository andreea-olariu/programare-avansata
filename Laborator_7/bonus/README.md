1. Consider the case in which the agents explore a graph and the goal is to visit each vertex in a concurrent fashion (collaborative graph exploration).

2. Using Graph4J API, implement such an algorithm.

    - Am generat random un graf in constructorul acestei clase
    - In metoda visit() din clasa ExplorationGraph caut primul nod nevizitat si acesta e vizitat
    - Metoda visit() este executata de fiecare robot si, cand metoda visit() returneaza fals, oprim robotul - adica cand toate nodurile sunt deja vizitate

4. You may also consider implementing a concurrent algorithm for determining a minimum spanning tree in a weighted graph or other graph algorithms that support parallelization.

   - Am folosit algoritmul lui Prim implementat in clasa ExplorationGraph in metoda MST(). Metoda e executata de fiecare robot.
   - Daca in MST() am visitat toate nodurile, returnez false si asta inseamna ca robotii se vor opri
   - Am pus lock pe lista de visited - care arata ordinea MST - in momentul in care adaug noduri pentru a ma asigura ca un singur thread adauga acel nod gasit
