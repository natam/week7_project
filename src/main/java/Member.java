public class Member {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Member)){
            return false;
        }else {
            return (this.getName().equals(((Member) o).getName()) && this.getEmail().equals(((Member) o).getEmail()));
        }
    }
}
