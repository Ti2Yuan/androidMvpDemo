package org.crazyit.androidmvp_test.presenter;


import android.text.TextUtils;
import android.view.View;

import org.crazyit.androidmvp_test.bean.InfoBean;
import org.crazyit.androidmvp_test.model.MyModel;
import org.crazyit.androidmvp_test.model.MyModelImpl;
import org.crazyit.androidmvp_test.view.MainView;

/**
 * Created by chenti on 2016/6/1.
 */
public class MyPresenterImpl implements MyPresenter,MyModel.OnSetOrGetInfoListener {


    private MainView mainView;
    private MyModel myModel;

    private InfoBean infoBean;

    public MyPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        myModel = new MyModelImpl();
        infoBean = new InfoBean();
    }


    @Override
    public boolean checkInput(String name, String age, String sex) {
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(sex)){
            return true;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void setInfo(String name, String age, String sex) {
        if(checkInput(name,age,sex)){
            infoBean.setName(name);
            infoBean.setAge(Integer.parseInt(age));
            infoBean.setSex(sex);
            myModel.setInfoBean(infoBean,this);
        }else {
            if(mainView != null) {
                mainView.showMessage("输入错误！");
            }
        }
    }

    @Override
    public void getInfo(String name) {
        mainView.showProgressBar();
        myModel.getInfoBean(name,this);
    }

    @Override
    public void succ(boolean save,InfoBean infoBean) {
        if (mainView != null) {
            if (!save) {
                mainView.hideProgressBar();
                mainView.setInfo(infoBean.getName(), infoBean.getAge(), infoBean.getSex());
                mainView.showMessage("搜索成功！");

            }
        }
    }
    @Override
    public void succ(boolean save){
        if(save){
            mainView.showMessage("存储成功");
        }
    }

    @Override
    public void error() {
        if(mainView != null) {
            mainView.hideProgressBar();
            mainView.showMessage("搜索无结果！");
        }
    }
}
