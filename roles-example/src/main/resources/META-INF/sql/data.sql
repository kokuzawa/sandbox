-- PASSWORDは'test'
-- 下記コマンドでSHA-256でハッシュ値に変換して登録
-- java -cp $JBOSS_HOME/modules/system/layers/base/org/picketbox/main/picketbox-4.9.2.Final.jar org.jboss.security.Base64Encoder test SHA-256
INSERT INTO ACCOUNTS (EMAIL, PASSWORD) VALUES ('hoge', 'n4bQgYhMfWWaL+qgxVrQFaO/TxsrC4Is0V1sFbDwCgg=');
INSERT INTO ROLES (ROLENAME, ACCOUNTID) VALUES ('MEMBER', 1);
