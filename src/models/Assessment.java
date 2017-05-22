package models;

/**
 * Created by Paddym1991 on 02/05/2017.
 */
public class Assessment {

    private double weight;
    private double chest;
    private double thigh;
    private double upperArm;
    private double waist;
    private double hips;
    private String comment;
    private Trainer trainer;


    /**
     *
     * @param weight member's weight as type double
     * @param chest member's chest measurement as type double
     * @param thigh member's thigh measurement as type double
     * @param upperArm member's upper arm measurement as type double
     * @param waist member's waist measurement as type double
     * @param hips member's hips measurement as type double
     * @param comment comment provided by trainer
     * @param trainer trainer that made the assessment
     */
    public Assessment(double weight, double chest, double thigh, double upperArm, double waist, double hips, String comment, Trainer trainer)
    {
        this.weight = weight;
        this.chest = chest;
        this.thigh = thigh;
        this.upperArm = upperArm;
        this.waist = waist;
        this.hips = hips;
        this.comment = comment;
        this.trainer = trainer;
    }

    /**
     * Return the member's weight in kg
     * @return the members weight in kg
     */
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Return the member's chest in cm
     * @return the member's chest in cm
     */
    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    /**
     * Return the member's thigh in cm
     * @return the member@s in cm
     */
    public double getThigh() {
        return thigh;
    }

    public void setThigh(double thigh) {
        this.thigh = thigh;
    }

    /**
     * Return the member's upper arm in cm
     * @return the member's in cm
     */
    public double getUpperArm() {
        return upperArm;
    }

    public void setUpperArm(double upperArm) {
        this.upperArm = upperArm;
    }

    /**
     * Return the member's waist in cm
     * @return the member's waist in cm
     */
    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    /**
     * Return the member's hips in cm
     * @return the member's hips in cm
     */
    public double getHips() {
        return hips;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    /**
     * Return the comment made by the trainer
     * @return comment made by the trainer
     */
    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Return trainer that assessed
     * @return trainer that assesses
     */
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString()
    {
        return "Weight: " + getWeight() + " Kgs"
                + "\nChest: " + getChest() + " Cms"
                + "\nThigh: " + getThigh() + " Cms"
                + "\nupperArm " + getUpperArm() + " Cms"
                + "\nWaist " + getWaist() + " Cms"
                + "\nHips " + getHips() + " Cms"
                + "\nComment: " + getComment() + " ."
                + "\nTrainer: " + getTrainer().getName() + " .";
    }

}
