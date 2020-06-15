/**
 * 功能描述
 *
 * @author l00365373
 * @since 2020-04-21
 */
class JuniorClass extends SeniorClass {
    private String name;
    public JuniorClass() {
        super();
        name = "JuniorClass";
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }

    // public static void main(String[] args) {
    //     JuniorClass juniorClass = new JuniorClass();
    // }
}
