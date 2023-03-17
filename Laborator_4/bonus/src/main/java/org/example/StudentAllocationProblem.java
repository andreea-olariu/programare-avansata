package org.example;

import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.matching.HopcroftKarpMaximumCardinalityBipartiteMatching;
import org.jgrapht.alg.vertexcover.RecursiveExactVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.*;
import java.util.stream.IntStream;

public class StudentAllocationProblem {
    int numberOfInstances = 0;
    private List<Student>  students;
    private Set<Project> projects;


    public StudentAllocationProblem(int x) {
        students = new LinkedList<>();
        projects = new TreeSet<>();
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

    public void buildMatchingGreedy() {
        Map<Student, Project> matching = new HashMap<>();
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

        for(Map.Entry<Student, Project> itr : matching.entrySet()) {
            System.out.println(itr.getKey() + " has " + itr.getValue());
        }
    }

    public Graph<Object, DefaultEdge> buildGraphJGT() {
        Graph<Object, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        for(Student stud : this.students) {
            graph.addVertex(stud);
        }
        for(Project proj : this.projects) {
            graph.addVertex(proj);
        }

        for(Student stud : this.students) {
            for(Project proj : stud.getPreferences())
                graph.addEdge(stud, proj);
        }

        return graph;
    }

    public void buildMatchingWithGraphsJGT() {
        Graph<Object, DefaultEdge> graph = buildGraphJGT();
        Set<Object> studs = new HashSet<>(this.students);
        Set<Object> projs = new HashSet<>(this.projects);

        HopcroftKarpMaximumCardinalityBipartiteMatching<Object, DefaultEdge> matchingAlgClass = new HopcroftKarpMaximumCardinalityBipartiteMatching<>(graph, studs, projs);
        for(var pair : matchingAlgClass.getMatching().getEdges()) {
            System.out.println(pair.toString());
        }
    }

    public Set<Object> minimumCardinalityVertexCover() {
        Graph<Object, DefaultEdge> graph = buildGraphJGT();
        Set<Object> vertexCover = new HashSet<>();
        // VERTEX COVER
        RecursiveExactVCImpl<Object, DefaultEdge> vertexCoverAlgClass = new RecursiveExactVCImpl<>(graph);
        vertexCover.addAll(vertexCoverAlgClass.getVertexCover());
        return vertexCover;
    }

    public Set<Object> maximumCardinalityIndependentSet() {
        Set<Object> vertexCover = minimumCardinalityVertexCover();

        Set<Object> independentSet = new HashSet<>();
        independentSet.addAll(projects);
        independentSet.addAll(students);
        independentSet.removeAll(vertexCover);
        return independentSet;
    }
}
