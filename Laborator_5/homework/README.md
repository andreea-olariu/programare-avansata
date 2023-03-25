1. Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command.

    Interfata Command reprezinta generalizarea comportamentului unei comenzi, avand o metoda de getHelp()

Implement the commands 
   - load,
        
        Clasa LoadCommand da load unui catalog dintr-un fisier JSON extern folosind libraria Jackson

   - list: prints the list of documents on the screen

        Clasa ListCommand afiseaza documentele dintr-un catalog dat ca parametru functiei statice care se ocupa de actiunea comenzii

   - view: opens a document using the native operating system application (see the Desktop class)

        In clasa ViewCommand, metoda action() foloseste clasa Desktop pentru a deschide aplicatia specifica sistemului de operare si afiseaza continutul fisierului
    
   - report: creates (and opens) an HTML report representing the content of the catalog.
   Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.

        In clasa ReportCommand, metoda action() se foloseste de template engine-ul FreeMakerker pentru a genera un fisier HTML cu documentele din obiectul de tip Catalog transmis ca parametru care poate fi ulterior deschis intr-un browser.

2. The application will signal invalid data or the commands that are not valid using custom exceptions.

    In package-ul exception, exista clase ce descriu exceptii pentru fiecare comanda si au cate un mesaj specific. Aceste exceptii functioneaza ca wrappere pentru exceptiile ce sunt aruncate de functiile folosite in interiorul claselor de comenzi. 

3. The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.

    Am folosit comanda **jar cf homework_jar.jar**
