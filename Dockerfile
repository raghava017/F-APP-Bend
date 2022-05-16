# stage 1
FROM maven:3.6.3-jdk-11 AS backend 
WORKDIR /app 
COPY ..
RUN mvn install

# stage 2
FROM amazoncorretto:11
WORKDIR /tmp
RUN tum update -y && yum install -y python3-pip && pip3 install awscli --upgrade --user && yum install -y awslogs
COPY --from=backend /app/target/tmp 
COPY --from=backend /app/start.sh /tmp
WORKDIR /tmp
RUN ls -l
ENV profile=${profile}
RUN chmod +x /tmp/start.sh
ENTRYPOINT ["/tmp/start.sh"]
EXPOSE 8097