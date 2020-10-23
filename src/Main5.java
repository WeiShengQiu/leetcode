import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * tw笔试
 */
public class Main5 {
    private static Integer sum = 0;

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

        // 排序
        Collections.sort(list);

        for (Work work : list) {
            sum = sum + work.getTime();
        }
        int trackAM = 180;
        int trackPM = 240;
        int trackNum = 1;

        while (sum > 0) {
            System.out.println("Track " + trackNum + ":");
            meetSet(list, trackAM, true);
            meetSet(list, trackPM, false);
            trackNum++;
        }
    }

    private static void meetSet(List<Work> list, int track, boolean isAm) {
        // AM 180min PM 240min
        // 设置时间
        Calendar cal = Calendar.getInstance();
        if (isAm) {
            cal.set(Calendar.HOUR_OF_DAY, 9);
        } else {
            cal.set(Calendar.HOUR_OF_DAY, 13);
        }
        cal.set(Calendar.MINUTE, 0);

        Iterator<Work> it = list.iterator();
        while (it.hasNext()) {
            Work work = it.next();
            int finalTrack = track;
            boolean amFull = list.stream().filter(item -> item.getTime().equals(finalTrack)).findAny().isPresent();
            if (track >= work.getTime()) {
                track = track - work.getTime();
                sum = sum - work.getTime();
                it.remove();
                System.out.println(new SimpleDateFormat("HH:mm a").format(cal.getTime()) + " " + work.getMessage());
                cal.add(Calendar.MINUTE, work.getTime());
            } else if (amFull) {
                continue;
            }
        }

        // 输出结束
        if (track == 0 && isAm) {
            System.out.println(new SimpleDateFormat("HH:mm a").format(cal.getTime()) + " Lunch");
        } else if (track <= 60 && !isAm) {
            cal.set(Calendar.HOUR_OF_DAY, 17);
            cal.set(Calendar.MINUTE, 0);
            System.out.println(new SimpleDateFormat("HH:mm a").format(cal.getTime()) + " Networking Event");
        }
    }

    static class Work implements Comparable<Work> {
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

        @Override
        public int compareTo(Work w) {
//            return this.id - o.id; //升序
            return w.getTime() - this.getTime();  //降序
        }
    }
}
