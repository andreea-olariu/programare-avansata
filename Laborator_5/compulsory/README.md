1. Create an object-oriented model of the problem. You should have at least the following classes: Catalog, Document. Create a class responsible with external operations regarding a catalog.

    Clasele:
    - Catalog
    - Document
    - Book (care extinde Document)
    - Article (care extinde Document)
    - CatalogController care se ocupa cu operatiile externe cu privire la catalog
    - LoadCatalogException o clasa ce se comporta ca un wrapper peste IOException si care extinde Exception si este aruncata cand apar exceptii la loadingul catalogului
    - SaveCatalogException o clasa ce se comporta ca un wrapper peste IOException si care extinde Exception si este aruncata cand apar exceptii la savingul catalogului

2. Implement the following methods representing commands that will manage the content of the catalog:
    - add: adds a new entry into the catalog;
    
        in clasa Catalog si adauga la o lista de documente unul nou primit ca parametru
    - toString: a textual representation of the catalog;
    
        in clasa Catalog si afiseaza numele si ce documente cuprinde catalogul
    - save: saves the catalog to an external file using JSON format; you may use Jackson or other library;
    
        in clasa CatalogController si, folosind ObjectMapper din libraria Jackson, parseaza un obiect de tip Catalog intr-un fisier JSON
    - load: loads the catalog from an external file.
    
        in clasa CatalogController si, folosind ObjectMapper din libraria Jackson, parseaza un fisier JSON intr-un obiect de tipul Catalog
        
   Pentru metodele load si save am creat cate o clasa de exceptii ce vor fi aruncate cand metodele writeValue() si readValue() ar arunca exceptii de tip IOException. In clasa Main am tratat aceste exceptii, deoarece nu le-am tratat in metodele save si load, ci le-am propagat prin adaugarea in semnatura a unei sintagme de tipul throws.
