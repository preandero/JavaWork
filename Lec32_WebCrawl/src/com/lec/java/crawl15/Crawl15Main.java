package com.lec.java.crawl15;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/* XML, JSON 파싱 연습
 * 
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/json/stationInfo/1/5/서울

 */

public class Crawl15Main {

	public static void main(String[] args) throws IOException, UnsupportedEncodingException {
		System.out.println("jackson-databind 연습2");

		ObjectMapper mapper = new ObjectMapper();

		String station = "시청";
		URL url = new URL("http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/json/stationInfo/1/5/"
				+ URLEncoder.encode(station, "UTF-8"));
		Subway subway = mapper.readValue(url, Subway.class);

		int count = 0;
		
		
		for (Sublist e : subway.getstationList()) {
			System.out.printf(count + 1 + ": %s역 %s %s\n", e.getStatnNm(), e.getSubwayId(), e.getSubwayNm());
			count++;
		}

		System.out.println("\n프로그램 종료");
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway {
	private List<Sublist> stationList; // 왜 이것만 public ???

	public List<Sublist> getstationList() {
		return stationList;
	}

	public void setstationList(List<Sublist> stationList) {
		this.stationList = stationList;
	}

}

// JSON 필드명과 매핑되는 Java 객체의 변수명을 달리 하고 싶다면
// @jsonProperty 사용

@JsonIgnoreProperties(ignoreUnknown = true)
class Sublist {

	private String statnNm;
	private String subwayNm;
	private String subwayId;

	public String getStatnNm() {
		return statnNm;
	}

	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}

	public String getSubwayNm() {
		return subwayNm;
	}

	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}

	public String getSubwayId() {
		return subwayId;
	}

	public void setSubwayId(String subwayId) {
		this.subwayId = subwayId;
	}

}
