package day13;
import java.lang.*;
public class Test13 {

}
class User{
	private String name;
	private int age;
//重写equals（）方法
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		if(obj instanceof User){
			User user = (User)obj;
			if(user.age == this.age && user.name.equals(this.name)) {
				return true;
			}
		}
		return false;
	}
	Integer in1 = 55;
	int number = in1;
}
