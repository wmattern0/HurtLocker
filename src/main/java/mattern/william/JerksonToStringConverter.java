package mattern.william;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by williammattern on 2/8/17.
 */
public class JerksonToStringConverter {
    String doubleHashPattern = "#{2}";
    Pattern pattern = Pattern.compile(doubleHashPattern);
    Matcher matcher;

    public String getMeThatFirstDamnItem(String jerkson){
        String[] arrayOfJerkson = jerkson.split(doubleHashPattern);
        if (arrayOfJerkson != null){
            return arrayOfJerkson[0];
        }
        return null;
    }

    public String[] getMeAllTheItems(String jerkson){
        return new String[] {" ", " "};
    }
}
