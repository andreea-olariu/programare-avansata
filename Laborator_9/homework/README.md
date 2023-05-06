1. Create all entity classes and repositories. Implement properly the one-to-many and many-to-many relationships.

    Fiecare model are @Entity si in clasa Album am implementat relatiile one-to-many (de la artist la album) si many-to-many (de la album la genuri)

2. Create a generic AbstractRepository using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework.
    
    Interfata AbstractRepository

3. Insert, using JPA, a large number of fake artists and albums in the database and log the execution time of your JPQL statements.

    Am folosit acelasi csv ca la laboratorul 8 si am introdus datele aferente in baza de date si folosind System.currentTimeMillis() am calculat diferenta de la inceputul executiei JPQL pana la finalul acesteia si finalizarea insertiei in baza de date