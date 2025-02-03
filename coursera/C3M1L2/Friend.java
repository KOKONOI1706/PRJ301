import java.util.Objects;

public class Friend {
    private String name;
    private String phoneNumber;
    public Friend(String name) {
        this.name = name;
    }
    public Friend(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String toString() {
        return "\nFriend : { "
                + "phone number: '" + phoneNumber + '\''
                + ", name: '" + name + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(getName(), friend.getName()) && Objects.equals(getPhoneNumber(), friend.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNumber());
    }
}
