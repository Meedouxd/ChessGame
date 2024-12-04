import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Iterator;

public class Board {
    public Player whitePlayer;
    public Player blackPlayer;

    public Board(){
     whitePlayer = new Player(GameColor.WHITE);
     blackPlayer = new Player(GameColor.BLACK);
    }

    public void movePiece(Piece p, String newloc){
        Piece poorBoy = getPieceFromPosition(newloc);
        if(poorBoy == null){
            p.position = newloc;
            try {
                File soundFile = new File("/home/chase/Programming/Java/ChessGame/resources/move-self.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();} catch (Exception e) {e.printStackTrace();}
            return;
        }
        if(p.position.equals(newloc)){
            System.out.println("you cannot move to your own damn position");
        }
        if(poorBoy.color == p.color){
            System.out.println("Friendly fire is not allowed");
            return;
        }

        if(p.color==GameColor.WHITE){
            Iterator iterator = blackPlayer.alivePieces.iterator();
            while(iterator.hasNext()){
                Piece poordude = (Piece) iterator.next();
                if(poordude.position.equals(newloc)){
                    iterator.remove();
                }
            }
        }
        if(p.color==GameColor.BLACK){
            Iterator iterator = whitePlayer.alivePieces.iterator();
            while(iterator.hasNext()){
                Piece poordude = (Piece) iterator.next();
                if(poordude.position.equals(newloc)){
                    iterator.remove();
                }
            }
        }
        try {
            File soundFile = new File("/home/chase/Programming/Java/ChessGame/resources/capture.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();} catch (Exception e) {e.printStackTrace();}
        p.position = newloc;
    }

    public Piece getPieceFromPosition(String loc){
        for(Piece p : whitePlayer.alivePieces){
            if(p.position.equals(loc)){
                return p;
            }
        }
        for(Piece p : blackPlayer.alivePieces){
            if(p.position.equals(loc)){
                return p;
            }
        }
        return null;
    }
}
