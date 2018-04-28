import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import data.BusLocationService.BusLocationServiceResponse;

public class BusInfoSystem {

	public static void main(String[] args) throws Exception {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.gbis.go.kr/ws/rest/buslocationservice");
		urlBuilder.append("?" + "serviceKey" + "=" + SecureInfo.getInfo("OPENAPI", "apikey"));
		
		urlBuilder.append("&" + URLEncoder.encode("routeId", "UTF-8") + "="
				+ URLEncoder.encode("234000995", "UTF-8")); /* 234001290(1551B), 234000995(M4403) */
		
		URL url = new URL(urlBuilder.toString());
		System.out.println(urlBuilder.toString());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        String res = sb.toString();
        Reader reader = new StringReader(res);
        
        JAXBContext context = JAXBContext.newInstance(BusLocationServiceResponse.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        BusLocationServiceResponse response = (BusLocationServiceResponse) unmarshaller.unmarshal(reader);
        System.out.println(response.toString());
        
        MariaDbManager.insert(response);
	}

}
