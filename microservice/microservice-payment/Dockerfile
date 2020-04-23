FROM java:8
#持久化到指定目录
VOLUME /tmp
# 将工程jar包（eureka-service-1.0-SNAPSHOT.jar）拷贝到 app.jar中
ADD target/microservice-payment.jar app.jar
EXPOSE  8084
# 执行jar包
ENTRYPOINT ["java","-jar","/app.jar"]