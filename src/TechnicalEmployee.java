public class TechnicalEmployee extends Employee {

    public int checkins;

    public TechnicalEmployee(String name) {
        // Has a default base salary of 75000
        super(name, 75000.00);
        this.checkins = 0;
    }

    @Override
    /*
        Should return a String representation of this TechnicalEmployee that
        includes their ID, name and how many successful check ins they have
        had. Example: "1 Kasey has 10 successful check ins"
    */
    public String employeeStatus() {
        return super.toString()+" has "+checkins+" successful check ins";
    }

    public void setCheckins() {
        this.checkins++;
    }
}
