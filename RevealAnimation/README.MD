![revealAnim.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6510aa46-bf57-4d40-8440-9c472e7e7c2d/revealAnim.gif)

### But:

Avoir une méthode simple pour mettre en avant un élément à l’ouverture d’une page grâce à une
animation sur la première apparition

### Déroulement prévisionnel du dojo:

<aside>
🐥 *Ce dojo peut être plus agréable a faire avec Android Studio preview qui possède les outils:*

- *animation preview*
- *calcul du nombre de recomposition dans le layout inspector*

</aside>

1. fonction `graphicLayer` with `Animatable` and `LaunchEffect` → méthode la plus libre pour
   modifier
   1. Créer une valeur initiale de l’élément à modifier avec `animatable`
   2. dans un effet de bord, animer l’`animatable` vers sa valeur cible
   3. Utiliser la valeur animée pour changer un des éléments du `graphicLayer` de l’élément que vous
      souhaitez révéler
2. `AnimatedVisibility` with `MutableTransitionState`
   1. Utiliser le `MutableTransitionState` pour avoir une valeur de base qui change aussitot
   2. utiliser `AnimatedVisibility` sur la `MutableTransitionState` en parent de l’élément à animer
   3. customiser l’animation
3. `AnimatedContent` with `MutableTransitionState`
   1. Utiliser le `MutableTransitionState` pour avoir une valeur de base qui change aussitot
   2. utiliser `AnimatedContent` sur la `MutableTransitionState` en parent de l’élément à animer
   3. customiser l’animation

**Bonus:**

- Mettre la fonction de “reveal” dans un composant à part (modifier ou composant parent) pour ne pas
  polluer la vue de base
- `drawBehind` : faire un dessin derriere l’élément à reveler, le dessin grossit et devient de plus
  en plus transparent
- Creuser le `updateTransition`

### Doc

[https://developer.android.com/jetpack/compose/animation](https://developer.android.com/jetpack/compose/animation)

### Aide

branch `revealanimation/solution`

### Aller plus loin

Ces animations peuvent aussi avoir lieu lors d’une action de l’utilisateur ou une inaction
justement (ex sur le meme ecran depuis trop longtemps sans rien faire, on pulse le bouton principal)
