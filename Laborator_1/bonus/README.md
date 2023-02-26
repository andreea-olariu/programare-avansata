1. Create the adjacency matrix A of a cycle graph Cn and compute the powers A2, A3, .... An. Give an interpretation of the result.
    
    - Aceasta problema am rezolvat-o in metoda instantei prob a clasei Problems numita cycleGraphProblem().
    - Am creat o clasa CycleGraph care mosteneste clasa Graph 
    - si o clasa Matrix care ma ajuta cu definirea matricei de adiacenta si diverse operatii facute pe matrice. 
    - In clasa Matrix am un constructor care imi initializeaza matricea care are n linii si m coloane date ca argumente in constructor.
    
    Am construit matricea de adiacenta a grafului circuit astfel: 
    - fiecare nod i (diferit de nodul 1 si nodul n) este vecin cu nodul i+1 si nodul i-1.
    - Caz special: nodurile 1 si n, deoarece 1 e vecin cu 2 si n, iar n e vecin cu n-1 si 1. 
    - In clasa Matrix exista si o metoda multiply si pentru fiecare numar x de la 1..n calculez matricea de adiacenta la puterea x si verific o exceptie in cazul in care dimensiunile matricelor nu sunt compatibile.

2. Create the adjacency matrix of a regular graph. The number of vertices and the vertex degree are given as arguments.  

   - Aceasta problema am rezolvat-o in metoda instantei prob a clasei Problems numita regularGraphProblem().
   - Am creat o clasa RegularGraph care mosteneste clasa Graph si am folosit aceeasi clasa Matrix.
   - Am construit matricea de adiacenta a grafului astfel:
   
    Am construit matricea de adiacenta a grafului regulat astfel: 
    - Validez conditiile de graf regulat: n < degree + 1 || n * degree % 2 != 0
    - Pentru fiecare nod i de la 1..n, aleg niste vecini random astfel incat acel vecin > i si ma asigur ca oglindesc matricea
    - Aleg vecini cat timp suma pe linie < gradul dat
    - Daca cumva sunt in imposibilitatea de a mai alege vecini sau suma pe linie > grad, o iau de la capat pana cand construiesc o matrice valida
