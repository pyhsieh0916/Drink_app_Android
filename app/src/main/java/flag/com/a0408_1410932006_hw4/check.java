package flag.com.a0408_1410932006_hw4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import advanced_httpurlconnection.PutData;

public class check extends AppCompatActivity {
    TextView txt_1, txt_2, ALL_TXT3, txt_3_1,txt_3_11, txt_3_111,  txt_3_2,  txt_3_22,  txt_3_222,
            txt_3_3, txt_3_33, txt_3_333, txt_3_4, txt_3_44, txt_3_444, txt_3_5, txt_3_55, txt_3_555, txt_s, txt_i,txt_count,
            txt_name, txt_num, txt_add, cup_3_1, cup_3_2, cup_3_3, cup_3_4, cup_3_5, all_money, cup_ALLL1;
    EditText edit_re2;
    Button btn_cus, check_OK, login_check_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        Bundle bundle0311 = this.getIntent().getExtras();
        String account = bundle0311.getString("account");
        String password = bundle0311.getString("password");

        setTitle("確認訂單　使用者："+account); //上方抬頭

        //接收已勾選的選項
        String txt = bundle0311.getString("ALL_TXT2");
        ALL_TXT3 = findViewById(R.id.ALL_TXT3);
        ALL_TXT3.setText(txt);

        //姓名
        String txt_na = bundle0311.getString("edit_name");
        txt_name = findViewById(R.id.txt_name);
        txt_name.setText(txt_na);

        //電話
        String txt_nu = bundle0311.getString("edit_num");
        txt_num = findViewById(R.id.txt_num);
        txt_num.setText(txt_nu);

        //地址
        String txt_ad = bundle0311.getString("edit_add");
        txt_add = findViewById(R.id.txt_add);
        txt_add.setText(txt_ad);

        //接收 s的選項
        String txt2 = bundle0311.getString("ALL_s");
        txt_s = findViewById(R.id.txt_s);
        txt_s.setText(txt2);

        //接收i的選項
        String txt3 = bundle0311.getString("ALL_i");
        txt_i = findViewById(R.id.txt_i);
        txt_i.setText(txt3);

        //接收杯數count_all的選項
        String txt4 = bundle0311.getString("ALL_count");
        txt_count = findViewById(R.id.txt_count);
        txt_count.setText("總共 " + txt4 + " 杯");

        //總金額
        String all_mon = bundle0311.getString("k");
        all_money = findViewById(R.id.all_money);
        all_money.setText("總金額 "+all_mon+" 元");

        //備註
        String edit_rem = bundle0311.getString("edit_re");
        edit_re2 = findViewById(R.id.edit_re2);
        edit_re2.setText(edit_rem);

        //cup_ALL 字串記錄各個杯數
        String cup_ALL = bundle0311.getString("cup_ALL");
        cup_ALLL1 = findViewById(R.id.cup_ALLL1);
        cup_ALLL1.setText(cup_ALL);


        // 上一頁
        Button btn_cus = (Button) findViewById(R.id.btn_cus);
        btn_cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(check.this, customized.class);
                Bundle bundle = new Bundle();
                bundle.putString("ALL_TXT", txt);
                bundle.putString("k", all_mon);
                bundle.putString("every_mo", all_mon);
                bundle.putString("account", account);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        //分割選項
        String str = txt;
        String[] all = str.split(",");

        String str2 = txt2;
        String[] all2 = str2.split(",");

        String str3 = txt3;
        String[] all3 = str3.split(",");

        String str4 = cup_ALL;
        String[] all4 = str4.split(",");

