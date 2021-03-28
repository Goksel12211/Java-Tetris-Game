import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Kare {
   public ArrayList<Integer> KareX=new ArrayList<>();

    public ArrayList<Integer> getKareX() {
        return KareX;
    }

    public void setKareX(ArrayList<Integer> kareX) {
        KareX = kareX;
    }

    public ArrayList<Integer> getKareY() {
        return KareY;
    }

    public void setKareY(ArrayList<Integer> kareY) {
        KareY = kareY;
    }

    public  ArrayList<Integer>KareY=new ArrayList<>();

public Kare(){
    KareY.clear();
    KareX.clear();
    KareX.add(5);
    KareX.add(4);

    KareX.add(5);
    KareX.add(4);



    KareY.add(0);
    KareY.add(0);


    KareY.add(1);
    KareY.add(1);

}
public void SıfırlamaKare(){
    KareY.clear();
    KareX.clear();


    KareX.add(5);
    KareY.add(0);

    KareX.add(4);
    KareY.add(0);

    KareX.add(5);
    KareY.add(1);



    KareX.add(4);

    KareY.add(1);


}
    public void SıfırlamaZ(){
        KareY.clear();
        KareX.clear();
        KareX.add(5);
        KareX.add(4);

        KareX.add(5);
        KareX.add(4);



        KareY.add(0);
        KareY.add(1);


        KareY.add(1);
        KareY.add(2);
    }



    public void Sıfırlamal(){
        KareY.clear();
        KareX.clear();
        KareX.add(3);
        KareX.add(4);

        KareX.add(5);
        KareX.add(6);



        KareY.add(0);
        KareY.add(0);


        KareY.add(0);
        KareY.add(0);
    }






    public void SıfırlamaARTI(){
        KareY.clear();
        KareX.clear();

        KareX.add(5);
        KareY.add(0);

        KareX.add(4);
        KareY.add(1);

        KareX.add(5);
        KareY.add(1);



        KareX.add(6);

        KareY.add(1);

    }



    public void SıfırlamaL(){
        KareY.clear();
        KareX.clear();

        KareX.add(4);
        KareY.add(0);

        KareX.add(4);
        KareY.add(1);

        KareX.add(5);
        KareY.add(1);



        KareX.add(6);

        KareY.add(1);

    }
    public void SıfırlamaTersL(){
        KareY.clear();
        KareX.clear();

        KareX.add(6);
        KareY.add(0);

        KareX.add(4);
        KareY.add(1);

        KareX.add(5);
        KareY.add(1);



        KareX.add(6);

        KareY.add(1);

    }

    public void SıfırlamaTersZ(){
        KareY.clear();
        KareX.clear();

        KareX.add(5);
        KareY.add(0);

        KareX.add(5);
        KareY.add(1);

        KareX.add(6);
        KareY.add(1);



        KareX.add(6);

        KareY.add(2);

    }

    public void SağaDöndürme(ArrayList<Integer> ÇizilenX,ArrayList<Integer>ÇizilenY){
    boolean Dönebilir=true;
    int birincix=this.KareX.get(0);
    int birinciy=this.KareY.get(0);


    for (int i=0;i<ÇizilenX.size();i++){
        for (int j=0;j<KareX.size();j++){
            if (KareX.get(j)==ÇizilenX.get(i) && KareY.get(j)==ÇizilenY.get(i) ){
                Dönebilir=false;
            }
        }
    }




    for (int i=1;i<KareX.size();i++) {
        int xx=0;
        int yy=0;
        int xfark=0;
        int yfark=0;
        xfark = birincix - KareX.get(i);
        yfark = birinciy - KareY.get(i);


        xx=KareX.get(0)+yfark;
        yy=KareY.get(0)-xfark;

        if (!(xx>-1 && xx<9 )){
            Dönebilir=false;
        }

        for (int mama=0;mama<ÇizilenX.size();mama++){
            if (ÇizilenX.get(mama)==xx && ÇizilenY.get(mama)==yy)
                Dönebilir=false;
        }



    }




    if (Dönebilir!=false) {
        for (int i = 1; i < KareX.size(); i++) {
            int xx = 0;
            int yy = 0;
            int xfark = 0;
            int yfark = 0;
            xfark = birincix - KareX.get(i);
            yfark = birinciy - KareY.get(i);


            KareX.set(i, KareX.get(0) +yfark);
            KareY.set(i, KareY.get(0) - xfark);
        }

    }
}

    public void SolaDöndürme(ArrayList<Integer> ÇizilenX,ArrayList<Integer>ÇizilenY){
        boolean Dönebilir=true;
        int birincix=this.KareX.get(0);
        int birinciy=this.KareY.get(0);


        for (int i=0;i<ÇizilenX.size();i++){
            for (int j=0;j<KareX.size();j++){
                if (KareX.get(j)==ÇizilenX.get(i) && KareY.get(j)==ÇizilenY.get(i) ){
                    Dönebilir=false;
                }
            }
        }




        for (int i=1;i<KareX.size();i++) {
            int xx=0;
            int yy=0;
            int xfark=0;
            int yfark=0;
            xfark = birincix - KareX.get(i);
            yfark = birinciy - KareY.get(i);


            xx=KareX.get(0)-yfark;
            yy=KareY.get(0)+xfark;

            if (!(xx>-1 && xx<9 )){
                Dönebilir=false;
            }

            for (int mama=0;mama<ÇizilenX.size();mama++){
                if (ÇizilenX.get(mama)==xx && ÇizilenY.get(mama)==yy)
                    Dönebilir=false;
            }



        }




        if (Dönebilir!=false) {
            for (int i = 1; i < KareX.size(); i++) {
                int xx = 0;
                int yy = 0;
                int xfark = 0;
                int yfark = 0;
                xfark = birincix - KareX.get(i);
                yfark = birinciy - KareY.get(i);


                KareX.set(i, KareX.get(0) -yfark);
                KareY.set(i, KareY.get(0) + xfark);
            }

        }
    }





}
