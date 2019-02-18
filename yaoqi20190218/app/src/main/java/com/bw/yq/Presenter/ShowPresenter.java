package com.bw.yq.Presenter;

import com.bw.yq.Model.ShowModel;
import com.bw.yq.View.ShowView;

import org.json.JSONArray;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @author yaoqi
 * @fileName ShowPresenter
 * @package com.bw.yq.Presenter
 * @date 2019/2/18 8:50
 */
public class ShowPresenter<T> {
         private Reference<T> mRefernce;
    private final ShowModel showModel;
    private final ShowView showView;


    public ShowPresenter(ShowView view){
        showModel = new ShowModel();
        showView = view;
    }
public void Accthach(T t){
        mRefernce=new WeakReference<T>(t);

}
    public void sendShow() {
        showModel.Show();
        showModel.OnShowListenter(new ShowModel.OnShowListenter() {
            @Override
            public void OnData(JSONArray data1) {
                showView.view(data1);
            }
        });
    }
    public void Xie(){
        if(Reference.class!=null){
            mRefernce.clear();
            mRefernce=null;

        }
    }
}
