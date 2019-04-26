/**
 * Nhập 1 chuỗi
 * Đếm số kí tự: đếm tất cả khoảng trắng, 
 * ngoài ra ký tự không phải khoảng trắng mà trùng nhau thì chỉ đếm 1 lần.
 */
package app;

import java.util.Scanner;

/**
 * @author ngbaanh
 *
 */
public class Main2 {
	Scanner sc;
	
	public Main2() {
		System.out.print("Nhập dzô: ");
		sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println("Chuỗi đã nhập: '" + input +"'");
		System.out.println("Tổng số kí tự: " + input.length());
		System.out.println("Tổng số kí tự khác nhau và kí tự trắng: " + this.count(input));
	}
	
	private int count(String input) {
		// Count spaces:
		String noSpacesInput = input.replaceAll("\\s+", "");
		int spaceNum = input.length() - noSpacesInput.length();
		// Count unique characters:
		String buffer = new String("");
		for (int idx = 0; idx < noSpacesInput.length(); idx++) {
			if (!buffer.contains(String.valueOf(noSpacesInput.charAt(idx)))) {
				buffer += noSpacesInput.charAt(idx);
			}
		}
		return spaceNum + buffer.length();
	}
	
	public static void main(String[] args) {
		new Main2();

	}

}
