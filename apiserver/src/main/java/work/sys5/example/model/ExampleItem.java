package work.sys5.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/** example item */
@ApiModel(description = "example item")
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2021-06-14T11:18:16.651486+09:00[Asia/Tokyo]")
@lombok.Builder
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class ExampleItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("col1")
    private String col1;

    public ExampleItem col1(String col1) {
        this.col1 = col1;
        return this;
    }

    /**
     * Get col1
     *
     * @return col1
     */
    @ApiModelProperty(value = "")
    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExampleItem exampleItem = (ExampleItem) o;
        return Objects.equals(this.col1, exampleItem.col1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(col1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExampleItem {\n");

        sb.append("    col1: ").append(toIndentedString(col1)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
