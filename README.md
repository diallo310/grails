# Projet GRAILS


Projet réalisé par **Ines NASR** et **Hawaou  DIALLO** pour l'unité d'enseignement "Serveur Grails" du master 2 MBDS 2018-2019.
Ce projet est encadré par **Mr Greg GALLI**

Sujet : [Création d’une plateforme de gestion de joueurs et résultats](http://cours.tokidev.fr/mbds/grails/tp_grails.pdf)

**Informations:**

- Serveur Web Apache pour stocker les images
- H2 pour la base de donnée


**Comptes:**

------ | Username | Password
--------------- | ---------- | -------------
**Administrateur** | admin | password
**Joueur 1** | ines | ines
**Joueur 2** | hawaou | hawaou
**Joueur 3** | playerUser | playerUser
**Joueur 4** | playerTwoUser | playerTwoUser



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

![Modèle de données en fonction des contraintes et besoins du TP](/Documentation/Images/Modele_Donnees.png)



# Projet REST

Dans les 3 tableaux ci-dessous nous présentons les différents services de notre API REST et les possibles réponses http.
L’objectif de ce projet est de concevoir et implémenter une API REST. Pour l'implémentation de l’API nous avons utilisé le Framework Grails.
Le modèle de donnée de l’API est composée de trois entités(User,Message,Match).

**1.	Ressource « User »**

L’entité User est composée des attributs suivants
- Id
- username
- Password
- Image
- enabled
- accountExpired
- accountLocked
- passwordExpired

![Ressource User](/Documentation/Images/Ressource_User.png)


**2.	Ressource « Match »**
L'entité Match est composée des attributs suivants
- winner
- winnerScore
- looser
- looserScore

![Ressource Message](/Documentation/Images/Ressource_Message.png)

**3.	Ressource « Message »**
L’entité Message est composée des attributs suivants
- author
- target
- content
- isRead

![Ressource Match](/Documentation/Images/Ressource_Match.png)



**Procédure de Test**
Nous avons utilisé une collection Postman. Pour chaque ressource, nous avons créé plusieurs scénarios pour les différentes réponses http possibles.

**Bonus**
Utilisation de Spring Security et son extension pour la mise en place dans le cadre d’une API REST : nous avons importé les deux plugins spring-security-core et spring-security-rest dans le fichier build.gradle. Après nous avons configuré à la main les accès aux différents services des ressources exposées dans le fichier application.groovy
``
compile "org.grails.plugins:spring-security-core:3.2.3"

compile "org.grails.plugins:spring-security-rest:2.0.0.RC1"
``




