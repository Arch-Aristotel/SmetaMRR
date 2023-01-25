package com.example.mytestapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class KabielKanaliz extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_kabkanaliz, container, false);

        return v;
    }

    String Zagolovok;
    String Sbornik;
    int Choose_k_set=1;
    double Ka=0, Kb=0;
    double KoifMin=1;
    double Nat_index;
    double Cb;

    void metod0_6(double dlinaKK)
    {
        Zagolovok = "Прокладка канализации связи и радио из асбоцементных труб диаметром 100 мм,\n емкостью до 6 отверстий включительно и протяженностью,\n 500 п.м. и менее";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.8, п.1.1";
        Nat_index = dlinaKK;

        double a500 = 21.6, b500=0;
        double a500_1000 = 4.6, b500_1000=0.034;
        double a1000_3000 = 8.6, b1000_3000=0.03;
        double a3000_6000 = 20.6, b3000_6000=0.026;
        double a6000_10000 = 62.6, b6000_10000=0.019;


        if(dlinaKK>0 && dlinaKK<=500)
        {
            Ka=a500;
            Kb=b500;
            if (dlinaKK<250) KoifMin=0.9;
        }
        if(dlinaKK>500 && dlinaKK<=1000)
        {
            Ka=a500_1000;
            Kb=b500_1000;
        }
        if(dlinaKK>1000 && dlinaKK<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if(dlinaKK>3001 && dlinaKK<=6000)
        {
            Ka=a3000_6000;
            Kb=b3000_6000;
        }
        if(dlinaKK>6000 && dlinaKK<=10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
        }

        Cb=(Ka+Kb*dlinaKK)*KoifMin;

        if(dlinaKK>10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
            Cb=Ka+Kb*10000+Kb*(dlinaKK-10000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }

    }

    void metod6_12(double dlinaKK)
    {
        Zagolovok = "Прокладка канализации связи и радио из асбоцементных труб диаметром 100 мм,\n емкостью до 12 отверстий включительно и протяженностью,\n "+ dlinaKK +" п.м.";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.8, п.1.2";
        Nat_index = dlinaKK;

        double a250 = 21.6, b250=0;
        double a250_500 = 4.6, b250_500=0.068;
        double a500_1000 = 8.6, b500_1000=0.06;
        double a1000_3000 = 35.6, b1000_3000=0.033;
        double a3000_6000 = 47.6, b3000_6000=0.029;
        double a6000_10000 = 95.6, b6000_10000=0.021;

        if(dlinaKK>0 && dlinaKK<=250)
        {
            Ka=a250;
            Kb=b250;
            if (dlinaKK<125) KoifMin=0.9;
        }
        if(dlinaKK>250 && dlinaKK<=500)
        {
            Ka=a250_500;
            Kb=b250_500;
        }
        if(dlinaKK>500 && dlinaKK<=1000)
        {
            Ka=a500_1000;
            Kb=b500_1000;
        }
        if(dlinaKK>1000 && dlinaKK<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if(dlinaKK>3001 && dlinaKK<=6000)
        {
            Ka=a3000_6000;
            Kb=b3000_6000;
        }
        if(dlinaKK>6000 && dlinaKK<=10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
        }
        Cb=(Ka+Kb*dlinaKK)*KoifMin;
        if(dlinaKK>10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
            Cb=Ka+Kb*10000+Kb*(dlinaKK-10000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }
    }

    void metod12_24(double dlinaKK)
    {
        Zagolovok = "Прокладка канализации связи и радио из асбоцементных труб диаметром 100 мм,\n емкостью до 24 отверстий включительно и протяженностью,\n "+ dlinaKK +" п.м.";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.8, п.1.3";
        Nat_index = dlinaKK;

        double a100 = 21.6, b100=0;
        double a100_500 = 4.6, b100_500=0.171;
        double a500_1000 = 61.0, b500_1000=0.058;
        double a1000_3000 = 68.0, b1000_3000=0.051;
        double a3000_6000 = 86.0, b3000_6000=0.045;
        double a6000_10000 = 164.0, b6000_10000=0.032;


        if(dlinaKK>0 && dlinaKK<=100)
        {
            Ka=a100;
            Kb=b100;
            if (dlinaKK<50) KoifMin=0.9;
        }
        if(dlinaKK>100 && dlinaKK<=500)
        {
            Ka=a100_500;
            Kb=b100_500;
        }
        if(dlinaKK>500 && dlinaKK<=1000)
        {
            Ka=a500_1000;
            Kb=b500_1000;
        }
        if(dlinaKK>1000 && dlinaKK<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if(dlinaKK>3001 && dlinaKK<=6000)
        {
            Ka=a3000_6000;
            Kb=b3000_6000;
        }
        if(dlinaKK>6000 && dlinaKK<=10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
        }
        Cb=(Ka+Kb*dlinaKK)*KoifMin;
        if(dlinaKK>10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
            Cb=Ka+Kb*10000+Kb*(dlinaKK-10000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }
    }

    void metod24_36(double dlinaKK)
    {
        Zagolovok = "Прокладка канализации связи и радио из асбоцементных труб диаметром 100 мм,\n емкостью до 36 отверстий включительно и протяженностью,\n "+ dlinaKK +" п.м.";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.8, п.1.4";
        Nat_index = dlinaKK;

        double a100 = 42.3, b100=0;
        double a100_500 = 25.2, b100_500=0.171;
        double a500_1000 = 42.2, b500_1000=0.137;
        double a1000_3000 = 77.2, b1000_3000=0.102;
        double a3000_6000 = 110.2, b3000_6000=0.091;
        double a6000_10000 = 260.2, b6000_10000=0.066;

        if(dlinaKK>0 && dlinaKK<=100)
        {
            Ka=a100;
            Kb=b100;
            if (dlinaKK<50) KoifMin=0.9;
        }
        if(dlinaKK>100 && dlinaKK<=500)
        {
            Ka=a100_500;
            Kb=b100_500;
        }
        if(dlinaKK>500 && dlinaKK<=1000)
        {
            Ka=a500_1000;
            Kb=b500_1000;
        }
        if(dlinaKK>1000 && dlinaKK<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if(dlinaKK>3001 && dlinaKK<=6000)
        {
            Ka=a3000_6000;
            Kb=b3000_6000;
        }
        if(dlinaKK>6000 && dlinaKK<=10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
        }
        Cb=(Ka+Kb*dlinaKK)*KoifMin;
        if(dlinaKK>10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
            Cb=Ka+Kb*10000+Kb*(dlinaKK-10000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }
    }

    void metod36_48(double dlinaKK)
    {
        Zagolovok = "Прокладка канализации связи и радио из асбоцементных труб диаметром 100 мм,\n емкостью до 48 отверстий включительно и протяженностью,\n "+ dlinaKK +" п.м.";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.8, п.1.5";
        Nat_index = dlinaKK;

        double a50 = 48.6, b50=0;
        double a50_500 = 37.8, b50_500=0.216;
        double a500_1000 = 52.8, b500_1000=0.186;
        double a1000_3000 = 85.8, b1000_3000=0.153;
        double a3000_6000 = 136.8, b3000_6000=0.136;
        double a6000_10000 = 358.8, b6000_10000=0.099;

        if(dlinaKK>0 && dlinaKK<=100)
        {
            Ka=a50;
            Kb=b50;
            if (dlinaKK<25) KoifMin=0.9;
        }
        if(dlinaKK>100 && dlinaKK<=500)
        {
            Ka=a50_500;
            Kb=b50_500;
        }
        if(dlinaKK>500 && dlinaKK<=1000)
        {
            Ka=a500_1000;
            Kb=b500_1000;
        }
        if(dlinaKK>1000 && dlinaKK<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if(dlinaKK>3001 && dlinaKK<=6000)
        {
            Ka=a3000_6000;
            Kb=b3000_6000;
        }
        if(dlinaKK>6000 && dlinaKK<=10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
        }
        Cb=(Ka+Kb*dlinaKK)*KoifMin;
        if(dlinaKK>10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
            Cb=Ka+Kb*10000+Kb*(dlinaKK-10000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }
    }



    void metod48_60(double dlinaKK)
    {
        Zagolovok = "Прокладка канализации связи и радио из асбоцементных труб диаметром 100 мм,\n емкостью до 60 отверстий включительно и протяженностью,\n "+ dlinaKK +" п.м.";
        Sbornik = "Сборник 4.2 МРР-4.2.03-20 Табл. 3.8, п.1.6";
        Nat_index = dlinaKK;

        double a50 = 63.9, b50=0;
        double a50_500 = 51.3, b50_500=0.252;
        double a500_1000 = 69.3, b500_1000=0.216;
        double a1000_3000 = 115.3, b1000_3000=0.170;
        double a3000_6000 = 172.3, b3000_6000=0.151;
        double a6000_10000 = 424.3, b6000_10000=0.109;

        if(dlinaKK>0 && dlinaKK<=100)
        {
            Ka=a50;
            Kb=b50;
            if (dlinaKK<25) KoifMin=0.9;
        }
        if(dlinaKK>100 && dlinaKK<=500)
        {
            Ka=a50_500;
            Kb=b50_500;
        }
        if(dlinaKK>500 && dlinaKK<=1000)
        {
            Ka=a500_1000;
            Kb=b500_1000;
        }
        if(dlinaKK>1000 && dlinaKK<=3000){
            Ka=a1000_3000;
            Kb=b1000_3000;
        }
        if(dlinaKK>3001 && dlinaKK<=6000)
        {
            Ka=a3000_6000;
            Kb=b3000_6000;
        }
        if(dlinaKK>6000 && dlinaKK<=10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
        }
        Cb=(Ka+Kb*dlinaKK)*KoifMin;
        if(dlinaKK>10000)
        {
            Ka=a6000_10000;
            Kb=b6000_10000;
            Cb=Ka+Kb*10000+Kb*(dlinaKK-10000)*0.5;
            Choose_k_set=Choose_k_set+1;
        }
    }


}