

public class Main {
    public static void main(String[] args) {
     LinkedList list = new LinkedList();
        list.addCustomer("John", "Party of 3");
        list.addCustomer("Jane", "Party of 2");
        list.addCustomer("Bob", "Party of 1");
        list.addCustomer("Michel", "Party of 4");
        list.addCustomer("Mary", "Party of 3");
        list.addCustomer("David", "Party of 2");
        list.printCustomers();
        list.removeCustomer("Mary");
        list.addVipCustomer("Vip Dave", "Party of 4");
        list.addVipCustomer("Vip Charlie", "Party of 1");
        list.printCustomers();
    }
}
