import java.util.Objects;

public class Person {
    private int pId;
    private String pName;

    public Person() {
    }

    public Person(int pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    public int getpId() {
        return this.pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return this.pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String toString() {
        return "Person [pId=" + this.pId + ", pName=" + this.pName + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Person other = (Person)obj;
            return this.pId == other.pId && Objects.equals(this.pName, other.pName);
        }
    }
}