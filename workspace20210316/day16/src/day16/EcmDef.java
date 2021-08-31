package day16;

public class EcmDef {
	public static void main(String[] args) {
		double result = 0;
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			result = ecm(i, j);
		} catch (NumberFormatException e) {
			System.out.println("数据类型不一致");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("缺少命令行参数");
		}catch (ArithmeticException e) {
			System.out.println("除数为0");
		}catch (EcDef e) {
			System.out.println(e.getMessage());
		}
		System.out.println(result);
	}
	public static double ecm(int i,int j) throws EcDef {
		if(i<0||j<0) {
			throw new EcDef("分子或分母为负数");
		}
		
		return i/j;
	}
}


class EcDef extends Exception{
	static final long serialVersionUID = -33875946124229948L;
	public EcDef() {
		
	}
	public EcDef(String msg) {
		super(msg);
	}
}