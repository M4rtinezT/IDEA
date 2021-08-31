package day09;

public class ArrayUtilTest {
	public static void main(String[] args) {
		ArrayUtil test = new ArrayUtil();
		int[] temp =new  int []{1,3,4,5,-56,-65,5,25,36,-7};
		test.Average(temp);
		test.Copy(temp);
		test.Max(temp);
		test.Min(temp);
		test.Search(temp, 5);
		test.Reverse(temp);
		test.Sort(temp);
		test.Traverse(temp);
	}
}
