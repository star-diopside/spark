package jp.gr.java_conf.stardiopside.ark.service;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import jp.gr.java_conf.stardiopside.ark.data.entity.User;
import jp.gr.java_conf.stardiopside.ark.service.dto.UserDto;
import jp.gr.java_conf.stardiopside.ark.service.userdetails.LoginUserDetails;

/**
 * ユーザ管理インタフェース
 */
@Validated
public interface UserService {

    /**
     * ユーザを作成する。
     * 
     * @param userDto ユーザ情報
     * @param mainRegistration 本登録の場合はtrue、仮登録の場合はfalse
     * @param authorities 権限名
     */
    void create(@Valid UserDto userDto, boolean mainRegistration, String... authorities);

    /**
     * 仮登録ユーザを作成する。
     * 
     * @param userDto ユーザ情報
     */
    void createTemporaryUser(@Valid UserDto userDto);

    /**
     * 取得したユーザ情報が有効かどうか判定する。
     * 
     * @param user ユーザエンティティ
     * @return 有効なユーザ情報と判定した場合はtrue、無効なユーザと判定した場合はfalse
     */
    boolean checkValid(User user);

    /**
     * ユーザを削除する。
     * 
     * @param user ユーザエンティティ
     */
    void remove(User user);

    /**
     * ユーザ状態を判定し、無効ユーザの場合は削除する。
     * 
     * @param loginUser ユーザ情報
     * @return 無効なユーザと判定して削除した場合はtrue、それ以外の場合はfalse
     */
    boolean removeInvalidUser(LoginUserDetails loginUser);

    /**
     * ログイン成功時の処理を行う。
     * 
     * @param loginUser ユーザ情報
     * @return 更新後のユーザエンティティ
     */
    User loginSuccess(LoginUserDetails loginUser);

    /**
     * ログイン失敗時の処理を行う。
     * 
     * @param userId ユーザID
     * @return 更新後のユーザエンティティ
     */
    User loginFailure(String userId);

    /**
     * ログアウト処理を行う。
     * 
     * @param loginUser ユーザ情報
     */
    void logout(LoginUserDetails loginUser);

    /**
     * 二重ログインチェックを行う。
     * 
     * @param loginUser ユーザ情報
     * @return 二重ログインエラーの場合はtrue、それ以外の場合はfalse。
     */
    boolean checkDualLogin(LoginUserDetails loginUser);

}
