package POJO;
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
	@JsonProperty(value="name")
	public String name;
	
	@JsonProperty(value="description")
	public String description;
	
	@JsonProperty(value="homepage")
	public String homepage;
	
	@JsonProperty(value="private")
	public boolean isPrivate;
	
	@JsonProperty(value="has_issues")
	public boolean has_issues;
	
	@JsonProperty(value="has_projects")
	public boolean has_projects;
	
	@JsonProperty(value="has_wiki")
	public boolean has_wiki;
}
