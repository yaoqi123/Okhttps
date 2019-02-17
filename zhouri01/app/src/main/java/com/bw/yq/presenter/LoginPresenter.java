package com.bw.yq.presenter;

import com.bw.yq.model.LoginModel;
import com.bw.yq.view.LoginView;

/**
 * @author yaoqi
 * @fileName LoginPresenter
 * @package com.bw.yq.presenter
 * @date 2019/2/17 15:11
 */
public class LoginPresenter {

    private final LoginModel loginModel;
    private final LoginView loginView;

    public LoginPresenter(LoginView view){

        loginModel = new LoginModel();
        loginView = view;

    }
    public void sendLogin(String name, String pass) {

        loginModel.Login(name,pass);
        loginModel.OnLoginListenter(new LoginModel.OnLoginListenter() {
            @Override
            public void OnStats(String status) {
                loginView.view(status);
            }
        });
    }
}
