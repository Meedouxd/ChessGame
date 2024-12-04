import java.security.AlgorithmConstraints;
import java.util.ArrayList;

public class Player {

    public boolean isTurn;
    public GameColor color;
    Piece pawn1;
    Piece pawn2;
    Piece pawn3;
    Piece pawn4;
    Piece pawn5;
    Piece pawn6;
    Piece pawn7;
    Piece pawn8;

    Piece bishop1;
    Piece bishop2;

    Piece rook1;
    Piece rook2;

    Piece knight1;
    Piece knight2;

    Piece king;

    Piece queen;

    public ArrayList<Piece> alivePieces;
    public ArrayList<Piece> deadPieces;
    public ArrayList<Piece> capturedPieces;

    public Player(){
        System.out.println("A Player was called with the default constructor. You shouldn't have done this.");
    }
    public Player(GameColor c){

        String pawnColumn = "";
        String specialColumn = "";

        color = c;

        switch (color){
            case BLACK:
                isTurn = false;
                pawnColumn = "7";
                specialColumn = "8";
                break;
            case WHITE:
                isTurn = true;
                pawnColumn = "2";
                specialColumn = "1";
        }

        pawn1 = new Piece("a"+pawnColumn, Piece.Type.PAWN, color);
        pawn2 = new Piece("b"+pawnColumn, Piece.Type.PAWN, color);
        pawn3 = new Piece("c"+pawnColumn, Piece.Type.PAWN, color);
        pawn4 = new Piece("d"+pawnColumn, Piece.Type.PAWN, color);
        pawn5 = new Piece("e"+pawnColumn, Piece.Type.PAWN, color);
        pawn6 = new Piece("f"+pawnColumn, Piece.Type.PAWN, color);
        pawn7 = new Piece("g"+pawnColumn, Piece.Type.PAWN, color);
        pawn8 = new Piece("h"+pawnColumn, Piece.Type.PAWN, color);

        bishop1 = new Piece("c"+specialColumn, Piece.Type.BISHOP, color);
        bishop2 = new Piece("f"+specialColumn, Piece.Type.BISHOP, color);

        rook1 = new Piece("a"+specialColumn, Piece.Type.ROOK, color);
        rook2 = new Piece("h"+specialColumn, Piece.Type.ROOK, color);

        knight1 = new Piece("b"+specialColumn, Piece.Type.KNIGHT, color);
        knight2 = new Piece("g"+specialColumn, Piece.Type.KNIGHT, color);

        king = new Piece("e"+specialColumn, Piece.Type.KING, color);

        queen = new Piece("d"+specialColumn, Piece.Type.QUEEN, color);

        alivePieces = new ArrayList<>();
        deadPieces = new ArrayList<>();
        capturedPieces = new ArrayList<>();

        alivePieces.add(pawn1);
        alivePieces.add(pawn2);
        alivePieces.add(pawn3);
        alivePieces.add(pawn4);
        alivePieces.add(pawn5);
        alivePieces.add(pawn6);
        alivePieces.add(pawn7);
        alivePieces.add(pawn8);
        alivePieces.add(bishop1);
        alivePieces.add(bishop2);
        alivePieces.add(rook1);
        alivePieces.add(rook2);
        alivePieces.add(knight1);
        alivePieces.add(knight2);
        alivePieces.add(king);
        alivePieces.add(queen);
    }

}
