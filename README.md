# Projet JEE - Gestion des comptes bancaires


Projet réalisé par **Ines NASR** et **Hawaou  DIALLO** pour l'unité d'enseignement **"Serveurs d’applications et java avancé (EJB,JPA,JMS...)"** du master 2 MBDS 2018-2019.
Ce projet est encadré par **Mr Michel BUFFA**

**Sujet :** [réaliser  une  application  en  J2EE  de  gestion  de  comptes  bancaires](https://www.dropbox.com/sh/3ipivnnedcvdpya/AAAz22U5GdXXDqvX9vDdIPi1a?dl=0&preview=mini_projet.pdf)

**Description:**
Ce  mini  projet  s’inscrit  dans  la  suite  du  TP3.

**Les différentes entités développés :**
- Personne
- Client
- Conseiller
- Operation
- CompteEpargne
- CompteCourant
- Administrateur
- Operation

**Fonctionnalités implémentées :**
- Administrateur
- Lister les conseillers;
- Créer un conseiller;
- Modifier un conseiller;
- Supprimer un conseiller.
      
**Conseiller**
- Lister des clients
- Créer un nouveau Compte bancaire
- Lister des  comptes bancaires
- Supprimer un compte
- Modifier certaines informations
- Exporter un compte au format csv

**Client**
- Lister ses comptes
- Effectuer des opérations (versement, retrait, virement)
- Lister ses opérations
- Exporter ses opérations au format csv

**Contraintes:**
 - Utilisation de tous les  types  de  relations  vus  en  cours: 1  à  1,  1  à  n  et  m à  n  
 - Utiliser  Primefaces  pour  la  création  des  interfaces:  exploitation  les  fonctions  de  filtrages,  d’ordonnancements, d’exports  en csv
 - Utiliser  deux  types  de  session  beans: **Singleton** et **Stateless**.
 - Utiliser  deux  types  de  scope  dans  les  backend  bean: **ViewScoped** et **RequestScoped**


**Comptes créés par défaut:**

------ | Username | Password
--------------- | ---------- | -------------
**Administrateur** | nasr@gmail.com | nasr
**Conseiller** | maxime@gmail.com | maxime
**Client** | ines@gmail.com | ines



Pour la réalisation de notre projet nous avons implémenté trois types de rôle:

- **ADMINISTRATEUR** : pour les administrateurs
- **CONSEILLER** : pour les conseillers de la banque
- **CLIENT** : pour un client ayant un ou plusieurs comptes bancaires




**Utilisation / Déploiement:**

 - Importer le projet sur Netbeans;
 - Créer une base de donnéé mySQL nommée **sample**;
 - Déployer le sur un serveur full-profile (GlassFish, JBoss...);
 - Exécuter le projet;
 - Tester les différentes fonctionnalités (Vous avez 3 comptes de départ décrits ci-dessus)



 
 
 
 
