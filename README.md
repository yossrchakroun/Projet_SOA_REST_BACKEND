pour le backend de projet REST SOA de gestion de campus on a choisit le Rest et pas d'autre puisqu'il nous permet de tester des services web
facile à manipuler pour ce type de projet grace aux requetes json.

Donc pour realiser ce projet on a utilisé le serveur tomcat qui va nous donner l'url de base de notre application.

Donc commencant par le backend qui est une API REST utilise jakarta EE et qui s'agit d'une architecture en couche dont on'a la couche model 
qui presente les entités et les tables de la base de données dont on'a dans notre base la table client , chambre et reservation .
La couche Controller qui definit les methodes de CRUD appliquées et les url specifiques pour chaque methode.
et concernant la couche DAO, c'est le coeur de notre projet presentant la logique metier qui va etre appliquée sur les entités de la base de données.

Pour la creation et la configuration de la  base de données on a utilisé mysql dont la configuration est effectuée par la dependance de mysql-connector.
Et la connexion est verifiée avec la classe presistence qui contient l'authentfication de la base de données.

Concernant les dependances, on a utlisé JAX-RS/Jursey Container : qui est une specification de Jakarta EE pour creer des services Rest en java
qui est aussi l'intermediaire entre tomcat et les resources rest autrement dit entre l'url general et les url specifiques
on a utlisé aussi jakarta ws-rs-api : qui est responsable des annotations et des interfaces.
de meme on avait besoin de dependances de json pour les requetes et kes dependances json.
