FROM java:8
#持久化到指定目录
VOLUME /tmp
# 将工程jar包（eureka-service-1.0-SNAPSHOT.jar）拷贝到 app.jar中
ADD target/eureka-1.0-SNAPSHOT.jar eureka.jar
EXPOSE  8100
# 执行jar包
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]