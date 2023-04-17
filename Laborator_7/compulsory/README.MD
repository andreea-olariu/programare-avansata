1. Create an object oriented model of the problem.

    Clasele:
    - Cell care descrie un cell din matricea de explorat
    - Exploration care e superviser-ul
    - ExploationMap descrie matricea de explorat si metoda de vizitare a celului din aceasta
    - Robot care este un obiect ce implementeaza Runnable si este transmis ca parametru Thread-ului
    - SharedMemory este o clasa cu Tokens din care robotii aleg pentru a-i pune in celula matricei
    - Token 

2. Each robot will have a name and they must perform in a concurrent manner, moving randomly around the map and extracting tokens from the shared memory when reaching an unvisited cell.

    Robotul este transmis ca parametru la crearea unui Thread, adica Thread-ul va executa acel cod din Robot din metoda run(). Thread-ul se va termina cand atributul running al robotului va fi false, adica cand matricea este vizitata in totalitate. 
    Cat timp running este true, aleg random o linie si o coloana si robotul o viziteaza.

3. A message will be displayed on the screen every time a robot visits a new cell.
4. Simulate the exploration using a thread for each robot.
5. Pay attention to the synchronization of the threads when extracting tokens and when visiting cells.

   In momentul in care creez un Thread, il salvez in Exploration, deoarece astept terminarea tuturor Thread-urilor in main.
   Metoda visit() este synchronized, pentru ca monitorul sa il aiba obiectul care viziteaza.
   Lista de Tokens e de tipul CopyOnWriteArrayList pentru ca este o resursa care este impartita de Threads. 
