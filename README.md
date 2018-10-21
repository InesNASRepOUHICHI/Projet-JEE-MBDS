# Projet JEE - Gestion des comptes bancaires


Projet réalisé par **Ines NASR** et **Hawaou  DIALLO** pour l'unité d'enseignement "Composantes  Distribués  pour  l’Entreprise  (J2EE) " du master 2 MBDS 2018-2019.
Ce projet est encadré par **Mr Michel BUFFA**

Sujet : [réaliser  une  application  en  J2EE  de  gestion  de  comptes  bancaires](https://www.dropbox.com/sh/3ipivnnedcvdpya/AAAz22U5GdXXDqvX9vDdIPi1a?dl=0&preview=mini_projet.pdf)

**Description:**
Ce  mini  projet  s’inscrit  dans  la  suite  du  TP3dans  lequel  vous  devez  compléter  l’application  en  y  ajoutant  des  fonctionnalités  jugées  utiles.
Ces  fonctionnalités  doivent  forcément  découler  des  notions  vues  en  cours  comme  les  relations,  l’héritage  etc...

**Fonctionnalités:**
Les  fonctionnalités  à  développer  doivent  incluent,  mais  ne  se  limitent  pas  seulement  à ceux-là:
 - Ajout/Création  d’entités  métiers: Comptes  bancaires,  Personnes,  Clients,  Conseillers,  Administrateurs,  Opérations  
 - Consultations:Liste  des  comptes  (en  fonction  des  droits  de  l’utilisateur  connecté),  liste  des  clients,  liste  des  opérations  d’un  compte
 - Modifications/Suppressions:Possibilités  de  modifier  des  comptespar  exemple  pour  y  ajouter/enlever  un  co-propriétaire,  Modifier  des  personnes
 - Opérations:Permettre  d’effectuer  des  opérations  sur  un  compte  bancaire; ces  opérations  incluent  mais  ne  se  limitent  pas  seulement  à:retrait,  virement,  dépôt
 - Gestionde  comptes:création,  connexion,  gestion  de  rôles  
 
**Contraintes:**
 - Utilisertousles  types  de  relations  vus  en  cours: 1  à  1,  1  à  n  et  mà  n  
 - Utiliser  Primefaces  pour  la  création  des  interfaces,  exploiter  les  fonctions  de  filtrages,  d’ordonnancements, d’exports  en  pdf  et/ou  csv-Utiliser  deux  types  de  session  beans  
 - Utiliser  au  moins  deux  types  de  scope  dans  les  backend  bean 


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





