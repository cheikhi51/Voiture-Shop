# Application Spring Boot + React avec Monitoring

Une application complète de gestion de voitures développée avec Spring Boot (backend), React (frontend), et monitorée avec Prometheus et Grafana.

Voici le lien vers le repo du frontend : 

## 🏗️ Architecture

- **Backend**: Spring Boot avec Spring Data REST, Spring Security
- **Base de données**: MariaDB
- **Frontend**: React avec React Bootstrap
- **Monitoring**: Prometheus + Grafana
- **Containerisation**: Docker + Docker Compose

## 📁 Structure du projet
SpringDataRest/
├── src/ # Code source Spring Boot
├── monitoring/ # Configuration monitoring
│ ├── prometheus.yml # Configuration Prometheus
│ └── grafana/
│ └── datasources/
│ └── prometheus.yml # Datasource Grafana
├── docker-compose.full.yml # Docker Compose complet
├── Dockerfile # Image Docker backend
└── README.md

reactSpringApp/ # Projet React frontend
├── src/
├── nginx.conf # Configuration Nginx
└── Dockerfile # Image Docker frontend

## 🚀 Services déployés

| Service | Port | URL | Description |
|---------|------|-----|-------------|
| Frontend React | 3000 | http://localhost:3000 | Application web |
| Backend Spring Boot | 8081 | http://localhost:8081/api | API REST |
| Métriques Actuator | 8081 | http://localhost:8081/actuator | Endpoints de monitoring |
| MariaDB | 3306 | localhost:3306 | Base de données |
| Prometheus | 9090 | http://localhost:9090 | Collecte de métriques |
| Grafana | 3001 | http://localhost:3001 | Dashboard de monitoring |

## 🔧 Prérequis

- Docker Desktop
- Java 17+
- Node.js 18+
- Maven 3.9+

## 🛠️ Installation et déploiement

### Option 1: Déploiement complet avec Docker Compose

```bash

# Démarrer tous les services
docker-compose -f docker-compose.full.yml up -d --build

# Vérifier le statut des services
docker-compose -f docker-compose.full.yml ps

# Arrêter les services
docker-compose -f docker-compose.full.yml down

# Lancer l'application Spring Boot depuis IntelliJ
# L'application sera disponible sur http://localhost:8081

#Pour la partie frontend
# Installer les dépendances
npm install

# Démarrer en mode développement
npm run dev
# L'application sera disponible sur http://localhost:5173

```
## Accès aux dashboards
Prometheus: http://localhost:9090

Vérifier les targets sous Status → Targets

Exécuter des requêtes PromQL

Grafana: http://localhost:3001

Identifiants: admin/admin

Datasource: Prometheus (pré-configuré)

Créer des dashboards personnalisés

🔌 API Endpoints
Gestion des voitures
Méthode	Endpoint	Description
GET	/api/voitures	Liste toutes les voitures
GET	/api/voitures/{id}	Récupère une voiture par ID
POST	/api/voitures	Ajoute une nouvelle voiture
DELETE	/api/voitures/{id}	Supprime une voiture
