# Dojo

https://www.notion.so/m33/Animation-Create-an-effect-on-press-move-layout-71cda0280c9e4b319f51296a23ec7c8d

![pressEffect.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/08507be3-f59b-428b-91e0-b3a954836b0b/pressEffect.gif)

[https://twitter.com/philipcdavis/status/1509200015587041281](https://twitter.com/philipcdavis/status/1509200015587041281)

- add a `graphicsLayer` Modifier on the card layout to make rotation.
  - Rotation values are animated
  - Rotation values are calculated according to a tap position
- add a `pointerInput` modifier to detect press position and calculate the position value
- reset rotation values after press, add some delay
- Bonus: change elevation related to press
- Bonus: make sameThing with a translation

  ![translationOnPress.gif](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1c5c831d-5d0b-4cc0-ab2b-acc1b329cf2a/translationOnPress.gif)

- Bonus: add a ModifierExtension function to be able to add this effect on all layout
- Bonus: instead of using low level `pointerInput`, use `InteractionSource` and
  collect `PressInteraction`
  - it keeps advantages of high level `.clickable` modifier or `Surface`
- Bonus : Black and Gradient Layout from twitter
  - Layout is a page with holes, cards are placed in these holes

### Aide:

Equivalent Compose du tweet: https://github.com/Rahkeen/Fidget

# Result

Coming soon ...
