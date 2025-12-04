## Kata SOLID

Ce dépôt propose 5 mini-katas (un par principe SOLID).  
Chaque package contient du code volontairement en infraction avec le principe cible, mais les tests couvrent le comportement métier pour sécuriser vos refactorings.

### Démarrer
- Prérequis : Java 25, Maven 3.9+.
- Lancer tous les tests : `mvn test`

### Organisation
- SRP : `src/main/java/fr/kata/solid/srp` — reçu de caisse qui calcule, formate et persiste tout seul.
- OCP : `src/main/java/fr/kata/solid/ocp` — calcul de remises avec un `switch` à rallonge.
- LSP : `src/main/java/fr/kata/solid/lsp` — un manchot qui casse la hiérarchie `Bird`.
- ISP : `src/main/java/fr/kata/solid/isp` — une interface `Worker` trop lourde pour les robots.
- DIP : `src/main/java/fr/kata/solid/dip` — un service de notification couplé à des clients concrets.

### SOLID
En programmation orientée objet, SOLID est un acronyme mnémonique qui regroupe cinq principes de conception destinés à produire des architectures logicielles plus compréhensibles, flexibles et maintenables. Les principes sont un sous-ensemble de nombreux principes promus par l'ingénieur logiciel et instructeur américain Robert C. Martin.

Bien qu'ils s'appliquent à toute conception orientée objet, les principes SOLID peuvent également former une philosophie de base pour des méthodologies telles que le développement agile ou le développement de logiciels adaptatifs.

La théorie des principes SOLID a été introduite par Martin dans son article Design Principles and Design Patterns de 2000, bien que l'acronyme SOLID ait été introduit plus tard par Michael Feathers.

#### Principes
##### Responsabilité unique (Single responsibility principle)
une classe, une fonction ou une méthode doit avoir une et une seule unique raison d'être. Cela favorise la modularité et facilite la maintenance en évitant les classes surchargées de responsabilités.
##### Ouvert/fermé (Open/closed principle)
une entité applicative (classe, fonction, module ...) doit être fermée à la modification directe mais ouverte à l'extension. L'objectif est de permettre l'ajout de nouvelles fonctionnalités sans altérer le code existant.
##### Substitution de Liskov (Liskov substitution principle)
une instance de type T doit pouvoir être remplacée par une instance de type G, tel que G sous-type de T, sans que cela ne modifie la cohérence du programme. Cela garantit que les sous-classes peuvent être utilisées de manière interchangeable avec leurs classes de base.
##### Ségrégation des interfaces (Interface segregation principle)
préférer plusieurs interfaces spécifiques pour chaque client plutôt qu'une seule interface générale. Cela évite aux classes de dépendre de méthodes dont elles n'ont pas besoin, réduisant ainsi les couplages inutiles.
##### Inversion des dépendances (Dependency inversion principle)
il faut dépendre des abstractions, pas des implémentations. Cela favorise la modularité, la flexibilité et la réutilisabilité en réduisant les dépendances directes entre les modules.
