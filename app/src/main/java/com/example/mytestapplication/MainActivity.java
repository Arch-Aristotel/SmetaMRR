package com.example.mytestapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.sax.SAXResult;

public class MainActivity extends AppCompatActivity {
    Double Koif_MKE=4.914;
    Double Res=0.0;
    Double Finish_res=0.0;
    List<String> Base_estimate = new ArrayList<>();
    int x_list=0;

    //Начало описания основных компонентов
    Spinner Spinner_select_ing;
    Button  Chose_set_spinner;
    CheckBox Select_chek_P;
    CheckBox Select_chek_R;
    Button Calculation_button;
    TextView Characteristic_txt;
    TextView Collection_txt;
    TextView A_txt;
    TextView B_txt;
    TextView Formula;
    TextView Price_txt;
    //Конец описания основных компонентов
    //Начало описания компонентов кабельной канализации
    EditText SetKabel_Kanaliz;
    Spinner  Spin_holes;
    CheckBox Check_Dism_KK;
    //Конец описания компонентов кабельной канализации
    //Начало описания компонентов кабеля
    EditText New_Kabel_Pr;
    EditText New_Kabel_S;
    EditText Sec_Kabel_Pr;
    EditText Sec_Kab_S;
    CheckBox Check_Dism_KabKK;
    //Конец описания компонентов кабеля

    //Начало описания компонентов ГНБ
    TextView Set_text_GNB;
    EditText Get_text_GNB;
    CheckBox Chek_select_case;
    //Конец описания компонентов ГНБ

    //Начало описания сметы
    ListView Base_est_name;
    ListView Base_est_summ;
    // Конец описания сметы



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner_select_ing = findViewById(R.id.spinner_select);
        Chose_set_spinner = findViewById(R.id.button_set_spinner);
        Select_chek_P = findViewById(R.id.checkBox_stage_P);
        Select_chek_R = findViewById(R.id.checkBox_stage_R);
        Calculation_button = findViewById(R.id.button_calc);
        Characteristic_txt = findViewById(R.id.textView_Characteristic);
        Collection_txt = findViewById(R.id.textView_Collection);
        A_txt = findViewById(R.id.textView_a);
        B_txt = findViewById(R.id.textView_b);
        Formula = findViewById(R.id.formula);
        Price_txt = findViewById(R.id.textView_price);

