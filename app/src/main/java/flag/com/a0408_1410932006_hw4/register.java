package flag.com.a0408_1410932006_hw4;

import android.annotation.SuppressLint;
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

import advanced_httpurlconnection.PutData;

public class register extends AppCompatActivity {
    TextView rrr, n;
    Button register_new, this_login;
    EditText account_re, password_re, password_re2;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setTitle("註冊");   //上方抬頭

        rrr = findViewById(R.id.rrr);
        n = findViewById(R.id.n);
        account_re = findViewById(R.id.account_re);
        password_re = findViewById(R.id.password_re);
        password_re2 = findViewById(R.id.password_re2);
        register_new = findViewById(R.id.register_new);
        this_login = findViewById(R.id.this_login);
        register_new.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   final String users_staffId, users_Password, users_Password2;

                                                   users_staffId = String.valueOf(account_re.getText());
                                                   users_Password = String.valueOf(password_re.getText());
                                                   users_Password2 = String.valueOf(password_re2.getText());

                                                   if(!users_staffId.equals("") && !users_Password.equals("") && !users_Password2.equals("")) {
                                                       if (users_Password.equals(users_Password2)) {
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
                                                                   data[0] = "register";
                                                                   data[1] = users_staffId;
                                                                   data[2] = users_Password;
                                                                   PutData putData = new PutData("http://10.0.2.2/drink.php", "POST", field, data);
                                                                   if (putData.startPut()) {
                                                                       if (putData.onComplete()) {
                                                                           //       progressBar.setVisibility(View.VISIBLE);
                                                                           String result = putData.getResult();
                                                                           ((TextView) findViewById(R.id.rrr)).setText(result);
                                                                           if (result.equals("Login Success")) {
                                                                               Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                                                               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                                               startActivity(intent);
                                                                               finish();
                                                                           } else {
                                                                               Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                                                               if (rrr.getText().toString().equals("The account number and password cannot be the same, please re-enter."))
                                                                                   re_enter();  //帳號和密碼不可相同，請重新輸入。
                                                                               else if (rrr.getText().toString().equals("The account has been registered, please log in directly."))
                                                                                   directly();  //帳號已註冊，請直接登入。
                                                                               else if (rrr.getText().toString().equals("Your data upload failed. Please try again."))
                                                                                   again(); //您的資料上傳失敗，請重新嘗試。
                                                                               else if (rrr.getText().toString().equals("The username or password is in the wrong format, please re-enter."))
                                                                                   again(); //帳號或密碼格式錯誤，請重新輸入。
                                                                               else if (rrr.getText().toString().equals("The registration is successful, please log in directly."))
                                                                                   successful(); //註冊成功，請直接登入。
                                                                           }
                                                                       }
                                                                   }
                                                               }
                                                           });
                                                       }

                                                       else if(!users_Password.equals(users_Password2)) {
                                                           Toast.makeText(getApplicationContext(), "The two passwords are different, please confirm again.", Toast.LENGTH_SHORT).show();
                                                           different(); //您的資料上傳失敗，請重新嘗試。
                                                       }
                                                       else {
                                                           Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
                                                           again(); //您的資料上傳失敗，請重新嘗試。
                                                       }
                                                   }
                                               }
                                           } );

        this_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
            }
        });
    }

            //帳號和密碼不可相同
            private void re_enter() {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");  //設置標題
                builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
                builder.setMessage("帳號和密碼不可相同，請重新輸入。\n\nThe account number and password cannot be the same,\n please re-enter. "); //提示訊息

                //確定按鈕
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }


            //帳號已註冊
            private void directly() {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");  //設置標題
                builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
                builder.setMessage("帳號已註冊，請直接登入。\n\nThe account has been registered,\n please log in directly. "); //提示訊息

                //確定按鈕
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent(register.this, login.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }


            //您的資料上傳失敗，請重新嘗試。
            private void again() {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");  //設置標題
                builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
                builder.setMessage("您的資料上傳失敗，請重新嘗試。\n\nYour data upload failed. Please try again. "); //提示訊息

                //確定按鈕
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }

                //註冊成功，請直接登入。
                private void successful() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("提示");  //設置標題
                    builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
                    builder.setMessage("註冊成功，請直接登入。\n\nThe registration is successful,\n please log in directly. "); //提示訊息

                    //確定按鈕
                    builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(register.this, login.class);
                            startActivity(intent);
                            dialogInterface.dismiss();
                        }
                    });
                    builder.create().show();
            }


            //兩次密碼輸入不同，請重新確認。
            private void different() {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");  //設置標題
                builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
                builder.setMessage("兩次密碼輸入不同，請重新確認。\n\nThe two passwords are different, \n please confirm again. "); //提示訊息

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

