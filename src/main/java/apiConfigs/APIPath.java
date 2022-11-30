package apiConfigs;

public class APIPath {
    public static final class apiPath {

        //END POINTS FOR API
        //get list of users
        public static final String GET_LIST_OF_USERS="posts";
        //get single user
        public static final String SINGLE_USER="posts/1";
        //post create user
        public static final String  CREATE_USER="posts";
        //delete user
        public static final String DELETE_USER="posts";

    }

    public static void main(String[] args) {
        System.out.println(APIPath.apiPath.CREATE_USER);
        System.out.println(apiPath.GET_LIST_OF_USERS);
    }
}
