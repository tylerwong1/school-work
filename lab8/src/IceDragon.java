public class IceDragon extends Dragon {

    private boolean breathe;

    public IceDragon(String name, String image) {
        super(name, image);
        super.setImage(image);
        // ice-dragon never breathes fire
        breathe = false;

    }
    //override needed because the same method is in a superclass
    @Override
    public boolean canBreatheFire() {
        return breathe;
    }
}

