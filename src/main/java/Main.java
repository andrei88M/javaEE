import util.Creator;

public class Main {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.createDB();
        creator.createTableManyToMany();
    }
}
