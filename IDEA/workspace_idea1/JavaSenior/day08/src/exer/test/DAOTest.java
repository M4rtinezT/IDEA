package exer.test;


import java.util.*;

/**
 * @author TJ
 * @create 2021-05-12  20:09
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> stringDAO = new DAO<>();
        stringDAO.save("001",new User(01,10,"Tom"));
        stringDAO.save("002",new User(02,20,"Able"));
        stringDAO.save("003",new User(03,30,"Jerry"));
        stringDAO.save("004",new User(04,40,"Mary"));
        System.out.println(stringDAO.get("001"));
        stringDAO.update("004",new User(12,23,"Tom"));
        System.out.println(stringDAO.list());
        stringDAO.delete("003");
        System.out.println(stringDAO);

    }
}


class DAO<T>{
    private Map<String,T> map = new HashMap<>();
    //保存T类型的对象到map成员变量中
    public void save(String id,T entity){
        map.put(id, entity);
    }
    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替换map中key为id的内容，改为entity
    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id,entity);
        }else {
            throw new RuntimeException("不存在当前id值");
        }
    }
    //返回map中存放的所有T对象
    public List<T> list(){
        Collection<T> values =  map.values();
        ArrayList<T> res = new ArrayList<>();
        for(T t:values){
            res.add(t);
        }
        return res;
    }
    //删除指定id的对象
    public void delete(String id){
        if(map.containsKey(id)){
            map.remove(id);
        }else{
            throw new RuntimeException("不存在指定id值");
        }
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

class User{
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}