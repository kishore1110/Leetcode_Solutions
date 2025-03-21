class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> supply=new HashSet<>();
        HashSet<Integer> completed=new HashSet<>();
        for(String supp:supplies){
            supply.add(supp);
        }
        boolean found=true;
        List<String> result=new ArrayList<>();
        while(found && result.size()<=recipes.length){
            found=false;
            for(int i=0;i<ingredients.size();i++){
                if(completed.contains(i))continue;
                int count=0;
                for(String ing:ingredients.get(i)){
                    if(supply.contains(ing))count++;
                }
                if(count==ingredients.get(i).size()){
                    found=true;
                    completed.add(i);
                    supply.add(recipes[i]);
                    result.add(recipes[i]);
                }
            }
        }
        return result;
    }
}