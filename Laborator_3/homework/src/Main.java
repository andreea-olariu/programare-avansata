
public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Node person1 = new Programmer("Olariu", "Andreea", 20,0, 2,29, 11, 2002, "Java");
        Node person2 = new Designer("Popescu", "Ion", 30, 2, 1, 30, 1, 1990, "Minimalistic");
        Node person3 = new Programmer("Ionescu", "Diana", 42, 10, 5, 17, 2, 1999, "Python");

        Node company1 = new Company("Bytex");
        Node company2 = new Company("Cognizant");
        Node company3 = new Company("Levi9");
        Node company4 = new Company("Centric");

        ((Person) person1).addRelationship(company1, "employee");
        ((Person) person1).addRelationship(person2, "friends");
        ((Person) person2).addRelationship(person3, "coworkers");
        ((Person) person2).addRelationship(company4, "employee");
        ((Person) person3).addRelationship(person1, "friends");

        network.addUser(person1);
        network.addUser(person2);
        network.addUser(person3);
        network.addUser(person3);

        network.addUser(company1);
        network.addUser(company2);
        network.addUser(company3);
        network.addUser(company4);
        network.addUser(company4);

        System.out.println(network);
    }
}