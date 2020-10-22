import java.util.*;

/**
 * tw笔试
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Work> list = new ArrayList<>(16);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if ("".equals(str)) {
                break;
            }
            String[] strArray = str.split(" ");
            String time = strArray[strArray.length - 1];
            Integer min = null;
            if (time.endsWith("min")) {

                min = Integer.parseInt(time.trim().replaceAll("min", ""));
            } else if (time.endsWith("lightning")) {
                min = 5;
            }
            Work work = new Work();
            work.setTime(min);
            work.setMessage(str);
            list.add(work);
        }

        Integer sum = 0;
        for (Work work : list) {
            sum = sum + work.getTime();
        }
        int trackAM = 180;
        int trackPM = 240;
        int trackNum = 1;

        while (sum > 0) {
            meetSet(list, 180, sum, true);
            meetSet(list, 240, sum, true);
            trackNum++;
        }
        if (trackAM <= 0 && trackPM <= 60 && sum <= 360) {
            trackNum++;
            trackAM = 180;
            trackPM = 240;
        }

        System.out.println(sum);
        System.out.println(list);
    }

    private static void meetSet(List<Work> list, int track, int sum, boolean isAm) {
        // AM 180min PM 240min
        for (Work work : list) {
            int finalTrack = track;
            boolean amFull = list.stream().filter(item -> item.getTime().equals(finalTrack)).findAny().isPresent();
            if (track > work.getTime()) {
                track = track - work.getTime();
                sum = sum - work.getTime();
                System.out.println(work.getMessage());
            } else if (amFull) {
                continue;
            }
        }
    }

    static class Work {
        private Integer time;
        private String message;

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "time=" + time +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
