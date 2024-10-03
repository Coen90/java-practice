package effectivejava.new_.item02;

public class Name {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String nickName;

    public static class Builder {
        //필수
        private final String firstName;
        private final String lastName;
        //선택
        private String middleName = "";
        private String nickName = "";

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder middleName(String val) {
            middleName = val;
            return this;
        }

        public Builder nickName(String val) {
            nickName = val;
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }

    public Name(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;
        nickName = builder.nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getNickName() {
        return nickName;
    }
}
