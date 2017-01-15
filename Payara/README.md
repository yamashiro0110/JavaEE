# Payara Sample

Payaraを試す

> DBはh2データベースをサーバモードで起動しておく

### entry point

- `sample.payara.Application`

### JPA

- `src/main/resources/META-INF/persistence.xml`

### Glassfish

*resource*

`src/main/webapp/WEB-INF/glassfish-resources.xml`

glassfishを起動した状態で以下を実行してJDBCリソースを登録する

```sh
$ asadmin add-resources src/main/webapp/WEB-INF/glassfish-resources.xml
```

*deploy*

buildしたwarファイルをdeployする

```sh
$ asadmin deploy build/libs/Payara.war
```

```sh
$ asadmin undeploy ${domain_name}
```

*start*

Applicationを起動する

```sh
$ asadmin start-domain domain1
```

### MyBatis

- `src/main/resources/mybatis-config.xml`
