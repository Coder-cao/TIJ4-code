package src.my.test;

public class Super {

    //
    {
        age = initAge();
        desc = initString("desc");
    }

    private String initString(String str){
        return str;
    }

    private String name;
    private Integer age ;

    private Integer initAge(){
        return 5;
    }

    public Super(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    private String desc ;


}
