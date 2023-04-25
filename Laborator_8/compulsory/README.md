1.Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).

Postgres

2. Write an SQL script that will create the following tables:
albums: id, rele ase year, title, artist, genre(s)
artists: id, name (for example: Beatles)
genres: id, name (for example: Rock)
an associative (junction) table in order to store each album genres

    In src/main/scripts/script.sql

3. Update pom.xml, in order to add the database driver to the project libraries.

     <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.6.0</version>
    </dependency>

4. Create a singleton class in order to manage a connection to the database.

    Clasa Database

5. Create DAO classes that offer methods for managing artists, genres and albums (at least one).

    ArtistDAO care contine metodele create, findByName, findById, updateName, deleteByName

6. Implement a simple test using your classes.

   In src/test/java am implementat metoda findByNameTest()