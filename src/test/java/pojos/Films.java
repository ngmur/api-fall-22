package pojos;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Films {

    private String id;
    private String title;
   @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_title_romanised")
   private String originalTitleRomanised;
    private String description;
    private String director;
    private String producer;

   @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("running_time")
   private String runningTime;
   @SerializedName("rt_score")
    private String rtScore;
    private String[] people;
    private String[] species;
    private String[] locations;
    private String[] vehicles;
    private String url;

    public Films(){}

    public Films(String id, String title, String originalTitle, String originalTitleRomanised, String description, String director, String producer, String releaseDate, String runningTime, String rtScore, String[] people, String[] species, String[] locations, String[] vehicles, String url) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalTitleRomanised = originalTitleRomanised;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.rtScore = rtScore;
        this.people = people;
        this.species = species;
        this.locations = locations;
        this.vehicles = vehicles;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalTitleRomanised() {
        return originalTitleRomanised;
    }

    public void setOriginalTitleRomanised(String originalTitleRomanised) {
        this.originalTitleRomanised = originalTitleRomanised;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getRtScore() {
        return rtScore;
    }

    public void setRtScore(String rtScore) {
        this.rtScore = rtScore;
    }

    public String[] getPeople() {
        return people;
    }

    public void setPeople(String[] people) {
        this.people = people;
    }

    public String[] getSpecies() {
        return species;
    }

    public void setSpecies(String[] species) {
        this.species = species;
    }

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    public String[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(String[] vehicles) {
        this.vehicles = vehicles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Films{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", originalTitle='").append(originalTitle).append('\'');
        sb.append(", originalTitleRomanised='").append(originalTitleRomanised).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", director='").append(director).append('\'');
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", releaseDate='").append(releaseDate).append('\'');
        sb.append(", runningTime='").append(runningTime).append('\'');
        sb.append(", rtScore='").append(rtScore).append('\'');
        sb.append(", people=").append(Arrays.toString(people));
        sb.append(", species=").append(Arrays.toString(species));
        sb.append(", locations=").append(Arrays.toString(locations));
        sb.append(", vehicles=").append(Arrays.toString(vehicles));
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
