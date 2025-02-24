package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi;

public class MyFallingWordThread extends Thread {


    private final Screen screen;
    private final String word;
    private final int x;
    private final int speed;
    private int limit;
    private int y = 2;

    public MyFallingWordThread(Screen screen, String word, int x, int speed, int limit){
        super();
        this.screen = screen;
        this.word = word;
        this.x = x;
        this.speed = speed;
        this.limit = limit;
        screen.writeStringAt(y,x, Ansi.Color.BLUE, word);
    }

    public void run(){
        while(y < limit){
            screen.writeStringAt(y,x, Ansi.Color.BLUE, " ".repeat(word.length()));
            y = y + 1;
            screen.writeStringAt(y,x, Ansi.Color.BLUE, word);
            try {
                Thread.sleep(speed);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
