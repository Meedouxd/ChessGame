import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JBoard extends JPanel {
    int screenWidth;
    int screenHeight;
    Player whitePlay, blackPlay;
    Board chessBoard;
    String pos1 = "";
    String pos2 = "";
    Piece selectedPiece;
    int count = 0;
    public JBoard(int w, int h, Player wp, Player bp, Board b){
        screenWidth = w;
        screenHeight = h;
        setBackground(new Color(201, 200, 199));
        whitePlay = wp;
        blackPlay = bp;
        chessBoard = b;


        addMouseListener(new MouseAdapter() {
            private Color background;

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(count==0){
                    count++;
                    pos1=Piece.getCoordinateAsPosition(e.getX(),e.getY(), 800,800);
                    return;
                }
                if(count==1){
                    count = 0;
                    pos2= Piece.getCoordinateAsPosition(e.getX(),e.getY(),800,800);
                    Piece p1 = chessBoard.getPieceFromPosition(pos1);
                    Piece p2 = chessBoard.getPieceFromPosition(pos2);
                    chessBoard.movePiece(p1,pos2);
                    pos1="";
                    pos2="";
                    repaint();
                }
            }
        });
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        drawBoard(g);
    }

    public void drawBoard(Graphics g){
        g.setColor(new Color(64, 63, 62));
        for(int a = 0; a < 8; a++){
            int offset = 0;
            for(int i =0; i < 4; i++){
                if(a%2==0){
                    offset=100;
                }else{
                    offset=0;
                }
                g.fillRect((i*200)+offset,(a*100),100,100);
            }
        }
        for(Piece p : whitePlay.alivePieces){
            drawPiece(g, p);
        }
        for(Piece p: blackPlay.alivePieces){
            drawPiece(g,p);
        }
        /*
        int posX = whitePlay.king.getLocationAsCoordinate(800,800).x;
        int posY = whitePlay.king.getLocationAsCoordinate(800,800).y;
        ImageIcon pawn = new ImageIcon("/home/chase/Programming/Java/ChessGame/resources/blackpawn.png");

        System.out.println("DEBUG!: POSX: " + posX);
        System.out.println("DEBUG!: POSY: " + posY);
        g.drawImage(pawn.getImage(),posX,posY,100,100,null);
        */

        /*
        g.drawImage(getPieceImage(whitePlay.pawn1).getImage(), whitePlay.pawn1.getLocationAsCoordinate(800,800).x, whitePlay.pawn1.getLocationAsCoordinate(800,800).y,100,100,null);
        g.drawImage(getPieceImage(whitePlay.queen).getImage(), whitePlay.queen.getLocationAsCoordinate(800,800).x, whitePlay.queen.getLocationAsCoordinate(800,800).y,100,100,null);
        */

    }
    public ImageIcon getPieceImage(Piece p){
        String fileName = "/home/chase/Programming/Java/ChessGame/resources/";
        if(p.color == GameColor.WHITE){
            fileName = fileName + "white";
        }else{
            fileName = fileName + "black";
        }
        switch(p.pieceType){
            case PAWN:
                fileName = fileName + "pawn";
                break;
            case BISHOP:
                fileName = fileName + "bishop";
                break;
            case ROOK:
                fileName = fileName + "rook";
                break;
            case KING:
                fileName = fileName + "king";
                break;
            case QUEEN:
                fileName = fileName + "queen";
                break;
            case KNIGHT:
                fileName = fileName + "knight";
                break;

        }
        fileName = fileName + ".png";
        return new ImageIcon(fileName);
    }
    public void drawPiece(Graphics g, Piece p){
        g.drawImage(getPieceImage(p).getImage(), p.getLocationAsCoordinate(800,800).x, p.getLocationAsCoordinate(800,800).y,100,100,null);
        g.drawImage(getPieceImage(p).getImage(), p.getLocationAsCoordinate(800,800).x, p.getLocationAsCoordinate(800,800).y,100,100,null);
    }
}
