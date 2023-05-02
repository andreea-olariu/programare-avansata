1. Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).
Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).

    In /Users/andreeaolariu/Facultate/programare-avansata/Laborator_9/compulsory/src/main/resources/META-INF/persistence.xml

2. Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.

    Am folosit @Entity (pt a arata conexiunea intre clasa si tabel), @Table, @Id (pt a specifica primary key),
   @GeneratedValue(strategy = GenerationType.AUTO) pt a genera un id automat in package-ul Models

3. Create a singleton responsible with the management of an EntityManagerFactory object.

    Clasa Database Operations

4. Define repository clases for your entities (at least one). They must contain the following methods:
create - receives an entity and saves it into the database;
findById - returns an entity based on its primary key;
findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.

   Folosind @NamedQueries si functiile aferente din AlbumsRepository 

5. Test your application.

    In test/java/Repositories am facut o clasa de test pentru AlbumRepository