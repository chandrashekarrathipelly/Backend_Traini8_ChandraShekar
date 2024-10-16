package traini8.API.model;


import java.time.Instant;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import traini8.API.DTOs.TrainingCenterDTO;

@Entity
@Builder
@Data
public class TrainingCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Center name is mandatory")
	@Size(max = 40, message = "Center name must be less than 40 characters")
	private String centerName;

	@NotNull(message = "Center code is mandatory")
	@Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
	private String centerCode;

	@Embedded
	private TrainingCenterDTO.@NotNull @Valid AddressDTO address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public TrainingCenterDTO.@NotNull @Valid AddressDTO getAddress() {
		return address;
	}

	public void setAddress(TrainingCenterDTO.@NotNull @Valid AddressDTO address) {
		this.address = address;
	}

	public Integer getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(Integer studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public List<String> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public Long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Min(value = 0, message = "Student capacity must be a positive number")
	private Integer studentCapacity;

	private List<String> coursesOffered;

	private Long createdOn; // Field to store epoch time

	@Email(message = "Invalid email format")
	private String contactEmail;

	@NotBlank(message = "Contact phone is mandatory")
	@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits")
	private String contactPhone;


	@PrePersist
	public void prePersist() {
		this.createdOn = Instant.now().toEpochMilli(); // Set current epoch time in milliseconds
	}

	// Constructors
	public TrainingCenter(Long id,
						  String centerName,
						  String centerCode,
						  TrainingCenterDTO.@NotNull @Valid AddressDTO address,
						  Integer studentCapacity,
						  List<String> coursesOffered,
						  Long createdOn,
						  String contactEmail,
						  String contactPhone) {
		this.id = id;
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.createdOn = createdOn;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}

	public TrainingCenter() {
	}


	@Override
	public String toString() {
		return "TrainingCenter [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode + ", address="
				+ address + ", studentCapacity=" + studentCapacity + ", coursesOffered=" + coursesOffered
				+ ", createdOn=" + createdOn + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone
				+ "]";
	}



	public static class Address {
		private String detailedAddress;
		private String city;
		private String state;

		@Pattern(regexp = "^[0-9]{6}$", message = "Pin code must be exactly 6 digits")
		private String pinCode;


		@Override
		public String toString() {
			return "Address [detailedAddress=" + detailedAddress + ", city=" + city + ", state=" + state + ", pinCode="
					+ pinCode + "]";
		}

		public Address() {
		}

		public String getDetailedAddress() {
			return detailedAddress;
		}

		public void setDetailedAddress(String detailedAddress) {
			this.detailedAddress = detailedAddress;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPinCode() {
			return pinCode;
		}

		public Address(String detailedAddress, String city, String state, String pinCode) {
			this.detailedAddress = detailedAddress;
			this.city = city;
			this.state = state;
			this.pinCode = pinCode;
		}

		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
	}

}

