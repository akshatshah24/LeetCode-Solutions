class FoodRatings {

    Map<String, PriorityQueue<Food>> map;
    Map<String, Food> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        foodMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], f);
            map.putIfAbsent(cuisines[i], new PriorityQueue<>((a, b) -> b.rating == a.rating ? a.name.compareTo(b.name) : b.rating - a.rating));
            map.get(cuisines[i]).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food f = foodMap.get(food);
        map.get(f.cuisine).remove(f);
        f.rating = newRating;
        map.get(f.cuisine).add(f);
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().name;
    }

    class Food {
        String name;
        String cuisine;
        int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */