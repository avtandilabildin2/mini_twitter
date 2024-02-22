import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;

public class MiniTwitterApplication {
    User[] users=new User[0];
    Scanner sc=new Scanner(System.in);
    User user;
    User auth;
    //==========================================================================
    Organization[] organizations=new Organization[0];
    Organization organization;
    Organization authOrgan;
    //=======================================================================
    Post[] posts=new Post[0];
    Post post;
    String pribor;
    Post[] authPosts=new Post[0];
    public void run(){
        boolean bool=true;
        while(bool){
            System.out.println("Print a command!");
            String command=sc.next();
            if(command.equals("register")){
                if(Objects.nonNull(auth)||Objects.nonNull(authOrgan)){
                    System.out.println("Sperva ty dolzhen vyiti iz sistemy");
                }
                System.out.println("Choose who you are 0-person(user) or 1-organization");
                int choose=sc.nextInt();
                if(choose==0){
                    System.out.println("Print login!");
                    String login=sc.next();
                    if(users.length>0){
                        for (int i = 0; i < users.length ; i++) {
                            if(users[i].getLogin().equals(login)){
                                while(login.equals(users[i].getLogin())){
                                    System.out.println("Polzovatel s takim loginom uje sushshestvuet Print login again");
                                    login=sc.next();
                                }
                            }
                        }
                    }
                    if(organizations.length>0){
                        for (int i = 0; i <organizations.length ; i++) {
                            if(login.equals(organizations[i].getLogin())){
                                while(login.equals(organizations[i].getLogin())){
                                    System.out.println("Polzovatel s takim loginom uje sushshestvuet Print login again");
                                    login=sc.next();
                                }
                            }
                        }
                    }

                    System.out.println("Print password!");
                    String password=sc.next();
                    System.out.println("Print your name! ");
                    String name=sc.next();
                    System.out.println("Print your surname! ");
                    String surname=sc.next();
                    System.out.println("Print your birthday in format yyyy-mm-dd");
                    String datebirth=sc.next();
                    user=new User(datebirth,name,0,login,password,surname);
                    register();
                }
                if(choose==1){
                    System.out.print("Print login: ");
                    String login=sc.nextLine();
                    if(users.length>0){
                        for (int i = 0; i < users.length ; i++) {
                            if(users[i].getLogin().equals(login)){
                                while(login.equals(users[i].getLogin())){
                                    System.out.println("Polzovatel s takim loginom uje sushshestvuet Print login again");
                                    login=sc.next();
                                }
                            }
                        }
                    }
                    if(organizations.length>0){
                        for (int i = 0; i <organizations.length ; i++) {
                            if(login.equals(organizations[i].getLogin())){
                                while(login.equals(organizations[i].getLogin())){
                                    System.out.println("Polzovatel s takim loginom uje sushshestvuet Print login again");
                                    login=sc.next();
                                }
                            }
                        }
                    }
                    System.out.print("Print password: ");
                    String password=sc.nextLine();
                    System.out.println("Print nazvanie");
                    String nazvanie=sc.nextLine();
                    System.out.println("Print rod deiatelnosti");
                    String rodDeiatel=sc.nextLine();
                    System.out.println("Print data osnovanya");
                    String dataOsnov=sc.nextLine();
                    organization=new Organization(dataOsnov,1,login,nazvanie,password,rodDeiatel);
                    registerOrg();
                }
            }
            else if(command.equals("login")){
                if(Objects.nonNull(auth)||Objects.nonNull(authOrgan)){
                    System.out.println("Sperva ty dolzhen vyiti iz sistemy");
                }
                System.out.println("Print your login!");
                String login=sc.next();
                System.out.println("Print your password!");
                String password=sc.next();
                boolean bool1=true;
                for (int i = 0; i < users.length ; i++) {
                    if(login.equals(users[i].getLogin())&&password.equals(users[i].getPassword())){
                        auth=users[i];
                        System.out.println(auth.getLogin()+" you logged in to the system!");
                        bool1=false;
                    }
                }
                for (int i = 0; i <organizations.length ; i++) {
                    if(login.equals(organizations[i].getLogin())&&password.equals(organizations[i].getPassword())){
                        authOrgan=organizations[i];
                        System.out.println(authOrgan.getLogin()+" you logged in to the system");
                        bool1=false;
                    }
                }
                if(bool1){
                    System.out.println("Takogo polzovatelya net v sisteme!");
                }
            }
            else if(command.equals("logout")){
                System.out.println("You logged out from system!");
                authOrgan=null;
                auth=null;
            }
            else if(command.equals("info")){
                if(auth!=null&&authOrgan==null){
                    System.out.println(auth);
                    pribor=auth.getName()+" "+auth.getSurname();
                }
                if(authOrgan!=null&&auth==null){
                    System.out.println(authOrgan);
                    pribor=authOrgan.getNazvanie();
                }
                if(auth==null&&authOrgan==null){
                    System.out.println("Netu avtorizirovannyh polzovateley");
                }
            }
            else if(command.equals("info_by_login")){
                System.out.println("Print login!");
                String login=sc.next();
                boolean bool2=true;
                for (int i = 0; i < users.length ; i++) {
                    if(login.equals(users[i].getLogin())){
                        System.out.println(users[i]);
                        bool2=false;
                    }
                }
                for (int i = 0; i < organizations.length; i++) {
                    if(login.equals(organizations[i].getLogin())){
                        System.out.println(organizations[i]);
                        bool2=false;
                    }
                }
                if(bool2){
                    System.out.println("Polzovatel s takim loginom ne sushshestvuet");
                }
            }
            else if(command.equals("info_all")){
                for (int i = 0; i < users.length; i++) {
                    System.out.println(users[i]);
                }
                for (int i = 0; i <organizations.length ; i++) {
                    System.out.println(organizations[i]);
                }
            }
            else if(command.equals("add_post")){
                if(auth==null&&authOrgan==null){
                    System.out.println("Nuzhno sperva vhodit na sistemu!");
                    continue;
                }
                System.out.println("<<<<<<<<<<<<<<<<<<Sozdanie novoi publikatsii>>>>>>>>>>>>>>>>>");
                System.out.println("The theme of the publication");
                String theme=sc.next();
                System.out.println("The text of the publication");
                String text=sc.next();
                System.out.println("Print the tag of the publication");
                String tag=sc.next();
                post=new Post(0,"2024",tag,theme,text);
                addPost();
            }
            else if(command.equals("my_posts")){
                System.out.println("Ne znaiu kak sdelat to");
            }
            else if(command.equals("all_posts")){
                for (int i = 0; i <posts.length ; i++) {
                    System.out.println(posts[i]);
                }
            }
            else if(command.equals("posts_by_tag")){
                System.out.println("Print tag");
                String tag=sc.next();
                boolean bool3=true;
                for (int i = 0; i < posts.length; i++) {
                    if(posts[i].getTags().equals(tag)){
                        System.out.println(posts[i]);
                        bool3=false;
                    }
                }
                if(bool3){
                    System.out.println("S takim tegom net publikatsiy");
                }
            }
            else if(command.equals("posts_by_user_type")){
                System.out.println("Print which type 0-person and 1-organization");
                int type=sc.nextInt();
                if(type==0&& users.length>0){
                    for (int i = 0; i < users.length; i++) {
                        System.out.println(users[i]);
                    }
                }
                if(type==0&&users.length==0){
                    System.out.println("Tip polzovatelya chelovek ne sushshestvuet");
                }
                if(type==1&&organizations.length>0){
                    for (int i = 0; i <organizations.length ; i++) {
                        System.out.println(organizations[i]);
                    }
                }
                if(type==1&&organizations.length==0){
                    System.out.println("Tip polzovatelya organization ne sushshestvuet!");
                }
            }
            else if(command.equals("exit")){
                System.out.println("Vyhod iz sistemy");
                break;
            }
            else{
                System.out.println("Takoi komandy ne sushshestvuet!");
            }
        }
    }
    public void addPost(){
        Post[] newPosts=new Post[posts.length+1];
        for (int i = 0; i < posts.length ; i++) {
            newPosts[i]=posts[i];
        }
        newPosts[posts.length]=post;
        posts=newPosts;
        System.out.println(post);
    }
    public void register(){
            User[] newUsers=new User[users.length+1];
            for (int i = 0; i < users.length ; i++) {
                newUsers[i]=users[i];
            }
            newUsers[users.length]=user;
            users=newUsers;
            System.out.println(user);
    }
    public void registerOrg(){
        Organization[] newOrg=new Organization[organizations.length+1];
        for (int i = 0; i <organizations.length ; i++) {
            newOrg[i]=organizations[i];
        }
        newOrg[organizations.length]=organization;
        organizations=newOrg;
        System.out.println(organization);
    }
}
