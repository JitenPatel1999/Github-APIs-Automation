package responsePOJO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRepository {
	@JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("private")
    private boolean isPrivate;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("pushed_at")
    private String pushedAt;

    @JsonProperty("git_url")
    private String gitUrl;
}
