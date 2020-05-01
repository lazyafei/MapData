package com.example.mappicture.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mappicture.R;
import com.example.mappicture.SqliteHelper.Constant;
import com.example.mappicture.SqliteHelper.DbManger;
import com.example.mappicture.SqliteHelper.MySQLiteHelper;
public class InsertInfoActivity extends AppCompatActivity {

    private MySQLiteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_info_activity);
        helper = DbManger.getInstance(this);
    }


    /**
     * 点击保存按钮插入基础信息
     * @param view
     */
    public void click(View view) {
        switch (view.getId()) { //便利xml文件中的  id
            case R.id.btn_insert:
                SQLiteDatabase db = helper.getWritableDatabase();
                EditText editText = (EditText) findViewById(R.id.editText);
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                String text = editText.getText().toString().trim();
                String text1 = editText1.getText().toString().trim();
                if (text.length() == 0 && text1.length() == 0){//若两者皆为空弹出提示框
                    Toast.makeText(InsertInfoActivity.this, "至少填一项", Toast.LENGTH_SHORT).show();
                }else { //执行插入语句
                    String sql = "INSERT INTO "+ Constant.TABLE_NAME  + "("+ Constant.NAME  + "," + Constant.AGE +") "
                            + "VALUES (" + text + ","+  text1 + ")";//插入数据
                    DbManger.execSQL(db, sql);
                    db.close();//关闭数据库
                }
                break;
        }
    }

    /****************重置按钮****************/
    private Button clearButton = null; //重置按钮
    private EditText editTextName = null;//名输入框
    private EditText editTextCode = null;//编号输入框
    public void setClearButton(View view){
        editTextName = (EditText) this.findViewById(R.id.editText);
        editTextCode = (EditText) this.findViewById(R.id.editText1);
        clearButton = (Button) this.findViewById(R.id.clearButton);
    }







}