        Spinner_select_ing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager tmp = getSupportFragmentManager();
                FragmentTransaction setFragm = tmp.beginTransaction();
                if (Spinner_select_ing.getSelectedItemId()==0){
                    KabielKanaliz KabelKanaliz = new KabielKanaliz();
                    setFragm.replace(R.id.Frag_Show, KabelKanaliz);
                    setFragm.commit();
                }
                if (Spinner_select_ing.getSelectedItemId()==1){
                    KabielCC Kabel = new KabielCC();
                    setFragm.replace(R.id.Frag_Show, Kabel);
                    setFragm.commit();
                }
                if (Spinner_select_ing.getSelectedItemId()==2){
                    GNB G_n_B = new GNB();
                    setFragm.replace(R.id.Frag_Show, G_n_B);
                    setFragm.commit();
                }
                if (Spinner_select_ing.getSelectedItemId()==3){
                    CCTV Video = new CCTV();
                    setFragm.replace(R.id.Frag_Show, Video);
                    setFragm.commit();
                }
                if (Spinner_select_ing.getSelectedItemId()==4){
                    CCTV_PVN pvn_show = new CCTV_PVN();
                    setFragm.replace(R.id.Frag_Show, pvn_show);
                    setFragm.commit();

                }
                if (Spinner_select_ing.getSelectedItemId()==5){
                    Estimate ETM = new Estimate();
                    setFragm.replace(R.id.Frag_Show, ETM);
                    setFragm.commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void  Clic_select (View view){
       if (Spinner_select_ing.getSelectedItemId()==5){
           for (int i=0;i<x_list+1;++i) Base_estimate.remove(0);
           Estim();
           Finish_res=0.0;
       }
       else{
           Base_estimate.add(Characteristic_txt.getText().toString()+"\n"
                   +Collection_txt.getText().toString()+"\n"
                   +A_txt.getText().toString()+"\n"
                   +B_txt.getText().toString()+"\n Формула расчета стоимости "
                   +Formula.getText().toString()+"\n"
                   +Price_txt.getText().toString()+"\n"
           );
           Finish_res=Finish_res+Res;
           x_list++;
       }
    }

    public void Click_button_calc(View view){
        double StP=0, StR=0;
        if (Select_chek_R.isChecked()) StR=+0.6;
        if (Select_chek_P.isChecked()) StP=+0.4;
        if (Spinner_select_ing.getSelectedItemId()==0) Set_kab_kanaliz(StP, StR);
        if (Spinner_select_ing.getSelectedItemId()==1) Kabel_in_KK(StP, StR);
        if (Spinner_select_ing.getSelectedItemId()==2) GNB(StP, StR);
        if (Spinner_select_ing.getSelectedItemId()==3) CCTV(StP, StR);
        if (Spinner_select_ing.getSelectedItemId()==4) PVN(StP, StR);
        if (Spinner_select_ing.getSelectedItemId()==5){
            Base_estimate.add("\n Итого в ценах 2000 года: "+Math.round(Finish_res)+
                    "\n Итого с учетом коэффициента пересчета "+ Koif_MKE +" (приказ от 30.12.20 №МКЭ-ОД/20-93), руб.:"+Math.round(Finish_res*Koif_MKE)+
                    "\n Всего с НДС "+Math.round((Finish_res*Koif_MKE)*1.2));
            Estim();
        }
        }


    public void Set_kab_kanaliz(Double StP, Double StR){
        double dismant_coeff=1;
        Fragment e = getSupportFragmentManager().findFragmentById(R.id.Frag_Show);
        SetKabel_Kanaliz = e.getView().findViewById(R.id.editDlinnaKK);
        Spin_holes = e.getView().findViewById(R.id.spinner_set_holes);
        Check_Dism_KK = e.getView().findViewById(R.id.checkBox_dismant);
        KabielKanaliz cc = new KabielKanaliz();
        Double CNT = Double.parseDouble(SetKabel_Kanaliz.getText().toString());
        int SpinOtnNumber = Spin_holes.getSelectedItemPosition();
        if (SpinOtnNumber==0) cc.metod0_6(CNT);
        if (SpinOtnNumber==1) cc.metod6_12(CNT);
        if (SpinOtnNumber==2) cc.metod12_24(CNT);
        if (SpinOtnNumber==3) cc.metod24_36(CNT);
        if (SpinOtnNumber==4) cc.metod36_48(CNT);
        if (SpinOtnNumber==5) cc.metod48_60(CNT);
        if (Check_Dism_KK.isChecked()) dismant_coeff=0.05;
        cc.Cb=cc.Cb*(StR+StP)*dismant_coeff*1000;
        Characteristic_txt.setText(cc.Zagolovok);
        Collection_txt.setText(cc.Sbornik);
        A_txt.setText(cc.Ka+" a-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        B_txt.setText(cc.Kb+" в-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        if(cc.Choose_k_set==1) Formula.setText("("+cc.Ka+"+"+cc.Kb+"*"+cc.Nat_index+")*"+cc.KoifMin+"*"+(StP+StR)+"*1000*"+dismant_coeff);
        if(cc.Choose_k_set==2) Formula.setText(cc.Ka+"+"+cc.Kb+"*10000+"+cc.Kb+"*("+cc.Nat_index+"-10000)*0.5*"+(StP+StR)+"*1000*"+dismant_coeff);
        Price_txt.setText(Math.round(cc.Cb)+" Стоимость (руб.)\n"+Math.round(cc.Cb*Koif_MKE)+" Коэфецент № МКЭ-ОД/21-100");
        Res=cc.Cb;
    }

    public void Kabel_in_KK(Double StP, Double StR){
        double dismant_coeff=1;
        Fragment e = getSupportFragmentManager().findFragmentById(R.id.Frag_Show);
        New_Kabel_Pr = e.getView().findViewById(R.id.editTextFistKabel_proekt);
        New_Kabel_S = e.getView().findViewById(R.id.editTextFistKabel_sush);
        Sec_Kabel_Pr = e.getView().findViewById(R.id.editTextSecondKabel_proekt);
        Sec_Kab_S = e.getView().findViewById(R.id.editTextSecondKabel_sush);
        Check_Dism_KabKK = e.getView().findViewById(R.id.checkBoxDemKabel);
        if(Check_Dism_KabKK.isChecked()) dismant_coeff=0.05;
        KabielCC cck = new KabielCC();
        double Perv_kab_proekt = Double.parseDouble(New_Kabel_Pr.getText().toString());
        double Perv_kab_sush = Double.parseDouble(New_Kabel_S.getText().toString());
        double Vtoroy_kab_proekt = Double.parseDouble(Sec_Kabel_Pr.getText().toString());
        double Vtoroy_kab_sush = Double.parseDouble(Sec_Kab_S.getText().toString());
        cck.set_kabel(Perv_kab_proekt,Perv_kab_sush, Vtoroy_kab_proekt, Vtoroy_kab_sush);
        cck.Cb=cck.Cb*(StR+StP)*1000*dismant_coeff;
        Characteristic_txt.setText(cck.Zagolovok);
        Collection_txt.setText(cck.Sbornik);
        A_txt.setText(cck.Ka+" a-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        B_txt.setText(cck.Kb+" в-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        if(cck.Choose_k_set==1) Formula.setText("("+cck.Ka+"+"+cck.Kb+"*"+cck.Nat_index+")*"+cck.KoifMin+"*"+cck.koifSuch+"*"+(StP+StR)+"*1000*"+dismant_coeff);
        if(cck.Choose_k_set==2) Formula.setText(cck.Ka+"+"+cck.Kb+"*10000+"+cck.Kb+"*("+cck.Nat_index+"-10000)*0.5*"+cck.koifSuch+"*"+(StP+StR)+"*1000*"+dismant_coeff);
        Price_txt.setText(Math.round(cck.Cb)+" Стоимость (руб.)\n"+Math.round(cck.Cb*Koif_MKE)+" Коэфецент № МКЭ-ОД/21-100");
        Res=cck.Cb;
    }

    public void GNB(Double StP, Double StR){
        Fragment e = getSupportFragmentManager().findFragmentById(R.id.Frag_Show);
        Set_text_GNB = e.getView().findViewById(R.id.textView_close_case);
        Get_text_GNB = e.getView().findViewById(R.id.editText_close_case);
        Chek_select_case = e.getView().findViewById(R.id.checkBox_close_case);
        GNB gnb = new GNB();
        if (Chek_select_case.isChecked()) {
            Set_text_GNB.setText("Закрытая прокладка футляра для инженерных коммуникаций способом продавливания или прокола, глубиной до 5 м и протяжённостью, п.м:");
            gnb.GNB_case(Double.parseDouble(Get_text_GNB.getText().toString()));
        }
            else{
                Set_text_GNB.setText("Бестраншейная прокладка инженерных коммуникаций методом горизонтального направленного бурения");
                gnb.GNB_dep(Double.parseDouble(Get_text_GNB.getText().toString()));
        }
            Characteristic_txt.setText(gnb.Zagolovok);
            Collection_txt.setText(gnb.Sbornik);
            gnb.Cb=gnb.Cb*(StR+StP)*1000;
            A_txt.setText(gnb.Ka+" a-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
            B_txt.setText(gnb.Kb+" в-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
            if(gnb.Choose_k_set==1) Formula.setText("("+gnb.Ka+"+"+gnb.Kb+"*"+gnb.Nat_index+")*"+(StP+StR)+"*1000*");
            if(gnb.Choose_k_set==2) Formula.setText(gnb.Ka+"+"+gnb.Kb+"*1000+"+gnb.Kb+"*("+gnb.Nat_index+"-1000)*0.5*"+(StP+StR)+"*1000*");
            Price_txt.setText(Math.round(gnb.Cb)+" Стоимость (руб.)\n"+Math.round(gnb.Cb*Koif_MKE)+" Коэфецент № МКЭ-ОД/21-100");
            Res=gnb.Cb;
    }



    //Начало описания компонентов кабельной канализации
    CheckBox Seleckt_CCTV;
    EditText Get_CCTV;
    EditText Get_CCTV_Cab;
    CheckBox Inset_floor_koif;
    //Конец описания компонентов кабельной канализации
    public void CCTV(Double StP, Double StR) {
        Fragment e = getSupportFragmentManager().findFragmentById(R.id.Frag_Show);
        Seleckt_CCTV = e.getView().findViewById(R.id.checkBox_select_CCTV);
        Get_CCTV = e.getView().findViewById(R.id.editTextNumber_CCTV);
        Get_CCTV_Cab = e.getView().findViewById(R.id.editTextNumberDecimal_CCTV_cabel);
        Inset_floor_koif = e.getView().findViewById(R.id.checkBox_CCTV_floor_koif);
        CCTV cctv = new CCTV();

        if (Seleckt_CCTV.isChecked()) {
            if (Inset_floor_koif.isChecked()) cctv.Koif_floor=1.2;
            cctv.CCTV_Outdor(Double.parseDouble(Get_CCTV_Cab.getText().toString()), Integer.parseInt(Get_CCTV.getText().toString()));
        }
        else
            cctv.CCTV_Inside(Double.parseDouble(Get_CCTV_Cab.getText().toString()), Integer.parseInt(Get_CCTV.getText().toString()));

        Characteristic_txt.setText(cctv.Zagolovok);
        Collection_txt.setText(cctv.Sbornik);
        cctv.Cb=cctv.Cb*(StR+StP)*1000;
        A_txt.setText(cctv.Ka+" a-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        B_txt.setText(cctv.Kb+" в-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        Formula.setText("("+cctv.Ka+"+"+cctv.Kb+"*"+cctv.Nat_index+")*"+cctv.Koif_floor+"*"+(StP+StR)+"*1000*");
        Price_txt.setText(Math.round(cctv.Cb)+" Стоимость (руб.)\n"+Math.round(cctv.Cb*Koif_MKE)+" Коэфецент № МКЭ-ОД/21-100");
        Res=cctv.Cb;
    }


    //Начало описания компонентов кабельной канализации
        EditText Set_PVN_amount;
        CheckBox Select_only_ARM;
    //Окончание описания компонентов кабельной канализации

    public void PVN(Double StP, Double StR){
        Fragment e = getSupportFragmentManager().findFragmentById(R.id.Frag_Show);
        Set_PVN_amount = e.getView().findViewById(R.id.editTextNumber_CCTV_PVN);
        Select_only_ARM = e.getView().findViewById(R.id.checkBox_ARM_PVN);
        CCTV_PVN pvn = new CCTV_PVN();
        if (Select_only_ARM.isChecked()) pvn.Koif_ARM=0.5;
        pvn.PVN(Integer.parseInt(Set_PVN_amount.getText().toString()));

        Characteristic_txt.setText(pvn.Zagolovok);
        Collection_txt.setText(pvn.Sbornik);
        pvn.Cb=pvn.Cb*(StR+StP)*1000;
        A_txt.setText(pvn.Ka+" a-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        B_txt.setText(pvn.Kb+" в-постоянная величина стоимости проектных работ  01.01.2000г., тыс. руб.");
        Formula.setText("("+pvn.Ka+"+"+pvn.Kb+"*"+pvn.Nat_index+")*"+pvn.Koif_ARM+"*"+(StP+StR)+"*1000*");
        Price_txt.setText(Math.round(pvn.Cb)+" Стоимость (руб.)\n"+Math.round(pvn.Cb*Koif_MKE)+" Коэфецент № МКЭ-ОД/21-100");
        Res=pvn.Cb;
    }

    public void Estim(){
        Fragment e = getSupportFragmentManager().findFragmentById(R.id.Frag_Show);
        ArrayAdapter words = new ArrayAdapter(this, R.layout.row, Base_estimate);
        Base_est_name = e.getView().findViewById(R.id.Base_est_name);
        Base_est_name.setAdapter(words);
    }

    }

