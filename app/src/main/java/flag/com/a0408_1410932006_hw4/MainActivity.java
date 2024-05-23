package flag.com.a0408_1410932006_hw4;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity<tx> extends AppCompatActivity {

    TextView     rrr, n;
    EditText     ALL_TXT, account, password;
    LinearLayout tea_ALL, milktea_ALL, spe_ALL, ju_ALL, ice_ALL, login_ALL;
    Button       tea_btn, milktea_btn, spe_btn, ju_btn, ice_btn, customized_btn, cancel_btn, signout_btn, options_btn;
    CheckBox     m_50_3 , m_35_2 , m_30_1 , m_30_2 , m_55_4 , m_30_5 , m_25_6 ,
            m_30_3 , m_75_1 , m_45_5 , m_25_1 , m_50_5 , m_45_1 , m_40_2 ,
            m_45_3 , m_70_2 , m_50_2 , m_25_3 , m_25_2 , m_50_7 , m_45_6 ,
            m_60_1 , m_45_7 , m_25_7 , m_55_3 , m_60_2 , m_55_2 , m_50_1 ,
            m_40_4 , m_45_4 , m_50_6 , m_35_1 , m_25_4 , m_55_1 , m_50_4 ,
            m_70_1 , m_30_4 , m_45_2 , m_55_5 , m_40_3 , m_25_5 , m_40_1 ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



      //  getWindow().setStatusBarColor(0xFFD4E0D2);  //狀態列顏色
        //setTitle("嵌入式系統期中報告　第八組　01.02.06");
        setContentView(R.layout.activity_main);
        //接收訊息
        Bundle bundle0311 = this.getIntent().getExtras();
        String account = bundle0311.getString("account");
        String password = bundle0311.getString("password");
        setTitle("使用者："+account);   //上方抬頭


        customized_btn = findViewById(R.id.customized_btn);     //customized=客製化
        customized_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ALL_TXT = findViewById(R.id.ALL_TXT);
                Editable str = ALL_TXT.getText();
                final int[] count = {0};
                char temp;
                for (int j = 0; j < str.length(); j++) {
                    temp = str.charAt(j);
                    if (temp == ',')
                        count[0]++;
                }

                if(count[0] > 5)        dialog();
                else if(count[0] ==0)   dialog();

                else {      //k=金額加總
                    int k=0;
                    if (m_25_1.isChecked())k += 25;
                    if (m_25_2.isChecked())k += 25;
                    if (m_25_3.isChecked())k += 25;
                    if (m_25_4.isChecked())k += 25;
                    if (m_25_5.isChecked())k += 25;
                    if (m_25_6.isChecked())k += 25;
                    if (m_25_7.isChecked())k += 25;

                    if (m_30_1.isChecked())k += 30;
                    if (m_30_2.isChecked())k += 30;
                    if (m_30_3.isChecked())k += 30;
                    if (m_30_4.isChecked())k += 30;
                    if (m_30_5.isChecked())k += 30;

                    if (m_35_1.isChecked())k += 35;
                    if (m_35_2.isChecked())k += 35;

                    if (m_40_1.isChecked())k += 40;
                    if (m_40_2.isChecked())k += 40;
                    if (m_40_3.isChecked())k += 40;
                    if (m_40_4.isChecked())k += 40;

                    if (m_45_1.isChecked())k += 45;
                    if (m_45_2.isChecked())k += 45;
                    if (m_45_3.isChecked())k += 45;
                    if (m_45_4.isChecked())k += 45;
                    if (m_45_5.isChecked())k += 45;
                    if (m_45_6.isChecked())k += 45;
                    if (m_45_7.isChecked())k += 45;


                    if (m_50_1.isChecked())k += 50;
                    if (m_50_2.isChecked())k += 50;
                    if (m_50_3.isChecked())k += 50;
                    if (m_50_4.isChecked())k += 50;
                    if (m_50_5.isChecked())k += 50;
                    if (m_50_6.isChecked())k += 50;
                    if (m_50_7.isChecked())k += 50;


                    if (m_55_1.isChecked())k += 55;
                    if (m_55_2.isChecked())k += 55;
                    if (m_55_3.isChecked())k += 55;
                    if (m_55_4.isChecked())k += 55;
                    if (m_55_5.isChecked())k += 55;

                    if (m_60_1.isChecked())k += 60;
                    if (m_60_2.isChecked())k += 60;

                    if (m_70_1.isChecked())k += 70;
                    if (m_70_2.isChecked())k += 70;
                    if (m_75_1.isChecked())k += 75;

                    ((TextView) findViewById(R.id.ALL_m)).setText(String.valueOf(k));


                    //設定傳到下個頁面
                    EditText EditTextTel = (EditText) findViewById(R.id.ALL_TXT);
                    Editable StrTel;
                    StrTel = EditTextTel.getText();
                    String ALL_TXT = StrTel.toString();


                    EditText every_mo = (EditText) findViewById(R.id.every_mo);
                    Editable StrTel2;
                    StrTel2 = every_mo.getText();
                    String every_mon = StrTel2.toString();


                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, customized.class);

                    //new一個Bundle物件，並將要傳遞的資料傳入
                    Bundle bundle = new Bundle();

                    //intent.putExtra("name",name);    //可放所有基本類別
                    bundle.putString("ALL_TXT", ALL_TXT);
                    bundle.putString("k", String.valueOf(k));
                    bundle.putString("every_mo", every_mon);
                    bundle.putString("account", account);
                    bundle.putString("password", password);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        signout_btn = findViewById(R.id.signout_btn);
        signout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
        {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        }});

        options_btn = findViewById(R.id.options_btn);
        options_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, options.class);
                startActivity(intent);

                String StrTel2;
                StrTel2 = account;
                String every_mon = StrTel2.toString();

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();

                //intent.putExtra("name",name);    //可放所有基本類別
                bundle.putString("account", account);
                intent.putExtras(bundle);
                startActivity(intent);
            }});



        tea_btn = findViewById(R.id.tea_btn);
        tea_ALL = findViewById(R.id.tea_ALL);
        tea_ALL.setVisibility(View.GONE);           // 處於隱藏狀態
        tea_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (tea_ALL.getVisibility() == View.GONE) {     //tea
                    tea_ALL.setVisibility(View.VISIBLE);        // 處於可見狀態
                }
                else if (tea_ALL.getVisibility() == View.VISIBLE) {
                    tea_ALL.setVisibility(View.GONE);
                }
            }
        });

        milktea_btn = findViewById(R.id.milktea_btn);
        milktea_ALL = findViewById(R.id.milktea_ALL);
        milktea_ALL.setVisibility(View.GONE);       // 處於隱藏狀態
        milktea_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (milktea_ALL.getVisibility() == View.GONE) {             //milktea
                    milktea_ALL.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (milktea_ALL.getVisibility() == View.VISIBLE) {
                    milktea_ALL.setVisibility(View.GONE);
                }
            }
        });

        spe_btn = findViewById(R.id.spe_btn);
        spe_ALL = findViewById(R.id.spe_ALL);
        spe_ALL.setVisibility(View.GONE);       // 處於隱藏狀態
        spe_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (spe_ALL.getVisibility() == View.GONE) {             //spe
                    spe_ALL.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (spe_ALL.getVisibility() == View.VISIBLE) {
                    spe_ALL.setVisibility(View.GONE);
                }
            }
        });

        ju_btn = findViewById(R.id.ju_btn);
        ju_ALL = findViewById(R.id.ju_ALL);
        ju_ALL.setVisibility(View.GONE);       // 處於隱藏狀態
        ju_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (ju_ALL.getVisibility() == View.GONE) {             //ju
                    ju_ALL.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (ju_ALL.getVisibility() == View.VISIBLE) {
                    ju_ALL.setVisibility(View.GONE);
                }
            }
        });

        ice_btn = findViewById(R.id.ice_btn);
        ice_ALL = findViewById(R.id.ice_ALL);
        ice_ALL.setVisibility(View.GONE);       // 處於隱藏狀態
        ice_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (ice_ALL.getVisibility() == View.GONE) {             //ice
                    ice_ALL.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (ice_ALL.getVisibility() == View.VISIBLE) {
                    ice_ALL.setVisibility(View.GONE);
                }
            }
        });

        m_25_1 = findViewById(R.id.m_25_1);
        m_25_3 = findViewById(R.id.m_25_3);
        m_30_2 = findViewById(R.id.m_30_2);
        m_25_2 = findViewById(R.id.m_25_2);
        m_30_1 = findViewById(R.id.m_30_1);
        m_30_3 = findViewById(R.id.m_30_3);
        m_25_4 = findViewById(R.id.m_25_4);
        m_35_1 = findViewById(R.id.m_35_1);
        m_25_5 = findViewById(R.id.m_25_5);
        m_45_1 = findViewById(R.id.m_45_1);
        m_55_3 = findViewById(R.id.m_55_3);
        m_55_4 = findViewById(R.id.m_55_4);
        m_50_6 = findViewById(R.id.m_50_6);
        m_50_4 = findViewById(R.id.m_50_4);
        m_40_2 = findViewById(R.id.m_40_2);
        m_45_2 = findViewById(R.id.m_45_2);
        m_50_5 = findViewById(R.id.m_50_5);
        m_45_7 = findViewById(R.id.m_45_7);
        m_30_5 = findViewById(R.id.m_30_5);
        m_25_6 = findViewById(R.id.m_25_6);
        m_30_4 = findViewById(R.id.m_30_4);
        m_25_7 = findViewById(R.id.m_25_7);
        m_55_2 = findViewById(R.id.m_60_3);
        m_50_1 = findViewById(R.id.m_50_1);
        m_50_2 = findViewById(R.id.m_50_2);
        m_50_3 = findViewById(R.id.m_50_3);
        m_40_1 = findViewById(R.id.m_40_1);
        m_35_2 = findViewById(R.id.m_35_2);
        m_40_4 = findViewById(R.id.m_40_4);
        m_60_1 = findViewById(R.id.m_60_1);
        m_75_1 = findViewById(R.id.m_75_1);
        m_70_1 = findViewById(R.id.m_70_1);
        m_70_2 = findViewById(R.id.m_70_2);
        m_55_5 = findViewById(R.id.m_55_5);
        m_45_3 = findViewById(R.id.m_45_3);
        m_60_2 = findViewById(R.id.m_60_2);
        m_50_7 = findViewById(R.id.m_50_7);
        m_45_4 = findViewById(R.id.m_45_4);
        m_40_3 = findViewById(R.id.m_40_3);
        m_45_5 = findViewById(R.id.m_45_5);
        m_55_1 = findViewById(R.id.m_55_1);
        m_45_6 = findViewById(R.id.m_45_6);

        m_25_1.setOnCheckedChangeListener(new MM());
        m_25_3.setOnCheckedChangeListener(new MM());
        m_30_2.setOnCheckedChangeListener(new MM());
        m_25_2.setOnCheckedChangeListener(new MM());
        m_30_1.setOnCheckedChangeListener(new MM());
        m_30_3.setOnCheckedChangeListener(new MM());
        m_25_4.setOnCheckedChangeListener(new MM());
        m_35_1.setOnCheckedChangeListener(new MM());
        m_25_5.setOnCheckedChangeListener(new MM());
        m_45_1.setOnCheckedChangeListener(new MM());
        m_55_4.setOnCheckedChangeListener(new MM());
        m_55_3.setOnCheckedChangeListener(new MM());
        m_50_6.setOnCheckedChangeListener(new MM());
        m_40_2.setOnCheckedChangeListener(new MM());
        m_45_7.setOnCheckedChangeListener(new MM());
        m_50_4.setOnCheckedChangeListener(new MM());
        m_45_2.setOnCheckedChangeListener(new MM());
        m_30_5.setOnCheckedChangeListener(new MM());
        m_25_6.setOnCheckedChangeListener(new MM());
        m_50_5.setOnCheckedChangeListener(new MM());
        m_25_7.setOnCheckedChangeListener(new MM());
        m_55_2.setOnCheckedChangeListener(new MM());
        m_50_3.setOnCheckedChangeListener(new MM());
        m_50_2.setOnCheckedChangeListener(new MM());
        m_30_4.setOnCheckedChangeListener(new MM());
        m_60_1.setOnCheckedChangeListener(new MM());
        m_40_4.setOnCheckedChangeListener(new MM());
        m_35_2.setOnCheckedChangeListener(new MM());
        m_50_1.setOnCheckedChangeListener(new MM());
        m_40_1.setOnCheckedChangeListener(new MM());
        m_70_1.setOnCheckedChangeListener(new MM());
        m_70_2.setOnCheckedChangeListener(new MM());
        m_75_1.setOnCheckedChangeListener(new MM());
        m_45_3.setOnCheckedChangeListener(new MM());
        m_55_5.setOnCheckedChangeListener(new MM());
        m_50_7.setOnCheckedChangeListener(new MM());
        m_45_4.setOnCheckedChangeListener(new MM());
        m_40_3.setOnCheckedChangeListener(new MM());
        m_45_5.setOnCheckedChangeListener(new MM());
        m_55_1.setOnCheckedChangeListener(new MM());
        m_45_6.setOnCheckedChangeListener(new MM());
        m_60_2.setOnCheckedChangeListener(new MM());


        cancel_btn = findViewById(R.id.cancel_btn);

        cancel_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){

                if(m_25_1.isChecked())m_25_1.setChecked(false);
                if(m_25_2.isChecked())m_25_2.setChecked(false);
                if(m_25_3.isChecked())m_25_3.setChecked(false);
                if(m_25_4.isChecked())m_25_4.setChecked(false);
                if(m_25_5.isChecked())m_25_5.setChecked(false);
                if(m_25_6.isChecked())m_25_6.setChecked(false);
                if(m_25_7.isChecked())m_25_7.setChecked(false);

                if(m_30_1.isChecked())m_30_1.setChecked(false);
                if(m_30_2.isChecked())m_30_2.setChecked(false);
                if(m_30_3.isChecked())m_30_3.setChecked(false);
                if(m_30_4.isChecked())m_30_4.setChecked(false);
                if(m_30_5.isChecked())m_30_5.setChecked(false);

                if(m_35_1.isChecked())m_35_1.setChecked(false);
                if(m_35_2.isChecked())m_35_2.setChecked(false);

                if(m_40_1.isChecked())m_40_1.setChecked(false);
                if(m_40_2.isChecked())m_40_2.setChecked(false);
                if(m_40_3.isChecked())m_40_3.setChecked(false);
                if(m_40_4.isChecked())m_40_4.setChecked(false);

                if(m_45_1.isChecked())m_45_1.setChecked(false);
                if(m_45_2.isChecked())m_45_2.setChecked(false);
                if(m_45_3.isChecked())m_45_3.setChecked(false);
                if(m_45_4.isChecked())m_45_4.setChecked(false);
                if(m_45_5.isChecked())m_45_5.setChecked(false);
                if(m_45_7.isChecked())m_45_7.setChecked(false);
                if(m_45_7.isChecked())m_45_7.setChecked(false);

                if(m_50_1.isChecked())m_50_1.setChecked(false);
                if(m_50_2.isChecked())m_50_2.setChecked(false);
                if(m_50_3.isChecked())m_50_3.setChecked(false);
                if(m_50_4.isChecked())m_50_4.setChecked(false);
                if(m_50_5.isChecked())m_50_5.setChecked(false);
                if(m_50_6.isChecked())m_50_6.setChecked(false);
                if(m_50_7.isChecked())m_50_7.setChecked(false);

                if(m_55_1.isChecked())m_55_1.setChecked(false);
                if(m_55_2.isChecked())m_55_2.setChecked(false);
                if(m_55_3.isChecked())m_55_3.setChecked(false);
                if(m_55_4.isChecked())m_55_4.setChecked(false);
                if(m_55_5.isChecked())m_55_5.setChecked(false);

                if(m_60_1.isChecked())m_60_1.setChecked(false);
                if(m_60_2.isChecked())m_60_2.setChecked(false);

                if(m_70_1.isChecked())m_70_1.setChecked(false);
                if(m_70_2.isChecked())m_70_2.setChecked(false);
                if(m_75_1.isChecked())m_75_1.setChecked(false);

            }
        });



    }


    private class MM implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            CheckBox chk;
            String msg="";
            String mo="";
            int[] id={  R.id.m_25_1, R.id.m_25_2, R.id.m_25_3, R.id.m_25_4, R.id.m_25_5, R.id.m_25_6, R.id.m_25_7,
                    R.id.m_30_1, R.id.m_30_2, R.id.m_30_3, R.id.m_30_4, R.id.m_30_5,
                    R.id.m_35_1, R.id.m_35_2,
                    R.id.m_40_1, R.id.m_40_2, R.id.m_40_3, R.id.m_40_4,
                    R.id.m_45_1, R.id.m_45_2, R.id.m_45_3, R.id.m_45_4, R.id.m_45_5, R.id.m_45_6, R.id.m_45_7,
                    R.id.m_50_1, R.id.m_50_2, R.id.m_50_3, R.id.m_50_4, R.id.m_50_5, R.id.m_50_6, R.id.m_50_7,
                    R.id.m_55_1, R.id.m_60_3, R.id.m_55_3, R.id.m_55_4, R.id.m_55_5,
                    R.id.m_60_1, R.id.m_60_2,
                    R.id.m_70_1, R.id.m_70_2,
                    R.id.m_75_1
            };
            if (m_25_1.isChecked())mo += ",25";
            if (m_25_2.isChecked())mo += ",25";
            if (m_25_3.isChecked())mo += ",25";
            if (m_25_4.isChecked())mo += ",25";
            if (m_25_5.isChecked())mo += ",25";
            if (m_25_6.isChecked())mo += ",25";
            if (m_25_7.isChecked())mo += ",25";

            if (m_30_1.isChecked())mo += ",30";
            if (m_30_2.isChecked())mo += ",30";
            if (m_30_3.isChecked())mo += ",30";
            if (m_30_4.isChecked())mo += ",30";
            if (m_30_5.isChecked())mo += ",30";

            if (m_35_1.isChecked())mo += ",35";
            if (m_35_2.isChecked())mo += ",35";

            if (m_40_1.isChecked())mo += ",40";
            if (m_40_2.isChecked())mo += ",40";
            if (m_40_3.isChecked())mo += ",40";
            if (m_40_4.isChecked())mo += ",40";

            if (m_45_1.isChecked())mo += ",45";
            if (m_45_2.isChecked())mo += ",45";
            if (m_45_3.isChecked())mo += ",45";
            if (m_45_4.isChecked())mo += ",45";
            if (m_45_5.isChecked())mo += ",45";
            if (m_45_6.isChecked())mo += ",45";
            if (m_45_7.isChecked())mo += ",45";

            if (m_50_1.isChecked())mo += ",50";
            if (m_50_2.isChecked())mo += ",50";
            if (m_50_3.isChecked())mo += ",50";
            if (m_50_4.isChecked())mo += ",50";
            if (m_50_5.isChecked())mo += ",50";
            if (m_50_6.isChecked())mo += ",50";
            if (m_50_7.isChecked())mo += ",50";

            if (m_55_1.isChecked())mo += ",55";
            if (m_55_2.isChecked())mo += ",55";
            if (m_55_3.isChecked())mo += ",55";
            if (m_55_4.isChecked())mo += ",55";
            if (m_55_5.isChecked())mo += ",55";

            if (m_60_1.isChecked())mo += ",60";
            if (m_60_2.isChecked())mo += ",60";

            if (m_70_1.isChecked())mo += ",70";
            if (m_70_2.isChecked())mo += ",70";
            if (m_75_1.isChecked())mo += ",70";
            ((TextView) findViewById(R.id.every_mo)).setText(mo);

            for(int i:id){
                chk = (CheckBox) findViewById(i);

                String str = msg;
                final int[] count = {0};
                char temp;
                for (int j = 0; j < str.length(); j++) {
                    temp = str.charAt(j);
                    if (temp == ',')
                        count[0]++;
                }

                if(count[0] > 5) {dialog(); break; }

                else if (chk.isChecked()) {
                    msg += "," + chk.getText();
                }
            }
            ((TextView) findViewById(R.id.ALL_TXT)).setText(msg);
        }
    }

    //勾選少於1或者大於五的提示
    private void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("數量最少１杯唷！\n總數量最多５杯唷！"); //提示訊息


        //確定按鈕
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


}


/* PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                //       progressBar.setVisibility(View.VISIBLE);
                                String result = putData.getResult();
                                ((TextView) findViewById(R.id.rrr)).setText(result);
                                if (result.equals("Login Success")) {
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), check.class);
                                    startActivity(intent);
                                    finish();
                                }
                                        else{
                                            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                            if (rrr.getText().toString().equals("OK")) check_OK();  //上傳成功
                                            else if (rrr.getText().toString().equals("NO")) check_NO();       //更新資料失敗，請重新嘗試。
                                        }
                            }
                        }*/