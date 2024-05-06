# Atelier2-SpringBoot

## Concepts :
Différentes architectures de conception logicielle
- MVC
- SOA
- MicroService

Avantages/inconvénients des architectures
- Services Web Full Rest
- Gestionnaires de dépendances (basique)

Techno :
- Maven
- Spring boot
- Javascript, AJAX


## Schéma de l'Architecture (haut niveau) :
```mermaid
graph LR
    A[Client]
    B[UserController]
    C[AuthController]
    D[MarketController]
    E[UserService]
    F[AuthService]
    G[MarketService]
    H[UserRepo]
    I[CardRepo]
    J[InventoryRepo]
    K[CardService]
    L[DataFormatter]

    A -- Inscription --> B
    B -- Créer utilisateur --> E
    E -- Enregistrer utilisateur --> H
    E -- Générer cartes --> K
    K -- Récupérer cartes --> I
    E -- Mettre à jour inventaire --> J
    E -- Formatter données utilisateur --> L
    B -- Réponse inscription --> A

    A -- Authentification --> C
    C -- Vérifier utilisateur --> F
    F -- Vérifier authentification --> H
    C -- Réponse authentification --> A

    A -- Achat carte --> D
    D -- Acheter carte --> G
    G -- Traiter achat --> I
    G -- Mettre à jour inventaire --> J
    G -- Formatter données carte --> L
    D -- Réponse achat --> A

    A -- Vente carte --> D
    D -- Vendre carte --> G
    G -- Traiter vente --> J
    G -- Mettre à jour carte --> I
    G -- Formatter données carte --> L
    D -- Réponse vente --> A

```

## Schéma de l'Architecture (bas niveau) :
```mermaid
sequenceDiagram
participant Client
participant UserController
participant UserService
participant CardService
participant UserRepo
participant CardRepo
participant InventoryRepo
participant AuthController
participant AuthService
participant MarketController
participant MarketService
participant DataFormatter

Client->>UserController: POST /api/user/register
UserController->>UserService: Appel à UserService pour créer l'utilisateur
UserService->>UserRepo: Accès à la base de données pour enregistrer l'utilisateur
UserRepo-->>UserService: Enregistrement de l'utilisateur dans la base de données
UserService->>CardService: Appel à CardService pour générer 5 cartes aléatoires
CardService->>CardRepo: Accès à la base de données pour récupérer 5 cartes
CardRepo-->>CardService: Retour des cartes
CardService-->>UserService: Retour des cartes générées
UserService->>InventoryRepo: Accès à la base de données pour mettre à jour l'inventaire de l'utilisateur
InventoryRepo-->>UserService: Mise à jour de l'inventaire de l'utilisateur dans la base de données
UserService-->>DataFormatter: Appel à DataFormatter pour formatter les données de l'utilisateur
DataFormatter-->>UserService: Données de l'utilisateur formatées
UserService-->>UserController: Réponse d'inscription: succès ou échec
UserController-->>Client: Réponse d'inscription

Client->>AuthController: POST /api/auth/login
AuthController->>AuthService: Appel à AuthService pour authentifier l'utilisateur
AuthService->>UserRepo: Accès à la base de données pour vérifier l'utilisateur
UserRepo-->>AuthService: Vérification de l'authentification dans la base de données
AuthService-->>AuthController: Réponse d'authentification: succès ou échec
AuthController-->>Client: Réponse d'authentification

Client->>MarketController: POST /api/market/buy
MarketController->>MarketService: Appel à MarketService pour acheter la carte
MarketService->>CardRepo: Accès à la base de données pour traiter l'achat
CardRepo-->>MarketService: Traitement de l'achat dans la base de données
MarketService->>InventoryRepo: Accès à la base de données pour mettre à jour l'inventaire de l'utilisateur
InventoryRepo-->>MarketService: Mise à jour de l'inventaire de l'utilisateur dans la base de données
MarketService-->>DataFormatter: Appel à DataFormatter pour formatter les données de la carte
DataFormatter-->>MarketService: Données de la carte formatées
MarketService-->>MarketController: Réponse d'achat de carte: succès ou échec
MarketController-->>Client: Réponse d'achat de carte

Client->>MarketController: POST /api/market/sell
MarketController->>MarketService: Appel à MarketService pour vendre la carte
MarketService->>InventoryRepo: Accès à la base de données pour traiter la vente
InventoryRepo-->>MarketService: Traitement de la vente dans la base de données
MarketService->>CardRepo: Accès à la base de données pour mettre à jour la carte vendue
CardRepo-->>MarketService: Mise à jour de la carte vendue dans la base de données
MarketService-->>DataFormatter: Appel à DataFormatter pour formatter les données de la carte
DataFormatter-->>MarketService: Données de la carte formatées
MarketService-->>MarketController: Réponse de vente de carte: succès ou échec
MarketController-->>Client: Réponse de vente de carte
```


## Architecture Logicielle:

Frontend (JavaScript + AJAX) :
- Utilisera JavaScript pour la logique client.
- Les appels AJAX seront utilisés pour communiquer avec les services Web REST côté serveur.
- Interface utilisateur (UI) pour l'inscription, la connexion, l'achat et la vente de cartes.

## Backend (Spring Boot) :
Controllers :
- UserController : Gère les requêtes liées à l'inscription et l'authentification des utilisateurs.
- CardController : Gère les requêtes liées à l'achat et la vente de cartes.
    
Services :
- UserService : Contient la logique métier pour la création d'utilisateurs et la gestion de l'authentification.
- CardService : Gère la logique métier pour l'achat, la vente et la génération de cartes.

Repository :
Contient les interfaces pour interagir avec la base de données.

Base de Données :
  Stockage des informations sur les utilisateurs, les cartes disponibles, les transactions, etc.

## Avantages et Inconvénients de l'Architecture :
Avantages :
- Une structure bien organisée avec une séparation claire des préoccupations.
- Les controllers agissent comme des points d'entrée pour les requêtes HTTP et délèguent le travail aux services.
- Les services contiennent la logique métier, ce qui rend le code facilement testable et évolutif.
  
Inconvénients :
- Une gestion précise des dépendances entre les composants est nécessaire pour éviter les problèmes de dépendances circulaires.


## Détails de l'Implémentation :
- UserController :
  Endpoints pour l'inscription (POST /api/user/register) et l'authentification (POST /api/user/login).

- CardController :
  Endpoints pour acheter (POST /api/card/buy) et vendre (POST /api/card/sell) des cartes.

- UserService :
  Méthodes pour créer un utilisateur (registerUser) et authentifier un utilisateur (loginUser).

- CardService :
  Méthodes pour acheter (buyCard), vendre (sellCard) et générer automatiquement des cartes (generateCards).

