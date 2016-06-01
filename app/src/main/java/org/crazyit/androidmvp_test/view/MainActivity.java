package org.crazyit.androidmvp_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.crazyit.androidmvp_test.R;
import org.crazyit.androidmvp_test.bean.InfoBean;
import org.crazyit.androidmvp_test.presenter.MyPresenter;
import org.crazyit.androidmvp_test.presenter.MyPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView,View.OnClickListener{

    private EditText nameEdit;
    private EditText ageEdit;
    private EditText sexEdit;
    private Button ok;
    private Button search;
    private ProgressBar progressBar;

    private String name,sex,age;

    private MyPresenter myPresenter;

    private InfoBean infoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = (EditText) findViewById(R.id.name);
        ageEdit = (EditText) findViewById(R.id.age);
        sexEdit = (EditText) findViewById(R.id.sex);
        ok = (Button) findViewById(R.id.ok);
        search = (Button) findViewById(R.id.search);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        ok.setOnClickListener(this);
        search.setOnClickListener(this);

        myPresenter = new MyPresenterImpl(this);
    }

    @Override
    public void setInfo(String name, int age, String sex) {
       //此处填充EditText
        nameEdit.setText(name);
        ageEdit.setText(age+"");
        sexEdit.setText(sex);
    }

    public void getInfo() {
        //此处获取EditText的内容
        name = nameEdit.getText().toString();
        age = ageEdit.getText().toString();
        sex = sexEdit.getText().toString();
    }

    @Override
    public void showMessage(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                getInfo();
                myPresenter.setInfo(name,age,sex);
                break;
            case R.id.search:
                myPresenter.getInfo(name);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if(myPresenter != null){
            myPresenter.onDestroy();
        }
        super.onDestroy();
    }
}
