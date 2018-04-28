import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.BusLocationService.BusLocationList;
import data.BusLocationService.BusLocationServiceResponse;

public class MariaDbManager {

	public static void insert(BusLocationServiceResponse response) throws Exception {

		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = null;
		PreparedStatement ps = null;
		
		String ip = SecureInfo.getInfo("DB", "ip");
		String port = SecureInfo.getInfo("DB", "port");
		String db = SecureInfo.getInfo("DB", "db");
		String id = SecureInfo.getInfo("DB", "id");
		String pw = SecureInfo.getInfo("DB", "pw");
		
		try {
			
			con = DriverManager.getConnection("jdbc:mariadb://" + ip + ":" + port + "/" + db, id, pw);

			ps = con.prepareStatement("insert into busLocation values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			String strQueryTime = response.getMsgHeader().getQueryTime();
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
			java.util.Date queryTimeDate = formatter.parse(strQueryTime);
			java.sql.Timestamp queryTime = new java.sql.Timestamp( queryTimeDate.getTime()) ;
			
			ps.setTimestamp(1, queryTime);

			for(BusLocationList busLocation : response.getMsgBody()) {
				ps.setString(2, busLocation.getEndBus());
				ps.setString(3, busLocation.getLowPlate());
				ps.setString(4, busLocation.getPlateNo());
				ps.setString(5, busLocation.getPlateType());
				ps.setInt(6, Integer.parseInt(busLocation.getRemainSeatCnt()));
				ps.setString(7, busLocation.getRouteId());
				ps.setString(8, busLocation.getStationId());
				ps.setString(9, busLocation.getStationSeq());
				
				ps.executeUpdate();
			}
			
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		} finally {
			try { ps.close(); } catch (Exception e) {}
			try { con.close(); } catch (Exception e) {}
		}
	}

}
