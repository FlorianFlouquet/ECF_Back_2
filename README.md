# Localib dockerisation de l'application

## 🐧 Table des matières
* [Infos Générales](#infos-générales)
* [Prérequis](#prérequis)
* [Installation](#installation)
* [Usage](#usage)
* [Chemins des requêtes](#chemins-des-requêtes)
* [Formats des entités](#formats-des-entités)

## ⭕ Infos Générales
Ce projet pour but de dockeriser l'application Localib.

## 🚩 Prérequis
- Java 11+
- Docker desktop
- IDE (IntelliJ IDEA)
- Postman
- Spring 2.6.1 (if you wish to use Swagger)
- Maven

## 🔨 Installation

Vous devez tout d'abord cloner le projet sur votre machine à l'aide de la commande suivante (à entrer dans un CLI):
```bash
git clone https://github.com/FlorianFlouquet/ECF_Back_2.git
cd ECF_Back_2
```

Une fois à l'intérieur vous pouvez lancer la commande suivante qui lancera la dockerisation de l'application:
```bash
docker-compose up -d
```

Vous pouvez désormais cliquer [ici](http://localhost:3000) pour accéder au site.

## 🚀 Usage

A travers [Postman](https://www.postman.com/) vous pouvez les requêtes présentées ci-dessous.

### 💡 Chemins des requêtes

```

LOCATAIRES
- FIND all : /users (GET)
- FIND one : /users/id (GET)
- CREATE : /users (POST)
- DELETE one : /users/id (DELETE)
- UPDATE one : /users/id (PUT)
- SEARCH by firstname : /users/search?firstname=firstname
- SEARCH by surname : /users/search?surname=surname

VEHICULES
- FIND all : /vehicles (GET)
- FIND one : /vehicles/id (GET)
- CREATE one : /vehicles (POST)
- DELETE one : /vehicles/id (DELETE)
- UPDATE one : /vehicles/id (PUT)
- SEARCH by brand : /users/search?brand=brand
- SEARCH by model : /users/search?model=model
- SEARCH by availability : /users/search?availability=availability
- SEARCH by type : /users/search?type=type

LOCATIONS
- FIND all : /rentals (GET)
- FIND one : /rentals/id (GET)
- CREATE : /rentals (POST)
- DELETE one : /rentals/id (DELETE)

DEBUGG
- CLEAR database : /debugg/clear (DELETE)
- INITIALIZE database with a few entities : /debugg/init (POST)
```

## 💡 Formats des entités
```
LOCATAIRE
* id String
* surname String
* firstname String
* birthdate LocalDate (format = yyyy-MM-dd)
* email String
* phoneNumer String

VEHICULE
* id String
* brand String
* model String
* state String
* licenseNumber String
* type String
* price Double
* available boolean

LOCATION
* id String
* renter User
* vehicle Vehicle
* dateStart LocalDate (format = yyyy-MM-dd)
* dateEnd LocalDate (format = yyyy-MM-dd)
```

