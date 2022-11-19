package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Posts {
//   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @SerializedName("user_id")
    private String userId;
    private String title;
    private String body;

    public Posts( String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }


    public String getUserId() {
        return userId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Posts{");
        sb.append("id='").append(id).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
