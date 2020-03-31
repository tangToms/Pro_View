package com.example.pro_view;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //重写Activity的OnCreate方法
        //setContentView设置Activity对应View
        setContentView(R.layout.main_activity);
//        //获取RadioGroup选择
//        RadioGroup rg1 = findViewById(R.id.rg1);
//        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId==R.id.rg1_female){
//                    Toast.makeText(MainActivity.this,"female",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this,"male",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        //获取CheckBox
//        CheckBox cb1=findViewById(R.id.cb_1);
//        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    Toast.makeText(MainActivity.this,"选中",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this,"未选中",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//        //获取日期选择器
//        DatePicker datePicker = findViewById(R.id.dt1);
//        //初始化日期
//        datePicker.init(2019, 12, 1, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Toast.makeText(MainActivity.this,"选择日期",Toast.LENGTH_SHORT);
//            }
//        });
//
//        //获取时间选择器
//        TimePicker timePicker = findViewById(R.id.tp1);
//        //设置24小时制
//        timePicker.setIs24HourView(true);
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                Toast.makeText(MainActivity.this,"选择时间",Toast.LENGTH_SHORT);
//            }
//        });

//        //获取webView
//        final WebView webView = findViewById(R.id.webview);
//        //设置打开新的连接不跳转
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//        //设置javaScript支持
//        webView.getSettings().setJavaScriptEnabled(true);
//        //默认不支持js弹出框alert(), prompt(),confirm()等，但会调用onJsAlert方法
//        webView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                //可以输出Android弹窗
//                return super.onJsAlert(view, url, message, result);
//            }
//        });
//        //加载网页
//        webView.loadUrl("https://www.baidu.com");


//        //Logcat使用
//        //android.util.Log类
//        //参数tag,info
//        Log.v("tag2","verbose1");
//        Log.d("tag4","debug1");
//        Log.i("tag1","info1");
//        Log.w("tag5","warn1");
//        Log.e("tag3","error1");
//        //等级从低到高；
//        //等级越高的拦截器，不能拦截比他等级低的日志；
//        //warn的拦截器，只拦截warn，error等级的日志；


//        //1获取内部存储/data
//        File filedata = Environment.getDataDirectory();
//        //2获取外部存储
//        File exfiledata = Environment.getExternalStorageDirectory();


    }


    //读取数据
    public void readData(){
        try {
            //读取文件,参数文件路径：/data/data/包名/文件名
            File file = new File("路径");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //读取一行
            String line = reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //写文件到指定目录
    public void saveData1() {
        try {
            //文件对象，参数文件路径：/data/data/包名/文件名
            File file = new File("路径");
            //获取cache目录
            File file1 = new File(getCacheDir(), "filename");
            //获取files目录
            File file2 = new File(getFilesDir(), "filename");
            //字符流
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("hehe");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //保存文件成键值对
    public void saveShare(){
        //使用SharedPreferences
        SharedPreferences sp = getSharedPreferences("sp1",MODE_PRIVATE);
        //存储键值对
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name","heha");
        editor.putInt("age",22);
        //提交任务
        editor.commit();
    }
    //获取SharedPreferences
    public void getShare(){
        SharedPreferences sp = getSharedPreferences("sp1",MODE_PRIVATE);
        //获取value
        int age = sp.getInt("age",0);
        String name = sp.getString("name","");
    }

    //生成XML文件
    public void creatXML(){
        //使用字符串拼接
        try {
            //使用XML序列化工具生产Xml
            XmlSerializer xmlSerializer = Xml.newSerializer();
            //创建输出流
            FileOutputStream fileOutputStream = openFileOutput("file.xml",MODE_PRIVATE);
            xmlSerializer.setOutput(fileOutputStream,"UTF-8");
            //文档开始头
            xmlSerializer.startDocument("UTF-8",true);
            //namespace：命名空间，name:标签名，<h:name>
            xmlSerializer.startTag(null,"name");
            xmlSerializer.text("tang");
            xmlSerializer.endTag(null,"name");
            xmlSerializer.endDocument();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //SQLiteDatabase使用，执行SQL语句
    public  void useSqlite(){
        //创建DBHelper对象
        DBHelper dbHelper = new DBHelper(this,"my_db",null);
        //创建数据库文件
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //创建数据库文件
        //SQLiteDatabase database = dbHelper.getWritableDatabase();
        //添加记录
        database.execSQL("INSERT INTO person(name,sex,info) VALUES(?,?,?)",new String[]{"tang","男","test"});
        //查询记录
        Cursor cursor= database.rawQuery("SELECT * FROM person",new String[]{});
        //读取查询出结果
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
        }
        //删除记录
        database.execSQL("delete from person");
        //删除指定记录
        database.execSQL("delete from person where name=?",new String[]{"tang"});
        //更新记录
        database.execSQL("update person set info='new info' where name=?",new String[]{"tang"});
    }

    //通过Android提供API方式操作数据库
    public void useSqlite1(){
        //创建DBHelper对象
        DBHelper dbHelper = new DBHelper(this,"my_db",null);
        //创建数据库文件
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","tang");
        contentValues.put("sex","男");
        //插入记录
        //table:操作表名，nullcolumnHack:null：允许某些值为空；contentValues：数据Map
        //返回一个long型数据，插入失败返回-1
        long ret = database.insert("people",null,contentValues);
        //更新记录
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("name","tang");
        contentValues1.put("sex","女");
        //返回更新行数
        int ret1 = database.update("people",contentValues1,"name=?",new String[]{"tang"});
        //删除数据
        //返回删除数据行数
        int ret2 = database.delete("people","name=?",new String[]{"tang"});
        //查询数据
        Cursor cursor =  database.query("people",new String[]{"name","sex","info"},
                "name=?",new String[]{"tang"},
                null,null,null);
        //使用cursor读取查询到数据
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
        }
    }

}
