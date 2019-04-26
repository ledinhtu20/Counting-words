/**
 * 
 */
package app;

/**
 * @author ngbaanh
 * baanh.nguyen@outlook.com
 *
 */
public class WordMap {
	private String word;
	private int count;

	public WordMap(String word) {
		super();
		this.word = word;
		this.count = 1;
	}

	public String getWord() {
		return word;
	}


	public int getCount() {
		return count;
	}


	void countUp() {
		this.count++;
	}

}
