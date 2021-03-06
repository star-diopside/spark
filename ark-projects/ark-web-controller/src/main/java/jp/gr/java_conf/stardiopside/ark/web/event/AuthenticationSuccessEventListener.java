package jp.gr.java_conf.stardiopside.ark.web.event;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

import jp.gr.java_conf.stardiopside.ark.data.entity.User;
import jp.gr.java_conf.stardiopside.ark.service.UserService;
import jp.gr.java_conf.stardiopside.ark.service.userdetails.LoginUserDetails;

@Named
@Singleton
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private final UserService userService;

    public AuthenticationSuccessEventListener(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        // 認証成功時の処理を行う。
        LoginUserDetails loginUser = (LoginUserDetails) event.getAuthentication().getPrincipal();
        User user = userService.loginSuccess(loginUser);

        // ログイン情報を更新する。
        loginUser.update(loginUser, user);
    }
}
