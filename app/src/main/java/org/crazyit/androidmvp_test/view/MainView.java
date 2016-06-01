package org.crazyit.androidmvp_test.view;

/**
 * Created by chenti on 2016/6/1.
 */
public interface MainView {

     void setInfo(String name,int age,String sex);

     void showMessage(String str);

     void showProgressBar();

     void hideProgressBar();
}
