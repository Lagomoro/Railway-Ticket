package pers.lagomoro.railway_system.manager;

import pers.lagomoro.railway_system.entity.User;

import java.util.*;

public class TokenManager {

    private static HashMap<String, Token> tokenMap = new HashMap<String, Token>();

    public static final int TOKEN_TIME = 7 * 24 * 60 * 60;

    public static void addToken(String token, int uid){
        removeAllTokenFromUser(uid);
        tokenMap.put(token, new Token(uid));
    }

    public static void removeToken(String token){
        if(tokenMap.containsKey(token)){
           tokenMap.remove(token);
        }
    }

    public static int checkToken(String token){
        return isTokenValid(token)? tokenMap.get(token).getUid() : -1;
    }

    public static boolean isTokenValid(String token){
        if(tokenMap.containsKey(token)){
            if(tokenMap.get(token).isDump()){
                tokenMap.remove(token);
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean isUserTokenExist(int uid){
        Map.Entry<String, Token> entry;
        for (Iterator tokens = tokenMap.entrySet().iterator(); tokens.hasNext(); ){
            entry = (Map.Entry<String, Token>) tokens.next();
            if(entry.getValue().getUid() == uid) {
                return true;
            }
        }
        return false;
    }

    public static void removeAllTokenFromUser(int uid){
        ArrayList<String> delList = new ArrayList<String>();
        Map.Entry<String, Token> entry;
        for (Iterator tokens = tokenMap.entrySet().iterator(); tokens.hasNext(); ){
            entry = (Map.Entry<String, Token>) tokens.next();
            if(entry.getValue().getUid() == uid) {
                delList.add(entry.getKey());
            }
        }
        for (Iterator<String> list = delList.iterator(); list.hasNext();) {
            tokenMap.remove(list.next());
        }
    }

}
