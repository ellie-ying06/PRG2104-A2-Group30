package a2.analysis
import a2.model.FoodOrder

//Q2 - Find the Mean order cost by cuisine.
//Calculates the average cost of orders for each cuisine type and returns in alphabetical order.
def meanCostCuisine(orders: List[FoodOrder]): List[(String, Double)] =
    orders
    .groupBy(_.cuisineType)
    .toList
    .map{case (cName, os) =>
        val mean = os.map(_.costOfTheOrder).sum / os.size
        (cName, mean)}
    .sortBy(cuisine => cuisine._1)    