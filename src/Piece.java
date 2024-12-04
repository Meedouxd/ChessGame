import java.awt.*;

public class Piece {



    public enum Type{
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        KING,
        QUEEN
    }
    public String position;
    public Type pieceType;
    public GameColor color;
    public Piece(){
        System.out.println("Default Constructor for a piece was called. you shouldn't have done this.");
    }
    public Piece(String pos, Type t, GameColor col){
        position = pos;
        pieceType = t;
        color = col;
    }

    public String toString(){
        return "Position: " + position + " Piece Type: " + pieceType.toString() + " Color: " + color.toString() + "\n";
    }

    public Point getLocationAsCoordinate(int screenWidth, int screenHeight){
        Point p = new Point();

        int scale = screenHeight / 8;

        int column = ((int) position.charAt(0)) - 'a';
        int row = ((int) position.charAt(1)) - '0';
        row = screenHeight - (row*100);
        column = (column*100);
        return new Point(column,row);
    }
    public static String getCoordinateAsPosition(int x, int y, int screenWidth, int screenHeight){
        String toReturn = "";
        int posX = (int) Math.ceil((double)x/100.0);
        int posY = (int) Math.ceil((double)(800-y)/100.0);
        String[] columns = {"a","b","c","d","e","f","g", "h"};
        toReturn = columns[posX-1];
        toReturn = toReturn + Integer.toString(posY);
        return toReturn;
    }


    public void movePiece(String newloc) {
        position =newloc;
    }
}
