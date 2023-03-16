1. Create a class that describes the problem.

    Clasa StudentAllocationProblem care are:
    - proprietatile
      - numberOfInstances (cate proiecte/studenti generam random)
      - List<Student> students (lista studentilor)
      - Set<Project> projects (set cu proiecte)
    - metodele
      - gettere / settere pentru proprietati
      - computeAveragePreferencesSize() ce calculeaza media size-ului listei de preferinte a studentilor
      - generateRandomInstancesStudents() / generateRandomInstancesProjects() genereaza instante random in numar de numberOfInstances pentru proiecte si studenti
      - setRandomPreferences() care seteaza un numar random de preferinte fiecarui student ( >= 1)
      - printStudentsWithLessPreferences()
      - buildMatching()

2. Using Java Stream API, write a query that display all the students that have a number of preferences lower than the average number of preferences.

   Metoda printStudentsWithLessPreferences() din clasa StudentAllocationProblem.
   M-am folosit de o metoda de computeAveragePreferencesSize() si am filtrat studentii care au size-ul preferintelor mai mic decat acest average

3. Use a third-party library in order to generate random fake names for students and projects.

   Folosint libraria javafaker, am creat cate un obiect Faker() in fiecare metoda de generateRandomInstances...() pentru a atribui nume instantelor. 
   In cazul proiectelor, pe langa faker.funnyName() am adaugat si indexul unic i la nume, pentru a evita cazul in care faker-ul ar genera acelasi nume de doua ori si, fiind un set, sa nu fie adaugat (deoarece un set nu permite duplicate).
   Am facut asta pentru a ma asigura ca se pastreaza numarul de instante corect.

4. Create a Greedy algorithm in order to solve the problem.
   
   Metoda buildMatching() din clasa StudentAllocationProblem.

   Structuri de date folosite:
   - List<Project> taken in care exista proiectele deja luate de un student
   - List<Student> specialStudents in care exista studentii care pentru un motiv nu au primit un proiect din preferintele lor.
   
   Mai intai am sortat lista de studenti in functie de size-ul listei lor de preferinte, mai intai sa tratez studentii cu mai putine preferinte, deoarece este o paleta mai restransa de alegeri si lasand  la final pe cei care au mai multe preferinte. 
   Am iterat in lista de studenti si, pentru fiecare, am iterat in lista de preferinte ale lor si, cand au in preferinta un proiect care nu este deja luat, il adaug in matching si dau break la iteratia in lista de preferinte. 
   Daca un student nu a primit in urma iteratiei prin lista preferintelor un proiect (de ex, doi studenti au o singura preferinta care e aceeasi), va fi adaugat in lista specialStudents si va primi unul dintre proiectele nealese la final.
   
   Am afisat matching-ul prin metoda printMatching().