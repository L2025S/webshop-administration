package se.iths.lw;

class User {
    private String username;
    private String password;

    User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }
    String getPassword() {
        return password;
    }

    void setUsername (String userName) {
        this.username = userName;
    }
    void setPassword (String password){
        this.password = password;
    }


    @Override
    public String toString() {
        return "Username: " + username;
    }
}
