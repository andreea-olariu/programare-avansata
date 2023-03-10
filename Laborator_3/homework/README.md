1. Create the complete model: Person, Programmer, Designer, Company. All persons have a birth date. Each class must have at least one specific property, that others don't have (be creative).
    Am urmatoarele clase:
    - Company (date membru specifice: name, un List<Employee> employees)
    - Date (date membru specifice: day, month, year)
    - Network (date membru specifice: un List<Node> users)
    - Person (date membru specifice: name, surname, age, un Map<Node, String> relationships, dateOfBirth)
      - Employee (date membru specifice: job, experienceYears)
        - Designer (date membru specifice: designingYears, designingStyle)
        - Programmer (date membru specifice: programmingYears, programmingLanguage)
    si interfata Node


2. Each person will contain a Map defining the relationships to other persons or companies.

    protected Map<Node, String> relationships;

3. Create the Network class containing a List of identifiable nodes.

   private List<Node> users;

4. Create a method that computes the importance of a node in the network, as the number of its connections to other nodes.
    
    Am creat o metoda computeImportance() in interfata Node care va fi implementata in clasele Person si Company astfel:
        In cazul obiectelor de tipul Person: numarul de relatii
        In cazul obiectelor de tipul Company: numarul de angajati

5. Create a network object containing persons, companies and relationships and print it on the screen. When printing the network, the nodes must be ordered according to their importance.

    Am dat override la metoda toString() in clasa Network pentru a afisa. Am creat o copye a userilor din Network si i-am sortat dupa importanta, dupa care am afisat detalii despre fiecare conform metodei toString() careia i-am dat override si in clasele Person, Employee, Designer, Programmer si Company