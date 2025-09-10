public class Codec {

    String chars = "01fgh23489abcdei567jklQRSTUVWXYZmnopqwxyzABCDEFGrstuvHIJKLMNOP";
    Map<String, String> db = new HashMap<>();
    public String makeTinyUrl(){
        StringBuilder str = new StringBuilder("https://tinyUrl.com/");
        for(int i = 0;i<6;i++){
            str.append(chars.charAt((int)(Math.random() * 62)));
        }
        return str.toString();
    }
    public String encode(String longUrl) {
        String key = makeTinyUrl();
        db.put(key,longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return db.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));