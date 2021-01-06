public class Dragon extends Cow {

    private boolean breathe;

    public Dragon(String name, String image) {
        super(name);
        super.setImage(image);
        // dragon always breathes fire
        breathe = true;
    }

    public boolean canBreatheFire() {
        return breathe;
    }
}
