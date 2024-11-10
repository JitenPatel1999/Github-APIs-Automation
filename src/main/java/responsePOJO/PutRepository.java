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
public class PutRepository {
	 @JsonProperty("id")
	    private Long id;

	    @JsonProperty("name")
	    private String name;

	    @JsonProperty("full_name")
	    private String fullName;

	    @JsonProperty("description")
	    private String description;

	    @JsonProperty("private")
	    private Boolean isPrivate;
}