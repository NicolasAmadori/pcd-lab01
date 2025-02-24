package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static pcd.lab01.ex01.AuxLib.*;

public class TestAuxLib {

	public static void main(String[] args) {

		final int LIMIT = 20;
		final int STARTING_X = 10;
		var sentence = "This  is a simple sentence with words ready to fall";

		Screen screen = Screen.getInstance();
		screen.clear();
		screen.writeStringAt(0,STARTING_X, Ansi.Color.RED, "-".repeat(50));
		screen.writeStringAt(LIMIT+1,STARTING_X, Ansi.Color.RED, "-".repeat(50));
		Random r = new Random();

		var wordList = getWordsPos(sentence);
		List<Thread> threads = new ArrayList<>();

		for (WordPos w : wordList){
			threads.add(new MyFallingWordThread(screen, w.word(), STARTING_X + w.pos(), r.nextInt(500,3000), LIMIT));
		}
		threads.forEach(Thread::start);

//		for (var wp: wordList) {
//			System.out.println("Word: " + wp.word() + " -- Pos: " + wp.pos());
//		}
	}

}
