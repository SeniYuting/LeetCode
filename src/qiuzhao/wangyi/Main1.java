package qiuzhao.wangyi;

// 40%

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        List<Log> logs = new ArrayList<>();

        while (sc.hasNext()) {
            Log log = changeLineToLog(line);
            if (log != null) {
                logs.add(log);
            }
            line = sc.nextLine();
        }

        Collections.sort(logs);

        int length = logs.size();
        Activity[] activities = new Activity[length / 2];

        for (int i = 0; i < activities.length; i++) {
            Log beginLog = logs.get(2 * i);
            Log endLog = logs.get(2 * i + 1);

            activities[i] = new Activity(beginLog.roleId, beginLog.time, endLog.time);
        }

        double mostLike = 0;
        int[] likeList = new int[length / 2];
        for (int i = 0; i < activities.length; i++) {
            for (int j = i + 1; j < activities.length; j++) {

                double like = 0;
                int iBegin = activities[i].begin;
                int iEnd = activities[i].end;
                int jBegin = activities[j].begin;
                int jEnd = activities[j].end;

                if (iEnd <= jBegin || jEnd <= iBegin) {
                    like = 0;
                } else {
                    like = ((iEnd < jEnd ? iEnd : jEnd) - (iBegin < jBegin ? jBegin : iBegin)) * 2.0 / (activities[i].interval + activities[j].interval);
                }

                like = Math.round(like * 10000);

//                System.out.println(activities[i].roleId + "_" + activities[j].roleId + "_" + like);

                if (like == mostLike) {
                    likeList[i] = 1;
                    likeList[j] = 1;
                }
                if (like > mostLike) {
                    likeList = new int[length / 2];
                    likeList[i] = 1;
                    likeList[j] = 1;
                    mostLike = like;
                }
            }
        }

        for (int i = 0; i < likeList.length; i++) {
            if (likeList[i] == 1) {
                System.out.println(activities[i].roleId);
            }

        }
    }

    static Log changeLineToLog(String line) {

        String[] lineSplit = line.split("\"");
        int roleId = Integer.parseInt(lineSplit[3]);
        String[] timeTypeSplit = lineSplit[0].split("]");
        int date = Integer.parseInt(timeTypeSplit[0].substring(1));
        String type = timeTypeSplit[1].substring(1);

        if (type.equals("login") || type.equals("logout")) {
            return new Log(roleId, date, type);
        } else {
            return null;
        }
    }

    static class Log implements Comparable<Log> {
        int roleId;
        int time;
        String type;

        Log(int roleId, int time, String type) {
            this.roleId = roleId;
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Log log) {
            if (this.roleId != log.roleId) { // 升序
                return this.roleId - log.roleId;
            } else {
                return this.time - log.time;
            }
        }

        public String toString() {
            return "roleId: " + roleId + ", time: " + time + ", type: " + type;
        }
    }

    static class Activity {
        int roleId;
        int begin;
        int end;
        int interval;

        Activity(int roleId, int begin, int end) {
            this.roleId = roleId;
            this.begin = begin;
            this.end = end;
            this.interval = end - begin;
        }
    }
}
