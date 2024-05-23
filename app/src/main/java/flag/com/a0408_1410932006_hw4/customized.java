package flag.com.a0408_1410932006_hw4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class customized extends AppCompatActivity {
    TextView mon_1, mon_2, mon_3, mon_4, mon_5, ALL_mon2;
    EditText ALL_s, s_1_txt, s_2_txt, s_3_txt, s_4_txt, s_5_txt, ALL_i, i_1_txt, i_2_txt, i_3_txt, i_4_txt, i_5_txt,
            count_ALL, c_1, c_2, c_3, c_4, c_5, count_1, edit_name, edit_num, edit_re;
    Button btn_1, btn_2, btn_3, btn_4, btn_5, check_btn,
            cup_btn_1, cup_btn_2, cup_btn_3, cup_btn_4, cup_btn_5, edit_add, minus_1, plus_1;
    RadioButton btn_out, btn_self;
    RadioGroup s_1, s_2, s_3, s_4, s_5, i_1, i_2, i_3, i_4, i_5;
    LinearLayout out_adr, s_i_1, s_i_2, s_i_3, s_i_4, s_i_5, cup_1, cup_2, cup_3, cup_4, cup_5,
            cup_layout_1, cup_layout_2, cup_layout_3, cup_layout_4, cup_layout_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //接收訊息
        Bundle bundle0311 = this.getIntent().getExtras();
        String account = bundle0311.getString("account");
        String password = bundle0311.getString("password");
        setTitle("客製化調整 使用者："+account); //上方抬頭
        setContentView(R.layout.customized);

        Button btn_to_A = (Button) findViewById(R.id.back_btn); //上一頁
        btn_to_A.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customized.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //接收訊息
        String txt = bundle0311.getString("ALL_TXT");
        String k = bundle0311.getString("k");
        String every_money = bundle0311.getString("every_mo");

        TextView ALL_TXT2 = (TextView) findViewById(R.id.ALL_TXT2);
        TextView ALL_mon = (TextView) findViewById(R.id.ALL_mon);
        TextView ALL_mon2 = (TextView) findViewById(R.id.ALL_mon2);
        TextView every_mon = (TextView) findViewById(R.id.every_mon);

        ALL_TXT2.setText(txt);
        ALL_mon.setText("總金額 "+k+" 元");
        every_mon.setText(every_money);

        //分割選項
        String str = txt;
        String[] all = str.split(",");
        String str2 = every_money;
        String[] everyone_mon = str2.split(",");

        //計算有幾個
        final int[] count = {0};
        char temp;
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if (temp == ',')
                count[0]++;
        }


        //傳送訊息
        Button check_btn = (Button) findViewById(R.id.check_btn); //下一頁
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_num = (EditText) findViewById(R.id.edit_num);
        check_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             //設定傳到下個頁面
             public void onClick(View view) {
                 //　name 輸入為空白或無輸入*****
                 if("".equals(edit_name.getText().toString().trim())){
                     name();
                 }
                 // 電話 輸入為空白或無輸入*****
                 else if("".equals(edit_num.getText().toString().trim())){
                     num();
                 }


                 else {
                 //飲料
                 EditText EditTextTel = (EditText) findViewById(R.id.ALL_TXT2);
                 Editable StrTel;
                 StrTel = EditTextTel.getText();
                 String ALL_TXT2 = StrTel.toString();

                 //名字
                 EditText EditTextTel_name = (EditText) findViewById(R.id.edit_name);
                 Editable StrTel_name;
                 StrTel_name = EditTextTel_name.getText();
                 String edit_name = StrTel_name.toString();

                 //電話
                 EditText EditTextTel_num = (EditText) findViewById(R.id.edit_num);
                 Editable StrTel_num;
                 StrTel_num = EditTextTel_num.getText();
                 String edit_num = StrTel_num.toString();

                 //地址
                 EditText EditTextTel_add = (EditText) findViewById(R.id.edit_add);
                 Editable StrTel_add;
                 StrTel_add = EditTextTel_add.getText();
                 String edit_add = StrTel_add.toString();


                 //糖
                 EditText EditTextTel_s = (EditText) findViewById(R.id.ALL_s);
                 Editable StrTel_s;
                 StrTel_s = EditTextTel_s.getText();
                 String ALL_s = StrTel_s.toString();

                 //冰
                 EditText EditTextTel_i = (EditText) findViewById(R.id.ALL_i);
                 Editable StrTel_i;
                 StrTel_i = EditTextTel_i.getText();
                 String ALL_i = StrTel_i.toString();

                //總杯數
                 EditText count_ALL = (EditText) findViewById(R.id.count_ALL);
                 Editable StrTel_count;
                 StrTel_count = count_ALL.getText();
                 String ALL_count = StrTel_count.toString();

                 //1杯數
                 TextView count_1 = (TextView) findViewById(R.id.count_1);
                 String StrTel_count1;
                 StrTel_count1 = (String) count_1.getText();

                 //2杯數
                 TextView count_2 = (TextView) findViewById(R.id.count_2);
                 String StrTel_count2;
                 StrTel_count2 = (String) count_2.getText();

                 //3杯數
                 TextView count_3 = (TextView) findViewById(R.id.count_3);
                 String StrTel_count3;
                 StrTel_count3 = (String) count_3.getText();

                 //4杯數
                 TextView count_4 = (TextView) findViewById(R.id.count_4);
                 String StrTel_count4;
                 StrTel_count4 = (String) count_4.getText();

                 //5杯數
                 TextView count_5 = (TextView) findViewById(R.id.count_5);
                 String StrTel_count5;
                 StrTel_count5 = (String) count_5.getText();

                 //總金額
                 TextView ALL_mon = (TextView) findViewById(R.id.ALL_mon);
                 String str_money_ALL;
                 str_money_ALL = (String) ALL_mon.getText();

                 //備註
                 EditText edit_re = (EditText) findViewById(R.id.edit_re);
                 Editable str_edit_re;
                 str_edit_re =  edit_re.getText();


                 Intent intent = new Intent();
                 intent.setClass(customized.this, check.class);

                 //new一個Bundle物件，並將要傳遞的資料傳入
                 Bundle bundle = new Bundle();

                 //intent.putExtra("name",name);    //可放所有基本類別
                 bundle.putString("account", account);
                 bundle.putString("password", password);
                 bundle.putString("ALL_TXT2", ALL_TXT2);
                 bundle.putString("edit_name", edit_name);
                 bundle.putString("edit_num", edit_num);
                 bundle.putString("edit_add", edit_add);
                 bundle.putString("ALL_s", ALL_s);
                 bundle.putString("ALL_i", ALL_i);
                 bundle.putString("ALL_count", ALL_count);
                 bundle.putString("StrTel_count1", StrTel_count1);
                 bundle.putString("StrTel_count2", StrTel_count2);
                 bundle.putString("StrTel_count3", StrTel_count3);
                 bundle.putString("StrTel_count4", StrTel_count4);
                 bundle.putString("StrTel_count5", StrTel_count5);
                 bundle.putString("cup_ALL", StrTel_count1+","+StrTel_count2+","+StrTel_count3+","+StrTel_count4+","+StrTel_count5);
                 bundle.putString("k", k );
                 bundle.putString("edit_re", String.valueOf(str_edit_re));
                 intent.putExtras(bundle);
                 startActivity(intent);
             }
                   }
         }
        );

        //判斷自取、外送
        btn_out = findViewById(R.id.btn_out);
        btn_self = findViewById(R.id.btn_self);
        out_adr = findViewById(R.id.out_adr);

        //當按下外送選擇時跳出編輯框，按自取時隱藏
        btn_out.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                   out_adr.setVisibility(View.VISIBLE);
               }
           }
        );
        btn_self.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    out_adr.setVisibility(View.GONE);
                }
            }
        );

        //糖量、冰量、加料
        s_i_1 = findViewById(R.id.s_i_1);
        s_i_2 = findViewById(R.id.s_i_2);
        s_i_3 = findViewById(R.id.s_i_3);
        s_i_4 = findViewById(R.id.s_i_4);
        s_i_5 = findViewById(R.id.s_i_5);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        cup_1 = findViewById(R.id.cup_1);
        cup_2 = findViewById(R.id.cup_2);
        cup_3 = findViewById(R.id.cup_3);
        cup_4 = findViewById(R.id.cup_4);
        cup_5 = findViewById(R.id.cup_5);
        cup_layout_1 = findViewById(R.id.cup_layout_1);
        cup_layout_2 = findViewById(R.id.cup_layout_2);
        cup_layout_3 = findViewById(R.id.cup_layout_3);
        cup_layout_4 = findViewById(R.id.cup_layout_4);
        cup_layout_5 = findViewById(R.id.cup_layout_5);
        mon_1 = findViewById(R.id.mon_1);
        mon_2 = findViewById(R.id.mon_2);
        mon_3 = findViewById(R.id.mon_3);
        mon_4 = findViewById(R.id.mon_4);
        mon_5 = findViewById(R.id.mon_5);

        //第一個飲料
        btn_1.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         //茶類顏色
                                         btn_1.setBackgroundColor(0xFF009889);
                                         btn_2.setBackgroundColor(0x78009688);
                                         btn_3.setBackgroundColor(0x78009688);
                                         btn_4.setBackgroundColor(0x78009688);
                                         btn_5.setBackgroundColor(0x78009688);

                                         //錢錢顏色
                                         mon_1.setBackgroundColor(0x78009688);
                                         mon_2.setBackgroundColor(0xFF009889);
                                         mon_3.setBackgroundColor(0xFF009889);
                                         mon_4.setBackgroundColor(0xFF009889);
                                         mon_5.setBackgroundColor(0xFF009889);

                                         //糖量+冰輛
                                         s_i_1.setVisibility(View.VISIBLE);
                                         s_i_2.setVisibility(View.GONE);
                                         s_i_3.setVisibility(View.GONE);
                                         s_i_4.setVisibility(View.GONE);
                                         s_i_5.setVisibility(View.GONE);

                                         //杯數
                                         cup_layout_1.setVisibility(View.VISIBLE);
                                         cup_layout_2.setVisibility(View.GONE);
                                         cup_layout_3.setVisibility(View.GONE);
                                         cup_layout_4.setVisibility(View.GONE);
                                         cup_layout_5.setVisibility(View.GONE);
                                         cup_1.setVisibility(View.GONE);
                                         cup_2.setVisibility(View.GONE);
                                         cup_3.setVisibility(View.GONE);
                                         cup_4.setVisibility(View.GONE);
                                         cup_5.setVisibility(View.GONE);
                                     }
                                 }
        );

        //第二個飲料
        btn_2.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         btn_1.setBackgroundColor(0x78009688);
                                         btn_2.setBackgroundColor(0xFF009889);
                                         btn_3.setBackgroundColor(0x78009688);
                                         btn_4.setBackgroundColor(0x78009688);
                                         btn_5.setBackgroundColor(0x78009688);

                                         mon_1.setBackgroundColor(0xFF009889);
                                         mon_2.setBackgroundColor(0x78009688);
                                         mon_3.setBackgroundColor(0xFF009889);
                                         mon_4.setBackgroundColor(0xFF009889);
                                         mon_5.setBackgroundColor(0xFF009889);

                                         s_i_1.setVisibility(View.GONE);
                                         s_i_2.setVisibility(View.VISIBLE);
                                         s_i_3.setVisibility(View.GONE);
                                         s_i_4.setVisibility(View.GONE);
                                         s_i_5.setVisibility(View.GONE);

                                         cup_layout_1.setVisibility(View.GONE);
                                         cup_layout_2.setVisibility(View.VISIBLE);
                                         cup_layout_3.setVisibility(View.GONE);
                                         cup_layout_4.setVisibility(View.GONE);
                                         cup_layout_5.setVisibility(View.GONE);
                                         cup_1.setVisibility(View.GONE);
                                         cup_2.setVisibility(View.GONE);
                                         cup_3.setVisibility(View.GONE);
                                         cup_4.setVisibility(View.GONE);
                                         cup_5.setVisibility(View.GONE);
                                     }
                                 }
        );

        //第三個飲料
        btn_3.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         btn_1.setBackgroundColor(0x78009688);
                                         btn_2.setBackgroundColor(0x78009688);
                                         btn_3.setBackgroundColor(0xFF009889);
                                         btn_4.setBackgroundColor(0x78009688);
                                         btn_5.setBackgroundColor(0x78009688);

                                         mon_1.setBackgroundColor(0xFF009889);
                                         mon_2.setBackgroundColor(0xFF009889);
                                         mon_3.setBackgroundColor(0x78009688);
                                         mon_4.setBackgroundColor(0xFF009889);
                                         mon_5.setBackgroundColor(0xFF009889);

                                         s_i_1.setVisibility(View.GONE);
                                         s_i_2.setVisibility(View.GONE);
                                         s_i_3.setVisibility(View.VISIBLE);
                                         s_i_4.setVisibility(View.GONE);
                                         s_i_5.setVisibility(View.GONE);

                                         cup_layout_1.setVisibility(View.GONE);
                                         cup_layout_2.setVisibility(View.GONE);
                                         cup_layout_3.setVisibility(View.VISIBLE);
                                         cup_layout_4.setVisibility(View.GONE);
                                         cup_layout_5.setVisibility(View.GONE);
                                         cup_1.setVisibility(View.GONE);
                                         cup_2.setVisibility(View.GONE);
                                         cup_3.setVisibility(View.GONE);
                                         cup_4.setVisibility(View.GONE);
                                         cup_5.setVisibility(View.GONE);
                                     }
                                 }
        );

        //第四個飲料
        btn_4.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         btn_1.setBackgroundColor(0x78009688);
                                         btn_2.setBackgroundColor(0x78009688);
                                         btn_3.setBackgroundColor(0x78009688);
                                         btn_4.setBackgroundColor(0xFF009889);
                                         btn_5.setBackgroundColor(0x78009688);

                                         mon_1.setBackgroundColor(0xFF009889);
                                         mon_2.setBackgroundColor(0xFF009889);
                                         mon_3.setBackgroundColor(0xFF009889);
                                         mon_4.setBackgroundColor(0x78009688);
                                         mon_5.setBackgroundColor(0xFF009889);

                                         s_i_1.setVisibility(View.GONE);
                                         s_i_2.setVisibility(View.GONE);
                                         s_i_3.setVisibility(View.GONE);
                                         s_i_4.setVisibility(View.VISIBLE);
                                         s_i_5.setVisibility(View.GONE);

                                         cup_layout_1.setVisibility(View.GONE);
                                         cup_layout_2.setVisibility(View.GONE);
                                         cup_layout_3.setVisibility(View.GONE);
                                         cup_layout_4.setVisibility(View.VISIBLE);
                                         cup_layout_5.setVisibility(View.GONE);
                                         cup_1.setVisibility(View.GONE);
                                         cup_2.setVisibility(View.GONE);
                                         cup_3.setVisibility(View.GONE);
                                         cup_4.setVisibility(View.GONE);
                                         cup_5.setVisibility(View.GONE);
                                     }
                                 }
        );

        //第五個飲料
        btn_5.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View v) {
                                         btn_1.setBackgroundColor(0x78009688);
                                         btn_2.setBackgroundColor(0x78009688);
                                         btn_3.setBackgroundColor(0x78009688);
                                         btn_4.setBackgroundColor(0x78009688);
                                         btn_5.setBackgroundColor(0xFF009889);

                                         mon_1.setBackgroundColor(0xFF009889);
                                         mon_2.setBackgroundColor(0xFF009889);
                                         mon_3.setBackgroundColor(0xFF009889);
                                         mon_4.setBackgroundColor(0xFF009889);
                                         mon_5.setBackgroundColor(0x78009688);

                                         s_i_1.setVisibility(View.GONE);
                                         s_i_2.setVisibility(View.GONE);
                                         s_i_3.setVisibility(View.GONE);
                                         s_i_4.setVisibility(View.GONE);
                                         s_i_5.setVisibility(View.VISIBLE);

                                         cup_layout_1.setVisibility(View.GONE);
                                         cup_layout_2.setVisibility(View.GONE);
                                         cup_layout_3.setVisibility(View.GONE);
                                         cup_layout_4.setVisibility(View.GONE);
                                         cup_layout_5.setVisibility(View.VISIBLE);
                                         cup_1.setVisibility(View.GONE);
                                         cup_2.setVisibility(View.GONE);
                                         cup_3.setVisibility(View.GONE);
                                         cup_4.setVisibility(View.GONE);
                                         cup_5.setVisibility(View.GONE);
                                     }
                                 }
        );

        //設定按鈕
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);

        mon_1 = findViewById(R.id.mon_1);
        mon_2 = findViewById(R.id.mon_2);
        mon_3 = findViewById(R.id.mon_3);
        mon_4 = findViewById(R.id.mon_4);
        mon_5 = findViewById(R.id.mon_5);

        //茶項輸入mon_1
        if (count[0] == 1) {
            btn_1.setText(all[1]);

            mon_1.setText(everyone_mon[1]);
        } else if (count[0] == 2) {
            btn_1.setText(all[1]);
            btn_2.setText(all[2]);
            btn_2.setVisibility(View.VISIBLE);
            mon_2.setVisibility(View.VISIBLE);

            mon_1.setText(everyone_mon[1]);
            mon_2.setText(everyone_mon[2]);
        } else if (count[0] == 3) {
            btn_1.setText(all[1]);
            btn_2.setText(all[2]);
            btn_3.setText(all[3]);
            btn_2.setVisibility(View.VISIBLE);
            btn_3.setVisibility(View.VISIBLE);
            mon_2.setVisibility(View.VISIBLE);
            mon_3.setVisibility(View.VISIBLE);

            mon_1.setText(everyone_mon[1]);
            mon_2.setText(everyone_mon[2]);
            mon_3.setText(everyone_mon[3]);
        } else if (count[0] == 4) {
            btn_1.setText(all[1]);
            btn_2.setText(all[2]);
            btn_3.setText(all[3]);
            btn_4.setText(all[4]);
            btn_2.setVisibility(View.VISIBLE);
            btn_3.setVisibility(View.VISIBLE);
            btn_4.setVisibility(View.VISIBLE);
            mon_2.setVisibility(View.VISIBLE);
            mon_3.setVisibility(View.VISIBLE);
            mon_4.setVisibility(View.VISIBLE);

            mon_1.setText(everyone_mon[1]);
            mon_2.setText(everyone_mon[2]);
            mon_3.setText(everyone_mon[3]);
            mon_4.setText(everyone_mon[4]);
        } else if (count[0] == 5) {
            btn_1.setText(all[1]);
            btn_2.setText(all[2]);
            btn_3.setText(all[3]);
            btn_4.setText(all[4]);
            btn_5.setText(all[5]);
            btn_2.setVisibility(View.VISIBLE);
            btn_3.setVisibility(View.VISIBLE);
            btn_4.setVisibility(View.VISIBLE);
            btn_5.setVisibility(View.VISIBLE);
            mon_2.setVisibility(View.VISIBLE);
            mon_3.setVisibility(View.VISIBLE);
            mon_4.setVisibility(View.VISIBLE);
            mon_5.setVisibility(View.VISIBLE);

            mon_1.setText(everyone_mon[1]);
            mon_2.setText(everyone_mon[2]);
            mon_3.setText(everyone_mon[3]);
            mon_4.setText(everyone_mon[4]);
            mon_5.setText(everyone_mon[5]);
        }

        Button plus_1 = (Button) findViewById(R.id.plus_1);
        Button plus_2 = (Button) findViewById(R.id.plus_2);
        Button plus_3 = (Button) findViewById(R.id.plus_3);
        Button plus_4 = (Button) findViewById(R.id.plus_4);
        Button plus_5 = (Button) findViewById(R.id.plus_5);
        Button minus_1 = (Button) findViewById(R.id.minus_1);
        Button minus_2 = (Button) findViewById(R.id.minus_2);
        Button minus_3 = (Button) findViewById(R.id.minus_3);
        Button minus_4 = (Button) findViewById(R.id.minus_4);
        Button minus_5 = (Button) findViewById(R.id.minus_5);
        TextView count_1 = (TextView) findViewById(R.id.count_1);
        TextView count_2 = (TextView) findViewById(R.id.count_2);
        TextView count_3 = (TextView) findViewById(R.id.count_3);
        TextView count_4 = (TextView) findViewById(R.id.count_4);
        TextView count_5 = (TextView) findViewById(R.id.count_5);
        EditText count_ALL = (EditText) findViewById(R.id.count_ALL);

        //設定陣列紀錄數量
        final int[] count_a = {1};
        final int[] count_b = {1};
        final int[] count_c = {1};
        final int[] count_d = {1};
        final int[] count_e = {1};

        //按加的時候
        plus_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int save_all_mon = Integer.parseInt(k);
                int save_2;

                //如果高於5，則跳出視窗提醒
                if (Integer.parseInt(count_ALL.getText().toString()) > 4){
                    dialog();
                }

                //數量加
                else  {
                    int x = Integer.parseInt(everyone_mon[1]);
                    int y = Integer.parseInt(mon_1.getText().toString());
                    if (count[0] == 1) {
                        count_1.setText(String.valueOf(++count_a[0]));  //杯數增加
                        count_ALL.setText(String.valueOf(count_a[0]));  //總杯數增加

                        y=y+x;  //金額增加
                        mon_1.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");


                    } else if (count[0] == 2) {
                        count_1.setText(String.valueOf(++count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0]));

                        y=y+x;  //金額增加
                        mon_1.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 3) {
                        count_1.setText(String.valueOf(++count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0]));

                        y=y+x;  //金額增加
                        mon_1.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 4) {
                        count_1.setText(String.valueOf(++count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y+x;  //金額增加
                        mon_1.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 5) {
                        count_1.setText(String.valueOf(++count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));

                    }
                }
            }
        });

        //按減的時候
        minus_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int save_all_mon = Integer.parseInt(k);
                int save_2;

                //如果低於1，則跳出視窗提醒最少杯數
                if (Integer.parseInt(count_1.getText().toString()) < 2){
                    dialog();
                }

                //數量減
                else {
                    int x = Integer.parseInt(everyone_mon[1]);
                    int y = Integer.parseInt(mon_1.getText().toString());
                    if (count[0] == 1) {
                        count_1.setText(String.valueOf(--count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0]));

                        y=y-x;  //金額減少
                        mon_1.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));


                    } else if (count[0] == 2) {
                        count_1.setText(String.valueOf(--count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0]));

                        y=y-x;  //金額減少
                        mon_1.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));


                    } else if (count[0] == 3) {
                        count_1.setText(String.valueOf(--count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0]));

                        y=y-x;  //金額減少
                        mon_1.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 4) {
                        count_1.setText(String.valueOf(--count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y-x;  //金額減少
                        mon_1.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 5) {
                        count_1.setText(String.valueOf(--count_a[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));
                    }
                }
            }
        });

        plus_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int save_all_mon = Integer.parseInt(k);
                int save_2;

                if (Integer.parseInt(count_ALL.getText().toString()) > 4){
                    dialog();
                }

                else {
                    int x = Integer.parseInt(everyone_mon[2]);
                    int y = Integer.parseInt(mon_2.getText().toString());
                    if (count[0] == 2) {
                        count_2.setText(String.valueOf(++count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0]));

                        y=y+x;  //金額增加
                        mon_2.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 3) {
                        count_2.setText(String.valueOf(++count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0]));

                        y=y+x;  //金額增加
                        mon_2.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 4) {
                        count_2.setText(String.valueOf(++count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y+x;  //金額增加
                        mon_2.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 5) {
                        count_2.setText(String.valueOf(++count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));
                    }
                }
            }
        });
        minus_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int save_2;

                if (Integer.parseInt(count_2.getText().toString()) < 2){
                    dialog();
                }

                else {
                    int x = Integer.parseInt(everyone_mon[2]);
                    int y = Integer.parseInt(mon_2.getText().toString());
                    if (count[0] == 2) {
                        count_2.setText(String.valueOf(--count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0]));

                        y=y-x;  //金額減少
                        mon_2.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 3) {
                        count_2.setText(String.valueOf(--count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0]));

                        y=y-x;  //金額減少
                        mon_2.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 4) {
                        count_2.setText(String.valueOf(--count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y-x;  //金額減少
                        mon_2.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 5) {
                        count_2.setText(String.valueOf(--count_b[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));
                    }
                }
            }
        });

        plus_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int save_all_mon = Integer.parseInt(k);
                int save_2;
                if (Integer.parseInt(count_ALL.getText().toString()) > 4){
                    dialog();
                }

                else {

                    int x = Integer.parseInt(everyone_mon[3]);
                    int y = Integer.parseInt(mon_3.getText().toString());

                    if (count[0] == 3) {
                        count_3.setText(String.valueOf(++count_c[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0]));

                        y=y+x;  //金額增加
                        mon_3.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 4) {
                        count_3.setText(String.valueOf(++count_c[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y+x;  //金額增加
                        mon_3.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 5) {
                        count_3.setText(String.valueOf(++count_c[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));
                    }
                }
            }
        });
        minus_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int save_2;

                if (Integer.parseInt(count_3.getText().toString()) < 2){
                    dialog();
                }

                else {
                    int x = Integer.parseInt(everyone_mon[3]);
                    int y = Integer.parseInt(mon_3.getText().toString());
                    if (count[0] == 3) {
                        count_3.setText(String.valueOf(--count_c[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0]));

                        y=y-x;  //金額減少
                        mon_3.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 4) {
                        count_3.setText(String.valueOf(--count_c[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y-x;  //金額減少
                        mon_3.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 5) {
                        count_3.setText(String.valueOf(--count_c[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));
                    }
                }
            }
        });

        plus_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int save_all_mon = Integer.parseInt(k);
                int save_2;

                if (Integer.parseInt(count_ALL.getText().toString()) > 4){
                    dialog();
                }

                else {

                    int x = Integer.parseInt(everyone_mon[4]);
                    int y = Integer.parseInt(mon_4.getText().toString());

                    if (count[0] == 4) {
                        count_4.setText(String.valueOf(++count_d[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y+x;  //金額增加
                        mon_4.setText(String.valueOf(y));

                        save_2 = save_all_mon-x+y;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(""+save_2+"");

                    } else if (count[0] == 5) {
                        count_4.setText(String.valueOf(++count_d[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));
                    }
                }
            }
        });
        minus_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int save_2;
                if (Integer.parseInt(count_4.getText().toString()) < 2){
                    dialog();
                }

                else {
                    int x = Integer.parseInt(everyone_mon[4]);
                    int y = Integer.parseInt(mon_4.getText().toString());
                    if (count[0] == 4) {
                        count_4.setText(String.valueOf(--count_d[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));

                        y=y-x;  //金額減少
                        mon_4.setText(String.valueOf(y));

                        save_2 = Integer.parseInt(ALL_mon2.getText().toString())-x;
                        ALL_mon.setText("總金額 "+save_2+" 元");
                        ALL_mon2.setText(String.valueOf(save_2));
                    } else if (count[0] == 5) {
                        count_4.setText(String.valueOf(--count_d[0]));
                        count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));

                        y=y-x;  //金額減少
                        mon_4.setText(String.valueOf(y));
                    }
                }
            }
        });

        plus_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(count_ALL.getText().toString()) > 4){
                    dialog();
                }

                else {
                    count_5.setText(String.valueOf(++count_e[0]));
                    c_5.setText(String.valueOf(count_e[0]));
                    count_ALL.setText(String.valueOf((int) count_a[0] + (int) count_b[0] + (int) count_c[0] + (int) count_d[0] + (int) count_e[0]));
                }
            }
        });
        minus_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(count_5.getText().toString()) < 2) {
                    dialog();
                } else {
                    count_5.setText(String.valueOf(--count_e[0]));
                    c_5.setText(String.valueOf(count_e[0]));
                    count_ALL.setText(String.valueOf((int) count_a[0] + (int) count_b[0] + (int) count_c[0] + (int) count_d[0] + (int) count_e[0]));
                }
            }
        });

        //糖量紀錄
        s_1 = findViewById(R.id.s_1);
        s_2 = findViewById(R.id.s_2);
        s_3 = findViewById(R.id.s_3);
        s_4 = findViewById(R.id.s_4);
        s_5 = findViewById(R.id.s_5);
        s_1_txt = findViewById(R.id.s_1_txt);
        s_2_txt = findViewById(R.id.s_2_txt);
        s_3_txt = findViewById(R.id.s_3_txt);
        s_4_txt = findViewById(R.id.s_4_txt);
        s_5_txt = findViewById(R.id.s_5_txt);
        EditText ALL_s = (EditText) findViewById(R.id.ALL_s);




        s_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();

                if (count[0] == 1) {
                    count_ALL.setText(String.valueOf(count_a[0]));
                } else if (count[0] == 2) {
                    count_ALL.setText(String.valueOf(count_a[0] + count_b[0]));
                } else if (count[0] == 3) {
                    count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0]));
                } else if (count[0] == 4) {
                    count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0]));
                } else if (count[0] == 5) {
                    count_ALL.setText(String.valueOf(count_a[0] + count_b[0] + count_c[0] + count_d[0] + count_e[0]));
                }
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(s_1.getCheckedRadioButtonId());
                s_1_txt.setText(s.getText());
                ALL_s.setText(s_1_txt.getText().toString().trim() + "," + s_2_txt.getText().toString().trim() + "," + s_3_txt.getText().toString().trim() + "," + s_4_txt.getText().toString().trim() + "," + s_5_txt.getText().toString().trim());
            }
        });


        s_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(s_2.getCheckedRadioButtonId());
                s_2_txt.setText(s.getText());
                ALL_s.setText(s_1_txt.getText().toString().trim() + "," + s_2_txt.getText().toString().trim() + "," + s_3_txt.getText().toString().trim() + "," + s_4_txt.getText().toString().trim() + "," + s_5_txt.getText().toString().trim());
            }
        });


        s_3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(s_3.getCheckedRadioButtonId());
                s_3_txt.setText(s.getText());
                ALL_s.setText(s_1_txt.getText().toString().trim() + "," + s_2_txt.getText().toString().trim() + "," + s_3_txt.getText().toString().trim() + "," + s_4_txt.getText().toString().trim() + "," + s_5_txt.getText().toString().trim());
            }
        });

        s_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(s_4.getCheckedRadioButtonId());
                s_4_txt.setText(s.getText());
                ALL_s.setText(s_1_txt.getText().toString().trim() + "," + s_2_txt.getText().toString().trim() + "," + s_3_txt.getText().toString().trim() + "," + s_4_txt.getText().toString().trim() + "," + s_5_txt.getText().toString().trim());
            }
        });

        s_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(s_5.getCheckedRadioButtonId());
                s_5_txt.setText(s.getText());
                ALL_s.setText(s_1_txt.getText().toString().trim() + "," + s_2_txt.getText().toString().trim() + "," + s_3_txt.getText().toString().trim() + "," + s_4_txt.getText().toString().trim() + "," + s_5_txt.getText().toString().trim());
            }
        });


        //冰量紀錄
        i_1 = findViewById(R.id.i_1);
        i_2 = findViewById(R.id.i_2);
        i_3 = findViewById(R.id.i_3);
        i_4 = findViewById(R.id.i_4);
        i_5 = findViewById(R.id.i_5);
        i_1_txt = findViewById(R.id.i_1_txt);
        i_2_txt = findViewById(R.id.i_2_txt);
        i_3_txt = findViewById(R.id.i_3_txt);
        i_4_txt = findViewById(R.id.i_4_txt);
        i_5_txt = findViewById(R.id.i_5_txt);

        EditText ALL_i = (EditText) findViewById(R.id.ALL_i);
        i_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(i_1.getCheckedRadioButtonId());
                i_1_txt.setText(s.getText());
                ALL_i.setText(i_1_txt.getText().toString().trim() + "," + i_2_txt.getText().toString().trim() + "," + i_3_txt.getText().toString().trim() + "," + i_4_txt.getText().toString().trim() + "," + i_5_txt.getText().toString().trim());
            }
        });


        i_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(i_2.getCheckedRadioButtonId());
                i_2_txt.setText(s.getText());
                ALL_i.setText(i_1_txt.getText().toString().trim() + "," + i_2_txt.getText().toString().trim() + "," + i_3_txt.getText().toString().trim() + "," + i_4_txt.getText().toString().trim() + "," + i_5_txt.getText().toString().trim());
            }
        });


        i_3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(i_3.getCheckedRadioButtonId());
                i_3_txt.setText(s.getText());
                ALL_i.setText(i_1_txt.getText().toString().trim() + "," + i_2_txt.getText().toString().trim() + "," + i_3_txt.getText().toString().trim() + "," + i_4_txt.getText().toString().trim() + "," + i_5_txt.getText().toString().trim());
            }
        });

        i_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(i_4.getCheckedRadioButtonId());
                i_4_txt.setText(s.getText());
                ALL_i.setText(i_1_txt.getText().toString().trim() + "," + i_2_txt.getText().toString().trim() + "," + i_3_txt.getText().toString().trim() + "," + i_4_txt.getText().toString().trim() + "," + i_5_txt.getText().toString().trim());
            }
        });

        i_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectRadioButton();
            }

            private void selectRadioButton() {
                RadioButton s = (RadioButton) customized.this.findViewById(i_5.getCheckedRadioButtonId());
                i_5_txt.setText(s.getText());
                ALL_i.setText(i_1_txt.getText().toString().trim() + "," + i_2_txt.getText().toString().trim() + "," + i_3_txt.getText().toString().trim() + "," + i_4_txt.getText().toString().trim() + "," + i_5_txt.getText().toString().trim());
            }
        });

        cup_btn_1 = findViewById(R.id.cup_btn_1);
        cup_btn_2 = findViewById(R.id.cup_btn_2);
        cup_btn_3 = findViewById(R.id.cup_btn_3);
        cup_btn_4 = findViewById(R.id.cup_btn_4);
        cup_btn_5 = findViewById(R.id.cup_btn_5);

        //杯數
        cup_btn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cup_1.getVisibility() == View.GONE) {
                    cup_1.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (cup_1.getVisibility() == View.VISIBLE) {
                    cup_1.setVisibility(View.GONE);
                }
                if (count[0] == 1) {
                    count_ALL.setText(String.valueOf(count_a[0]));
                } else if (count[0] == 2) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]));
                } else if (count[0] == 3) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]));
                } else if (count[0] == 4) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]));
                } else if (count[0] == 5) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]+count_e[0]));
                }
            }
        });

        cup_btn_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cup_2.getVisibility() == View.GONE) {
                    cup_2.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (cup_2.getVisibility() == View.VISIBLE) {
                    cup_2.setVisibility(View.GONE);
                }
                if (count[0] == 2) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]));
                } else if (count[0] == 3) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]));
                } else if (count[0] == 4) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]));
                } else if (count[0] == 5) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]+count_e[0]));
                }
            }
        });

        cup_btn_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cup_3.getVisibility() == View.GONE) {             //
                    cup_3.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (cup_3.getVisibility() == View.VISIBLE) {
                    cup_3.setVisibility(View.GONE);
                }
                if (count[0] == 3) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]));
                } else if (count[0] == 4) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]));
                } else if (count[0] == 5) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]+count_e[0]));
                }
            }
        });

        cup_btn_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cup_4.getVisibility() == View.GONE) {             //
                    cup_4.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (cup_4.getVisibility() == View.VISIBLE) {
                    cup_4.setVisibility(View.GONE);
                }
                if (count[0] == 4) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]));
                } else if (count[0] == 5) {
                    count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]+count_e[0]));
                }
            }
        });

        cup_btn_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cup_5.getVisibility() == View.GONE) {             //
                    cup_5.setVisibility(View.VISIBLE);
                }   // 處於可見狀態
                else if (cup_5.getVisibility() == View.VISIBLE) {
                    cup_5.setVisibility(View.GONE);
                }
                count_ALL.setText(String.valueOf(count_a[0]+count_b[0]+count_c[0]+count_d[0]+count_e[0]));
            }
        });
        }

    private void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("數量最少１杯唷！\n總數量最多５杯唷！"); //提示訊息
        //確定 取消 一般 這三種按鈕就看你怎麼發揮你想置入的功能囉
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void name() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("訂購人名稱尚未填寫唷！"); //提示訊息
        //確定 按鈕
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    private void num() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("連絡電話尚未填寫唷！"); //提示訊息

        //確定
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
  /*  private void add() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("地址尚未填寫唷！"); //提示訊息

        //確定
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }*/
}