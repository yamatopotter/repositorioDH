FROM openjdk:17
COPY target/movie-service.jar app.jar
COPY wait-for-it.sh /wait-for-it.sh
# Defina as permissões de execução para o script
RUN chmod +x /wait-for-it.sh
# Execute o wait-for-it.sh antes de iniciar o aplicativo
CMD ["/bin/bash", "-c", "/wait-for-it.sh config-service:8888 --timeout=60 --strict -- java -jar app.jar"]
EXPOSE 8098
