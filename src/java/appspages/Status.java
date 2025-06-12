import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    COMPLETE("complete"),
    INCOMPLETE("incomplete"),
    COMPLETED("completed");

    private final String status;
}
