package com.bw.yq.presenter;

import com.bw.yq.model.ShowModel;
import com.bw.yq.view.ShowView;

import org.json.JSONArray;

/**
 * @author yaoqi
 * @fileName ShowPresenter
 * @package com.bw.yq.presenter
 * @date 2019/2/17 16:18
 */
public class ShowPresenter {

    private final ShowModel showModel;
    private final ShowView showView;

    public ShowPresenter(ShowView view){
        showModel = new ShowModel();
        showView = view;
    }
    public void sendShow() {
        showModel.Show();
        showModel.OnShowListenter(new ShowModel.OnShowListenter() {
            @Override
            public void OnShow(JSONArray data) {
                showView.view(data);
            }
        });
    }
}
