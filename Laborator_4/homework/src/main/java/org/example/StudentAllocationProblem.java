package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class StudentAllocationProblem {
    int numberOfInstances = 0;
    private List<Student>  students;
    private Set<Project> projects;

    // the final match
    private Map<Student, Project> matching;

    public StudentAllocationProblem(int x) {
        students = new LinkedList<>();
        projects = new TreeSet<>();
        matching = new HashMap<>();
        numberOfInstances = x;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Map<Student, Project> getMatching() {
        return matching;
    }

    public void setMatching(Map<Student, Project> matching) {
        this.matching = matching;
    }

    public double computeAveragePreferencesSize() {
        double sum = 0;
        for(Student s : students) {
            sum += s.getPreferencesSize();
        }
        return sum / students.size();
    }

    public void printStudentsWithLessPreferences() {
        double avg = computeAveragePreferencesSize();

        students.stream()
                .filter(s -> s.getPreferencesSize() < avg)
                .forEach(System.out::println);
    }

    public void generateRandomInstancesStudents() {
        Faker faker = new Faker();

        Student[] studs = IntStream.range(0, numberOfInstances)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        this.students.addAll(Arrays.asList(studs));

        // sort all students based on compareTo() method
        Collections.sort(this.students);
    }

    public void printStudents() {
        System.out.println("Students are...: ");
        for(Student stud : students) {
            System.out.println("\t" + stud);
        }
    }

    public void generateRandomInstancesProjects() {
        Faker faker = new Faker();
        // Stream for creating the projects
        Project[] projs = IntStream.range(0, numberOfInstances)
                .mapToObj(i -> new Project(faker.funnyName().name() + i))
                .toArray(Project[]::new);
        this.projects.addAll(Arrays.asList(projs));
    }

    public void printProjects() {
        // A TreeSet is already sorted according to the compareTo() method of the elements it contains
        System.out.println("Projects are...: ");
        for(Project proj : this.projects) {
            System.out.println("\t" + proj);
        }
    }

    public void setRandomPreferences() {
        Object[] projs = this.projects.toArray();
        for(Student stud : this.students) {
            Random random = new Random();
            // Each students has at least one preference and maximum numberOfInstances - 1
            int nrOfProjs = random.nextInt(1, numberOfInstances);

            // Generating the starting point in projs Array
            int start = random.nextInt(0, numberOfInstances);

            // Adds 
            for (int i = start; i < start + nrOfProjs; i++)
                stud.addPreference((Project) projs[i % numberOfInstances]);
        }
    }


    public void buildMatching() {
        List<Project> taken = new ArrayList<>();
        List<Student> specialStudents = new ArrayList<>();

        // sort the students according to the size of the preferences list
        Collections.sort(this.students, Comparator.comparingInt(Student::getPreferencesSize));
        for(Student stud : this.students) {
            boolean assigned = false;
            for(Project proj : stud.getPreferences()) {
                if(!taken.contains(proj)) {
                    matching.put(stud, proj);
                    taken.add(proj);
                    assigned = true;
                    break;
                }
            }
            if(!assigned)
                specialStudents.add(stud);
        }

        for(Student stud : specialStudents) {
            for(Project proj : this.projects) {
                if(!taken.contains(proj)) {
                    matching.put(stud, proj);
                    taken.add(proj);
                }
            }
        }

    }

    public void printMatching() {
        for(Map.Entry<Student, Project> itr : matching.entrySet()) {
            System.out.println(itr.getKey() + " has " + itr.getValue());
        }
    }
}
