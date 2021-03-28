import java.security.PublicKey;
import java.util.ArrayList;

public class Zemin {
    ArrayList<Integer> X=new ArrayList<>();
    ArrayList<Integer> Y=new ArrayList<>();
    static  public int line=0;
    static public int Score=0;

    public static int getLine() {
        return line;
    }

    public static void setLine(int line) {
        Zemin.line = line;
    }

    public boolean Devam=true;

    public ArrayList<Integer> getX() {
        return X;
    }

    public void setX(ArrayList<Integer> x) {
        X = x;
    }

    public ArrayList<Integer> getY() {
        return Y;
    }

    public void setY(ArrayList<Integer> y) {
        Y = y;
    }

    public boolean isDevam() {
        return Devam;
    }

    public void setDevam(boolean devam) {
        Devam = devam;
    }

    public Zemin(){
        for (int i=0;i<10;i++)
        X.add(i);
        Y.add(20);
    }
    public void ZemineekleX(ArrayList<Integer> EklenecekX){
        for (int i=0;i<EklenecekX.size();i++){
            this.X.add(EklenecekX.get(i));
        }
    }
    public void ZemineekleY(ArrayList<Integer> EklenecekY){
        for (int i=0;i<EklenecekY.size();i++){
            this.Y.add(EklenecekY.get(i));
        }
    }


}
