package lab1.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetGameResponse implements Comparable<GetGameResponse> {
	private String name;
	private double price;
	private String developer;

	public int compareTo(GetGameResponse o) {
		int result = Double.compare(price, o.getPrice());
		if (result != 0) {
			return result;
		}
		return name.compareTo(o.getName());
	}

}
