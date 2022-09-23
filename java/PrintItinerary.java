import java.util.HashMap;
import java.util.Map;

public class PrintItinerary {

    public void printResult(Map<String,String> dataSet){
        Map<String, String> reverseMap = new HashMap<String, String>();
        for(Map.Entry<String,String> entry: dataSet.entrySet()){
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        String start=null;

        for(Map.Entry<String,String> entry:dataSet.entrySet()){
            if (!reverseMap.containsKey(entry.getKey())){
                start=entry.getKey();
                break;
            }
        }

        // If we could not find a starting point, then something wrong
        // with input
        if (start == null)
        {
            System.out.println("Invalid Input");
            return;
        }

        String to = dataSet.get(start);
        while (to != null)
        {
            System.out.print(start +  "->" + to + ", ");
            start = to;
            to = dataSet.get(to);
        }
    }

    public  void execute()
    {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet);
    }


}
