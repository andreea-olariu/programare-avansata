1. Implement the commands that start/pause the robots (all of them or only a specific one). A robot can be paused for a specific time or indefinitely, requiring a start command.
The commands must be given using the keyboard.

    In clasa Exploration, metoda getCommand() accepta de la tastatura o comanda si:

   P = pause -> iterez prin lista de thread-uri si apelez metoda wait() pentru fiecare din ele

   R = resume -> apelez metoda notifyAll() din thread-ul 'main'

   Pentru ambele metode am pus lock pe lista de thread-uri.

2. Design an algorithm such that each robots will try to explore the map in a systematic fashion, ensuring the termination of the exploration process.

   Robotul va explora prima celula nevizitata.

3. Implement a timekeeper thread that runs concurrently with the player threads, as a daemon. This thread will display the running time of the exploration and it will stop it exceeds a certain time limit.
   
   Am creat un thread si logica propiu-zisa am implementat-o in clasa Timekeeper care implementeaza interfata Runnable. Un obiect de acest tip este transmis in constructorul thread-ului daemon.
   In metoda run() am adaugat un while() care este executat atat timp cat proprietatea running este true. Proprietatea running devine false in momentul in care timpul executiei depaseste limita data c proprietate in clasa Timekeeper.
   

5. At the end of the exploration, determine how many tokens each robot has placed in the matrix.
   
   Pentru fiecare robot am adaugat o proprietate nrOfTokens care tine numarul de tokens utilizati. Numarul este afisat la finalul thread-ului main, dupa ce thread-urile care gestioneaza munca robotilor s-au finalizat. 