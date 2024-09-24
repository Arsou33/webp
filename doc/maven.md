# Publish to Maven

https://central.sonatype.org/publish/publish-maven/

Add token information to your ~/.m2/settings.xml file:

```xml
<settings>
  <servers>
    <server>
      <id>ossrh</id>
      <username>token_user</username>
      <password>token_pass</password>
    </server>
  </servers>
</settings>
```
Token can be generated from https://oss.sonatype.org/#profile;User%20Token

A key pair has been generated and public key push to openpgp directory

```
brew install gpg
gpg --gen-key
# user: Arsouille
# email: a......@.....org
# passphrase: cf keypass
gpg --export a.....@......org | curl -T - https://keys.openpgp.org
```

In order to deploy only the parent this command can be used :
```
mvn --non-recursive deploy
```