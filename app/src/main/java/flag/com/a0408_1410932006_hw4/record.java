package flag.com.a0408_1410932006_hw4;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class record extends AppCompatActivity  {
    Button option_btn;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"WrongViewCast", "SetJavaScriptEnabled", "AddJavascriptInterface"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        Bundle bundle0311 = this.getIntent().getExtras();
        String account = bundle0311.getString("account");
        String password = bundle0311.getString("password");
        String record = bundle0311.getString("record");
        String date_time = bundle0311.getString("date_time");
        setTitle("歷史訂單查詢　使用者：" + account);   //上方抬頭

        //左側清單
        ListView record_list = findViewById(R.id.record_list);
        String[] queArr = record.split(",");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, queArr);
        record_list.setAdapter(adapter);

        record_list.post(new Runnable() {
            @Override
            public void run() {
                record_list.getChildAt(0).setBackgroundResource(R.color.green2);
            }
        });

        //瀏覽器傳值並開啟
        WebView record_web = (WebView) findViewById(R.id.record_web);
        record_web.postUrl("http://10.0.2.2/record_web.php",
                ("x_code=record_web&Account=" + account + "&date_time=" + date_time).getBytes()); //設定發送值

        //選擇查看哪一個紀錄
        record_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                record_web.postUrl("http://10.0.2.2/record_web.php", ("x_code=record_web&Account=" +
                        account + "&date_time=" + queArr[position]).getBytes()); //設定發送值

                record_list.post(new Runnable() {
                    @Override
                    public void run() {
                        record_list.getChildAt(0).setBackgroundResource(R.color.green3);
                    }
                });
        }});

        option_btn = findViewById(R.id.option_btn);     //返回
        option_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(record.this, options.class);
                startActivity(intent);

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();

                //intent.putExtra("name",name);    //可放所有基本類別
                bundle.putString("account", account);
                bundle.putString("password", password);
                intent.putExtras(bundle);
                startActivity(intent);
            }});
    }
}