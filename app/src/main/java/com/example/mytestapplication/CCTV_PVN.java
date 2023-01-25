package com.example.mytestapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CCTV_PVN extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c_c_t_v__p_v_n, container, false);
    }

    String Zagolovok;
    String Sbornik;
    double Ka=0, Kb=0;
    int Nat_index;
    double Koif_ARM=1;
    double Cb;

    void PVN(int X_PVN){
        Nat_index=X_PVN;

        Zagolovok="Центр приемного, просмотрового, переговорного и документируемого оборудования ПВН "+
                "(видеонаблюдение и экстренная связь)";
        Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 4, п.1";

        Double a1=19.7, b1=0.0;
        Double a1_5=13.32, b1_5=6.38;
        Double a5_10=23.17, b5_10=4.41;
        Double a10_15=38.67, b10_15=2.86;
        Double a15_20=50.67, b15_20=2.06;
        Double a20_25=52.67, b20_25=1.96;
        Double a25_30=57.17, b25_30=1.78;
        Double a30=110.57, b30=0.0;

        if(X_PVN==1){
            Ka=a1;
            Kb=b1;
        }
        if (X_PVN>1 && X_PVN<=5){
            Ka=a1_5;
            Kb=b1_5;
        }
        if (X_PVN>5 && X_PVN<=10){
            Ka=a5_10;
            Kb=b5_10;
        }
        if (X_PVN>10 && X_PVN<=15){
            Ka=a10_15;
            Kb=b10_15;
        }
        if (X_PVN>15 && X_PVN<=20){
            Ka=a15_20;
            Kb=b15_20;
        }
        if (X_PVN>20 && X_PVN<=25){
            Ka=a20_25;
            Kb=b20_25;
        }
        if (X_PVN>25 && X_PVN<=30){
            Ka=a25_30;
            Kb=b25_30;
        }
        if (X_PVN>30){
            Ka=a30;
            Kb=b30;
        }
        Cb=(Ka+Kb*X_PVN)*Koif_ARM;
    }

}