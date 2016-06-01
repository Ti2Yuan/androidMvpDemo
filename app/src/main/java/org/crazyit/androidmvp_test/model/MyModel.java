package org.crazyit.androidmvp_test.model;

import org.crazyit.androidmvp_test.bean.InfoBean;

/**
 * Created by chenti on 2016/6/1.
 */
public interface MyModel {

     void setInfoBean(InfoBean infoBean,OnSetOrGetInfoListener onSetOrGetInfoListener);

     void getInfoBean(String name,OnSetOrGetInfoListener onSetOrGetInfoListener);

     interface OnSetOrGetInfoListener{
         void succ(boolean save,InfoBean infoBean);
         void succ(boolean save);
         void error();
    }
}
