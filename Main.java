/**
 * Nhập 1 chuỗi bất kì
 * In mỗi từ trên mỗi dòng, đếm số lượng từ trong chuỗi
 * Đếm tần suất của mỗi từ
 * 
 */
package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ngbaanh
 * baanh.nguyen@outlook.com
 *
 */
public class Main {
	Scanner scanner;
	ArrayList<WordMap> wordMapList;
	
	public Main() {
		scanner = new Scanner(System.in);
		System.out.print("Nhập một chuỗi: ");
		String input = scanner.nextLine();
		processWords(input);
	}

	private void processWords(String input) {
		if ("".equals(input)) { // chuỗi rỗng thì nghỉ
			return;
		}
		wordMapList = new ArrayList<WordMap>();
		// Xử lí sơ sơ
		String wordSequence = input.trim().toLowerCase().replaceAll("\\s+", " ");
		// Cắt thành mảnh
		String regex = "[\\!\\?\\;\\`\\\"\\'\\.\\,\\:\\-\\s\\t~\\[\\]\\(\\)\\{\\}]+";
		String word[] = wordSequence.split(regex);
		// Nhập từ đầu tiên
		wordMapList.add(new WordMap(word[0]));
		// Dò trùng lặp và đếm
		int position = 0;
		for (int idx = 1; idx < word.length; idx++) {
			position = findPosition(word[idx]);
			if (position > 0) {
				wordMapList.get(position).countUp();
			} else {
				wordMapList.add(new WordMap(word[idx]));
			}
		}
		
		// in ra danh sách các từ cùng tần suất xuất hiện
		System.out.println("Có tất cả " + word.length + " từ, trong đó có " 
				+ wordMapList.size() + " từ khác nhau.");
		System.out.println("===== Bảng tần suất từ =====");
		for (WordMap wm : wordMapList) {
			System.out.println("[" + wm.getCount() + "] : " + wm.getWord());
		}
	}

	/**
	 * Tìm vị trí của từ xuất hiện trong danh sách đã tạo
	 * @param word từ đầu vào
	 * @return vị trí xuất hiện trong WordMapList, nếu không tìm thấy thì trả về 0
	 */
	private int findPosition(String word) {
		int position = 0;
		for (int i = 0; i < this.wordMapList.size(); i++) {
			if (word.hashCode() == this.wordMapList.get(i).getWord().hashCode()) {
				position = i;
				break;
			} else {
				continue;
			}
		}
		return position;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();

	}

}


/**
 * Đối chiếu kết quả tại: http://www.writewords.org.uk/word_count.asp
 * Sample Run:
Nhập một chuỗi: Our word frequency counter allows you to count the frequency usage of each word in your text. Paste or type in your text below, and click submit.
Có tất cả 27 từ, trong đó có 22 từ khác nhau.
===== Bảng tần suất từ =====
[1] : our
[2] : word
[2] : frequency
[1] : counter
[1] : allows
[1] : you
[1] : to
[1] : count
[1] : the
[1] : usage
[1] : of
[1] : each
[2] : in
[2] : your
[2] : text
[1] : paste
[1] : or
[1] : type
[1] : below
[1] : and
[1] : click
[1] : submit
*/ 
