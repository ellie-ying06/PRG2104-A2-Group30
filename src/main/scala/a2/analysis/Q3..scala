package a2.analysis
import a2.model.FoodOrder
//Q3 - Find top 30% restaurants with delivery-time condition
//Calculate the mean order cost per restaurant, select the top 30%, and sort by shortest average delivery time.


def top30Restaurants(
  orders: List[FoodOrder],
  maxDeliveryTime: Double
): List[(String, Double, Double)] =

  val ranked = orders
    .groupBy(_.restaurantName)
    .toList
    .map { case (name, os) =>
      val meanCost = os.map(_.costOfTheOrder).sum / os.size
      val meanDelivery = os.map(_.deliveryTime.toDouble).sum / os.size
      (name, meanCost, meanDelivery)
    }
    .sortBy { case (name, cost, _) => (-cost, name) }

  val topCount = math.ceil(ranked.size * 0.30).toInt

  ranked
    .take(topCount)
    .filter { case (_, _, delivery) =>
      delivery <= maxDeliveryTime
    }
    .sortBy { case (name, _, delivery) =>
      (delivery, name)
    }
