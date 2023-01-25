package com.example.mytestapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class KabielCC extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kabel_cc, container, false);
    }


    String Zagolovok;
    String Sbornik;
    int Choose_k_set=1;
    double Ka=0, Kb=0;
    double KoifMin=1;
    double Nat_index;
    double Cb;
    double koifSuch;

    public void set_kabel(double Perv_kab_proekt, double Perv_kab_sush, double Vtoroy_kab_proekt, double Vtoroy_kab_sush){
        Zagolovok = "Прокладка кабелей связи и радио в канализации\n";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.8, п.2.1";
        Double L=Perv_kab_proekt+Perv_kab_sush+Vtoroy_kab_proekt+Vtoroy_kab_sush;
        Nat_index=L;
        koifSuch=(Perv_kab_proekt/L*1)+(Perv_kab_sush/L*1.2)+(Vtoroy_kab_proekt/L*0.5)+(Vtoroy_kab_sush/L*1.2*0.5);

        double a250 = 17.1, b250=0;
        double a250_1000 = 12.6, b250_1000=0.018;
        double a1000_3000 = 17.6, b1000_3000=0.013;
        double a3000_6000 = 23.6, b3000_6000=0.011;
        double a6000_10000 = 41.6, b6000_10000=0.008;


        if (L>0 && L<=250){
            Ka=a250;
            Kb=b250;
            if (L<125)  KoifMin=0.9;
        }
        if (L>250 && L<=1000){
            Ka=a250_1000;
            Kb=b250_1000;
        }
        if (L>1000 && L<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if (L>3000 && L<=6000){
            Ka=a3000_6000;
            Kb=b3000_6000;
        }
        if (L>6000 && L<=10000){
            Ka=a6000_10000;
            Kb=b6000_10000;
        }
        Cb=(Ka+Kb*L)*KoifMin*koifSuch;

        if (L>10000){
            Ka=a6000_10000;
            Kb=b6000_10000;
            Cb=Ka+Kb*10000+Kb*(L-10000)*0.5*koifSuch;
            Choose_k_set=Choose_k_set+1;
        }

    }
}