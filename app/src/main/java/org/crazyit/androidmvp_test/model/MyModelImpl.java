package org.crazyit.androidmvp_test.model;

import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;

import org.crazyit.androidmvp_test.bean.InfoBean;
import org.crazyit.androidmvp_test.presenter.MyPresenter;

import java.util.HashMap;

/**
 * Created by chenti on 2016/6/1.
 */
public class MyModelImpl implements MyModel{

    private HashMap<String,InfoBean> infoBeanList;
    private InfoBean infoBean;

    private boolean save = false;

    public MyModelImpl() {
        this.infoBeanList = new HashMap<>();
    }

    @Override
    public void setInfoBean(InfoBean infoBean, OnSetOrGetInfoListener onSetOrGetInfoListener) {
        infoBeanList.put(infoBean.getName(),infoBean);
        save = true;
        onSetOrGetInfoListener.succ(save);
    }

    @Override
    public void getInfoBean(final String name, final OnSetOrGetInfoListener onSetOrGetInfoListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (infoBeanList.containsKey(name)) {
                    save = false;
                    infoBean = infoBeanList.get(name);
                    onSetOrGetInfoListener.succ(save,infoBean);

                    Log.d("tag",infoBean.getName());
                } else {
                    onSetOrGetInfoListener.error();
                }
            }
        }, 2000);
    }
}
