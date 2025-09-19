import java.util.*;
public class B{
	public static void main(String[] args){

	}
    class FoodRatings {

        /*
        storing cuisine name as key and foodname with there rating as the values
        using treeMap to store the value of foods : rating
        */
        HashMap<String , String> map = new HashMap<>(); //food - cuisine
        HashMap<String, TreeMap<Integer, List<String>>> food_ratedfoods = new HashMap<>(); //storing place -  (Rating, Sorted list of food name of that rating)
        HashMap<String, Integer> foodrating = new HashMap<>();
        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

            int n = foods.length;
            for(int i = 0; i < n; i++){
                map.put(foods[i], cuisines[i]);
                foodrating.put(foods[i], ratings[i]);

                if(food_ratedfoods.containsKey(cuisines[i])){
                    TreeMap<Integer, List<String>> temp = food_ratedfoods.get(cuisines[i]);
                    if(temp.containsKey(ratings[i])){
                        List<String> list = temp.get(ratings[i]);
                        list.add(foods[i]);
                        Collections.sort(list);
                        temp.put(ratings[i], list);
                        food_ratedfoods.put(cuisines[i], temp);
                    }
                    else{
                        List<String> list = new ArrayList<>();
                        list.add(foods[i]);
                        temp.put(ratings[i], list);
                        food_ratedfoods.put(cuisines[i], temp);
                    }
                }
                else{
                    TreeMap<Integer, List<String>> temp = new TreeMap<>();
                    List<String> list = new ArrayList<>();
                    list.add(foods[i]);
                    temp.put(ratings[i], list);
                    food_ratedfoods.put(cuisines[i], temp);
                }
            }

        }

        public void changeRating(String food, int newRating) {
            String place = map.get(food);
            TreeMap<Integer , List<String>> temp = food_ratedfoods.get(place); // contains rating with food names in sorted way

            int lastrating = foodrating.get(food);
            foodrating.put(food, newRating);

            //fetching ans removing the food from its last rating key
            List<String>  list= temp.get(lastrating);
            list.remove(food);
            Collections.sort(list);

            temp.put(lastrating, list);

            //adding the food into new rating key if present
            if(temp.containsKey(newRating)){
                List<String> temp2 = temp.get(newRating);
                temp2.add(food);
                Collections.sort(list);
                temp.put(newRating, temp2);
            }
            else{
                List<String> foodname = new ArrayList<>();
                foodname.add(food);
                temp.put(newRating, foodname);
            }
            food_ratedfoods.put(food, temp);

        }

        public String highestRated(String cuisine) {
            TreeMap<Integer, List<String>> tempmap = food_ratedfoods.get(cuisine);
            int top = tempmap.lastKey();
            List<String> list = tempmap.get(top);
            Collections.sort(list);
            return list.get(list.size()-1);
        }
    }

}