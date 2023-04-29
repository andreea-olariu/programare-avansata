1. Create an object-oriented model of the data managed by the Java application.

    Clasele Album, Artist, Genre ce mostenesc clasa abstracta Entity

2. Implement all the DAO classes.

   Clasele AlbumDAO, ArtistDAO, GenreDAO ce mostenesc clasa abstracta EntityDAO

3. Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.

      ```pool = new ComboPooledDataSource();
      pool.setDriverClass("org.postgresql.Driver");
      pool.setJdbcUrl(URL);```
      // La pool am stabilit conexiunwa

4. Create a tool to import data from a real dataset, such as Rolling Stone's 500 Greatest Albums of All Time (or other)

   Am folosit com.opencsv.CSVReader si cum am folosit acest tool e implementat in clasa DataManipulationTool