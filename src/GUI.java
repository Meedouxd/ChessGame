import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame;
    Board chessBoard;
    JBoard boardPanel;
    public GUI(){
        chessBoard = new Board();
        frame = new JFrame("Chess");
        frame.setBounds(100,100,800,825);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        boardPanel = new JBoard(800,800, chessBoard.whitePlayer, chessBoard.blackPlayer, chessBoard);
        frame.getContentPane().add(boardPanel);


    }
}

class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}