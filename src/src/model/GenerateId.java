package src.model;

public class GenerateId {
    public static Long userId =0L;
    public static Long postId =0L;


    public static long genPostId(){
        return ++postId;
    }

    public static long genUserId(){
        return ++userId;
    }

}
