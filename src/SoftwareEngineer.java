public class SoftwareEngineer extends TechnicalEmployee {
    public boolean CodeAccess = false;

    // Start without access to code and with 0 code check ins
    public SoftwareEngineer(String name) {
        super(name);
    }

    // Return whether this SoftwareEngineer has access to make changes to the code base
    public boolean getCodeAccess() {
        return CodeAccess;
    }

    // Allow an external piece of code to update the SoftwareEngieer's code privileges to either true or false
    public void setCodeAccess(boolean codeAccess) {
        CodeAccess = codeAccess;
    }

    // Return the current count of how many times this SoftwareEngineer has successfully checked in code
    public int getSuccessfulCheckIns() {
        return checkins;
    }

    /*
        Should check if this SoftwareEngineer's manager approves of their
        check in. If the check in is approved their successful checkin count
        should be increased and the method should return "true". If the
        manager does not approve the check in the SoftwareEngineer's code
        access should be changed to false and the method should return
        "false"
     */
    public boolean checkInCode() {
        TechnicalLead manager = (TechnicalLead) this.getManager();
        if (manager.approveCheckIn(this)){
            this.checkins++;
            return true;
        } else {
            CodeAccess=false;
            return false;
        }
    }
}