        //計算有幾個
        int count = 0;
        char temp;
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if (temp == ',')
                count++;
        }


        //飲料項目
        txt_3_1 = findViewById(R.id.txt_3_1);
        txt_3_2 = findViewById(R.id.txt_3_2);
        txt_3_3 = findViewById(R.id.txt_3_3);
        txt_3_4 = findViewById(R.id.txt_3_4);
        txt_3_5 = findViewById(R.id.txt_3_5);

        txt_3_11 = findViewById(R.id.txt_3_11);
        txt_3_22 = findViewById(R.id.txt_3_22);
        txt_3_33 = findViewById(R.id.txt_3_33);
        txt_3_44 = findViewById(R.id.txt_3_44);
        txt_3_55 = findViewById(R.id.txt_3_55);

        txt_3_111 = findViewById(R.id.txt_3_111);
        txt_3_222 = findViewById(R.id.txt_3_222);
        txt_3_333 = findViewById(R.id.txt_3_333);
        txt_3_444 = findViewById(R.id.txt_3_444);
        txt_3_555 = findViewById(R.id.txt_3_555);

        //茶項輸入
        if (count == 1) {
            txt_3_1.setText(all[1]);    //名稱
            txt_3_11.setText(all2[0]);  //糖量
            txt_3_111.setText(all3[0]); //冰輛


            //接收杯數count_all的選項
            String txt5 = bundle0311.getString("StrTel_count1");
            cup_3_1 = findViewById(R.id.cup_3_1);
            cup_3_1.setText(txt5);

            //記錄各個杯量
            cup_ALLL1.setText(txt5);

        } else if (count == 2) {
            txt_3_1.setText(all[1]);
            txt_3_11.setText(all2[0]);
            txt_3_111.setText(all3[0]);

            txt_3_2.setText(all[2]);
            txt_3_22.setText(all2[1]);
            txt_3_222.setText(all3[1]);

            txt_3_2.setVisibility(View.VISIBLE);


            //接收杯數count_1的選項
            String txt5 = bundle0311.getString("StrTel_count1");
            cup_3_1 = findViewById(R.id.cup_3_1);
            cup_3_1.setText(txt5);

            //接收杯數count_2的選項
            String txt6 = bundle0311.getString("StrTel_count2");
            cup_3_2 = findViewById(R.id.cup_3_2);
            cup_3_2.setText(txt6);


            //記錄各個杯量
            cup_ALLL1.setText(txt5+","+txt6);

        }
        else if (count == 3) {
            txt_3_1.setText(all[1]);
            txt_3_11.setText(all2[0]);
            txt_3_111.setText(all3[0]);

            txt_3_2.setText(all[2]);
            txt_3_22.setText(all2[1]);
            txt_3_222.setText(all3[1]);

            txt_3_3.setText(all[3]);
            txt_3_33.setText(all2[2]);
            txt_3_333.setText(all3[2]);

            txt_3_2.setVisibility(View.VISIBLE);
            txt_3_3.setVisibility(View.VISIBLE);


            //接收杯數count_1的選項
            String txt5 = bundle0311.getString("StrTel_count1");
            cup_3_1 = findViewById(R.id.cup_3_1);
            cup_3_1.setText(txt5);

            //接收杯數count_2的選項
            String txt6 = bundle0311.getString("StrTel_count2");
            cup_3_2 = findViewById(R.id.cup_3_2);
            cup_3_2.setText(txt6);

            //接收杯數count_3的選項
            String txt7 = bundle0311.getString("StrTel_count3");
            cup_3_3 = findViewById(R.id.cup_3_3);
            cup_3_3.setText(txt7);




            //記錄各個杯量
            cup_ALLL1.setText(txt5+","+txt6+","+txt7);

        } else if (count == 4) {
            txt_3_1.setText(all[1]);
            txt_3_11.setText(all2[0]);
            txt_3_111.setText(all3[0]);

            txt_3_2.setText(all[2]);
            txt_3_22.setText(all2[1]);
            txt_3_222.setText(all3[1]);

            txt_3_3.setText(all[3]);
            txt_3_33.setText(all2[2]);
            txt_3_333.setText(all3[2]);

            txt_3_4.setText(all[4]);
            txt_3_44.setText(all2[3]);
            txt_3_444.setText(all3[3]);

            txt_3_2.setVisibility(View.VISIBLE);
            txt_3_3.setVisibility(View.VISIBLE);
            txt_3_4.setVisibility(View.VISIBLE);


            //接收杯數count_1的選項
            String txt5 = bundle0311.getString("StrTel_count1");
            cup_3_1 = findViewById(R.id.cup_3_1);
            cup_3_1.setText(txt5);

            //接收杯數count_2的選項
            String txt6 = bundle0311.getString("StrTel_count2");
            cup_3_2 = findViewById(R.id.cup_3_2);
            cup_3_2.setText(txt6);

            //接收杯數count_3的選項
            String txt7 = bundle0311.getString("StrTel_count3");
            cup_3_3 = findViewById(R.id.cup_3_3);
            cup_3_3.setText(txt7);

            //接收杯數count_4的選項
            String txt8 = bundle0311.getString("StrTel_count4");
            cup_3_4 = findViewById(R.id.cup_3_4);
            cup_3_4.setText(txt8);



            //記錄各個杯量
            cup_ALLL1.setText(txt5+","+txt6+","+txt7+","+txt8);
        } else if (count == 5)
        {
            txt_3_1.setText(all[1]);
            txt_3_11.setText(all2[0]);
            txt_3_111.setText(all3[0]);

            txt_3_2.setText(all[2]);
            txt_3_22.setText(all2[1]);
            txt_3_222.setText(all3[1]);

            txt_3_3.setText(all[3]);
            txt_3_33.setText(all2[2]);
            txt_3_333.setText(all3[2]);

            txt_3_4.setText(all[4]);
            txt_3_44.setText(all2[3]);
            txt_3_444.setText(all3[3]);

            txt_3_5.setText(all[5]);
            txt_3_55.setText(all2[4]);
            txt_3_555.setText(all3[4]);
            txt_3_2.setVisibility(View.VISIBLE);
            txt_3_3.setVisibility(View.VISIBLE);
            txt_3_4.setVisibility(View.VISIBLE);
            txt_3_5.setVisibility(View.VISIBLE);


            //接收杯數count_1的選項
            String txt5 = bundle0311.getString("StrTel_count1");
            cup_3_1 = findViewById(R.id.cup_3_1);
            cup_3_1.setText(txt5);

            //接收杯數count_2的選項
            String txt6 = bundle0311.getString("StrTel_count2");
            cup_3_2 = findViewById(R.id.cup_3_2);
            cup_3_2.setText(txt6);

            //接收杯數count_3的選項
            String txt7 = bundle0311.getString("StrTel_count3");
            cup_3_3 = findViewById(R.id.cup_3_3);
            cup_3_3.setText(txt7);

            //接收杯數count_4的選項
            String txt8 = bundle0311.getString("StrTel_count4");
            cup_3_4 = findViewById(R.id.cup_3_4);
            cup_3_4.setText(txt8);

            //接收杯數count_5的選項
            String txt9 = bundle0311.getString("StrTel_count5");
            cup_3_5 = findViewById(R.id.cup_3_5);
            cup_3_5.setText(txt9);


            //記錄各個杯量
            cup_ALLL1.setText(txt5+","+txt6+","+txt7+","+txt8+","+txt9);
        }


        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //checkOK 送出
        Button check_OK = (Button) findViewById(R.id.check_OK);
        TextView rrr = (TextView) findViewById(R.id.rrr);
        check_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name, num, address, drink_ALL, drink_i, drink_s, cup_2ALL ;
                name        = String.valueOf(txt_name.getText());
                num         = String.valueOf(txt_num.getText());
                address     = String.valueOf(txt_add.getText());
                drink_ALL   = String.valueOf(ALL_TXT3.getText());
                drink_i     = String.valueOf(txt_i.getText());
                drink_s     = String.valueOf(txt_s.getText());
                cup_2ALL    = String.valueOf(cup_ALLL1.getText());

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        String[] field = new String[13];
                        field[0] = "x_code";
                        field[1] = "Account";
                        field[2] = "name";
                        field[3] = "phonenumber";
                        field[4] = "address";
                        field[5] = "demo";
                        field[6] = "cup_ALL";
                        field[7] = "drink_ALL";
                        field[8] = "drink_i";
                        field[9] = "drink_s";
                        field[10] = "total_money";
                        field[11] = "date_time";
                        field[12] = "cup_else";     //各個杯數字串

                        String[] data = new String[13];
                        data[0] = "buy_ALL";
                        data[1] = account;
                        data[2] = name;
                        data[3] = num;
                        data[4] = address;
                        data[5] = edit_rem;
                        data[6] = txt4;
                        data[7] = drink_ALL;
                        data[8] = drink_i;
                        data[9] = drink_s;
                        data[10] = all_mon;
                        data[11] = nowDate;
                        data[12] = cup_2ALL;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                //       progressBar.setVisibility(View.VISIBLE);
                                String result = putData.getResult();
                                ((TextView) findViewById(R.id.rrr)).setText(result);
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                if (rrr.getText().toString().equals("success"))   check_success();     //上傳成功
                                else if (rrr.getText().toString().equals("fail")) check_fail();     //更新資料失敗，請重新嘗試。

                            }
                        }
                    }
                });
            }
        });
    }


    //送出成功訂單
    private void check_success() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //接收訊息
        Bundle bundle0311 = this.getIntent().getExtras();
        String account = bundle0311.getString("account");
        String password = bundle0311.getString("password");

        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("已成功訂購，歡迎您再次光臨！"); //提示訊息
        //回主頁面(設定跳至哪一頁)
        builder.setPositiveButton("回首頁", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent();
                intent.setClass(check.this, options.class);

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();

                //intent.putExtra("name",name);    //可放所有基本類別
                bundle.putString("account", account);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        builder.create().show();
    }


    //送出失敗訂單
    private void check_fail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("訂購失敗，請重新嘗試。"); //提示訊息
        //回主頁面(設定跳至哪一頁)
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}