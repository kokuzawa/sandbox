# WildFlyのイメージを取得
FROM jboss/wildfly:latest

# MAINTAINER
MAINTAINER Katsumi

# アプリケーションのデプロイ
COPY target/docker-wildfly-example.war /opt/jboss/wildfly/standalone/deployments/

# ポートの解放
EXPOSE 9999

# WildFlyの実行
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "--debug", "9999"]
