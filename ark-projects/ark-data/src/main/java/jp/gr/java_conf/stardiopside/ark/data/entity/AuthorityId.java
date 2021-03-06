package jp.gr.java_conf.stardiopside.ark.data.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 権限主キークラス
 */
@Data
@SuppressWarnings("serial")
public class AuthorityId implements Serializable {

    /** ユーザID */
    private String userId;

    /** 権限 */
    private String authority;

}
