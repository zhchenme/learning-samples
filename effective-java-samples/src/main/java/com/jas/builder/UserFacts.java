package com.jas.builder;
/**
 * UserFacts
 *
 * @author lanxiang
 * @since 2019-08-29
 */
public class UserFacts {

    private String name;

    private String nickName;

    private Integer age;

    private String mobile;

    public static UserFactsBuilder builder() {
        return new UserFactsBuilder();
    }

    public static class UserFactsBuilder implements Builder<UserFacts> {

        private String name;

        private String nickName;

        private Integer age = 0;

        private String mobile;

        public UserFactsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserFactsBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public UserFactsBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserFactsBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        @Override
        public UserFacts build() {
            return new UserFacts(this);
        }
    }

    private UserFacts(UserFactsBuilder builder) {
        this.name = builder.name;
        this.nickName = builder.nickName;
        this.age = builder.age;
        this.mobile = builder.mobile;
    }

    public static void main(String[] args) {
        UserFacts userFacts = UserFacts.builder()
                .name("zchen")
                .mobile("110")
                .nickName("jas")
                .build();

        System.out.println(userFacts.name);
        System.out.println(userFacts.age);
    }

}
