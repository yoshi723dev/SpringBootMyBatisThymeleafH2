#### SpringBootMyBatisThymeleafH2

- 学習内容
  - spring boot
   - application.properties
    - server.portでportの設定が可能
   - 起動時にmasterテーブルにアクセスし、それ以降アクセスしないように設定
  - h2DB
   - resourceの下にDDLをschema.sql、DMLをdata.sqlという名前で配置すると起動時に自動登録される。
   - application.propertiesにspring.datasource.schema=classpath:schema.sql、spring.datasource.data=classpath:data.sqlの登録が必要。
   - h2データベースをlocalインストールしておかないと動作しない。
  - mybatis
  - thymeleaf
   - application.propertiesにspring.thymeleaf.cache=falseを指定することで再起動なしで反映される
