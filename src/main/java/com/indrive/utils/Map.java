package com.indrive.utils;


import com.indrive.datas.models.Location;

public class Map {

    public static double calculateDistance(Location point1, Location point2) {

        final int radius = 6371;

        double latitudeDistance = Math.toRadians(point2.getLatitude() - point1.getLatitude());
        double longitudeDistance = Math.toRadians(point2.getLongitude() - point1.getLongitude());

        double geoDistance = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2)
                + Math.cos(Math.toRadians(point1.getLatitude()))
                * Math.cos(Math.toRadians(point2.getLatitude()))
                * Math.sin(longitudeDistance / 2)
                * Math.sin(longitudeDistance / 2);

        double angularDistance = 2 * Math.atan2(Math.sqrt(geoDistance), Math.sqrt(1 - geoDistance));

        return radius * angularDistance;
    }
}
