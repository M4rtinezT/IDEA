package domain;
import service.status;
public class Programmer extends Employee{
	private int memberId;
	private status status = service.status.FREE;
	private Equipment equipment;
	public Programmer() {
		super();
	}
	public Programmer(int id, String name, int age, double salary,Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
		
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		return super.toString()+ "\t程序员\t" + status + "\t\t\t"+equipment.getDescription();
	}
	public String getDetailsForTeam() {
		return memberId+"/"+getId()+"\t"+super.getDetailsForTeamCommon()+"\t程序员";
	}
	
}
