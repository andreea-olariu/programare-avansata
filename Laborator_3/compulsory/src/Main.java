
public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Node person1 = new Person("Olariu", "Andreea", 20);
        Node person2 = new Designer("Popescu", "Ion", 30, 2, 1);
        Node person3 = new Programmer("Ionescu", "Diana", 42, 10, 5);

        Node company1 = new Company("Bytex");
        Node company2 = new Company("Cognizant");
        Node company3 = new Company("Levi9");
        Node company4 = new Company("Centric");

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