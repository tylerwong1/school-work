public class Cow {

    private String name;
    private String image;


    public Cow(String name) {
        // initialize cow name
        this.name = name;
    }
    // returns name
    public String getName() {
        return name;
    }
    // returns image
    public String getImage() {
        return image;
    }
    // necessary for Heifer class
    public void setImage(String image) {
        // sets the image for this cow object to image
        this.image = image;
    }
}
