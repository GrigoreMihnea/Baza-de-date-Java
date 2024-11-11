package demo.dto;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CollegeDto {

	private String studentName;
	private Boolean admission;
	private String name;
	
	public CollegeDto(String firstName, String lastName, Boolean admission, String name) {
		
		this.admission = admission;
		this.name = name;
		this.studentName = StringUtils.join(firstName," ",lastName);
	}
	
}
