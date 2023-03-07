1. Create an object-oriented model of the problem. You should have at least the following classes Person, Company.

    Am creat clasele:
    - Network 
    - Company (implements Comparable, Node)
    - Person (implements Comparable, Node)
      - Employee (extends Person)
        - Programmer (extends Employee)
        - Designer (extends Employee)
    Si interfata:
    - Node

2. Both classes should implement the interface java.util.Comparable. The natural order of the objects will be given by their names.
    
    Am dat override la metoda toString() atat pentru clasa Person, cat si pentru clasa Company si pentru a compara obiectele am folosit aceasta metoda. 

    Metoda compareTo() ajuta la implementarea metodei equalsTo() pe care o folosesc cand adaug useri in network pentru a nu adauga duplicate.

3. Create the interface Node that defines the method used to obtain the name of a person or company. The classes above must implement this interface.

    Metoda implementata pentru a obtine numele persoanei/companiei este getUniqueName(). In cerinta problemei scrie ca in network entitatile au nume unic.

4. Create a java.util.List containing node objects and print it on the screen.

    Am implementat un List\<Node\> in clasa Network si am dat overrire la metoda toString() pentru a afisa pe ecran entitatile din network.