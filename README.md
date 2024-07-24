# Exercice : Développement d'un site de vente de meubles
## Objectif :
Développer un site web complet de vente de meubles avec gestion de
stock et panier d'achat en utilisant Spring, Spring Data JPA et
Thymeleaf.

## Les entités
### 1. Créer l'entité Furniture avec au minimum les attributs  suivants :
   * id
   * name
   * description
   * price
   * stock
### 2. Créer l'entité CartItem avec au minimum les attributs suivants :
   * id
   * furnitureId
   * quantity


## les repositories
1. Créer FurnitureRepository en étendant
   JpaRepository<Furniture, Long> .

2. Créer CartItemRepository en étendant
   JpaRepository<CartItem, Long> 

## les vues
1. Créer une vue pour afficher la liste des meubles avec des options
   pour ajouter des meubles au panier, éditer ou supprimer.

2. Créer une vue pour ajouter ou modifier un meuble.

3. Créer une vue pour afficher les éléments du panier avec des
   options pour supprimer des éléments ou vider le panier.
