import processing.core.PApplet;
import processing.core.PFont;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formattable;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    PFont f;

    int x = 400, y = 0;
    Zaman time = new Zaman();
    Boolean devam = new Boolean(true);

    public void settings() {
        fullScreen();
    }

    ArrayList<Integer> ÇizilcekX = new ArrayList<>();
    ArrayList<Integer> ÇizilcekY = new ArrayList<>();
    int tursayısı = 0;
    boolean GameOver = false;

    public void setup() {
        f = createFont("LemonMilk.otf", 36);

        textFont(f);
        for (int j = 0; j < 10; j++) {
            ÇizilcekX.add(j);
            ÇizilcekY.add(20);


        }


    }

    int sayac = 0;
    int sayac1 = 0;
    Kare kare = new Kare();
    int[][] matrix = new int[20][10];

    public void draw() {
        stroke(88, 24, 69);
        if (GameOver == false) {
            if (sayac == 0) {
                time.start();
                sayac = 1;
            }
            background(218, 247, 166);
            //İÇ KUTULARI ÇİZDİRME
            for (int i = 0; i < 20; i++) {

                for (int j = 0; j < 10; j++) {

                    fill(255, 195, 0);
                    rect(x + 40 * j, y + 40 * i, 40, 40);

                }
            }


            for (int i = 0; i < kare.KareX.size(); i++) {
                fill(199, 0, 57);
                rect(x + kare.KareX.get(i) * 40, y + kare.KareY.get(i) * 40, 40, 40);
            }


//      Zemin Kontrol
            for (int i = 0; i < kare.KareY.size(); i++) {
                for (int j = 0; j < ÇizilcekX.size(); j++) {

                    if (kare.KareY.get(i) + 1 == ÇizilcekY.get(j) && kare.KareX.get(i) == ÇizilcekX.get(j)) {
                        devam = false;
                    }
                }
            }


//Sürekli y arttırma.
            if (time.saniye % 2 == 1 && sayac1 == 0 && devam == true) {


                for (int i = 0; i < kare.KareY.size(); i++) {
                    kare.KareY.set(i, kare.KareY.get(i) + 1);

                }
                sayac1 = 1;
            }

            if (time.saniye % 2 == 0) {
                sayac1 = 0;
            }

            if (devam == false) {
                for (int i = 0; i < kare.KareY.size(); i++) {
                    ÇizilcekX.add(kare.KareX.get(i));
                    ÇizilcekY.add(kare.KareY.get(i));

                }
            }


            //Zemini Çİzdirme
            for (int i = 0; i < ÇizilcekX.size(); i++) {
                rect(x + ÇizilcekX.get(i) * 40, y + ÇizilcekY.get(i) * 40, 40, 40);
            }


            //Listeyi Sıfırlama Ve Devam
            if (!devam) {
                if (tursayısı % 7 == 0) {
                    kare.SıfırlamaTersZ();
                    Zemin.Score = 100 + Zemin.Score;


                    tursayısı++;
                } else if (tursayısı % 7 == 1) {
                    kare.SıfırlamaARTI();
                    Zemin.Score = 100 + Zemin.Score;

                    tursayısı++;
                } else if (tursayısı % 7 == 2) {
                    tursayısı++;
                    kare.Sıfırlamal();
                    Zemin.Score = 100 + Zemin.Score;

                } else if (tursayısı % 7 == 3) {
                    tursayısı++;
                    kare.SıfırlamaZ();

                    Zemin.Score = 100 + Zemin.Score;
                } else if (tursayısı % 7 == 4) {
                    tursayısı++;
                    kare.SıfırlamaL();
                    Zemin.Score = 100 + Zemin.Score;

                } else if (tursayısı % 7 == 5) {
                    tursayısı++;
                    kare.SıfırlamaTersL();
                    ;
                    Zemin.Score = 100 + Zemin.Score;

                } else if (tursayısı % 7 == 6) {
                    tursayısı++;
                    kare.SıfırlamaKare();
                    Zemin.Score = 100 + Zemin.Score;

                }
                devam = true;

            }


            int index = listedoldumu(ÇizilcekX, ÇizilcekY);
            if (index != -1) {

                for (int i = 0; i < ÇizilcekX.size(); i++) {

                    if (ÇizilcekY.get(i) < index) {
                        ÇizilcekY.set(i, ÇizilcekY.get(i) + 1);
                    }

                    if (ÇizilcekY.get(i) == index) {
                        ÇizilcekY.remove(i);
                        ÇizilcekX.remove(i);
                        i--;
                    }
                }
                Zemin.line++;
                Zemin.Score = Zemin.line + Zemin.Score;
            }


//NEXT EKRANI


            fill(255, 87, 51);
            rect(1000, 30, 400, 800, 45, 45, 45, 45);


            fill(88, 24, 69);
            text("NEXT:", 1050, 130);
            text("LINES:     " + Zemin.line, 1050, 470);
            text("SCORE:     " + Zemin.Score, 1050, 570);




            //SIRADA NE VAR
            if (tursayısı % 7 == 6) {
                for (int i = 0; i < 2; i++) {
                    rect(1130 + 40 * i, 200, 40, 40);
                    rect(1130 + 40 * i, 240, 40, 40);

                }

            }
            if (tursayısı % 7 == 5) {

                for (int i = 0; i < 3; i++) {
                    rect(1110 + 40 * i, 240, 40, 40);
                    if (i == 2)
                        rect(1110 + 80, 240 - 40, 40, 40);

                }

            }
            if (tursayısı % 7 == 4) {
                for (int i = 0; i < 3; i++) {
                    rect(1110 + 40 * i, 240, 40, 40);
                    if (i == 0)
                        rect(1110 + 40 * i, 240 - 40, 40, 40);

                }

            }

            if (tursayısı % 7 == 3) {
                for (int i = 0; i < 2; i++) {
                    rect(1150 + 40, 200 + 40 * i, 40, 40);
                    rect(1150, 240 + 40 * i, 40, 40);
                }

            }
            if (tursayısı % 7 == 2) {
                for (int i = 0; i < 4; i++)
                    rect(1110 + 40 * i, 240, 40, 40);

            }
            if (tursayısı % 7 == 1) {
                for (int i = 0; i < 3; i++) {
                    rect(1110 + 40 * i, 240, 40, 40);
                    if (i == 1)
                        rect(1110 + 40 * i, 240 - 40 * i, 40, 40);

                }
            }
            if (tursayısı % 7 == 0) {
                for (int i = 0; i < 2; i++) {
                    rect(1110 + 40, 200 + 40 * i, 40, 40);
                    rect(1110 + 80, 200 + 40 * i + 40, 40, 40);
                }
            }

//Kenarlar
            for (int i = 0; i < 20; i++) {
                fill(255, 87, 51);
                rect(x - 40, y + 40 * i, 40, 40);
                rect(x + 400, y + 40 * i, 40, 40);
                if (i < 10)
                    rect(x + 40 * i, y + 800, 40, 40);
            }


            //OYUN BITTIMI KOTNROL
            if (Collections.min(ÇizilcekY) < 1) {
                GameOver = true;
                devam = false;
                System.out.println("kk");
            }

        }


        //Bitiş Ekranı
        if (GameOver == true) {
            fill(255, 0, 0);
            stroke(255, 0, 0);
            rect(400, 150, 650, 500, 60, 60, 60, 60);
            fill(255, 195, 0);

            text("BAŞARAMADIK ", 620, 200);
            text("ABİ ", 710, 250);
            text("Score: " + Zemin.Score, 640, 350);
            rect(570, 300, 300, 100, 90, 90, 90, 90);
            rect(570, 450, 300, 100, 90, 90, 90, 90);
            fill(255, 0, 0);
            text("REPLAY ", 655, 515);
            text("QUİT", 675, 360);

        }


    }


    public void keyPressed() {
        int minx = 1000000000;
        int maxx = -10000000;
        for (int i = 0; i < kare.KareX.size(); i++) {
            if (minx > kare.KareX.get(i))
                minx = kare.KareX.get(i);
            if (minx < kare.KareX.get(i))
                maxx = kare.KareX.get(i);

        }

        if ((key == 'D' || key == 'd') && 9 > Collections.max(kare.KareX)) {
            {


                for (int i = 0; i < kare.KareX.size(); i++) {

                    int temp = kare.getKareX().get(i) + 1;
                    kare.KareX.set(i, temp);
                }
            }
        }


        if ((key == 'A' || key == 'a') && 0 < Collections.min(kare.KareX)) {
            {
                for (int i = 0; i < kare.KareX.size(); i++) {

                    int temp = kare.getKareX().get(i) - 1;
                    kare.KareX.set(i, temp);
                }
            }
        }


        if ((key == 'S' || key == 's' && Collections.min(kare.KareY) < 18)) {
            {
                for (int i = 0; i < kare.KareX.size(); i++) {

                    int temp = kare.getKareY().get(i) + 1;
                    kare.KareY.set(i, temp);
                }
            }
        }

        if ((key == 'Z' || key == 'z')) {
            {
                kare.SağaDöndürme(ÇizilcekX, ÇizilcekY);
            }
        }
        if ((key == 'C' || key == 'c')) {
            {
                kare.SolaDöndürme(ÇizilcekX, ÇizilcekY);
            }
        }

    }


    public int listedoldumu(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int dizi[] = new int[20];
        int index = -1;
        for (int i = 0; i < X.size(); i++) {
            for (int j = 0; j < 20; j++) {
                if (Y.get(i) == j) {
                    dizi[j] = dizi[j] + X.get(i);
                    if (dizi[j] == 45)
                        index = j;
                }
            }
        }

        return index;


    }

    @Override
    public void mousePressed() {
        if (GameOver == true && mouseX > 570 && mouseX < 870 && mouseY > 450 && mouseY <550) {
            devam = true;
            GameOver = false;
            ÇizilcekX.clear();
            ÇizilcekY.clear();
            kare.KareY.clear();
            kare.KareX.clear();
            kare.SıfırlamaKare();
            tursayısı=0;
            for (int j = 0; j < 10; j++) {
                ÇizilcekX.add(j);
                ÇizilcekY.add(20);

            }
            Zemin.Score = 0;
            Zemin.line = 0;
        }
        if (GameOver==true && mouseX > 570 && mouseX < 870 && mouseY > 300 && mouseY < 400) exit();

    }
}
