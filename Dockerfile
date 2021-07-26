FROM maven:3.3-jdk-8
ENV MY_HOME=/usr/src/app
RUN mkdir -p $MY_HOME
WORKDIR $MY_HOME
ADD pom.xml $MY_HOME
ADD . $MY_HOME
RUN ["/usr/local/bin/mvn-entrypoint.sh"]


