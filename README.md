# Interbanking API

API para gestionar :

- Empresas que hicieron transferencias el último mes

- Empresas que se adhirieron el último mes.

- Adhesión de una empresa.

## 📋 Requisitos previos

Asegúrate de tener instalado:

- [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven 3.6+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)
- Mysql
- Lombok
- SpringDoc Open Api

O utilizar intellijIdea

## 📌 Endpoints principales
Documentado con springdoc url :

http://localhost:8080/swagger-ui/index.html

| Método | Endpoint | Descripción |
|--------|---------|------------|
| `POST` | `/api/companies` | Crea compañias |
| `GET` | `/api/companies/adhered/last-month` | Trae las compañias adheridas el último mes |
| `GET` | `/api/companies/transfers/last-month` | Trae las compañias que realizaron una transferncia el último mes |

## 🚀 Instalación y ejecución

Clona el repositorio:

git clone https://github.com/pjod2212/interbanking-api.git
cd interbanking-api
mvn clean install

---
**Desarrollado por [Pablo Donati](https://github.com/pjod2212)**
