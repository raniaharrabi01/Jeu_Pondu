Description du Jeu de Pendu
Le jeu de pendu est une application Java interactive où les joueurs doivent deviner un mot caché en un nombre limité de tentatives (6 essais).
À chaque erreur, une partie du dessin du pendu est ajoutée. L’objectif est de deviner le mot avant que le dessin ne soit complet.

Voici une description claire et concise des deux classes de test JUnit à inclure dans votre README.md ou votre projet GitHub :

Tests du Jeu de Pendu avec JUnit
Le projet comprend deux classes de tests JUnit essentielles pour valider les fonctionnalités principales du jeu de pendu. 
Ces tests assurent la fiabilité et la cohérence des règles avant et pendant le déroulement d'une partie.

1. Classe de Test : Validation du Nom d'Utilisateur
Cette classe teste la validité du nom d'utilisateur saisi avant le démarrage du jeu.
Les validations incluent :
Caractères alphabétiques uniquement : Le nom ne peut contenir que des lettres.
Non nullité : Le champ du nom ne peut pas être vide ou nul.
Objectif : Garantir que le joueur entre un nom valide pour commencer une partie.

3. Classe de Test : Gestion des Tentatives et du Score
Cette classe teste les interactions du joueur pendant une partie, en fixant le mot recherché à "Test".
Elle valide :
Nombre de tentatives restantes : Réduction correcte des essais en cas de mauvaise réponse.
Mise à jour du score : Incrémentation du score pour chaque lettre correctement devinée.
Affichage des résultats :
Si une lettre correcte est proposée, elle est révélée dans l’interface.
Si une lettre incorrecte est proposée, les essais restants sont affichés.
Objectif : S'assurer que les règles du jeu sont respectées, y compris le suivi des tentatives et la gestion du score.

Les Interfaces du Jeu :

![image](https://github.com/user-attachments/assets/f36f88a4-f2d9-4c42-811f-70db01db7512)
![image](https://github.com/user-attachments/assets/a779755b-2528-4f2b-8372-ce7084991e84)
![image](https://github.com/user-attachments/assets/1534d61a-d316-4462-b281-1f1a8f6fd89f)
![image](https://github.com/user-attachments/assets/3d741772-15f9-4d3e-a765-956ff1c77808)
![image](https://github.com/user-attachments/assets/2dfd71fe-5ba5-4c80-a370-2ac8cd326431)
![image](https://github.com/user-attachments/assets/cd2f0dac-af49-4435-af09-ffdd178f7b40)
![image](https://github.com/user-attachments/assets/8a03443e-248e-41c3-aaa2-4c48212147db)
