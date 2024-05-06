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


## Schéma de l'Architecture :
```mermaid
graph TD;
    A[Client] -->| Demande d'inscription| B(Inscription);
    B -->|POST /api/user/register| C(UserController);
    C -->|Appel à UserService pour créer l'utilisateur| D(UserService);
    D -->|Accès à la base de données pour enregistrer l'utilisateur| E(Repository);
    E -->|Enregistrement de l'utilisateur dans la base de données| E;
    E -->|Réponse d'inscription: succès ou échec| C;
    C -->|Réponse d'inscription| A;
    A -->|Demande d'authentification| F(Authentification);
    F -->|POST /api/user/login| G(UserController);
    G -->|Appel à UserService pour authentifier l'utilisateur| H(UserService);
    H -->|Accès à la base de données pour vérifier l'utilisateur| I(Repository);
    I -->|Vérification de l'authentification dans la base de données| I;
    I -->|Réponse d'authentification: succès ou échec| G;
    G -->|Réponse d'authentification| A;
    A -->|Demande d'achat de carte| J(Achat de carte);
    J -->|POST /api/card/buy| K(CardController);
    K -->|Appel à CardService pour acheter la carte| L(CardService);
    L -->|Accès à la base de données pour traiter l'achat| M(Repository);
    M -->|Traitement de l'achat dans la base de données| M;
    M -->|Réponse d'achat de carte: succès ou échec| K;
    K -->|Réponse d'achat de carte| A;
    A -->|Demande de vente de carte| N(Vente de carte);
    N -->|POST /api/card/sell| O(CardController);
    O -->|Appel à CardService pour vendre la carte| P(CardService);
    P -->|Accès à la base de données pour traiter la vente| Q(Repository);
    Q -->|Traitement de la vente dans la base de données| Q;
    Q -->|Réponse de vente de carte: succès ou échec| O;
    O -->|Réponse de vente de carte| A;
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

