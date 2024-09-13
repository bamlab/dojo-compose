# Apercu

## Expected

![img.png](expected.png)

## Result

To be done

# But:

Introduire compose multiplateform en implémentant un layout simple:
https://www.figma.com/design/lt8PMrXreI87pmJPkKhcHl/DOJO-UI---For-Dev?node-id=1-501&t=Ag3aDCtJ1RJw4dIS-0

# Déroulement prévisionnel du dojo:

## Eléments non pris en compte

- barre de navigation en bas
- Le background qui fera l'objet d'un dojo à part entière. Mettez juste le
  violet en fond
- Les fonts ne sont pas à prendre en compte
- Les border en gradient ne sont pas à prendre en compte

## Tache a faire

### Premiere partie: design

- Mettre les 3 composants en colonne (AvatarCard, ContactCard, PremiumButton)
- Développer la vue du PremiumButton
- Developper la vue de ContactCard
- Developper la vue de AvatarCard

### Bonus 1ere partie

- Utiliser Coil
- border en gradient
- utiliser fleet et avoir des previews qui fonctionnent dans le code common

### Deuxieme partie: interaction

- Sur le click du bouton premium, changer le texte du bouton et le rendre non clickable
- Sur le click du bouton d'edition, rendre les champs editables et changer le bouton par une icone
  de validation

### Bonus 2eme partie

- Sur le click de l'icone de validation, rendre les champs non editables avec leur nouvelle valeure
  et changer l'icone par le bouton d'edition

# Aide

- `Modifier.blur`
- `Modifier.alpha`
- `Card`
- `implementation(compose.materialIconsExtended)`
- (
  Resources)[https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-images-resources.html#qualifiers]
- https://developer.android.com/develop/ui/compose/state-hoisting#viewmodels-as-state-owner
- https://developer.android.com/develop/ui/compose/state#use-other-types-of-state-in-jetpack-compose
- Andon Nicolas ACART et Dennis BORDET
