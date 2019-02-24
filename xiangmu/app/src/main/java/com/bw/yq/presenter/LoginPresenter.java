package com.bw.yq.presenter;

import com.bw.yq.model.LoginModel;
import com.bw.yq.view.LoginView;

/**
 * @author yaoqi
 * @fileName LoginPresenter
 * @package com.bw.yq.presenter
 * @date 2019/2/18 19:26
 */
public class LoginPresenter {

    private final LoginModel loginModel;
    private final LoginView loginView;

    public LoginPresenter(LoginView view){
        loginModel = new LoginModel();
        loginView = view;
    }
    public void sendShow(String name, String pass) {
        loginModel.Show(name,pass);
        loginModel.setOnLoginModelListenter(new LoginModel.OnLoginModelListenter() {
            @Override
            public void OnStatus(String status) {
                loginView.view(status);
            }
        });

    }
}
