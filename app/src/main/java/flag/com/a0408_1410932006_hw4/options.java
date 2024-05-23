package flag.com.a0408_1410932006_hw4;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import advanced_httpurlconnection.PutData;

public class options extends AppCompatActivity {
    Button btn_mainActivity, signout_btn, password_btn, edit_password_btn, suggest_btn, record_btn, record_btn_1, record_btn_2, record_btn_3, record_btn_4, record_btn_5, record_btn_A;
    LinearLayout password_ALL, suggest_ALL, record_ALL, record_1, record_2, record_3, record_4, record_5, record_ALL2;
    TextView n, rrr, cup_1, total_money_1, date_1, a111111, queArr;
    EditText edit_password_1, edit_password_2, password_check;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        Bundle bundle0311 = this.getIntent().getExtras();
        String account = bundle0311.getString("account");
        String password = bundle0311.getString("password");
        setTitle("使用者："+account);   //上方抬頭

        btn_mainActivity = findViewById(R.id.mainActivity_btn);     //點飲料
        btn_mainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(options.this, MainActivity.class);
                startActivity(intent);

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();

                //intent.putExtra("name",name);    //可放所有基本類別
                bundle.putString("account", account);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                startActivity(intent);

            }});





        //紀錄顯示
        record_1 = findViewById(R.id.record_1);
        record_2 = findViewById(R.id.record_2);
        record_3 = findViewById(R.id.record_3);
        record_4 = findViewById(R.id.record_4);
        record_5 = findViewById(R.id.record_5);
        cup_1 = findViewById(R.id.cup_1);
        total_money_1 = findViewById(R.id.total_money_1);
        date_1 = findViewById(R.id.date_1);
        record_btn = findViewById(R.id.record_btn);
        record_ALL = findViewById(R.id.record_ALL);
        record_ALL2 = findViewById(R.id.record_ALL2);
        record_ALL.setVisibility(View.GONE);           // 處於隱藏狀態

        record_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (record_ALL.getVisibility() == View.GONE) {     //tea
                      record_ALL.setVisibility(View.VISIBLE);        // 處於可見狀態
                      password_ALL.setVisibility(View.GONE);         // 處於隱藏狀態
                      suggest_ALL.setVisibility(View.GONE);          // 處於隱藏狀態
                  }
                  else if (record_ALL.getVisibility() == View.VISIBLE) {
                      record_ALL.setVisibility(View.GONE);
                  }
                  Handler handler = new Handler();
                  //總金額
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                          String[] field = new String[2];
                          field[0] = "x_code";
                          field[1] = "Account";
                          String[] data = new String[2];
                          data[0] = "simple_record_money";
                          data[1] = account;
                          PutData putData = new PutData("http://10.0.2.2/drink.php","POST",field,data);
                          if(putData.startPut()){
                              if(putData.onComplete()){
                                  String result = putData.getResult();
                                  String str = result;
                                  String[] all = str.split(",");

                                  //計算有幾個
                                  final int[] count = {0};
                                  char temp;
                                  for (int i = 0; i < str.length(); i++) {
                                      temp = str.charAt(i);
                                      if (temp == ',')
                                          count[0]++;
                                  }

                                  if(count[0]==0){
                                      ((TextView) findViewById(R.id.demo)).setText(" 目 前 尚 無 訂 購 紀 錄 ");
                                      record_ALL2.setVisibility(View.GONE);        // 處於隱藏狀態
                                      record_btn_A.setVisibility(View.GONE);       // 處於隱藏狀態
                                      record_1.setVisibility(View.GONE);           // 處於隱藏狀態
                                      record_2.setVisibility(View.GONE);           // 處於隱藏狀態
                                      record_3.setVisibility(View.GONE);           // 處於隱藏狀態
                                      record_4.setVisibility(View.GONE);           // 處於隱藏狀態
                                      record_5.setVisibility(View.GONE);           // 處於隱藏狀態
                                  }

                                  else if(count[0]==1){
                                      ((TextView) findViewById(R.id.total_money_1)).setText("$ "+all[0]);
                                      record_1.setVisibility(View.VISIBLE);        // 處於可見狀態
                                      record_2.setVisibility(View.GONE);           // 處於隱藏狀態
                                      record_3.setVisibility(View.GONE);           // 處於隱藏狀態
                                      record_4.setVisibility(View.GONE);           // 處於隱藏狀態
                                      record_5.setVisibility(View.GONE);           // 處於隱藏狀態
                                  }

                                  else if(count[0]==2){
                                      ((TextView) findViewById(R.id.total_money_1)).setText("$ "+all[0]);
                                      ((TextView) findViewById(R.id.total_money_2)).setText("$ "+all[1]);
                                      record_1.setVisibility(View.VISIBLE);
                                      record_2.setVisibility(View.VISIBLE);
                                      record_3.setVisibility(View.GONE);
                                      record_4.setVisibility(View.GONE);
                                      record_5.setVisibility(View.GONE);
                                  }

                                  else if(count[0]==3){
                                      ((TextView) findViewById(R.id.total_money_1)).setText("$ "+all[0]);
                                      ((TextView) findViewById(R.id.total_money_2)).setText("$ "+all[1]);
                                      ((TextView) findViewById(R.id.total_money_3)).setText("$ "+all[2]);
                                      record_1.setVisibility(View.VISIBLE);
                                      record_2.setVisibility(View.VISIBLE);
                                      record_3.setVisibility(View.VISIBLE);
                                      record_4.setVisibility(View.GONE);
                                      record_5.setVisibility(View.GONE);
                                  }

                                  else if(count[0]==4){
                                      ((TextView) findViewById(R.id.total_money_1)).setText("$ "+all[0]);
                                      ((TextView) findViewById(R.id.total_money_2)).setText("$ "+all[1]);
                                      ((TextView) findViewById(R.id.total_money_3)).setText("$ "+all[2]);
                                      ((TextView) findViewById(R.id.total_money_4)).setText("$ "+all[3]);
                                      record_1.setVisibility(View.VISIBLE);
                                      record_2.setVisibility(View.VISIBLE);
                                      record_3.setVisibility(View.VISIBLE);
                                      record_4.setVisibility(View.VISIBLE);
                                      record_5.setVisibility(View.GONE);
                                  }

                                  else if(count[0]==5){
                                      ((TextView) findViewById(R.id.total_money_1)).setText("$ "+all[0]);
                                      ((TextView) findViewById(R.id.total_money_2)).setText("$ "+all[1]);
                                      ((TextView) findViewById(R.id.total_money_3)).setText("$ "+all[2]);
                                      ((TextView) findViewById(R.id.total_money_4)).setText("$ "+all[3]);
                                      ((TextView) findViewById(R.id.total_money_5)).setText("$ "+all[4]);
                                      record_1.setVisibility(View.VISIBLE);
                                      record_2.setVisibility(View.VISIBLE);
                                      record_3.setVisibility(View.VISIBLE);
                                      record_4.setVisibility(View.VISIBLE);
                                      record_5.setVisibility(View.VISIBLE);
                                  }

                                  if(result.equals("Login Success")){
                                      Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                      Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                      startActivity(intent);
                                      finish();
                                  }
                              }
                          }
                      }
                  });

                                              //日期
                                              handler.post(new Runnable() {
                                                  @Override
                                                  public void run() {
                                                      String[] field = new String[2];
                                                      field[0] = "x_code";
                                                      field[1] = "Account";
                                                      String[] data = new String[2];
                                                      data[0] = "simple_record_date_time";
                                                      data[1] = account;
                                                      PutData putData = new PutData("http://10.0.2.2/drink.php","POST",field,data);
                                                      if(putData.startPut()){
                                                          if(putData.onComplete()){
                                                              //       progressBar.setVisibility(View.VISIBLE);
                                                              String result = putData.getResult();
                                                              //       ((TextView) findViewById(R.id.a111111)).setText(result);
                                                              //分割
                                                              String str = result;
                                                              String[] all = str.split(",");

                                                              //計算有幾個
                                                              final int[] count = {0};
                                                              char temp;
                                                              for (int i = 0; i < str.length(); i++) {
                                                                  temp = str.charAt(i);
                                                                  if (temp == ',')
                                                                      count[0]++;
                                                              }

                                                              if(count[0]==1){
                                                                  ((TextView) findViewById(R.id.date_1)).setText(all[0]);
                                                              }

                                                              else if(count[0]==2){
                                                                  ((TextView) findViewById(R.id.date_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.date_2)).setText(all[1]);
                                                              }

                                                              else if(count[0]==3){
                                                                  ((TextView) findViewById(R.id.date_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.date_2)).setText(all[1]);
                                                                  ((TextView) findViewById(R.id.date_3)).setText(all[2]);
                                                              }

                                                              else if(count[0]==4){
                                                                  ((TextView) findViewById(R.id.date_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.date_2)).setText(all[1]);
                                                                  ((TextView) findViewById(R.id.date_3)).setText(all[2]);
                                                                  ((TextView) findViewById(R.id.date_4)).setText(all[3]);
                                                              }

                                                              else if(count[0]==5){
                                                                  ((TextView) findViewById(R.id.date_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.date_2)).setText(all[1]);
                                                                  ((TextView) findViewById(R.id.date_3)).setText(all[2]);
                                                                  ((TextView) findViewById(R.id.date_4)).setText(all[3]);
                                                                  ((TextView) findViewById(R.id.date_5)).setText(all[4]);
                                                              }

                                                              if(result.equals("Login Success")){
                                                                  Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                                                  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                                  startActivity(intent);
                                                                  finish();
                                                              }
                                                          }
                                                      }
                                                  }
                                              });

                                              //總杯數
                                              handler.post(new Runnable() {
                                                  @Override
                                                  public void run() {
                                                      String[] field = new String[2];
                                                      field[0] = "x_code";
                                                      field[1] = "Account";
                                                      String[] data = new String[2];
                                                      data[0] = "simple_record_cup";
                                                      data[1] = account;
                                                      PutData putData = new PutData("http://10.0.2.2/drink.php","POST",field,data);
                                                      if(putData.startPut()){
                                                          if(putData.onComplete()){
                                                              //   progressBar.setVisibility(View.VISIBLE);
                                                              String result = putData.getResult();
                                                              //    ((TextView) findViewById(R.id.a111111)).setText(result);
                                                              //分割
                                                              String str = result;
                                                              String[] all = str.split(",");

                                                              //計算有幾個
                                                              final int[] count = {0};
                                                              char temp;
                                                              for (int i = 0; i < str.length(); i++) {
                                                                  temp = str.charAt(i);
                                                                  if (temp == ',')
                                                                      count[0]++;
                                                              }

                                                              if(count[0]==1){
                                                                  ((TextView) findViewById(R.id.cup_1)).setText(all[0]);
                                                              }

                                                              else if(count[0]==2){
                                                                  ((TextView) findViewById(R.id.cup_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.cup_2)).setText(all[1]);
                                                              }

                                                              else if(count[0]==3){
                                                                  ((TextView) findViewById(R.id.cup_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.cup_2)).setText(all[1]);
                                                                  ((TextView) findViewById(R.id.cup_3)).setText(all[2]);
                                                              }

                                                              else if(count[0]==4){
                                                                  ((TextView) findViewById(R.id.cup_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.cup_2)).setText(all[1]);
                                                                  ((TextView) findViewById(R.id.cup_3)).setText(all[2]);
                                                                  ((TextView) findViewById(R.id.cup_4)).setText(all[3]);
                                                              }

                                                              else if(count[0]==5){
                                                                  ((TextView) findViewById(R.id.cup_1)).setText(all[0]);
                                                                  ((TextView) findViewById(R.id.cup_2)).setText(all[1]);
                                                                  ((TextView) findViewById(R.id.cup_3)).setText(all[2]);
                                                                  ((TextView) findViewById(R.id.cup_4)).setText(all[3]);
                                                                  ((TextView) findViewById(R.id.cup_5)).setText(all[4]);
                                                              }

                                                              if(result.equals("Login Success")){
                                                                  Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                                                  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                                  startActivity(intent);
                                                                  finish();
                                                              }
                                                          }
                                                      }
                                                  }
                                              });
                                          }
                                      }
        );








        record_btn_A = findViewById(R.id.record_btn_A);
        record_btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {    Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[2];
                        field[0] = "x_code";
                        field[1] = "Account";

                        String[] data = new String[2];
                        data[0] = "record";
                        data[1] = account;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result_queArr = putData.getResult();
                                ((TextView) findViewById(R.id.queArr)).setText(result_queArr);
                                //           Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                queArr = findViewById(R.id.queArr);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        String[] field = new String[2];
                                        field[0] = "x_code";
                                        field[1] = "Account";
                                        String[] data = new String[2];
                                        data[0] = "record";
                                        data[1] = account;
                                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                                        if (putData.startPut()) {
                                            if (putData.onComplete()) {
                                                String result = putData.getResult();
                                                //分割
                                                String str = result;
                                                String[] all = str.split(",");

                                                Intent intent = new Intent(options.this, record.class);
                                                startActivity(intent);

                                                //new一個Bundle物件，並將要傳遞的資料傳入
                                                Bundle bundle = new Bundle();

                                                //intent.putExtra("name",name);    //可放所有基本類別
                                                bundle.putString("account", account);
                                                bundle.putString("password", password);
                                                bundle.putString("record", result_queArr);
                                                bundle.putString("date_time", all[0]);
                                                intent.putExtras(bundle);
                                                startActivity(intent);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }});
                            }});


        record_btn_1 = findViewById(R.id.record_btn_1);
        record_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {    Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[2];
                        field[0] = "x_code";
                        field[1] = "Account";

                        String[] data = new String[2];
                        data[0] = "record";
                        data[1] = account;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result_queArr = putData.getResult();
                                ((TextView) findViewById(R.id.queArr)).setText(result_queArr);
                                //           Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                queArr = findViewById(R.id.queArr);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        String[] field = new String[2];
                                        field[0] = "x_code";
                                        field[1] = "Account";
                                        String[] data = new String[2];
                                        data[0] = "record";
                                        data[1] = account;
                                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                                        if (putData.startPut()) {
                                            if (putData.onComplete()) {
                                                //       progressBar.setVisibility(View.VISIBLE);
                                                String result = putData.getResult();
                                                //       ((TextView) findViewById(R.id.a111111)).setText(result);
                                                //分割
                                                String str = result;
                                                String[] all = str.split(",");


                                                //              String str = (String) queArr.getText();
                                                //             String[] queArr2 = str.split(",");

                                                Intent intent = new Intent(options.this, record.class);
                                                startActivity(intent);

                                                //new一個Bundle物件，並將要傳遞的資料傳入
                                                Bundle bundle = new Bundle();


                                                //intent.putExtra("name",name);    //可放所有基本類別
                                                bundle.putString("account", account);
                                                bundle.putString("password", password);
                                                bundle.putString("record", result_queArr);
                                                bundle.putString("date_time", all[0]);
                                                intent.putExtras(bundle);
                                                startActivity(intent);

                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }});
            }});





        record_btn_2 = findViewById(R.id.record_btn_2);
        record_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {    Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[2];
                        field[0] = "x_code";
                        field[1] = "Account";

                        String[] data = new String[2];
                        data[0] = "record";
                        data[1] = account;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result_queArr = putData.getResult();
                                ((TextView) findViewById(R.id.queArr)).setText(result_queArr);
                                //           Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                queArr = findViewById(R.id.queArr);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        String[] field = new String[2];
                                        field[0] = "x_code";
                                        field[1] = "Account";
                                        String[] data = new String[2];
                                        data[0] = "record";
                                        data[1] = account;
                                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                                        if (putData.startPut()) {
                                            if (putData.onComplete()) {
                                                //       progressBar.setVisibility(View.VISIBLE);
                                                String result = putData.getResult();
                                                //       ((TextView) findViewById(R.id.a111111)).setText(result);
                                                //分割
                                                String str = result;
                                                String[] all = str.split(",");


                                                //              String str = (String) queArr.getText();
                                                //             String[] queArr2 = str.split(",");

                                                Intent intent = new Intent(options.this, record.class);
                                                startActivity(intent);

                                                //new一個Bundle物件，並將要傳遞的資料傳入
                                                Bundle bundle = new Bundle();


                                                //intent.putExtra("name",name);    //可放所有基本類別
                                                bundle.putString("account", account);
                                                bundle.putString("password", password);
                                                bundle.putString("record", result_queArr);
                                                bundle.putString("date_time", all[1]);
                                                intent.putExtras(bundle);
                                                startActivity(intent);

                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }});
            }});


        record_btn_3 = findViewById(R.id.record_btn_3);
        record_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {    Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[2];
                        field[0] = "x_code";
                        field[1] = "Account";

                        String[] data = new String[2];
                        data[0] = "record";
                        data[1] = account;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result_queArr = putData.getResult();
                                ((TextView) findViewById(R.id.queArr)).setText(result_queArr);
                                //           Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                queArr = findViewById(R.id.queArr);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        String[] field = new String[2];
                                        field[0] = "x_code";
                                        field[1] = "Account";
                                        String[] data = new String[2];
                                        data[0] = "record";
                                        data[1] = account;
                                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                                        if (putData.startPut()) {
                                            if (putData.onComplete()) {
                                                //       progressBar.setVisibility(View.VISIBLE);
                                                String result = putData.getResult();
                                                //       ((TextView) findViewById(R.id.a111111)).setText(result);
                                                //分割
                                                String str = result;
                                                String[] all = str.split(",");


                                                //              String str = (String) queArr.getText();
                                                //             String[] queArr2 = str.split(",");

                                                Intent intent = new Intent(options.this, record.class);
                                                startActivity(intent);

                                                //new一個Bundle物件，並將要傳遞的資料傳入
                                                Bundle bundle = new Bundle();


                                                //intent.putExtra("name",name);    //可放所有基本類別
                                                bundle.putString("account", account);
                                                bundle.putString("password", password);
                                                bundle.putString("record", result_queArr);
                                                bundle.putString("date_time", all[2]);
                                                intent.putExtras(bundle);
                                                startActivity(intent);

                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }});
            }});



        record_btn_4 = findViewById(R.id.record_btn_4);
        record_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {    Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[2];
                        field[0] = "x_code";
                        field[1] = "Account";

                        String[] data = new String[2];
                        data[0] = "record";
                        data[1] = account;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result_queArr = putData.getResult();
                                ((TextView) findViewById(R.id.queArr)).setText(result_queArr);
                                //           Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                queArr = findViewById(R.id.queArr);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        String[] field = new String[2];
                                        field[0] = "x_code";
                                        field[1] = "Account";
                                        String[] data = new String[2];
                                        data[0] = "record";
                                        data[1] = account;
                                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                                        if (putData.startPut()) {
                                            if (putData.onComplete()) {
                                                //       progressBar.setVisibility(View.VISIBLE);
                                                String result = putData.getResult();
                                                //       ((TextView) findViewById(R.id.a111111)).setText(result);
                                                //分割
                                                String str = result;
                                                String[] all = str.split(",");


                                                //              String str = (String) queArr.getText();
                                                //             String[] queArr2 = str.split(",");

                                                Intent intent = new Intent(options.this, record.class);
                                                startActivity(intent);

                                                //new一個Bundle物件，並將要傳遞的資料傳入
                                                Bundle bundle = new Bundle();


                                                //intent.putExtra("name",name);    //可放所有基本類別
                                                bundle.putString("account", account);
                                                bundle.putString("password", password);
                                                bundle.putString("record", result_queArr);
                                                bundle.putString("date_time", all[3]);
                                                intent.putExtras(bundle);
                                                startActivity(intent);

                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }});
            }});

        record_btn_5 = findViewById(R.id.record_btn_5);
        record_btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {    Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[2];
                        field[0] = "x_code";
                        field[1] = "Account";

                        String[] data = new String[2];
                        data[0] = "record";
                        data[1] = account;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result_queArr = putData.getResult();
                                ((TextView) findViewById(R.id.queArr)).setText(result_queArr);
                                //           Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                queArr = findViewById(R.id.queArr);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        String[] field = new String[2];
                                        field[0] = "x_code";
                                        field[1] = "Account";
                                        String[] data = new String[2];
                                        data[0] = "record";
                                        data[1] = account;
                                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                                        if (putData.startPut()) {
                                            if (putData.onComplete()) {
                                                //       progressBar.setVisibility(View.VISIBLE);
                                                String result = putData.getResult();
                                                //       ((TextView) findViewById(R.id.a111111)).setText(result);
                                                //分割
                                                String str = result;
                                                String[] all = str.split(",");


                                                //              String str = (String) queArr.getText();
                                                //             String[] queArr2 = str.split(",");

                                                Intent intent = new Intent(options.this, record.class);
                                                startActivity(intent);

                                                //new一個Bundle物件，並將要傳遞的資料傳入
                                                Bundle bundle = new Bundle();


                                                //intent.putExtra("name",name);    //可放所有基本類別
                                                bundle.putString("account", account);
                                                bundle.putString("password", password);
                                                bundle.putString("record", result_queArr);
                                                bundle.putString("date_time", all[4]);
                                                intent.putExtras(bundle);
                                                startActivity(intent);

                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }});
            }});


        password_btn = findViewById(R.id.password_btn);     //修改密碼
        password_ALL = findViewById(R.id.password_ALL);
        password_ALL.setVisibility(View.GONE);           // 處於隱藏狀態
        password_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (password_ALL.getVisibility() == View.GONE) {     //tea
                    record_ALL.setVisibility(View.GONE);             // 處於隱藏狀態
                    password_ALL.setVisibility(View.VISIBLE);        // 處於可見狀態
                    suggest_ALL.setVisibility(View.GONE);            // 處於隱藏狀態
                }
                else if (password_ALL.getVisibility() == View.VISIBLE) {
                    password_ALL.setVisibility(View.GONE);
                }
            }
        });

        suggest_btn = findViewById(R.id.suggest_btn);     //建議回饋
        suggest_ALL = findViewById(R.id.suggest_ALL);
        suggest_ALL.setVisibility(View.GONE);           // 處於隱藏狀態
        suggest_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (suggest_ALL.getVisibility() == View.GONE) {     //tea
                    record_ALL.setVisibility(View.GONE);             // 處於隱藏狀態
                    password_ALL.setVisibility(View.GONE);           // 處於隱藏狀態
                    suggest_ALL.setVisibility(View.VISIBLE);         // 處於可見狀態
                }
                else if (suggest_ALL.getVisibility() == View.VISIBLE) {
                    suggest_ALL.setVisibility(View.GONE);
                }
            }
        });

        signout_btn = findViewById(R.id.signout_btn);
        signout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(options.this, login.class);
                startActivity(intent);
            }});



        //修改密碼
        n = findViewById(R.id.n);
        rrr = findViewById(R.id.rrr);
        password_check = findViewById(R.id.password_check);
        edit_password_1 = findViewById(R.id.edit_password_1);
        edit_password_2 = findViewById(R.id.edit_password_2);
        edit_password_btn = findViewById(R.id.edit_password_btn);

        edit_password_btn.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     final String edit_password_a,edit_password_b;

                                                     edit_password_a = String.valueOf(edit_password_1.getText());
                                                     edit_password_b = String.valueOf(edit_password_2.getText());

                                                     if(!edit_password_a.equals("") && !edit_password_b.equals("") ) {
                                                         boolean equals = (edit_password_1.getText().toString().trim()).equals(account.trim());
                                                         if ((edit_password_2.getText().toString().trim()).equals(edit_password_1.getText().toString().trim()) && !((password_check.getText().toString().trim()).equals(edit_password_1.getText().toString().trim())) && ((password.trim()).equals(password_check.getText().toString().trim())) && !equals){
                                                             //  progressBar.setVisibility(View.VISIBLE);
                                                             Handler handler = new Handler();
                                                             handler.post(new Runnable() {
                                                                 @Override
                                                                 public void run() {
                                                                     String[] field = new String[3];
                                                                     field[0] = "x_code";
                                                                     field[1] = "Account";
                                                                     field[2] = "Password";
                                                                     String[] data = new String[3];
                                                                     data[0] = "edit";
                                                                     data[1] = account;
                                                                     data[2] = edit_password_b;
                                                                     PutData putData = new PutData("http://10.0.2.2/drink.php","POST",field,data);
                                                                     if(putData.startPut()){
                                                                         if(putData.onComplete()){
                                                                             //       progressBar.setVisibility(View.VISIBLE);
                                                                             String result = putData.getResult();
                                                                             ((TextView) findViewById(R.id.rrr)).setText(result);
                                                                             if(result.equals("Login Success")){
                                                                                 Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                                                                 Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                                                 startActivity(intent);
                                                                                 finish();
                                                                             }
                                                                             else{
                                                                                 Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                                                                 if (rrr.getText().toString().equals("Update information successful !")) {  //更新資料成功
                                                                                     successful();
                                                                                     Bundle bundle = new Bundle();
                                                                                     bundle.putString("password", edit_password_b);  }  //更新資料成功！
                                                                                 else if (rrr.getText().toString().equals("Failed to update data, please try again.")) again();  //更新資料失敗，請重新嘗試。
                                                                                 else if (rrr.getText().toString().equals("The format is entered incorrectly, please confirm again.")) again2();  //登入失敗，請重新嘗試。
                                                                             }
                                                                         }
                                                                     }
                                                                 }
                                                             });
                                                         }

                                                         else{
                                                             if(!((edit_password_2.getText().toString().trim()).equals(edit_password_1.getText().toString().trim()))){
                                                                 Toast.makeText(getApplicationContext(),"新密碼兩次輸入不相同，請重新確認。",Toast.LENGTH_SHORT).show();
                                                             }

                                                             else if(((password_check.getText().toString().trim()).equals(edit_password_1.getText().toString().trim()))){
                                                                 Toast.makeText(getApplicationContext(),"新密碼不可與原密碼相同，請重新確認。",Toast.LENGTH_SHORT).show();
                                                             }

                                                             else if(!((password.trim()).equals(password_check.getText().toString().trim()))){
                                                                 Toast.makeText(getApplicationContext(),"原密碼輸入錯誤，請重新確認。",Toast.LENGTH_SHORT).show();
                                                             }

                                                             else if((edit_password_1.getText().toString().trim()).equals(account.trim())){
                                                                 Toast.makeText(getApplicationContext(),"帳號與密碼不可相同，請重新確認。",Toast.LENGTH_SHORT).show();
                                                             }
                                                         }

                                                     }
                                                 }
                                             }
        );

        Spinner suggest_title = (Spinner) findViewById(R.id.suggest_title);
        TextView languages = (TextView) findViewById(R.id.languages);
        String suggest_a = "";
        suggest_title.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String[] languages = getResources().getStringArray(R.array.suggest_title);
                ((TextView) findViewById(R.id.languages)).setText(languages[pos]);
                Toast.makeText(options.this, languages[pos], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
        //建議回饋
        //TextView suggest_a = (TextView) findViewById(R.id.suggest_a);
        EditText suggest_b = (EditText) findViewById(R.id.suggest_content);
        Button suggest_check_btn = (Button) findViewById(R.id.suggest_check_btn);
        //Spinner suggest_title = (Spinner) findViewById(R.id.suggest_title);
        String suggest_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        //String suggest_a = suggest_title.getSelectedItem().toString();
        suggest_check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String suggest_title, suggest_content;
                //suggest_title   = suggest_a;
                suggest_title   = String.valueOf(languages.getText());
                suggest_content = String.valueOf(suggest_b.getText());
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        String[] field = new String[5];
                        field[0] = "x_code";
                        field[1] = "Account";
                        field[2] = "suggest_title";
                        field[3] = "suggest_content";
                        field[4] = "suggest_time";

                        String[] data = new String[5];
                        data[0] = "suggest";
                        data[1] = account;
                        data[2] = suggest_title;
                        data[3] = suggest_content;
                        data[4] = suggest_time;

                        PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                //       progressBar.setVisibility(View.VISIBLE);
                                String result = putData.getResult();
                                ((TextView) findViewById(R.id.rrr)).setText(result);
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                if      (rrr.getText().toString().equals("success"))  suggest_success(); //上傳成功
                                else if (rrr.getText().toString().equals("fail"))  suggest_fail(); //更新資料失敗，請重新嘗試。
                            }
                        }
                    }
                });
            }
        });
    }


    //更新資料成功
    private void successful() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("更新資料成功！\n\nUpdate information successful !"); //提示訊息
        //確定按鈕
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                home();
            }
        });
        builder.create().show();
    }


    //更新資料失敗，請重新嘗試
    private void again() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("更新資料失敗，請重新嘗試。\n\nFailed to update data, please try again. "); //提示訊息

        //確定按鈕
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


    //登入失敗，請重新嘗試。
    private void again2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("登入失敗，請重新嘗試。\n\nThe format is entered incorrectly, please confirm again. "); //提示訊息

        //確定按鈕
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


    //回饋送出成功
    private void suggest_success() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("已成功上傳，謝謝您的回饋！"); //提示訊息
        //回主頁面(設定跳至哪一頁)
        builder.setPositiveButton("回首頁", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                home();
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


    //回饋送出失敗
    private void suggest_fail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("資料上傳失敗，請重新嘗試。"); //提示訊息
        //回主頁面(設定跳至哪一頁)
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


    //回主頁
    private void home() {
        //回主頁面(設定跳至哪一頁)
        Bundle bundle0311 = this.getIntent().getExtras();
        String account = bundle0311.getString("account");
        String password = bundle0311.getString("password");

        Intent intent = new Intent(options.this, options.class);
        startActivity(intent);

        //new一個Bundle物件，並將要傳遞的資料傳入
        Bundle bundle = new Bundle();
        bundle.putString("account", account);
        bundle.putString("password", password);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}