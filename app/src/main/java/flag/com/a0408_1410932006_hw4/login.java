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

public class login extends AppCompatActivity {

    TextView rrr, n;
    Button login_check_btn, register_btn, btn_mainActivity;
    EditText account, password;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("使用者登入");   //上方抬頭

        account = findViewById(R.id.account);
        password = findViewById(R.id.password_btn);
        rrr = findViewById(R.id.rrr);
        n = findViewById(R.id.n);
        login_check_btn = findViewById(R.id.login_check_btn);
        register_btn = findViewById(R.id.register_btn);

        login_check_btn.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   final String users_staffId,users_Password;

                                                   users_staffId  = String.valueOf(account.getText());
                                                   users_Password = String.valueOf(password.getText());

                                                   if(!users_staffId.equals("") && !users_Password.equals("") ){
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
                                                               data[0] = "Screen1_login";
                                                               data[1] = users_staffId;
                                                               data[2] = users_Password;
                                                               PutData putData = new PutData("http://10.0.2.2/drink.php","POST",field,data);
                                                               if(putData.startPut()){
                                                                   if(putData.onComplete()){
                                                                       String result = putData.getResult();
                                                                       ((TextView) findViewById(R.id.rrr)).setText(result);
                                                                       Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                                                       if (rrr.getText().toString().equals("The username or password is in the wrong format, please re-enter.")) re_enter();  //帳號或密碼格式錯誤，請重新輸入。
                                                                       else if (rrr.getText().toString().equals("Check no account, please register first.")) first();  //查無帳號，請先註冊。
                                                                       else if (rrr.getText().toString().equals("Login failed, please try again.")) again();  //登入失敗，請重新嘗試。
                                                                       else if (rrr.getText().toString().equals("Sign in suceesfully.")) {

                                                                       String StrTel2;
                                                                       StrTel2 = users_staffId;
                                                                       String every_mon = StrTel2.toString();

                                                                       Intent intent = new Intent();
                                                                       intent.setClass(login.this, options.class);

                                                                       //new一個Bundle物件，並將要傳遞的資料傳入
                                                                       Bundle bundle = new Bundle();

                                                                       //intent.putExtra("name",name);    //可放所有基本類別
                                                                       bundle.putString("account", users_staffId);
                                                                       bundle.putString("password", users_Password);
                                                                       intent.putExtras(bundle);
                                                                       startActivity(intent);
                                                                       }

                                                                   }
                                                               }
                                                           }
                                                       });
                                                   }
                                                   else{
                                                       Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                                                   }
                                               }
                                           }
        );

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });
    }


    //錯誤重填
    private void re_enter() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("帳號或密碼格式錯誤，請重新輸入。\n\nThe username or password is in the wrong format,\n please re-enter. "); //提示訊息

        //確定按鈕
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    //查無資料
    private void first() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("查無帳號，請先註冊。\n\nCheck no account, please register first. "); //提示訊息

        //確定按鈕
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }


    //密碼錯誤
    private void again() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");  //設置標題
        builder.setIcon(R.mipmap.ic_launcher_round); //標題前面那個小圖示
        builder.setMessage("登入失敗，請重新嘗試。\n\nLogin failed,\n please try again. "); //提示訊息

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