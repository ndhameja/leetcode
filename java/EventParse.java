//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectReader;
////import net.minidev.json.writer.JsonReader;
//import java.lang.Object;
//import java.io.StringReader;
//import javax.json.Json;
//import java.util.PriorityQueue;
//import javax.json.JsonObject;
//import javax.json.JsonReader;
//
//public class EventParse {
//
//
//    private Object EventData;
//
//    public void example(){
//        String inputString= "\"event_data = {\n    \"event_id\": \"123456789\",\n    \"data\": [\n        {\n            \"name\": \"Fremont\",\n            \"num_attendees\": 1,\n            \"num_orders\": 1,\n        },\n        {\n            \"name\": \"Berkeley\",\n            \"num_attendees\": 3,\n            \"num_orders\": 1,\n        },\n        {\n            \"name\": \"San Francisco\",\n            \"num_attendees\": 5,\n            \"num_orders\": 2,\n        },\n        {\n            \"name\": \"Oakland\",\n            \"num_attendees\": 3,\n            \"num_orders\": 2,\n        },\n        {\n            \"name\": \"San Jose\",\n            \"num_attendees\": 2,\n            \"num_orders\": 1,\n        },\n    ],\n    \"totals\": {\n        \"num_attendees\": 14,\n        \"num_orders\": 7,\n    }\n}";
//        ObjectMapper mapper = new ObjectMapper();
//
//        JsonReader reader = Json.createReader(new StringReader(inputString));
//        JsonObject jsonObject = reader.readObject();
//
//       // mapper.readTree(inputString);
//        //mapper.writeValue(inputString,new EventData());
//        //ObjectReader reader = mapper.reader(EventData.class);
//       // mapper.reader(EventData);
//        //EventData event= mapper.reader().readTree(new String(inputString)).has("data");
//
//        String[][] strings =getCities(event.data);
//
//        for (String[] string : strings) {
//            System.out.println(string[0]);
//        }
//
//    }
//
//
//        public  String[][] getCities(Data[] data  ){
//
//            PriorityQueue<Data> queue= new PriorityQueue<>( );
////(a, b)-> Integer.compare(a.num_attendees-b.num_attendees)
//            for (Data d:data){
//                queue.add(d);
//
//            }
//            String[][] res= new String[4][4];
//
//            int counter=0;
//            while(!queue.isEmpty()){
//                if(counter<4){
//                    Data d= queue.poll();
//                    res[0][counter]=(String.valueOf(d.num_attendees),d.name);
//                    counter +=1;
//                }
//            }
//
//            return res;
//        }
//
//        class EventData{
//            int event_id;
//            Data[] data;
//            Totals totals;
//        }
//
//        class Data{
//            public String name;
//            public int num_attendees;
//            public  int num_orders;
//        }
//
//        class Totals{
//            int num_attendees;
//            int num_orders;
//        }
//
//}
