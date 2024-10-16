package traini8.API.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TrainingCenterDTO {

    @NotBlank
    @Size(max = 40)
    private String centerName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$")
    private String centerCode;

    @NotNull
    @Valid
    private AddressDTO address;

    private Integer studentCapacity;

    @NotEmpty
    private List<String> coursesOffered;

    private String contactEmail;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String contactPhone;

    @Data
    public static class AddressDTO {
        private String detailedAddress;
        private String city;
        private String state;
        private String pinCode;

    }

}
