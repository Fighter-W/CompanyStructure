public abstract class Employee {
    private static int incID;
    public String name;
    public double baseSalary;
    public int employeeID;

    public Employee manager;
    public int headcount = 0;
    public double bonus;
    public Accountant accountantSupport;

    /*
        Construct a new employee object and take in two parameters,
        one for the name of the user and one for their base salary
    */
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        incID++;
        this.employeeID = incID;
    }

    // Return the employee's current salary
    public double getBaseSalary() {
        return baseSalary;
    }

    // Return the employee's current name
    public String getName() {
        return name;
    }

    /*
        Return the employee's ID. The ID should be issued on behalf of
        the employee at the time they are constructed. The first ever
        employee should have an ID of "1", the second "2" and so on
    */
    public int getEmployeeID() {
        return employeeID;
    }

    // Return a reference to the Employee object that represents this employee's manager
    public Employee getManager() {
        return manager;
    }

    // Set manager for the employee
    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Accountant getAccountantSupport() {
        return accountantSupport;
    }

    // Return true if the two employee IDs are the same, false otherwise
    public boolean equals(Employee other){
        return this.getEmployeeID() == other.getEmployeeID();
    }


    // Return a String representation of the employee that is a combination of their id followed by their name. Example: "1 Kasey"
    public String toString(){
        return this.getEmployeeID()+" "+this.getName();
    }

    // Return a String representation of that Employee's current status. This will be different for every subclass of Employee
    public abstract String employeeStatus();

}
