package se.iths.lw;

class User {
    private String userName;
    private String password;

    User (String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    String getUserName() {
        return userName;
    }
    String getPassword() {
        return password;
    }

    void setUserName (String userName) {
        this.userName = userName;
    }
    void setPassword (String password){
        this.password = password;
    }


    @Override
    public String toString() {
        return "Username: " + userName;
    }


}
