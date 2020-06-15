package test;

import java.util.HashSet;

/**
 * 功能描述
 *
 * @author l00365373
 * @since 2020-04-22
 */
class Email {
    public String address;

    public Email(String address) {
        this.address = address;
    }
    public int hashCode() {
        int result = address.hashCode();
        return result;
    }

    public static void main(String[] args) {
        HashSet<Email> set = new HashSet<>();
        Email email = new Email("huawei.com");
        set.add(email);
        email.address = "silong.com";
        System.out.println(set.contains(email));
        set.remove(email);
    }
}
