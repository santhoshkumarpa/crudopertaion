/**
 * Country
 */
public class Country {

    private int id;
    private String name;

    /**
     * @return the id
     */Country(int id,String name){
         this.id=id;
         this.name=name;
     }
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {

        return "id:"+id+"name:"+name;
    }

    
}