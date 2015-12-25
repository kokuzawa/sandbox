# Roles Example

WildFly 9.0.1.Final で JdbcRealm を利用した認証をするサンプルです。  
WildFly の standalone.xml に下記の設定を追加する必要があります。

```xml
<security-domain name="app" cache-type="default">
    <authentication>
        <login-module name="app_auth" code="Database" flag="required">
            <module-option name="dsJndiName" value="java:jboss/datasources/ExampleDS"/>
            <module-option name="principalsQuery" value="SELECT PASSWORD FROM ACCOUNTS WHERE EMAIL = ?"/>
            <module-option name="rolesQuery" value="SELECT r.ROLENAME, 'Roles' FROM ROLES r, ACCOUNTS a WHERE r.ACCOUNTID = a.ACCOUNTID AND a.EMAIL = ?"/>
            <module-option name="hashAlgorithm" value="SHA-256"/>
            <module-option name="hashEncoding" value="base64"/>
        </login-module>
    </authentication>
</security-domain>
```

