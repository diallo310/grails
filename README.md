# Projet GRAILS


Projet réalisé par **Ines NASR** et **Hawaou  DIALLO** pour l'unité d'enseignement "Serveur Grails" du master 2 MBDS 2018-2019.
Ce projet est encadré par **Mr Greg GALLI**

Sujet : [Création d’une plateforme de gestion de joueurs et résultats](http://cours.tokidev.fr/mbds/grails/tp_grails.pdf)

**Informations:**

- Serveur Web Apache pour stocker les images
- H2 pour la base de donnée


**Comptes:**

- **Administrateur**
  - username : admin
  - password: password
- **Joueur 1**
  - username: ines
  - password: ines
- **Joueur 2**
  - username: hawaou
  - password: hawaou
- **Joueur 3**
  - username: playerUser
  - password: playerUser
- **Joueur 4**
  - username: playerTwoUser
  - password: playerTwoUser


Pour la réalisation de notre projet nous avons implémenté deux type de rôle:

- **ROLE\_ADMIN** : pour les administrateurs
- **ROLE\_USER** : pour les autres utilisateurs

**Fonctionnalités implémentées:**

- Gestions des Utilisateurs :
  - Les administrateurs peuvent effectuer toutes le opérations de CRUD
  - Les joueurs qui ne sont pas administrateur peuvent se connecter et effectuer des opérations les concernant(voir leur match, message, modifier leur profile ,etc)
- Stockage des images des  utilisateurs via les formulaires dans le serveur Apache
- Affichage des images des  utilisateurs dans les différentes pages
- Flag sur les messages pour savoir s&#39;ils ont été lu (couleur bleu si un message n&#39;a pas été lu et noir s&#39;il a été lu)


**Bonus**

Cron fonctionnel pour purger les messages, toutes les nuits à 4h du matin.(class JobMessageService,MessageDataService)



**Modèle de données en fonction des contraintes et besoins du TP**



# Projet REST



