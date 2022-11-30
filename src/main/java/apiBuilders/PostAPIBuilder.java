package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {
    /*DurgeshRestAssured*/
    public static Map<String,String > postRequestBody(String id, String title, String author){

        Map<String ,String > body=new HashMap<>();
        body.put("id",id);
        body.put("title",title);
        body.put("author",author);

        return body;
    }
    public Map<String ,String > postValidationBody(){
        Map<String ,String > bodyValPost=new HashMap<>();
        bodyValPost.put("id","7");
        bodyValPost.put("title","Geeta");
        bodyValPost.put("author","Ved Vyash");

        return bodyValPost;
    }

}
