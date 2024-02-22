public class Organization {
    int id;
    String login;
    String password;
    String nazvanie;
    String rodDeiatel;
    String dataOsnovaniya;

    public Organization(String dataOsnovaniya, int id, String login, String nazvanie, String password, String rodDeiatel) {
        this.dataOsnovaniya = dataOsnovaniya;
        this.id = id;
        this.login = login;
        this.nazvanie = nazvanie;
        this.password = password;
        this.rodDeiatel = rodDeiatel;
    }

    public String getDataOsnovaniya() {
        return dataOsnovaniya;
    }

    public void setDataOsnovaniya(String dataOsnovaniya) {
        this.dataOsnovaniya = dataOsnovaniya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRodDeiatel() {
        return rodDeiatel;
    }

    public void setRodDeiatel(String rodDeiatel) {
        this.rodDeiatel = rodDeiatel;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", rodDeiatel='" + rodDeiatel + '\'' +
                ", dataOsnovaniya='" + dataOsnovaniya + '\'' +
                ", login='" + login + '\'' +
                ", nazvanie='" + nazvanie + '\'' +
                '}';
    }
}
