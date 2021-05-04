package pt.upskill.projeto2.financemanager.categories;

import java.util.ArrayList;
import java.util.List;

/**
 * @author upSkill 2020
 * <p>
 * ...
 */

public class Category {
    List <String> description = new ArrayList<>();
    public String name;


    public Category(String name) {
        this.name = name;
    }

    public static List<Category> readCategories(String name, List<Category> categories) {
        return null;
    }

    public boolean hasTag(String string) {
        // TODO Auto-generated method stub
        return false;
    }

    public void addTag(String string) {
        // TODO Auto-generated method stub

    }

    public String getName() {
        return name;
    }


    public void addDescription(String summary) {
        if(summary == null ){
            throw new IllegalArgumentException();
        }
        else if (hasDescription (summary) == true){
            return;
        }
        else {
            description.add(summary);
        }

    }

    public boolean hasDescription(String purchase) {
        if(purchase != null) {
            for (String descriptions : description) {
                if (descriptions.equals(purchase)) {
                    return true;
                }
            }
        }
        return false;
    }
}

