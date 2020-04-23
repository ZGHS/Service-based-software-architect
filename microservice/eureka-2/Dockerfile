FROM java:8
#持久化到指定目录
VOLUME /tmp
# 将工程jar包（eureka-service-1.0-SNAPSHOT.jar）拷贝到 app.jar中
ADD target/eureka-2-1.0-SNAPSHOT.jar app.jar
EXPOSE  9100
# 执行jar包
ENTRYPOINT ["java","-jar","/app.jar"]