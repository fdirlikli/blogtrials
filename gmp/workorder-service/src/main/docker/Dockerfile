FROM java:8
ADD workorderservice-0.0.1-SNAPSHOT.jar app.jar
ADD wait-for-it.sh wait-for-it.sh
RUN bash -c 'touch /app.jar'
RUN bash -c 'chmod 777 /wait-for-it.sh'



