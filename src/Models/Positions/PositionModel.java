package Models.Positions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entities.Positons;
import Models.ConnectDB;



public class PositionModel {
	public List<Positons> ShowPosition() {
		List<Positons> positons = new ArrayList<Positons>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from positions");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Positons position = new Positons();
				position.setPosition_id(resultSet.getInt("position_id"));
				position.setPosition_name(resultSet.getString("position_name"));
				positons.add(position);
			}
		} catch (Exception e) {
			e.printStackTrace();
			positons = null;
		} finally {
			ConnectDB.disconnect();
		}
		
		return positons;
	}
}
