1. Create a Maven project.
2. Create an object-oriented model of the problem. Students and projects have names. Make sure the objects of these classes are comparable.

    Clasa Student contine proprietatea name si implementeaza interfata Comparable
    Clasa Project contine proprietatea name si implementeaza interfata Comparable

3. Create the students and the projects described in the example. Use streams in order to easily create the objects.

    Am folosit Java Stream-uri pentru a genera 10 studenti si 10 proiecte. 

4. Put all the students in a LinkedList and print them sorted by their names.

    Am creat un LinkedList, listOfStudents, si am iterat prin Array-ul obtinut prin stream-uri si am adaugat fiecare obiect si in LinkedList.
    Am folosit metoda  Collections.sort(listOfStudents) care se foloseste de metoda compareTo() implementata in clasa Student si apoi am iterat prin LinkedList pentru a afisa studentii.
    
5. Put all the projects in a TreeSet and print them sorted by their names.

    Am creat un TreeSet, setOfProject, si am iterat prin Array-ul obtinut prin stream-uri si am adaugat fiecare obiect si in TreeSet.
    Nu e necesara sortarea, deoarece un TreeSet este o structura de date care sorteaza elementele pe masura ce adaugam. Ulterior, am iterat prin TreeSet si am afisat proiectele.