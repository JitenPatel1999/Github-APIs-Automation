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
public class PostRepositoryResponse {
	@JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("description")
    private String description;

    @JsonProperty("private")
    private boolean isPrivate;

    @JsonProperty("message")
    private String message;

}
