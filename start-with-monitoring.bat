@echo off
echo Construction et démarrage de l'application complète...

echo Building backend...
docker build -t spring-boot-backend .

echo Building frontend...
cd C:/Users/cheik/reactSpringApp
docker build -t react-frontend .
cd ..\SpringDataRest

echo Démarrage des services...
docker-compose -f docker-compose.full.yml up -d

echo.
echo ===============================================
echo Application déployée avec succès!
echo ===============================================
echo Frontend: http://localhost:5173
echo Backend API: http://localhost:8081/api
echo Métriques: http://localhost:8082/actuator
echo Prometheus: http://localhost:9090
echo Grafana: http://localhost:3001 (admin/admin)
echo MariaDB: localhost:3306
echo ===============================================
pause