package com.bw.yq.presenter;

import com.bw.yq.activity.Main3Activity;
import com.bw.yq.model.RegisterModel;
import com.bw.yq.view.RegisterView;

/**
 * @author yaoqi
 * @fileName RegisterPresenter
 * @package com.bw.yq.presenter
 * @date 2019/2/17 15:49
 */
public class RegisterPresenter {

    private final RegisterModel registerModel;
    private final RegisterView registerView;

    public RegisterPresenter(RegisterView view){
        registerModel = new RegisterModel();
        registerView = view;
    }
    public void sendRegister(String name1, String pass1) {
        registerModel.Register(name1,pass1);
        registerModel.OnRegisterListenter(new RegisterModel.OnRegisterListenter() {
            @Override
            public void Onstat(String message, String status) {
                registerView.view(message,status);
            }
        });
    }
}
