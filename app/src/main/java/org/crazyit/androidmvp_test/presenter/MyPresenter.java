package org.crazyit.androidmvp_test.presenter;

import org.crazyit.androidmvp_test.bean.InfoBean;

/**
 * Created by chenti on 2016/6/1.
 */
public interface MyPresenter {

     boolean checkInput(String name,String age,String sex);

     void onDestroy();

     void setInfo(String name,String age,String sex);

     void getInfo(String name);
}
