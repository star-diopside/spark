
/* Drop Tables */

DROP TABLE IF EXISTS AUTHORITIES;
DROP TABLE IF EXISTS USERS;




/* Create Tables */

CREATE TABLE AUTHORITIES
(
	USER_ID VARCHAR(32) NOT NULL,
	AUTHORITY VARCHAR(50) NOT NULL,
	CREATED_AT TIMESTAMP NOT NULL,
	CREATED_USER_ID VARCHAR(32) NOT NULL,
	UPDATED_AT TIMESTAMP NOT NULL,
	UPDATED_USER_ID VARCHAR(32) NOT NULL,
	VERSION INT NOT NULL,
	PRIMARY KEY (USER_ID, AUTHORITY)
) WITHOUT OIDS;


CREATE TABLE USERS
(
	USER_ID VARCHAR(32) NOT NULL,
	USERNAME VARCHAR(32) NOT NULL,
	PASSWORD CHAR(80) NOT NULL,
	PASSWORD_UPDATED_AT TIMESTAMP NOT NULL,
	ENABLED BOOLEAN NOT NULL,
	HIGH_GRADE_REGISTRY BOOLEAN NOT NULL,
	LOGIN_ERROR_COUNT INT NOT NULL,
	LOCKOUT_AT TIMESTAMP,
	LAST_LOGIN_AT TIMESTAMP,
	LOGOUT_AT TIMESTAMP,
	CREATED_AT TIMESTAMP NOT NULL,
	CREATED_USER_ID VARCHAR(32) NOT NULL,
	UPDATED_AT TIMESTAMP NOT NULL,
	UPDATED_USER_ID VARCHAR(32) NOT NULL,
	VERSION INT NOT NULL,
	PRIMARY KEY (USER_ID)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE AUTHORITIES
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERS (USER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Comments */

COMMENT ON TABLE AUTHORITIES IS '権限';
COMMENT ON COLUMN AUTHORITIES.USER_ID IS 'ユーザID';
COMMENT ON COLUMN AUTHORITIES.AUTHORITY IS '権限';
COMMENT ON COLUMN AUTHORITIES.CREATED_AT IS '登録日時';
COMMENT ON COLUMN AUTHORITIES.CREATED_USER_ID IS '登録ユーザID';
COMMENT ON COLUMN AUTHORITIES.UPDATED_AT IS '更新日時';
COMMENT ON COLUMN AUTHORITIES.UPDATED_USER_ID IS '更新ユーザID';
COMMENT ON COLUMN AUTHORITIES.VERSION IS 'バージョン';
COMMENT ON TABLE USERS IS 'ユーザ';
COMMENT ON COLUMN USERS.USER_ID IS 'ユーザID';
COMMENT ON COLUMN USERS.USERNAME IS 'ユーザ名';
COMMENT ON COLUMN USERS.PASSWORD IS 'パスワード';
COMMENT ON COLUMN USERS.PASSWORD_UPDATED_AT IS 'パスワード更新日時';
COMMENT ON COLUMN USERS.ENABLED IS '有効フラグ';
COMMENT ON COLUMN USERS.HIGH_GRADE_REGISTRY IS '本登録フラグ';
COMMENT ON COLUMN USERS.LOGIN_ERROR_COUNT IS 'ログインエラー回数';
COMMENT ON COLUMN USERS.LOCKOUT_AT IS 'ロックアウト日時';
COMMENT ON COLUMN USERS.LAST_LOGIN_AT IS '最終ログイン日時';
COMMENT ON COLUMN USERS.LOGOUT_AT IS 'ログアウト日時';
COMMENT ON COLUMN USERS.CREATED_AT IS '登録日時';
COMMENT ON COLUMN USERS.CREATED_USER_ID IS '登録ユーザID';
COMMENT ON COLUMN USERS.UPDATED_AT IS '更新日時';
COMMENT ON COLUMN USERS.UPDATED_USER_ID IS '更新ユーザID';
COMMENT ON COLUMN USERS.VERSION IS 'バージョン';



