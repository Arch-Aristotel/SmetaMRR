package com.example.mytestapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CCTV extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_c_c_t_v, container, false);

    }
    String Zagolovok;
    String Sbornik;
    double Ka=0, Kb=0;
    int Nat_index;
    Double Koif_floor=1.0;
    double Cb;

    public void CCTV_Inside(Double L_CCTV, int X_CCTV){
        Nat_index=X_CCTV;
        if (L_CCTV<=850){
            Zagolovok="Видеонаблюдение  внутри жилых домов, общественных и промышленных зданий" +
                    "суммарной длине кабелей до 850 м";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 6, п.1";

            Double a6=17.87, b6=0.0;
            Double a6_12=8.27, b6_12=1.6;
            Double a12_24=14.99, b12_24=1.04;
            Double a24_36=38.03, b24_36=0.08;
            Double a36=40.91, b36=0.0;

            if (X_CCTV<6){
            Ka=a6;
            Kb=b6;
            }
            if (X_CCTV>=6 && X_CCTV<12){
                Ka=a6_12;
                Kb=b6_12;
            }
            if (X_CCTV>=12 && X_CCTV<24){
                Ka=a12_24;
                Kb=b12_24;
            }
            if (X_CCTV>=24 && X_CCTV<36){
                Ka=a24_36;
                Kb=b24_36;
            }
            if (X_CCTV>=36){
                Ka=a36;
                Kb=b36;
            }

        }
        if(L_CCTV>850 && L_CCTV<=2000){
            Zagolovok="Видеонаблюдение  внутри жилых домов, общественных и промышленных зданий" +
                    "суммарной длине кабелей свыше 850 м до 2000 м включительно";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 6, п.2";

            Double a24=50.83, b24=0.0;
            Double a24_36=9.31, b24_36=1.73;
            Double a36_48=24.43, b36_48=1.31;
            Double a48_60=34.99, b48_60=1.09;
            Double a60_110=76.39, b60_110=0.4;
            Double a110=120.39, b110=0.0;
            if (X_CCTV<24){
                Ka=a24;
                Kb=b24;
            }
            if (X_CCTV>=24 && X_CCTV<36){
                Ka=a24_36;
                Kb=b24_36;
            }
            if (X_CCTV>=36 && X_CCTV<48){
                Ka=a36_48;
                Kb=b36_48;
            }
            if (X_CCTV>=48 && X_CCTV<60){
                Ka=a48_60;
                Kb=b48_60;
            }
            if (X_CCTV>=60 && X_CCTV<110){
                Ka=a60_110;
                Kb=b60_110;
            }
            if (X_CCTV>=110){
                Ka=a110;
                Kb=b110;
            }

        }
        if(L_CCTV>2000 && L_CCTV<=3200){
            Zagolovok="Видеонаблюдение  внутри жилых домов, общественных и промышленных зданий" +
                    "суммарной длине кабелей свыше 2000 м до 3200 м включительно";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 6, п.3";
            Double a60=122.31, b60=0.0;
            Double a60_72=53.31, b60_72=1.15;
            Double a72_82=69.87, b72_82=0.92;
            Double a82_94=72.33, b82_94=0.89;
            Double a94_144=96.77, b94_144=0.63;
            Double a144=187.49, b144=0.0;
            if (X_CCTV<60){
                Ka=a60;
                Kb=b60;
            }
            if (X_CCTV>=60 && X_CCTV<72){
                Ka=a60_72;
                Kb=b60_72;
            }
            if (X_CCTV>=72 && X_CCTV<82){
                Ka=a72_82;
                Kb=b72_82;
            }
            if (X_CCTV>=82 && X_CCTV<94){
                Ka=a82_94;
                Kb=b82_94;
            }
            if (X_CCTV>=94 && X_CCTV<144){
                Ka=a94_144;
                Kb=b94_144;
            }
            if (X_CCTV>=144){
                Ka=a144;
                Kb=b144;
            }
        }
        if(L_CCTV>3200){
            Zagolovok="Видеонаблюдение  внутри жилых домов, общественных и промышленных зданий" +
                    "суммарной длине кабелей свыше 3200 м включительно";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 6, п.4";

            Double a60=146.77, b60=0.0;
            Double a60_72=63.97, b60_72=1.38;
            Double a72_82=83.41, b72_82=1.11;
            Double a82_94=87.51, b82_94=1.06;
            Double a94_144=115.71, b94_144=0.76;
            Double a114_294=180.51, b114_294=0.31;
            Double a294=271.65, b294=0.0;
            if (X_CCTV<60){
                Ka=a60;
                Kb=b60;
            }
            if (X_CCTV>=60 && X_CCTV<72){
                Ka=a60_72;
                Kb=b60_72;
            }
            if (X_CCTV>=72 && X_CCTV<82){
                Ka=a72_82;
                Kb=b72_82;
            }
            if (X_CCTV>=82 && X_CCTV<94){
                Ka=a82_94;
                Kb=b82_94;
            }
            if (X_CCTV>=94 && X_CCTV<144){
                Ka=a94_144;
                Kb=b94_144;
            }
            if (X_CCTV>=144 && X_CCTV<294){
                Ka=a114_294;
                Kb=b114_294;
            }
            if (X_CCTV>=294){
                Ka=a294;
                Kb=b294;
            }

        }
        Cb=(Ka+Kb*X_CCTV)*Koif_floor;
    }

    //*************************************Другой раздел*****************************************

    public void CCTV_Outdor(Double L_CCTV, int X_CCTV){

        Nat_index=X_CCTV;
        if (L_CCTV<=1200){
            Zagolovok="Видеонаблюдение за периметром здания, комплекса зданий " +
                    "и за их территориямипри суммарной длине кабелей до 1200 м";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 5, п.1";
            Double a6=21.58, b6=0.0;
            Double a6_12=9.7, b6_12=1.98;
            Double a12_24=18.34, b_12_24=1.26;
            Double a24_36=29.14, b24_36=0.81;
            Double a36=58.30, b36=0.0;
            if (X_CCTV < 6) {
                Ka=a6;
                Kb=b6;
            }
            if (X_CCTV >=6 && X_CCTV<12){
                Ka=a6_12;
                Kb=b6_12;
            }
            if (X_CCTV >=12 && X_CCTV<24){
                Ka=a12_24;
                Kb=b_12_24;
            }
            if (X_CCTV >=24 && X_CCTV<36){
                Ka=a24_36;
                Kb=b24_36;
            }
            if (X_CCTV>=36){
                Ka=a36;
                Kb=b36;
            }
            Cb=Ka+Kb*X_CCTV;
        }
        if (L_CCTV>1200 && L_CCTV<=3000){
            Zagolovok="Видеонаблюдение за периметром здания, комплекса зданий " +
                    "и за их территориямипри суммарной длине кабелей свыше 1200 м до 3000 м включительно";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 5, п.2";

            Double a24=50.9, b24=0.0;
            Double a24_36=2.9, b24_36=2.0;
            Double a36_48=10.1, b36_48=1.8;
            Double a48_60=26.9, b48_60=1.45;
            Double a60_110=86.9, b60_110=0.45;
            Double a110=136.4, b110=0.0;


            if (X_CCTV < 24) {
                Ka=a24;
                Kb=b24;
            }
            if (X_CCTV>=24 && X_CCTV<36){
                Ka=a24_36;
                Kb=b24_36;
            }
            if (X_CCTV>=36 && X_CCTV<48){
                Ka=a36_48;
                Kb=b36_48;
            }
            if (X_CCTV>=48 && X_CCTV<60){
                Ka=a48_60;
                Kb=b48_60;
            }
            if (X_CCTV>=60 && X_CCTV<110){
                Ka=a60_110;
                Kb=b60_110;
            }
            if (X_CCTV>=110){
                Ka=a110;
                Kb=b110;
            }

        }
        if (L_CCTV>3000 && L_CCTV<=5000){
            Zagolovok="Видеонаблюдение за периметром здания, комплекса зданий " +
                    "и за их территориямипри суммарной длине кабелей свыше 3000 м до 5000 м включительно";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 5, п.3";

            Double a60=125.78, b60=0.0;
            Double a60_72=6.98, b60_72=1.98;
            Double a72_82=16.34, b72_82=1.85;
            Double a82_94=26.18, b82_94=1.73;
            Double a94_110=38.40, b94_110=1.6;
            Double a110_160=119.8, b110_160=0.86;
            Double a160=257.4, b160=0.0;
            if (X_CCTV<60){
                Ka=a60;
                Kb=b60;
            }
            if (X_CCTV>=60 && X_CCTV<72){
                Ka=a60_72;
                Kb=b60_72;
            }
            if (X_CCTV>=72 && X_CCTV<82){
                Ka=a72_82;
                Kb=b72_82;
            }
            if (X_CCTV>=82 && X_CCTV<94){
                Ka=a82_94;
                Kb=b82_94;
            }
            if (X_CCTV>=94 && X_CCTV<110){
                Ka=a94_110;
                Kb=b94_110;
            }
            if (X_CCTV>=110 && X_CCTV<160){
                Ka=a110_160;
                Kb=b110_160;
            }
            if (X_CCTV<=160){
                Ka=a160;
                Kb=b160;
            }
        }
        if (L_CCTV>5000){
            Zagolovok="Видеонаблюдение за периметром здания, комплекса зданий " +
                    "и за их территориямипри суммарной длине кабелей свыше 5000 м";
            Sbornik="Сборник 5.1 МРР-5.1-16 Табл. 5, п.4";

            Double a60=150.94, b60=0.0;
            Double a60_72=11.74, b60_72=2.32;
            Double a72_82=18.94, b72_82=2.22;
            Double a82_94=30.42, b82_94=2.08;
            Double a94_110=45.46, b94_110=1.92;
            Double a110_160=143.36, b110_160=1.03;
            Double a160_310=242.56, b160_310=0.41;
            Double a310=369.66, b310=0.0;

            if (X_CCTV<60){
                Ka=a60;
                Kb=b60;
            }
            if (X_CCTV>=60 && X_CCTV<72){
                Ka=a60_72;
                Kb=b60_72;
            }
            if (X_CCTV>=72 && X_CCTV<82){
                Ka=a72_82;
                Kb=b72_82;
            }
            if (X_CCTV>=82 && X_CCTV<94){
                Ka=a82_94;
                Kb=b82_94;
            }
            if (X_CCTV>=94 && X_CCTV<110){
                Ka=a94_110;
                Kb=b94_110;
            }
            if (X_CCTV>=110 && X_CCTV<160){
                Ka=a110_160;
                Kb=b110_160;
            }
            if (X_CCTV>=160 && X_CCTV<310){
                Ka=a110_160;
                Kb=a160_310;
            }
            if (X_CCTV>=310){
                Ka=a310;
                Kb=b310;
            }
        }
        Cb=Ka+Kb*X_CCTV;
    }


}