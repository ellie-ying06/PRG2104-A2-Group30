package a2.analysis
import a2.model.FoodOrder

//Q1 - Identify the top 3 cuisine types based on their average customer rating, ranked from highest to lowest. (exclude not given)

def top3Cuisine(orders: List[FoodOrder]): List[(String, Double)] = 
    orders 
    .filter(_.rating != "Not given")
    .groupBy(_.cuisineType)
    .toList
    .map{case (cName, os) =>
        val ratings = os.map(_.rating.toDouble)
        val averageRating = ratings.sum / ratings.size
        (cName, averageRating)
    }
    .sortBy{case (cName, averageRating) => (-averageRating, cName)}
    .take(3)


@main def testQ1(): Unit =
    val orders = List(
        FoodOrder(1, 101, "A", "Japanese", 20.0, "Weekday", "5", 20, 25),
        FoodOrder(2, 102, "B", "Japanese", 30.0, "Weekend", "4", 20, 30),
        FoodOrder(3, 103, "C", "Italian", 25.0, "Weekday", "5", 15, 20),
        FoodOrder(4, 104, "D", "American", 15.0, "Weekend", "Not given", 15, 25),
        FoodOrder(5, 105, "E", "Chinese", 18.0, "Weekday", "8", 20, 25)
    )

    val result = top3Cuisine(orders)
    println(result)
