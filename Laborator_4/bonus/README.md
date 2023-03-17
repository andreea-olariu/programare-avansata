1. Implement an algorithm that determines the maximum cardinality matching
... or you may use the following libraries in order to solve it:
JGraphT
Graph4J

    Am folosit metoda getMatching() din clasa  HopcroftKarpMaximumCardinalityBipartiteMatching a librariei JGraphT.
    Graful din problema este unul bipartit, un set de noduri fiind studentii, iar celalalt set fiind proiectele. 

2. Create a random problem generator (with thousands of objects) and test the performance of the implementation (try both libraries).
    
    Am creat metodele generateRandomInstancesStudents(), generateRandomInstancesProjects(), setRandomPreferences() folosindu-ma de streamuri si javafaker pentru a atribui nume studentilor si proiectelor. 
    
3. Compare the results with the ones obtained by the greedy algorithm.

    Am folosit metoda System.currentTimeMillis(); pentru a calcula diferenta de timp in care se executa fiecare algoritm. Algoritmul Greedy este mai rapid. 

4. Determine a minimum cardinality set formed of students and projects with the property that each admissible pair (student-project) contains at least an element of this set.

    In metoda minimumCardinalityVertexCover(), am folosit metoda getVertexCover() a clasei RecursiveExactVCImpl din libraria JGraphT, deoarece o multime minima care sa contina macar una din capetele matchingului este un vertex cover.

5. Determine a maximum cardinality set of of students and projects such that there is no admissible pair (student-project) formed with elements of this set.
    
    In metoda maximumCardinalityIndependentSet(), am calculat diferenta dintre toate nodurile si nodurile din vertex cover, obtinand astfel maximum independent set, deoarece exista aceasta legatura intre cele doua notiuni: min vertex cover + max independent set = toate nodurile. 