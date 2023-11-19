import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    public ArrayList<SoftwareEngineer> team;

    /*
        Should create a new TechnicalLead that is a Manager. The
        TechnicalLead's base salary should be 1.3 times that of a
        TechnicalEmployee. TechnicalLeads should have a default
        head count of 4.
    */
    public TechnicalLead(String name) {
        super(name);
        this.baseSalary*=1.3;
        headcount = 4;
        this.team = new ArrayList<SoftwareEngineer>();
    }

    // Return true if the number of direct reports this manager has is less than their headcount
    public boolean hasHeadCount(){
        return team.size() < headcount;
    }

    /*
        Accept the reference to a SoftwareEngineer object,
        and if the TechnicalLead has head count left should add this
        employee to their list of direct reports. If the employee is
        successfully added to the TechnicalLead's direct reports true
        should be returned, false should be returned otherwise
    */
    public boolean addReport(SoftwareEngineer e){
        if(hasHeadCount()){
            team.add(e);
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    /*
        Should see if the employee passed in does report to this
        manager and if their code access is currently set to "true". If
        both those things are true, true is returned, otherwise false
        is returned
    */
    public boolean approveCheckIn(SoftwareEngineer e){
        return e.getManager().equals(this) && e.getCodeAccess();
    }

    /*
        Should check if the bonus amount requested would be
        approved by the BusinessLead supporting this TechnicalLead.
        If it is, that employee should get that bonus and true should
        be returned. False should be returned otherwise
    */
    public boolean requestBonus(Employee e, double bonus){
        BusinessLead businessLead = (BusinessLead) getAccountantSupport().getManager();
        return businessLead.approveBonus(e, bonus);
    }

    public String getTeamStatus(){
        if (team.isEmpty()){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            StringBuilder teamStatus= new StringBuilder();
            for (SoftwareEngineer softwareEngineer : team) {
                teamStatus.append("    ").append(softwareEngineer.employeeStatus()).append("\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }
    }
}
