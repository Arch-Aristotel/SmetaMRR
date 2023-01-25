package com.example.mytestapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GNB extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_g_n_b, container, false);
    }
    String Zagolovok;
    String Sbornik;
    int Choose_k_set=1;
    double Ka=0, Kb=0;
    double Nat_index;
    double Cb;

    public void GNB_dep(Double Length_close_case){
        Zagolovok = "Бестраншейная прокладка инженерных коммуникаций\n методом горизонтального направленного бурения\n (бурошнековыми установками или установками ГНБ), протяжённостью, п.м:";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.3 п.8";

        Nat_index=Length_close_case;
        Double a25=45.0, b25=0.0;
        Double a25_50=13.0, b25_50=1.280;
        Double a50_100=19.0, b50_100=1.160;
        Double a100_500=49.5, b100_500=0.855;
        Double a500_1000=81.0, b500_1000=0.792;
        Double a1000_3000=176.5, b1000_3000=0.697;
        Double a3000_5000=1039.0, b3000_5000=0.409;
        Double a5000_10000=1894.0, b5000_10000=0.238;


        if (Length_close_case>0 && Length_close_case<=25){
            Ka=a25;
            Kb=b25;
        }
        if (Length_close_case>25 && Length_close_case<=50){
            Ka=a25_50;
            Kb=b25_50;
        }
        if (Length_close_case>50 && Length_close_case<=100){
            Ka=a50_100;
            Kb=b50_100;
        }
        if (Length_close_case>100 && Length_close_case<=500){
            Ka=a100_500;
            Kb=b100_500;
        }
        if (Length_close_case>500 && Length_close_case<=1000){
            Ka=a500_1000;
            Kb=b500_1000;
        }
        if (Length_close_case>1000 && Length_close_case<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if (Length_close_case>3000 && Length_close_case<=5000){
            Ka=a3000_5000;
            Kb=b3000_5000;
        }
        if (Length_close_case>5000 && Length_close_case<=10000){
            Ka=a5000_10000;
            Kb=b5000_10000;
        }
        Cb=(Ka+Kb*Length_close_case);
        if (Length_close_case>10000){
            Ka=a5000_10000;
            Kb=b5000_10000;
            Cb=Ka+Kb*10000+Kb*(Length_close_case-10000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }
    }

    public void GNB_case(Double Length_close_case){
        Zagolovok = "Закрытая прокладка футляра для инженерных коммуникаций\n способом продавливания или прокола, глубиной до 5 м и протяжённостью, п.м:";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.3 п.9";
        Nat_index=Length_close_case;
        /*
        до 20       36,0 -
        от 20 до 40 9,0 1,350
        от 40 до 80 21,0 1,050
        от 80 до 200 39,0 0,825
        от 200 до 400 85,0 0,595
        от 400 до 1000 171,0 0,380
         */
        Double a20=36.0, b20=0.0;
        Double a20_40=9.0, b20_40=1.350;
        Double a40_80=21.0, b40_80=1.050;
        Double a80_200=39.0, b80_200=0.825;
        Double a200_400=85.0, b200_400=0.595;
        Double a400_1000=171.0, b400_1000=0.380;

        if (Length_close_case>0 && Length_close_case<=20){
            Ka=a20;
            Kb=b20;
        }
        if (Length_close_case>20 && Length_close_case<=40){
            Ka=a20_40;
            Kb=b20_40;
        }
        if (Length_close_case>40 && Length_close_case<=80){
            Ka=a40_80;
            Kb=b40_80;
        }
        if (Length_close_case>80 && Length_close_case<=200){
            Ka=a80_200;
            Kb=b80_200;
        }
        if (Length_close_case>200 && Length_close_case<=400){
            Ka=a200_400;
            Kb=b200_400;
        }
        if (Length_close_case>400 && Length_close_case<=1000){
            Ka=a400_1000;
            Kb=b400_1000;
        }

        Cb=(Ka+Kb*Length_close_case);

        if (Length_close_case>1000){
            Ka=a400_1000;
            Kb=b400_1000;
            Cb=Ka+Kb*1000+Kb*(Length_close_case-1000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }
    }

}