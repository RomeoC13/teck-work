package edu.episen.si.ing1.pds.backend.server.release2;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
//import edu.episen.si.ing1.pds.backend.server.DataSource;
import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jvm.hotspot.debugger.remote.RemoteDebuggerServer;

import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static edu.episen.si.ing1.pds.backend.server.release2.Crud.*;
import static java.lang.Thread.sleep;


public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Connection connection;
    private static String[] requestList = new String[10];
    private final static Logger log = LoggerFactory.getLogger(ClientHandler.class.getName());


    // Constructor
    public ClientHandler(Socket socket, Connection connection) {
        this.clientSocket = socket;
        this.connection = connection;


    }

    public void run() {


        ObjectMapper mapper = new ObjectMapper(new JsonFactory());

        try {
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
            DataOutputStream ds = new DataOutputStream(out);
            DataInputStream di = new DataInputStream(in);

            String request = di.readUTF();
            System.out.println(request);


            Map<String, String> map = mapper.readValue(request.split("@")[1], new TypeReference<Map<String, String>>() {
            });
            if (request.split("@")[0].equals("requestBuilding")) {
                ds.writeUTF(requestbuilding(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestFloor")) {
                ds.writeUTF(requestFloor(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestRoom")) {
                ds.writeUTF(requestRoom(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestCompany")) {
                ds.writeUTF(requestCompany(connection, map).toString());
            }

            if (request.split("@")[0].equals("request_id_building")) {
                ds.writeUTF(requestgetBuilding(connection, map).toString());
            }

            if (request.split("@")[0].equals("request_id_floor")) {
                ds.writeUTF(requestgetFloor(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestgetListBuilding")) {
                ds.writeUTF(requestgetListBuilding(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestGetIdRoom")) {
                ds.writeUTF(requestGetIdRoom(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestUpdate")) {
                ds.writeUTF(requestUpdate(connection, map).toString());
            }
            if (request.split("@")[0].equals("requestScreenIsEmpty")) {
                ds.writeUTF(requestScreenIsEmpty(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestUpdatePrise")) {
                ds.writeUTF(requestUpdatePrise(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestPriseIsEmpty")) {
                ds.writeUTF(requestPriseIsEmpty(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestUpdateSensor")) {
                ds.writeUTF(requestUpdateSensor(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestSensorIsEmpty")) {
                ds.writeUTF(requestSensorIsEmpty(connection, map).toString());
            }
//            if (request.split("@")[0].equals("requestAllCompany")){
//                ds.writeUTF(NberCompany(connection, map).toString());
//            }
            if (request.split("@")[0].equals("comboxCompany")){
                ds.writeUTF(comboxNameCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("requestUpdateWindows")) {
                ds.writeUTF(requestUpdateWindows(connection, map).toString());
            }

            if (request.split("@")[0].equals("requestWindowsIsEmpty")) {
                ds.writeUTF(requestWindowsIsEmpty(connection, map).toString());
            }

/******************************************starting condition for indicators***********************/

   /*****************his the start of general information of the indicators***************/
            if (request.split("@")[0].equals("rateOccupation")) {
                ds.writeUTF(rateOccupation(connection, map).toString());
            }
            if (request.split("@")[0].equals("connectedObject")) {
                ds.writeUTF(getConnectedObjets(connection, map).toString());
            }
            if (request.split("@")[0].equals("allEquipment")) {
                ds.writeUTF(getAllEquipments(connection, map).toString());
            }
            if (request.split("@")[0].equals("allSensor")) {
                ds.writeUTF(getAllSensor(connection, map).toString());
            }
            if (request.split("@")[0].equals("allCompany")) {
                ds.writeUTF(getAllCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("energyConsommation")) {
                ds.writeUTF(getEnergy(connection, map).toString());
            }
     /***************this the end of general information for indicators***************/

        /*****************************staring for company indicators***********************************/
            if (request.split("@")[0].equals("companyOccupation")){
                ds.writeUTF(rateCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("CompanyConnectedObject")) {
                ds.writeUTF(objectCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("AllEquipmentCompany")) {
                ds.writeUTF(equipmentCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("allSensorCompany")) {
                ds.writeUTF(sensorCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("energyConsommationCompany")) {
                ds.writeUTF(energyCompany(connection, map).toString());
            }
            if (request.split("@")[0].equals("usedBatiment")) {
                ds.writeUTF(usedBatiment(connection, map).toString());
            }
/************************* ending company indicators ****************************/
/***********starting for building conditions indicators***************************/

            if (request.split("@")[0].equals("rateBuilding")) {
                ds.writeUTF(rateBuilding(connection, map).toString());
            }
            if (request.split("@")[0].equals("objectBuilding")) {
                ds.writeUTF(objectBuilding(connection, map).toString());
            }
            if (request.split("@")[0].equals("equipmentBuilding")) {
                ds.writeUTF(equipmentBuilding(connection, map).toString());
            }
            if (request.split("@")[0].equals("sensorBuilding")) {
                ds.writeUTF(sensorBuilding(connection, map).toString());
            }
            if (request.split("@")[0].equals("companyBuilding")) {
                ds.writeUTF(companyBuilding(connection, map).toString());
            }
            if (request.split("@")[0].equals("energyBuilding")) {
                ds.writeUTF(energyBuilding(connection, map).toString());
            }
            if (request.split("@")[0].equals("allFloor")) {
                ds.writeUTF(getAllfloor(connection, map).toString());
            }
        /*******************ending building indicators****************************/

/*******************ending conditions for all indicators**********************************/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /*************** starting method request for building indicators*********************/

    private String getAllfloor(Connection connection, Map<String, String> map) {
        String value = null;
        try {
            String sql ="select count(name_floor) from floor" +
                    " inner join building on floor.id_building = building.id_building " +
                    "where building_name='"+ map.get("building_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);


        }catch (SQLException e) {
            e.printStackTrace();
        }

        return value;
    }

    private String equipmentBuilding(Connection connection, Map<String, String> map) {
        String value = null;
        try {
            String sql ="select count(position_screen)" +
                    " from room inner join floor on floor.id_floor = room.id_floor " +
                    "inner join building on building.id_building = floor.id_building " +
                    "where building_name='"+ map.get("building_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    private Integer objectBuilding(Connection connection, Map<String, String> map) {
        int sum = 0;
        int col1 =0;
        int col2 =0;
        int col3 = 0;
        try {
            String sql ="select count(position_screen), count(position_plug), count(position_windows)" +
                    " from room inner join floor on floor.id_floor = room.id_floor " +
                    "inner join building on building.id_building = floor.id_building " +
                    "where building_name='"+ map.get("building_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()){
                col1 = rs.getInt(1);
                col2 = rs.getInt(2);
                col3 = rs.getInt(3);
            }
            sum = col1 + col2 + col3;


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    private String rateBuilding(Connection connection, Map<String, String> map) {return null;
    }

    private String energyBuilding(Connection connection, Map<String, String> map) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        String value = null;
        double resp = 0.0;
        try{
            String sql = "select energy from building where " +
                    "building_name = '"+ map.get("building_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                resp = rs.getDouble(1);
            value = format.format(resp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    private String sensorBuilding(Connection connection, Map<String, String> map) {
        String value = null;
        try {

            String sql = "select count(position_sensor) from room inner join floor" +
                    " on floor.id_floor = room.id_floor inner join building on" +
                    " building.id_building = floor.id_building " +
                    "where building_name='" + map.get("building_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return value;
    }

    private String companyBuilding(Connection connection, Map<String, String> map) {
        String value = null;
        try {

        String sql = "select count(distinct company_name) from company inner join location" +
                " on company.company_id= location.id_location inner join room" +
                " on room.id_location = location.id_location inner join floor " +
                "on floor.id_floor = room.id_floor inner join building " +
                "on building.id_building = floor.id_building " +
                "where building_name='"+ map.get("building_name") +"'";
        ResultSet rs = connection.createStatement().executeQuery(sql);
        while (rs.next())
            value = rs.getString(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return value;
    }
/********************** end of method for building indicators******************/
/************************starting request methods for company indicators*****************************/


    private String usedBatiment(Connection connection, Map<String, String> map) {
        String value = null;
        try{
            String sql = "select distinct building_name from building inner join floor\n" +
                    "on building.id_building = floor.id_building inner join room\n" +
                    "on floor.id_floor = room.id_floor inner join location on\n" +
                    "room.id_location = location.id_location inner join company on\n" +
                    "company.company_id= location.id_location " +
                    "where company_name = '" + map.get("company_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;

    }

    private Integer equipmentCompany(Connection connection, Map<String, String> map) {

        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        try{
            String sql ="select distinct (select count(position_screen) " +
                    "from room where position_screen = true) from room" +
                    " inner join location on room.id_location = location.id_location" +
                    " inner join company on company.company_id= location.id_location" +
                    " where company_name ='" + map.get("company_name") + "'";

            String sql2 = "select distinct (select count(position_windows) " +
                    "from room where position_windows = true) from room" +
                    " inner join location on room.id_location = location.id_location" +
                    " inner join company on company.company_id= location.id_location" +
                    " where company_name ='" + map.get("company_name") + "'";

            String sql3 = "select distinct (select count(position_plug) " +
                    "from room where position_plug = true) from room" +
                    " inner join location on room.id_location = location.id_location" +
                    " inner join company on company.company_id= location.id_location" +
                    " where company_name ='" + map.get("company_name") + "'";
            ResultSet rs1 = connection.createStatement().executeQuery(sql);
            while (rs1.next())
                val1 = rs1.getInt(1);
            log.info(" je suis là val1 " +val1);
            ResultSet rs2 = connection.createStatement().executeQuery(sql);
            while (rs2.next())
                val2 = rs2.getInt(1);
            log.info(" je suis là val2 " +val2);
            ResultSet rs3 = connection.createStatement().executeQuery(sql);
            while (rs3.next())
                val3 = rs3.getInt(1);
            log.info(" je suis là val3 " +val3);


        }catch (Exception e){
            e.printStackTrace();
        }
        return val1+val3+val2;
    }

    private String sensorCompany(Connection connection, Map<String, String> map) {
        String value = null;
        try{
            String sql = "select distinct (select count(position_sensor) from room where position_sensor = true) from room inner join location\n" +
                    "on room.id_location = location.id_location inner join company on\n" +
                    "company.company_id= location.id_location\n" +
                    "where company_name = '" + map.get("company_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);
            log.info(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    private String energyCompany(Connection connection, Map<String, String> map) {
        return null;
    }

    private String objectCompany(Connection connection, Map<String, String> map) {
        String value = null;
        try{
            String sql = "select count(*) from company where company_name = '" + map.get("company_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);
            log.info(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    private Object rateCompany(Connection connection, Map<String, String> map) {
        return null;
    }/** end of company indicators**/

/** information general*/
    private String getEnergy(Connection connection, Map<String, String> map) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        String s = null ;
        double d = 0.0;
        try{
            String sql = "select sum(energy) from building";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                d = rs.getDouble(1);
            s=format.format(d);
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    private String getAllCompany(Connection connection, Map<String, String> map) {
        String value = null;
        try{
            String sql = "select count(*) from company";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                value = rs.getString(1);
            log.info(value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;

    }

    private String getAllSensor(Connection connection, Map<String, String> map) {
        String value = null;
        String value2 = null;
        String resp = null;
        try{
            String sql = "select count(position_sensor) from room where position_sensor=true ";
            String sql2 = "select count(position_sensor) from room";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            ResultSet rs2 = connection.createStatement().executeQuery(sql2);
            while (rs.next())
                value = rs.getString(1);
            while (rs2.next())
                value2 = rs2.getString(1);
            resp = value+"/"+value2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    private String getAllEquipments(Connection connection, Map<String, String> map) {

        String value = null;
        String value2 = null;
        String resp = null;
        try{
            String sql = "select count(position_screen) from room where position_screen=true";
            String sql2 = "select count(position_screen) from room";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            ResultSet rs2 = connection.createStatement().executeQuery(sql2);
            while (rs.next())
                value = rs.getString(1);
            while (rs2.next())
                value2 = rs2.getString(1);
            resp = value+"/"+value2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    private Integer getConnectedObjets(Connection connection, Map<String, String> map) {
       Integer load = 0;
        int val1 = 0;
        int val2 = 0;
        try {


            String sql = " select sum(n) from (\n" +
                    "select count(*) n from room where position_screen = true union\n" +
                    "select count (*) from room where position_plug = true union\n" +
                    "select count(*) from room where position_windows = true) as mesRequest";
            String sql2 = "select count(position_sensor) from room where position_sensor=true";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            ResultSet rs2 = connection.createStatement().executeQuery(sql2);
            while (rs.next())
                val1 = rs.getInt(1);
            while (rs.next())
                 val2 = rs2.getInt(1);
            load = val1 + val2;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return load;
    }

    private String rateOccupation(Connection connection, Map<String, String> map) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        String s = null;

        try {
            String sql =" select * from room" ;
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next())
                s =(rs.getString(1));


        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
    /** end  of information general*/
/* for selecting company in to a combobox**/
    private List<String> comboxNameCompany(Connection connection, Map<String, String> map)  {
        List<String> name = new ArrayList<>();
        try {
            String request = "select company_name from company";
            ResultSet rs = connection.createStatement().executeQuery(request);
            while (rs.next()) {
                name.add(rs.getString(1));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return name;
    }
/* end of combobox**/
    public static StringBuilder requestbuilding(Connection connection, Map<String, String> map) {

        StringBuilder sb = null;
        try {
            String sql = "SELECT building_name FROM building";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return sb;
    }
/************************** end of request method of general information***********************/

    public static StringBuilder requestFloor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;


        try {

            String sql = "SELECT name_floor FROM floor INNER JOIN building ON " +
                    "building.id_building = floor.id_building WHERE " +
                    "building.id_building = '" + map.get("id_building") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;

    }

    public StringBuilder requestRoom(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {
            String sql = "SELECT name_room FROM company INNER JOIN LOCATION ON company.company_id = location.company_id " +
                    "INNER JOIN room ON room.id_location = location.id_location INNER JOIN floor ON floor.id_floor = room.id_floor " +
                    "INNER JOIN building ON building.id_building = floor.id_building WHERE company.company_name = '" + map.get("company_name") +
                    "' AND floor.name_floor = '" + map.get("floor_name") +
                    "' AND building.building_name = '" + map.get("building_name") + "'";


            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;

    }

    public StringBuilder requestCompany(Connection connection, Map<String, String> map) {

        StringBuilder sb = null;

        try {

            String sql = "SELECT company_name FROM room INNER JOIN company ON  company.company_id = room.id_room";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;

    }

    public StringBuilder requestgetBuilding(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {


            String sql = "SELECT id_building FROM building WHERE building_name = '" + map.get("name_building") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;

    }

    public StringBuilder requestgetFloor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT id_floor FROM floor WHERE name_floor = '" + map.get("name_floor") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;

    }

    public StringBuilder requestgetListBuilding(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT DISTINCT building_name FROM company INNER JOIN location ON" +
                    " company.company_id = location.company_id INNER JOIN room" +
                    " ON location.id_location = room.id_location INNER JOIN floor ON" +
                    " floor.id_floor = room.id_floor INNER JOIN building ON" +
                    " building.id_building = floor.id_building " +
                    "WHERE company.company_name = '" + map.get("company_name") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestGetIdRoom(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT id_room FROM company INNER JOIN LOCATION " +
                    "ON company.company_id = location.company_id INNER JOIN room " +
                    "ON room.id_location = location.id_location INNER JOIN floor " +
                    "ON floor.id_floor = room.id_floor INNER JOIN building " +
                    "ON building.id_building = floor.id_building WHERE room.name_room = '" + map.get("name_room") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestUpdate(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_screen = '" + map.get("value") +
                    "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestScreenIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_screen FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestUpdatePrise(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_plug = '" + map.get("value") +
                    "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestPriseIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_plug FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestUpdateSensor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_sensor = '" + map.get("value") +
                    "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestSensorIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_sensor FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestUpdateWindows(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "UPDATE room set position_windows = '" + map.get("value") + "'" + "WHERE id_room = " + map.get("id_room") + "";

            connection.createStatement().executeUpdate(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            sb.append("Update done");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }

    public StringBuilder requestWindowsIsEmpty(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;

        try {

            String sql = "SELECT position_windows FROM room" +
                    "    WHERE id_room = '" + map.get("id_room") + "'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;
    }


}



