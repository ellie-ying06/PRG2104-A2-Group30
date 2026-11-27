package a2.model

//architect
case class FoodOrder(
  orderId: Int,
  customerId: Int,
  restaurantName: String,
  cuisineType: String,
  costOfTheOrder: Double,
  dayOfTheWeek: String,
  rating: String,
  foodPreparationTime: Int,
  deliveryTime: Int
)

val order1 = FoodOrder(
  1477147,
  337525,
  "Hangawi",
  "Korean",
  30.75,
  "Weekend",
  "Not given",
  25,
  20
)