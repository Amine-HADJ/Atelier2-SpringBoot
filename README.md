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
    A[Client] -->|Demande d'inscription| B(Inscription);
    B -->|POST /api/user/register| C(UserController);
    C -->|Appel à UserService pour créer l'utilisateur et générer 5 cartes aléatoires| D(UserService);
    D -->|Appel à CardService pour générer 5 cartes aléatoires| E(CardService);
    E -->|Accès à la base de données pour enregistrer l'utilisateur et les cartes| F(Repository);
    F -->|Enregistrement de l'utilisateur et des cartes dans la base de données| F;
    F -->|Réponse d'inscription: succès ou échec| C;
    C -->|Réponse d'inscription| A;
    A -->|Demande d'authentification| G(Authentification);
    G -->|POST /api/user/login| H(UserController);
    H -->|Appel à UserService pour authentifier l'utilisateur| I(UserService);
    I -->|Accès à la base de données pour vérifier l'utilisateur| J(Repository);
    J -->|Vérification de l'authentification dans la base de données| J;
    J -->|Réponse d'authentification: succès ou échec| H;
    H -->|Réponse d'authentification| A;
    A -->|Demande d'achat de carte| K(Achat de carte);
    K -->|POST /api/card/buy| L(CardController);
    L -->|Appel à CardService pour acheter la carte| M(CardService);
    M -->|Accès à la base de données pour traiter l'achat| N(Repository);
    N -->|Traitement de l'achat dans la base de données| N;
    N -->|Réponse d'achat de carte: succès ou échec| L;
    L -->|Réponse d'achat de carte| A;
    A -->|Demande de vente de carte| O(Vente de carte);
    O -->|POST /api/card/sell| P(CardController);
    P -->|Appel à CardService pour vendre la carte| Q(CardService);
    Q -->|Accès à la base de données pour traiter la vente| R(Repository);
    R -->|Traitement de la vente dans la base de données| R;
    R -->|Réponse de vente de carte: succès ou échec| P;
    P -->|Réponse de vente de carte| A;

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

